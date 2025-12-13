package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Review;
import com.papercraft.model.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class User_DAO {

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

        // Gán tham số: product_id
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
}
