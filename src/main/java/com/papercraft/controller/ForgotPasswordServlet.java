package com.papercraft.controller;

import com.papercraft.dao.UserDAO;
import com.papercraft.util.EmailUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/forgot-password")
public class ForgotPasswordServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("sendOTP".equals(action)) {
            // Lấy email từ request AJAX
            String email = request.getParameter("email");
            UserDAO userDAO = new UserDAO();

            // Kiểm tra Email có tồn tại không
            if (userDAO.checkEmailExists(email)) {

                // Tạo và gửi OTP
                String otp = EmailUtils.generateOTP();

                // Gửi mail
                EmailUtils.sendEmail(email, otp);

                // Lưu Session
                HttpSession session = request.getSession();
                session.setAttribute("OTP_CODE", otp);
                session.setAttribute("RESET_EMAIL", email); // Lưu email để đổi pass
                session.setAttribute("OTP_createTime", System.currentTimeMillis());

                response.getWriter().write("SUCCESS");
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Trả về lỗi 400
                response.getWriter().write("EMAIL_NOT_FOUND");
            }
        } else {
            request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userOtp = request.getParameter("otp");
        HttpSession session = request.getSession();
        String systemOtp = (String) session.getAttribute("OTP_CODE");

        if (systemOtp != null && systemOtp.equals(userOtp)) {
            session.setAttribute("IS_VERIFIED", true);
            response.sendRedirect("reset-password");
        } else {
            request.setAttribute("message", "Mã OTP sai hoặc đã hết hạn!");
            request.getRequestDispatcher("forgot-password").forward(request, response);
        }
    }
}