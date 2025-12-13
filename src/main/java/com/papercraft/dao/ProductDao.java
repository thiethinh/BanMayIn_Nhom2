package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setId(rs.getInt("id"));
                p.setCategoryId(rs.getInt("category_id"));
                p.setProductName(rs.getString("product_name"));
                p.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductDetail(rs.getString("product_detail")); // Mới thêm
                p.setBrand(rs.getString("brand"));
                p.setPrice(rs.getDouble("price"));
                p.setOriginPrice(rs.getDouble("origin_price"));
                p.setDiscount(rs.getDouble("discount"));
                p.setStockQuantity(rs.getInt("stock_quantity"));
                p.setCreatedAt(rs.getTimestamp("created_at"));      // Mới thêm

                list.add(p);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<List<String>> getAllImageOfProduct(int id){
        List<List<String>> images = new ArrayList<>();
        String sql = """
                SELECT image_name, is_thumbnail
                FROM product p
                JOIN image i ON i.entity_id =p.id
                WHERE p.id =?;
                """;
       try(Connection conn = DBConnect.getConnection();
           PreparedStatement ps = conn.prepareStatement(sql);){
           ps.setInt(1,id);
           try(ResultSet rs = ps.executeQuery();) {
               while (rs.next()) {
                   List<String> image = new ArrayList<>();
                   image.add(rs.getString("image_name"));
                   image.add(String.valueOf(rs.getBoolean("is_thumbnail")));
                   images.add(image);
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return images;
    }

    public List<Product> getFeaturedProductsByCategory(int categoryId) {
        List<Product> list = new ArrayList<>();
        String sql ="SELECT p.*, i.img_url " +
                    "FROM product p " +
                    "LEFT JOIN image i ON p.id = i.entity_id " +
                    "AND i.is_thumbnail = 1 " +
                    "WHERE p.category_id = ? " +
                    "ORDER BY p.discount DESC " +
                    "LIMIT 10 ";

        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                int id = rs.getInt("id");
                p.setId(id);
                p.setCategoryId(rs.getInt("category_id"));
                p.setProductName(rs.getString("product_name"));
                p.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                p.setProductDescription(rs.getString("product_description"));
                p.setProductDetail(rs.getString("product_detail"));
                p.setBrand(rs.getString("brand"));
                p.setPrice(rs.getDouble("price"));
                p.setOriginPrice(rs.getDouble("origin_price"));
                p.setDiscount(rs.getDouble("discount"));
                p.setStockQuantity(rs.getInt("stock_quantity"));
                p.setCreatedAt(rs.getTimestamp("created_at"));

                p.setImageURLs(getAllImageOfProduct(id));
                list.add(p);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
