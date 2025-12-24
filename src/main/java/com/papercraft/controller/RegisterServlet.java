package com.papercraft.controller;

import com.papercraft.dao.UserDAO;
import com.papercraft.model.User;
import com.papercraft.service.EmailService;
import com.papercraft.util.MD5;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        UserDAO dao = new UserDAO();
        String error = null;

        // Kiểm tra
        if (!password.equals(confirmPassword)) {
            error = "Mật khẩu nhập lại không khớp";
        }
        // Kiểm tra độ mạnh mật khẩu bằng Regex
        // ^(?=.*[0-9]) -> Phải có số
        // (?=.*[@#$%^&+=!]) -> Phải có ký tự đặc biệt
        // (?=\S+$) -> Không có khoảng trắng
        // .{8,} -> Dài ít nhất 8 ký tự
        else if (!password.matches("^(?=.*[0-9])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$")) {
            error = "Mật khẩu yếu! Cần phải có 8 kí tự, có số, có kí tự đặc biệt.";
        } else if (dao.checkEmailExists(email)) {
            error = "Email đã được sử dụng";
        }

        if (error != null) {
            request.setAttribute("errorRegister", error);
            request.setAttribute("activeTab", "register");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            EmailService es = new EmailService();
            String otp = es.getRandom();

            User newUser = new User();
            newUser.setFname(fname);
            newUser.setLname(lname);
            newUser.setEmail(email);
            newUser.setPhoneNumber(phone);
            newUser.setGender(gender);
            newUser.setPasswordHash(MD5.getMD5(password));

            boolean isSent = es.sendEmail(newUser, otp);
            if (isSent) {
                HttpSession session = request.getSession();
                session.setAttribute("authCode", otp);
                session.setAttribute("tempUser", newUser);
                session.setMaxInactiveInterval(300);

                request.setAttribute("showVerifyModal", true);
                request.setAttribute("activeTab", "register");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                request.setAttribute("errorRegister", "Gửi email thất bại! Vui lòng kiểm tra lại kết nối hoặc email.");
                request.setAttribute("activeTab", "register");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
