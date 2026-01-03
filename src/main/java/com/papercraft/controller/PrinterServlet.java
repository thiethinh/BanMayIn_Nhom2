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

@WebServlet(name = "PrinterServlet", value = "/printer")
public class PrinterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        List<Product>  printers = productDAO.getAllProducts("Printer");
        if(printers ==null){
            printers = new ArrayList<>();
        }
        CategoryDAO  categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategories("Printer");
        if(categories == null){
            categories = new ArrayList<>();
        }

        request.setAttribute("printers",printers);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/printer.jsp").forward(request, response);
    }

}