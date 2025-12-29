package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Blog;

import java.sql.*;

public class BlogDao {
    private static final String ROOT_PATH = "images/upload/";

    public boolean addBlog(Blog blog, String thumbnailName) {
        String sqlBlog = "INSERT INTO blog (user_id, blog_title, blog_description, type_blog, blog_content) VALUES (?, ?, ?, ?, ?)";
        String sqlImage = "INSERT INTO image (entity_id, entity_type, img_name, is_thumbnail) VALUES (?, 'Blog', ?, 1)";

        Connection conn = null;
        PreparedStatement psBlog = null;
        PreparedStatement psImage = null;

        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);

            psBlog = conn.prepareStatement(sqlBlog, Statement.RETURN_GENERATED_KEYS);
            psBlog.setInt(1, blog.getUserId());
            psBlog.setString(2, blog.getBlogTitle());
            psBlog.setString(3, blog.getBlogDescription());
            psBlog.setString(4, blog.getTypeBlog());
            psBlog.setString(5, blog.getBlogContent());
            int rowBlog = psBlog.executeUpdate();

            int blogId = 0;
            if (rowBlog > 0) {
                try (ResultSet rs = psBlog.getGeneratedKeys()) {
                    if (rs.next()) {
                        blogId = rs.getInt(1);
                    }
                }
            }

            if (blogId > 0) {
                psImage = conn.prepareStatement(sqlImage);
                psImage.setInt(1, blogId);
                psImage.setString(2, thumbnailName);
                psImage.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (psBlog != null) psBlog.close();
                if (psImage != null) psImage.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
