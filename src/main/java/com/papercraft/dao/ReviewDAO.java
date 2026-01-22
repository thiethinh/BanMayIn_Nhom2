package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Review;

import java.sql.*;
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

    /**
     * get list review by user id, if invalid user id then read all review
     *
     * @param idUser user id
     * @return list review
     */
    public List<Review> getReviewByUserID(int idUser) {
        List<Review> reviews = new ArrayList<>();
        String sqlRaw = """
                SELECT r.id,u.fullname, p.product_name, r.rating, r.comment, r.created_at
                FROM review r
                JOIN users u ON u.id = r.user_id
                JOIN product p ON p.id = r.product_id
                """;
        StringBuilder sqlBuilder = new StringBuilder(sqlRaw);
        if (idUser != 0) {
            sqlBuilder.append(" WHERE r.user_id =?;");
        } else {
            sqlBuilder.append(";");
        }
        String sql = sqlBuilder.toString();
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {

            if (idUser != 0) {
                ps.setInt(1, idUser);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Integer id = rs.getInt("id");
                    String userName = rs.getString("fullname");
                    String productName = rs.getString("product_name");
                    Integer rating = rs.getInt("rating");
                    String comment = rs.getString("comment");
                    Timestamp createdAt = rs.getTimestamp("created_at");

                    Review review = new Review();
                    review.setId(id);
                    review.setAuthorName(userName);
                    review.setProductName(productName);
                    review.setRating(rating);
                    review.setComment(comment);
                    review.setCreatedAt(createdAt);

                    reviews.add(review);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }


    public boolean deleteReviewByID(int idReview) {
        String sql = """
                DELETE FROM review
                WHERE id =?;
                """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, idReview);

            return ps.executeUpdate() > 0;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }
}
