package com.papercraft.controller;

import com.papercraft.dao.AddressDAO;
import com.papercraft.model.Address;
import com.papercraft.model.User;
import com.papercraft.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        //Lấy user từ sesion lưu vào biến
        User user = (User) session.getAttribute("acc");

        // Check đăng nhập
        if (user == null) {
            // Chuyển hướng sang trang Login
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        // Check Giỏ hàng trống
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            // Nếu giỏ rỗng thì trở về trang giỏ hàng
            response.sendRedirect(request.getContextPath() + "/cart");
            return;
        }

        // Lấy địa chỉ mặc định
        AddressDAO addressDAO = new AddressDAO();

        Address userAddr = addressDAO.findDefaultAddress(user.getId());

        // Gửi sang JSP nếu Null thì ô input sẽ trống
        request.setAttribute("addr", userAddr);

        // Tính tiền hiển thị (dùng lại logic cartService)
        CartService cartService = new CartService();
        CartService.CartResult cartData = cartService.calculateCart(cart);

        // Gửi các số tiền trong bill
        request.setAttribute("subTotal", cartData.subTotal); // Tạm tính
        request.setAttribute("vat", cartData.vat);           // Thuế
        request.setAttribute("grandTotal", cartData.grandTotal); // Tổng cộng

        // Gửi danh sách sản phẩm
        request.setAttribute("items", cartData.items);

        // Chuyển hướng
        request.getRequestDispatcher("/payment.jsp").forward(request, response);
    }
}