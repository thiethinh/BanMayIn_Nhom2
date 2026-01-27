package com.papercraft.controller;

import com.papercraft.dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPass = request.getParameter("newPassword");
        String confirmPass = request.getParameter("confirmPassword");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("RESET_EMAIL"); // Lấy Email

        if (newPass.equals(confirmPass)) {
            UserDAO dao = new UserDAO();
            // Gọi  updatePasswordByEmail
            boolean isUpdated = dao.updatePasswordByEmail(email, newPass);

            if (isUpdated) {
                session.invalidate();
                response.sendRedirect("login.jsp?message=Success");
            } else {
                request.setAttribute("error", "Lỗi hệ thống!");
                request.getRequestDispatcher("reset-password.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Mật khẩu xác nhận không khớp!");
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
        }
    }
}