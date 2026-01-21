package com.papercraft.controller;

import com.papercraft.dao.ProductDAO;
import com.papercraft.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProduct", value = "/admin-product")
public class AdminProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        String idDeleted =request.getParameter("delete");
        boolean isDeleted = false;
        if(idDeleted!= null){
             isDeleted=productDAO.deleteProductById(Integer.parseInt(idDeleted));
        }
        List<Product> products= productDAO.getProductForManagement();

        request.setAttribute("products",products);
        request.setAttribute("isDeleted",isDeleted);
        request.getRequestDispatcher("/admin-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code xử lý yêu cầu POST
    }
}