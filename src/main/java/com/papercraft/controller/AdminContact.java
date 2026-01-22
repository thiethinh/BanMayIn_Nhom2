package com.papercraft.controller;

import com.papercraft.dao.ContactDAO;
import com.papercraft.model.Contact;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminContact", value = "/admin-contacts")
public class AdminContact extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String repliedStr = request.getParameter("relied");

        userName = (userName == null || userName.isEmpty() || userName.isBlank()) ? "" : userName;
        int replied = -1;
        try {
            replied = (repliedStr == null || (Integer.parseInt(repliedStr) != 1 && Integer.parseInt(repliedStr) != 1)) ? -1 : (Integer.parseInt(repliedStr));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // status of a contact be prelied or not
        String stateContactStr = request.getParameter("state");
        String idContactStr = request.getParameter("id");
        int state = -1;
        int idContact = 0;
        try {
            state = Integer.parseInt(stateContactStr);
            idContact = Integer.parseInt(idContactStr);
        } catch (NumberFormatException e) {
            System.out.println("format error at admin contact");
            e.printStackTrace();
        }

        ContactDAO contactDAO = new ContactDAO();
        boolean toggled = false;
        if (idContact != 0 && state != -1) {
            toggled = contactDAO.toggleStateContact(idContact, state);
        }
        List<Contact> contacts = contactDAO.getContactFilter(userName, replied);

        request.setAttribute("contacts", contacts);
        request.setAttribute("toggled", toggled);
        request.setAttribute("username",userName);
        request.setAttribute("relied",replied);
        request.getRequestDispatcher("admin-contacts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code xử lý yêu cầu POST
    }
}