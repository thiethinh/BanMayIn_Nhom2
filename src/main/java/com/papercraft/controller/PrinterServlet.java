package com.papercraft.controller;

import com.papercraft.dao.Product_DAO;
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
        Product_DAO dao = new Product_DAO();
        List<Product>  printers = dao.getAllProducts("Printer");
        if(printers ==null){
            printers = new ArrayList<>();
        }
        request.setAttribute("printers",printers);
        request.getRequestDispatcher("/printer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}