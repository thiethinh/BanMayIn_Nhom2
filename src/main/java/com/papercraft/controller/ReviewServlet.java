package com.papercraft.controller;

import com.papercraft.dao.Review_DAO;
import com.papercraft.model.Review;
import com.papercraft.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/add-review")
public class ReviewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            int rating = Integer.parseInt(request.getParameter("rating"));
            String comment = request.getParameter("comment");

            Review review = new Review();
            review.setUserId(user.getId());
            review.setProductId(productId);
            review.setRating(rating);
            review.setComment(comment);

            Review_DAO dao = new Review_DAO();
            dao.addReview(review);

            response.sendRedirect("product-detail?productId=" + productId + "#review");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("home.jsp");
        }
    }
}
