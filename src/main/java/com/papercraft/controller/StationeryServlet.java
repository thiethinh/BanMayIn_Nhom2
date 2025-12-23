package com.papercraft.controller;

import com.papercraft.dao.CategoryDAO;
import com.papercraft.dao.ProductDAO;
import com.papercraft.model.Category;
import com.papercraft.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StationeryServlet", value = "/stationery")
public class StationeryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        List<Product> stationery = dao.getAllProducts("Stationery");
        if(stationery ==null){
            System.out.println("List null");
            stationery = new ArrayList<>();
        }

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategories("Stationery");
        if(categories == null){
            categories = new ArrayList<>();
        }

        request.setAttribute("stationery",stationery);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/stationery.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code xử lý yêu cầu POST
    }
}