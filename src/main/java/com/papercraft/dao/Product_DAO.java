package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Product_DAO {
    private static final String ROOT_PATH ="/images/upload";

    // get all product just for present product card in main page
    public List<Product> getAllProducts(String type) {
        List<Product> list = new ArrayList<>();
        String sql = """
            SELECT p.id, p.product_name,p.category_id, p.description_thumbnail,p.brand, p.price, i.image_name
            FROM product p 
            JOIN category c ON p.category_id = c.id
            JOIN image i ON p.id = i.entiry_id
            WHERE c.type=? AND i.is_thumbnail =1
            """;

        //  try-with-resources cho Connection và PreparedStatement
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,type);
            // try-with-resources cho ResultSet
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Product p = new Product();
                    // Gán
                    p.setId(rs.getInt("id"));
                    p.setCategoryId(rs.getInt("category_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                    p.setBrand(rs.getString("brand"));
                    p.setPrice(rs.getDouble("price"));
                    p.setThumbnail(ROOT_PATH+ rs.getString("img_name"));
                    list.add(p);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // getAllImageOfProduct
    public List<List<String>> getAllImageOfProduct(int id) {
        List<List<String>> images = new ArrayList<>();
        String sql = """
                SELECT i.img_name, i.is_thumbnail
                FROM product p
                JOIN image i ON i.entity_id =p.id
                WHERE p.id =?;
                """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    List<String> image = new ArrayList<>();
                    image.add(rs.getString("image_name"));
                    image.add(String.valueOf(rs.getBoolean("is_thumbnail")));
                    images.add(image);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return images;
    }

    // get top 10 product with the biggest discounts
    public List<Product> getFeaturedProductsByType(String type) {
        List<Product> list = new ArrayList<>();

        String sql = """
                     SELECT p.id, p.product_name,p.category_id, p.description_thumbnail,p.brand, p.price, i.image_name
                    FROM product p
                    JOIN category c ON p.category_id = c.id
                    LEFT JOIN image i ON i.entity_id = p.id
                    AND i.is_thumbnail = 1
                    WHERE c.type = ? 
                    ORDER BY p.discount DESC
                    LIMIT 10;
                    """;


        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            //  Gán tham số cho PreparedStatement
            ps.setString(1, type);

            // Áp dụng try-with-resources cho ResultSet
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Product p = new Product();
                    int id = rs.getInt("id");

                    //  Gán dữ liệu từ ResultSet vào Product
                    p.setId(id);
                    p.setId(rs.getInt("id"));
                    p.setCategoryId(rs.getInt("category_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                    p.setBrand(rs.getString("brand"));
                    p.setPrice(rs.getDouble("price"));
                    p.setThumbnail(ROOT_PATH+rs.getString("img_name"));

                    list.add(p);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    // searchProducts
    public List<Product> searchProducts(String keyword, int categoryId, String sortBy, int offset, int limit) {
        List<Product> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT p.* FROM product p WHERE 1=1 ");


        List<Object> parameters = new ArrayList<>();

        // tìm kiếm theo từ khóa
        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append(" AND p.product_name LIKE ? "); //nối chuỗi
            parameters.add("%" + keyword.trim() + "%");
        }

        // Điều kiện lọc theo danh mục
        if (categoryId > 0) {
            sql.append(" AND p.category_id = ? ");
            parameters.add(categoryId);
        }

        // 2. Điều kiện sắp xếp
        switch (sortBy) {
            case "price_asc":
                sql.append(" ORDER BY p.price ASC, p.id DESC ");
                break;
            case "price_desc":
                sql.append(" ORDER BY p.price DESC, p.id DESC ");
                break;
            default:
                sql.append(" ORDER BY p.avg_rating DESC, p.id DESC ");
                break;
        }


        // Áp dụng try-with-resources để quản lý tài nguyên JDBC
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            // 4. Gán các tham số cho Prepared Statement theo thứ tự
            for (int i = 0; i < parameters.size(); i++) {
                Object param = parameters.get(i);
                int paramIndex = i + 1;

                if (param instanceof String) {
                    ps.setString(paramIndex, (String) param);
                } else if (param instanceof Integer) {
                    ps.setInt(paramIndex, (Integer) param);
                }
                // Thêm logic gán kiểu dữ liệu khác nếu cần (vd: Double, Date)
            }

            // 5. Thực thi truy vấn và xử lý ResultSet
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = new Product();


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

                    list.add(p);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
