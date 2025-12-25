package com.papercraft.controller;

import com.papercraft.dao.UserDAO;
import com.papercraft.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", value = "/update-profile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("acc");

        if(user == null){
            response.sendRedirect("login.jsp");
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");

        User userToUpdate = new User();
        userToUpdate.setId(user.getId());
        userToUpdate.setFname(fname);
        userToUpdate.setLname(lname);
        userToUpdate.setPhoneNumber(phone);
        userToUpdate.setGender(gender);

        UserDAO userDAO = new UserDAO();
        boolean isUpdated = userDAO.updateProfile(userToUpdate);

        if(isUpdated){
            user.setFname(fname);
            user.setLname(lname);
            user.setPhoneNumber(phone);
            user.setGender(gender);
            session.setAttribute("acc", user);

            request.setAttribute("msg" ,"Cập nhật thông tin thành công!");
        } else {
            request.setAttribute("error", "Có lỗi xảy ra, vui lòng thử lại!");
        }
        request.getRequestDispatcher("account.jsp").forward(request, response);
    }
}
