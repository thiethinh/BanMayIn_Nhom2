package com.papercraft.controller;

import com.papercraft.dao.OrderDAO;
import com.papercraft.dao.OrderItemDAO;
import com.papercraft.dao.PaymentDAO;
import com.papercraft.dao.UserDAO;
import com.papercraft.model.Order;
import com.papercraft.model.OrderItem;
import com.papercraft.model.Payment;
import com.papercraft.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminOrderViewServlet", value = "/admin-order-view")
public class AdminOrderViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderID = request.getParameter("orderId");
        int id = orderID != null ? Integer.parseInt(orderID) : 0;

        OrderDAO orderDAO = new OrderDAO();
        Order order = orderDAO.getOrderByID(id);

        if(order == null){
            return;
        }
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        List<OrderItem> orderItems = orderItemDAO.getItemByOrderId(id);
        order.setOrderItems(orderItems);

        User user = new UserDAO().getBasicInfoById(order.getUserId());

        Payment payment = new PaymentDAO().getPaymentByOrderId(id);

        request.setAttribute("order", order);
        //request.setAttribute("orderItems", orderItems);
        request.setAttribute("user", user);
        request.setAttribute("payment", payment);

        request.getRequestDispatcher("/admin-order-view.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code xử lý yêu cầu POST
    }
}