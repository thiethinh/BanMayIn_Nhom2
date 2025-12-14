package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product_DAO {

//    getAllProducts
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";

        //  try-with-resources cho Connection và PreparedStatement
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // try-with-resources cho ResultSet
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Product p = new Product();

                    // Gán
                    p.setId(rs.getInt("id"));
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

//    getAllImageOfProduct
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

//getFeaturedProductsByCategory
public List<Product> getFeaturedProductsByCategory(int categoryId) {
    List<Product> list = new ArrayList<>();


    String sql = "SELECT p.*, i.img_url " +
            "FROM product p " +
            "LEFT JOIN image i ON p.id = i.entity_id " +
            "AND i.is_thumbnail = 1 " +
            "WHERE p.category_id = ? " +
            "ORDER BY p.discount DESC " +
            "LIMIT 10 ";


    try (Connection conn = DBConnect.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        //  Gán tham số cho PreparedStatement
        ps.setInt(1, categoryId);

        // Áp dụng try-with-resources cho ResultSet
        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product();
                int id = rs.getInt("id");

                //  Gán dữ liệu từ ResultSet vào Product
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

                //lấy các ảnh
                p.setImageURLs(getAllImageOfProduct(id));

                list.add(p);
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}


//       searchProducts
        public List<Product> searchProducts(String keyword, int categoryId, String sortBy, int offset, int limit) {
            List<Product> list = new ArrayList<>();

            StringBuilder sql = new StringBuilder("SELECT p.* FROM product p WHERE 1=1 ");


            List<Object> parameters = new ArrayList<>();

            // tìm kiếm theo từ khóa
            if (keyword != null && !keyword.trim().isEmpty()) {
                sql.append(" AND p.product_name LIKE ? "); //nối chuỗi
                parameters.add("%" + keyword.trim() + "%");
            }


            if (categoryId > 0) {
                sql.append(" AND p.category_id = ? ");
                parameters.add(categoryId);
            }


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





            try (Connection conn = DBConnect.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql.toString())) {


                for (int i = 0; i < parameters.size(); i++) {
                    Object param = parameters.get(i);
                    int paramIndex = i + 1;

                    if (param instanceof String) {
                        ps.setString(paramIndex, (String) param);
                    } else if (param instanceof Integer) {
                        ps.setInt(paramIndex, (Integer) param);
                    }

                }


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

//        Product details
public Product getProductById(int id) {
    Product product = null;


    String sql = "SELECT p.*, i.img_name AS thumbnail_url " +
            "FROM product p " +
            "LEFT JOIN image i ON p.id = i.entity_id AND i.is_thumbnail = 1 AND i.entity_type = 'product' " +
            "WHERE p.id = ?";


    try (
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
    ) {
        ps.setInt(1, id);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                product = new Product();


                product.setId(rs.getInt("id"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                product.setProductDescription(rs.getString("product_description"));
                product.setProductDetail(rs.getString("product_detail"));
                product.setBrand(rs.getString("brand"));
                product.setPrice(rs.getDouble("price"));
                product.setOriginPrice(rs.getDouble("origin_price"));
                product.setDiscount(rs.getDouble("discount"));
                product.setStockQuantity(rs.getInt("stock_quantity"));
                product.setCreatedAt(rs.getTimestamp("created_at"));



                 product.setImageURLs(getAllImageOfProduct(id));
            }
        }

    } catch (SQLException e) {
        System.err.println("SQL Error : " + e.getMessage());
        e.printStackTrace();
        throw new RuntimeException("Database error occurred while fetching product ID " + id, e);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    return product;
}

    }




