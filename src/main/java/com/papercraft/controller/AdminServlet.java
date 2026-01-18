package com.papercraft.controller;

import com.papercraft.dao.ContactDAO;
import com.papercraft.dao.OrderDAO;
import com.papercraft.dao.PaymentDAO;
import com.papercraft.dao.UserDAO;
import com.papercraft.model.Order;
import com.papercraft.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user =(User) request.getAttribute("acc");
        if(user==null){
            response.sendRedirect("/papercraft/home");
        }
        PaymentDAO paymentDAO = new PaymentDAO();
        double totalRevenue = paymentDAO.getTotalRevenue();

        OrderDAO orderDAO = new OrderDAO();
        Integer totalpendingOrder = orderDAO.totalPendingOrder();

        UserDAO userDAO = new UserDAO();
        Integer totalUser = userDAO.totalUser();

        ContactDAO contactDAO = new ContactDAO();
        Integer totalUnrepliedContact = contactDAO.totalUnrepliedContact();

        List<Order> orders = orderDAO.getTop10PendingOrder();

        request.setAttribute("orders", orders);
        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("totalpendingOrder", totalpendingOrder);
        request.setAttribute("totalUser", totalUser);

        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean logout = request.getAttribute("logout") != null ? true: false;
        if(logout){
            User user = new User();
            request.setAttribute("acc", user);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    }
}