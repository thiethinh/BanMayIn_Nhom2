package com.papercraft.controller;

import com.papercraft.dao.ProductDao;
import com.papercraft.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao dao = new ProductDao();

        List<Product> featuredPrinter = dao.getFeaturedProductsByCategory(1);
        List<Product> featuredStationery = dao.getFeaturedProductsByCategory(2);

        request.setAttribute("printers", featuredPrinter);
        request.setAttribute("stationery", featuredStationery);

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
