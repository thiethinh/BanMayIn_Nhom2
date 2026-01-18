package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Order;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {


    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();


        String sql = "SELECT * FROM `order` WHERE user_id = ? ORDER BY created_at DESC";

        try (
                Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Order order = new Order();

                    order.setId(rs.getInt("id"));
                    order.setUserId(rs.getInt("user_id"));
                    order.setStatus(rs.getString("status"));
                    order.setTotalPrice(rs.getBigDecimal("total_price"));
                    order.setNote(rs.getString("note"));
                    order.setShippingFee(rs.getBigDecimal("shipping_fee"));

                    // Thông tin giao hàng
                    order.setShippingName(rs.getString("shipping_name"));
                    order.setShippingPhone(rs.getString("shipping_phone"));
                    order.setShippingAddress(rs.getString("shipping_address"));

                    order.setCreatedAt(rs.getTimestamp("created_at"));

                    orders.add(order);
                }
            }

        } catch (SQLException e) {

            System.err.println("SQL Error in getOrdersByUserId: " + e.getMessage());
            e.printStackTrace();
            // Ném lại RuntimeException để tầng trên xử lý
            throw new RuntimeException("Database error occurred while fetching orders for user ID " + userId, e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    // updateOrderStatus
    public boolean updateOrderStatus(int orderId, String status) {


        String sql = "UPDATE `order` SET status = ? WHERE id = ?";

        try (
                Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setString(1, status);
            ps.setInt(2, orderId);


            int rowsAffected = ps.executeUpdate();


            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("SQL Error in updateOrderStatus: Could not update order ID " + orderId);
            e.printStackTrace();

            // Ném lại RuntimeException để tầng Service xử lý lỗi hệ thống
            throw new RuntimeException("Database error occurred while updating order status.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Integer totalPendingOrder() {

        String sql = """
                SELECT SUM(status) AS pending_order FROM order WHERE status ='Chờ Xử Lí';
                """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("pending_order");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<Order> getTop10PendingOrder() {
        List<Order> orders = new ArrayList<>();
        String sql = """
                SELECT o.id, o.user_id,o.created_at, o.status, sum( oi.quantity * oi.price) as total_price
                FROM orders o
                JOIN users u ON u.id =o.user_id
                JOIN order_item oi ON o.id = oi.order_id
                WHERE status ='Chờ Xử Lí'
                GROUP BY o.id, o.user_id,o.created_at, o.status;
                """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {

                    Integer id = rs.getInt("id");
                    Integer userId = rs.getInt("user_id");
                    Timestamp orderDate = rs.getTimestamp("created_at");
                    BigDecimal totalPrice = rs.getBigDecimal("total_price");
                    String status = rs.getString("status");

                    Order order = new Order();
                    order.setId(id);
                    order.setUserId(userId);
                    order.setCreatedAt(orderDate);
                    order.setTotalPrice(totalPrice);
                    order.setStatus(status);
                    orders.add(order);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

}
