package com.papercraft.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Map;

@WebServlet("/cart-count")
public class CartCountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);
        int count = 0;

        if (session != null) {
            Object obj = session.getAttribute("cart");
            if (obj instanceof Map) {
                Map<?, ?> cart = (Map<?, ?>) obj;
                for (Object v : cart.values()) {
                    count += Integer.parseInt(v.toString());
                }
            }
        }

        response.setContentType("text/plain");
        response.getWriter().print(count);
    }
}
