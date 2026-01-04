package com.papercraft.controller;

import com.papercraft.dao.AddressDAO;
import com.papercraft.model.Address;
import com.papercraft.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/save-address")
public class SaveAddressServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Cấu hình tiếng Việt
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("acc");

        //  Check login
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Lấy dữ liệu từ Form Địa Chỉ
        // (Tên tham số phải khớp với name="" trong account.jsp)
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phone = request.getParameter("phone");
        String nation = request.getParameter("nation");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postcode");
        String detailAddress = request.getParameter("detailAddress");

        // Lấy ID địa chỉ
        String addressIdRaw = request.getParameter("addressId");

        //  Tạo đối tượng Address
        Address addr = new Address();
        addr.setUserId(user.getId());
        addr.setFname(fname);
        addr.setLname(lname);
        addr.setPhone(phone);
        addr.setNation(nation);
        addr.setCity(city);
        addr.setPostcode(postcode);
        addr.setDetailAddress(detailAddress);
        addr.setDefault(true); // Mặc định set là địa chỉ chính

        //  Gọi DAO để lưu
        AddressDAO dao = new AddressDAO();
        boolean isSuccess;


        isSuccess = dao.insertAddress(addr);

        // Chuyển hướng
        if (isSuccess) {
            session.setAttribute("msgAddress", "Lưu địa chỉ thành công!");
        } else {
            session.setAttribute("errAddress", "Lưu thất bại!");
        }

        //  Quay về /account (AccountServlet) để load lại dữ liệu
        response.sendRedirect(request.getContextPath() + "/account");
    }
}