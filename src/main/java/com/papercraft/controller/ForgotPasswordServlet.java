package com.papercraft.controller;

import com.papercraft.dao.UserDAO;
import com.papercraft.util.EmailUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

                // Gửi mail (Nên chạy trong Thread riêng để tránh lag web, nhưng code đơn giản thì để thế này cũng được)
                EmailUtils.sendEmail(email, otp);

                // Lưu Session
                HttpSession session = request.getSession();
                session.setAttribute("OTP_CODE", otp);
                session.setAttribute("RESET_EMAIL", email); // Lưu email để lát đổi pass
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
            response.sendRedirect("reset-password.jsp");
        } else {
            request.setAttribute("message", "Mã OTP sai hoặc đã hết hạn!");
            request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
        }
    }
}