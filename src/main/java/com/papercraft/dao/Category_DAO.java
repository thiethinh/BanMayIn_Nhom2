package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Category_DAO {
    public List<Category> selectAllCategoryName(String type) {
        List<Category> list = new ArrayList<>();
        String sql = """
                SELECT category_name FROM category
                WHERE type =?
                """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, type);
            try (ResultSet rs = ps.executeQuery()) {
                List<String> categories = new ArrayList<>();
                while (rs.next()) {
                    categories.add(rs.getString("category_name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
