package com.papercraft.controller;

import com.papercraft.dao.OrderDAO;
import com.papercraft.dao.ProductDAO;
import com.papercraft.model.Order;
import com.papercraft.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminOrderManage", value = "/AdminOrderManage")
public class AdminOrderManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String status =request.getParameter("state");
        status=(status==null||status.isEmpty())? "":status;
        OrderDAO orderDAO = new OrderDAO();
        List<Order> products = orderDAO.getOrderByState(status);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code xử lý yêu cầu POST
    }
}