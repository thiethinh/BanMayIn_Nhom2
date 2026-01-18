package com.papercraft.controller;

import com.papercraft.dao.PaymentDAO;
import com.papercraft.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

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






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code xử lý yêu cầu POST
    }
}