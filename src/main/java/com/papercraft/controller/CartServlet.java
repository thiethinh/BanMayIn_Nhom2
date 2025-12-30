package com.papercraft.controller;

import com.papercraft.dao.ProductDAO;
import com.papercraft.model.Product;
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

        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        cart.put(productId, cart.getOrDefault(productId, 0) + quantity);

        session.setAttribute("cart", cart);
        response.setStatus(HttpServletResponse.SC_OK);

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

    //showCart
    private void showCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Map<Integer, Integer> cart =
                (Map<Integer, Integer>) session.getAttribute("cart");

        ProductDAO productDAO = new ProductDAO();

        List<Map<String, Object>> items = new ArrayList<>();
        BigDecimal subTotal = BigDecimal.ZERO;

        if (cart != null) {
            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {

                Product p = productDAO.getProductById(entry.getKey());
                if (p == null) continue;

                int qty = entry.getValue();
                BigDecimal price = BigDecimal.valueOf(p.getPrice());
                BigDecimal total = price.multiply(BigDecimal.valueOf(qty));

                subTotal = subTotal.add(total);

                Map<String, Object> item = new HashMap<>();
                item.put("product", p);
                item.put("quantity", qty);
                item.put("total", total);

                items.add(item);
            }
        }

        BigDecimal vat = subTotal.multiply(new BigDecimal("0.05"));
        BigDecimal grandTotal = subTotal.add(vat);

        request.setAttribute("items", items);
        request.setAttribute("subTotal", subTotal);
        request.setAttribute("vat", vat);
        request.setAttribute("grandTotal", grandTotal);

        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}





