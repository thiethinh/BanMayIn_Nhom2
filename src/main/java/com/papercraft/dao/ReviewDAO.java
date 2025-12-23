package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    // Lấy danh sách đanh giá của một sản phẩm
    public List<Review> getReviewsByProductId(int productId) {
        List<Review> reviews = new ArrayList<>();

        String sql = "SELECT r.*, u.fullname " +
                "FROM review r " +
                "JOIN users u ON r.user_id = u.id " +
                "WHERE r.product_id = ? " +
                "ORDER BY r.created_at DESC";

        try (
                Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, productId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Review review = new Review();

                    review.setId(rs.getInt("id"));
                    review.setUserId(rs.getInt("user_id"));
                    review.setProductId(rs.getInt("product_id"));
                    review.setRating(rs.getInt("rating"));
                    review.setComment(rs.getString("comment"));
                    review.setCreatedAt(rs.getTimestamp("created_at"));

                    review.setAuthorName(rs.getString("fullname"));

                    reviews.add(review);
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL Error in getReviewsByProductId for product ID " + productId + ": " + e.getMessage());
            e.printStackTrace();
            // Ném lại RuntimeException để tầng trên xử lý
            throw new RuntimeException("Database error occurred while fetching product reviews.", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return reviews;
    }

    // Thêm review
    public boolean addReview(Review review) {
        String sql = """
                INSERT INTO review (user_id, product_id, rating, comment)
                VALUES (?, ?, ?, ?)
                """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, review.getUserId());
            ps.setInt(2, review.getProductId());
            ps.setInt(3, review.getRating());
            ps.setString(4, review.getComment());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
