package com.papercraft.controller;

import com.papercraft.dao.ReviewDAO;
import com.papercraft.model.Review;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminReview", value = "/admin-review")
public class AdminReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUserStr = request.getParameter("user");
        String idReviewStr = request.getParameter("review");
        int idUser = 0;
        int idReview = 0;
        try {
            idUser = (idUserStr != null || !idUserStr.isEmpty()) ? Integer.parseInt(request.getParameter("user")) : 0;
            idReview = (idReviewStr != null || !idReviewStr.isEmpty()) ? Integer.parseInt(request.getParameter("review")) : 0;

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        ReviewDAO reviewDAO = new ReviewDAO();
        boolean reviewDeleted = false;
        if (idReview != 0) {
            reviewDeleted = reviewDAO.deleteReviewByID(idReview);
        }

        List<Review> reviews = null;
        reviews = reviewDAO.getReviewByUserID(idUser);

        request.setAttribute("reviews", reviews);
        request.setAttribute("reviewDeleted", reviewDeleted);
        request.getRequestDispatcher("/admin-review.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code xử lý yêu cầu POST
    }
}