package com.papercraft.controller;

import com.papercraft.dao.Product_DAO;
import com.papercraft.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "StationeryServlet", value = "/stationery")
public class StationeryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product_DAO dao = new Product_DAO();
        List<Product> products = dao.getAllProducts("Stationery");
        request.setAttribute("products",products);
        request.getRequestDispatcher("stationery.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code xử lý yêu cầu POST
    }
}