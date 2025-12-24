package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Review;
import com.papercraft.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    //getReviewsByProductId
    public List<Review> getReviewsByProductId(int productId) {
        List<Review> reviews = new ArrayList<>();

        String sql = "SELECT r.*, u.full_name " +
                "FROM review r " +
                "JOIN user u ON r.user_id = u.id " +
                "WHERE r.product_id = ? " +
                "ORDER BY r.created_at DESC";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Gán tham số cho product_id
            ps.setInt(1, productId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Review r = new Review();

                    r.setId(rs.getInt("id"));
                    r.setUserId(rs.getInt("user_id"));
                    r.setProductId(rs.getInt("product_id"));
                    r.setRating(rs.getInt("rating"));
                    r.setComment(rs.getString("comment"));
                    r.setCreatedAt(rs.getTimestamp("created_at"));

                    reviews.add(r);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public boolean checkEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM user WHERE email = ?";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void signup(User user) {
        String sql = "INSERT INTO user (fname, lname, email, phone_number, gender, password, role) VALUES (?, ?, ?, ?, ?, ?, 0)";

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFname());
            ps.setString(2, user.getLname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhoneNumber());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getPasswordHash());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
