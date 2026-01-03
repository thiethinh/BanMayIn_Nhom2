package com.papercraft.controller;

import com.papercraft.dao.ProductDAO;
import com.papercraft.model.Product;
import com.papercraft.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            showCart(request, response);
            return;
        }

        switch (action) {
            case "remove":
                removeItem(request, response);
                break;
            case "clear":
                clearCart(request, response);
                break;
            case "count":
                getCartCount(request, response);
                break;
            default:
                showCart(request, response);
        }
    }

    private void getCartCount(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        int total = 0;
        if (cart != null) {
            for (int q : cart.values()) {
                total += q;
            }
        }

        response.setContentType("text/plain");
        response.getWriter().print(total);
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "add":
                addToCart(request, response);
                break;
            case "update":
                updateQuantity(request, response);
                break;
            default:
                response.sendRedirect("cart");
        }
    }


    //addToCart
    private void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        //debug
        System.out.println("--- Server đang xử lý thêm giỏ hàng ---");

        try {
        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        //debug
        System.out.println("Product ID: " + productId + " | Qty: " + quantity);

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);
        session.setAttribute("cart", cart);

        //debug
        System.out.println("Cart size hiện tại: " + cart.size());

        response.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }


    //removeItem
    private void removeItem(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int productId = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart != null) {
            cart.remove(productId);
        }

        response.sendRedirect("cart");
    }


    //clearCart
    private void clearCart(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("cart");

        response.sendRedirect("cart");
    }


    //updateQuantity
    private void updateQuantity(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart != null) {
            if (quantity <= 0) {
                cart.remove(productId);
            } else {
                cart.put(productId, quantity);
            }
        }

        response.sendRedirect("cart");
    }

    //showCartp
    private void showCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        // Gọi Service để tính toán
        CartService cartService = new CartService();
        CartService.CartResult cartData = cartService.calculateCart(cart);

        // Đẩy dữ liệu ra JSP
        request.setAttribute("items", cartData.items);
        request.setAttribute("subTotal", cartData.subTotal);
        request.setAttribute("vat", cartData.vat);
        request.setAttribute("grandTotal", cartData.grandTotal);

        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}





