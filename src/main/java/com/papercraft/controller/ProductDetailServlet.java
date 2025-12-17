package com.papercraft.controller;

import com.papercraft.dao.Product_DAO;
import com.papercraft.dao.Review_DAO;
import com.papercraft.model.Product;
import com.papercraft.model.Review;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailServlet", value = "/product-detail")
public class ProductDetailServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String productId = request.getParameter("productId");
            if(productId == null){
                response.sendRedirect("home");
                return;
            }
            int id = Integer.parseInt(productId);

            // Lấy ảnh
            Product_DAO dao = new Product_DAO();
            Product product = dao.getProductById(id);
            List<String> listImages = dao.getAllImageOfProduct(id);

            request.setAttribute("p", product);
            request.setAttribute("listImages", listImages);

            // Lấy đánh giá
            Review_DAO reviewDao = new Review_DAO();
            List<Review> reviewList = reviewDao.getReviewsByProductId(id);

            request.setAttribute("reviewList", reviewList);
            request.setAttribute("countReview", reviewList.size());

            request.getRequestDispatcher("product-details.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home.jsp");
        }
    }
}
