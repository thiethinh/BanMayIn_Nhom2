package com.papercraft.service;

import com.papercraft.dao.OrderDAO;
import com.papercraft.dao.OrderItemDAO;
import com.papercraft.db.DBConnect;
import com.papercraft.model.Order;
import com.papercraft.model.OrderItem;
import com.papercraft.model.Product;
import com.papercraft.model.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    private final OrderDAO orderDAO = new OrderDAO();
    private final OrderItemDAO orderItemDAO = new OrderItemDAO();
    private final CartService cartService = new CartService();

    public boolean placeOrder(User user, Map<Integer, Integer> cart, Order order) {
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);

            CartService.CartResult cartResult = cartService.calculateCart(cart);
            order.setUserId(user.getId());
            order.setStatus("pending");
            order.setTotalPrice(cartResult.grandTotal);
            order.setShippingFee(cartResult.shippingFee);

            int orderId = orderDAO.insertOrder(conn, order);
            if (orderId > 0) {
                List<OrderItem> orderItems = new ArrayList<>();

                for (Map<String, Object> itemMap : cartResult.items) {
                    Product product = (Product) itemMap.get("product");
                    Integer quantity = (Integer) itemMap.get("quantity");

                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrderId(orderId);
                    orderItem.setProductId(product.getId());
                    orderItem.setQuantity(quantity);
                    orderItem.setPrice(BigDecimal.valueOf(product.getPrice()));
                    orderItem.setProduct(product);

                    orderItems.add(orderItem);
                }

                orderItemDAO.insertOrderItem(conn, orderItems);
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
