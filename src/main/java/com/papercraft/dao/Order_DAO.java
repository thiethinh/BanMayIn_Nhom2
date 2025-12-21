package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order_DAO {


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
}
