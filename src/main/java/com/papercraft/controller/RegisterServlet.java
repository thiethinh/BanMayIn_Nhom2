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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("firstname") != null ? request.getParameter("firstname").trim() : "";
        String lname = request.getParameter("lastname") != null ? request.getParameter("lastname").trim() : "";
        String email = request.getParameter("email") != null ? request.getParameter("email").trim() : "";
        String phone = request.getParameter("phone") != null ? request.getParameter("phone").trim() : "";
        String gender = request.getParameter("gender");
        String password = request.getParameter("password") != null ? request.getParameter("password") : "";
        String confirmPassword = request.getParameter("confirmPassword") != null ? request.getParameter("confirmPassword") : "";

        UserDAO dao = new UserDAO();
        String error = null;

        List<String> errors = new ArrayList<>();
        // Kiểm tra
        if (fname.isEmpty()) errors.add("Họ không được để trống");
        if (lname.isEmpty()) errors.add("Tên không được để trống");

        // Kiểm tra Giới tính (Bổ sung)
        if (gender == null || gender.isEmpty()) errors.add("Vui lòng chọn giới tính");

        // Kiểm tra SĐT
        if (phone.isEmpty() || !phone.matches("^0\\d{9}$")) {
            errors.add("Số điện thoại không hợp lệ");
        }

        // Kiểm tra Email
        if (email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.add("Email không hợp lệ");
        } else if (dao.checkEmailExists(email)) {
            errors.add("Email đã được sử dụng");
        }

        // Kiểm tra Password
        if (!password.equals(confirmPassword)) {
            errors.add("Mật khẩu nhập lại không khớp");
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$")) {
            errors.add("Mật khẩu yếu! Cần tối thiểu 8 kí tự, có số và kí tự đặc biệt");
        }

        if (!errors.isEmpty()) {
            request.setAttribute("errorRegister", errors);

            request.setAttribute("valueFName", fname);
            request.setAttribute("valueLName", lname);
            request.setAttribute("valueEmail", email);
            request.setAttribute("valuePhone", phone);
            request.setAttribute("valueGender", gender);
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

                String redirectUrl = request.getParameter("redirect");
                if (redirectUrl != null && !redirectUrl.isEmpty()) {
                    session.setAttribute("redirectAfterRegister", redirectUrl);
                }

                request.setAttribute("showVerifyModal", true);
                request.setAttribute("activeTab", "register");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                errors.add("Gửi email thất bại! Vui lòng kiểm tra lại kết nối hoặc email.");
                request.setAttribute("errorRegister", errors);

                request.setAttribute("valueFName", fname);
                request.setAttribute("valueLName", lname);
                request.setAttribute("valueEmail", email);
                request.setAttribute("valuePhone", phone);
                request.setAttribute("valueGender", gender);
                request.setAttribute("activeTab", "register");

                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
