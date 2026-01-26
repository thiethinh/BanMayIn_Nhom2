package com.papercraft.dao;

import com.papercraft.db.DBConnect;
import com.papercraft.model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ProductDAO {
    private static final String ROOT_PATH = "images/upload/";


    // get all product just for present product card in main page
    public List<Product> getAllProducts(String type) {
        List<Product> list = new ArrayList<>();

        String sql = """
                    SELECT p.id, p.product_name, p.category_id, p.description_thumbnail, p.brand, p.price, i.img_name
                    FROM product p
                    JOIN category c ON p.category_id = c.id
                    JOIN image i ON p.id = i.entity_id
                    WHERE c.type = ? AND i.is_thumbnail = 1 AND i.entity_type = 'Product';
                """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, type);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = new Product();


                    p.setId(rs.getInt("id"));
                    p.setCategoryId(rs.getInt("category_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                    p.setBrand(rs.getString("brand"));


                    p.setPrice(rs.getDouble("price"));


                    String imgName = rs.getString("img_name");
                    if (imgName != null && !imgName.trim().isEmpty()) {

                        p.setThumbnail("images/upload/" + rs.getString("img_name"));
                    } else {
                        p.setThumbnail("images/logo.webp"); // Ảnh mặc định nếu thiếu
                    }

                    list.add(p);
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi tại getAllProducts với type = " + type);
            e.printStackTrace();
        }

        return list;
    }

    // getAllImageOfProduct
    public List<String> getAllImageOfProduct(int id) {
        List<String> images = new ArrayList<>();

        String sql = "SELECT img_name FROM image WHERE entity_id = ? AND entity_type = 'Product' AND is_thumbnail = 0 AND img_name IS NOT NULL";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String imgName = rs.getString("img_name");
                    if (imgName != null && !imgName.trim().isEmpty()) {

                        images.add("images/upload/" + imgName.trim());
                    }
                }
            }
        } catch (Exception e) {

            System.err.println("Lỗi tại getAllImageOfProduct với Product ID: " + id);
            e.printStackTrace();
        }
        return images;
    }

    // getFeaturedProductsByCategory
    public List<Product> getFeaturedProductsByType(String type) {
        List<Product> list = new ArrayList<>();


        String sql = """
                SELECT p.id, p.product_name, p.category_id, p.description_thumbnail, p.brand, p.price, i.img_name, p.discount, p.origin_price
                FROM product p
                JOIN category c ON p.category_id = c.id
                LEFT JOIN image i ON i.entity_id = p.id
                AND i.is_thumbnail = 1
                AND i.entity_type = 'Product'
                WHERE c.type = ? 
                ORDER BY p.discount DESC
                LIMIT 10;
                """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, type);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = new Product();


                    p.setId(rs.getInt("id"));
                    p.setCategoryId(rs.getInt("category_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                    p.setBrand(rs.getString("brand"));
                    p.setDiscount(rs.getDouble("discount"));
                    p.setOriginPrice(rs.getDouble("origin_price"));

                    p.setPrice(rs.getDouble("price"));


                    String imgName = rs.getString("img_name");
                    if (imgName != null && !imgName.isEmpty()) {

                        p.setThumbnail("images/upload/" + imgName);
                    } else {

                        p.setThumbnail("images/logo.webp");
                    }

                    list.add(p);
                }
            }
        } catch (Exception e) {

            System.err.println("Lỗi tại getFeaturedProductsByType: " + e.getMessage());
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

        //  Điều kiện sắp xếp
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

    //Thêm một sản phẩm mới vào cơ sở dữ liệu.
    public boolean insertProduct(Product product) throws Exception {

        String sql = "INSERT INTO product (category_id, product_name, description_thumbnail, product_description, product_detail, " +
                "brand, price, origin_price, discount, stock_quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = DBConnect.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Lấy ID tự tăng
        ) {

            ps.setInt(1, product.getCategoryId());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getDescriptionThumbnail());
            ps.setString(4, product.getProductDescription());
            ps.setString(5, product.getProductDetail());
            ps.setString(6, product.getBrand());
            ps.setDouble(7, product.getPrice());
            ps.setDouble(8, product.getOriginPrice());
            ps.setDouble(9, product.getDiscount());
            ps.setInt(10, product.getStockQuantity());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int generatedId = rs.getInt(1);
                        product.setId(generatedId); // Gán ID mới cho đối tượng Product
                    }
                }
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.err.println("SQL Error when inserting product: " + e.getMessage());
            e.printStackTrace();

            throw new RuntimeException("Database error occurred while adding a new product.", e);
        }
    }

    // Lấy product bởi id
    public Product getProductById(int id) {
        Product p = null;
        String sql = """
                SELECT p.*, i.img_name, c.type
                FROM product p
                JOIN category c ON p.category_id = c.id
                LEFT JOIN image i ON p.id = i.entity_id
                AND i.is_thumbnail = 1
                AND i.entity_type = 'Product'
                WHERE p.id = ?
                """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new Product();
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

                    p.setType(rs.getString("type"));
                    p.setThumbnail("images/upload/" + rs.getString("img_name"));
//                    p.setThumbnail(rs.getString("img_name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public Set<String> getAllBrandByType(String type) {
        Set<String> brands = new TreeSet<>();
        String sql = """
                SELECT DISTINCT p.brand
                FROM product p
                JOIN category c on c.id = p.category_id
                WHERE c.type = ?
                """;
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, type);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    brands.add(rs.getString("brand"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return brands;
    }

    public List<Product> filterProduct(String type, String search, int categoryId, String brand, String sort){
        List<Product> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder(
                """
                    SELECT p.id, p.product_name, p.category_id, p.description_thumbnail, p.brand,  p.origin_price,p.discount,p.price, i.img_name, AVG(r.rating) as avg_rating
                    FROM product p
                    JOIN category c ON p.category_id = c.id
                    JOIN image i ON p.id = i.entity_id
                    LEFT JOIN review r ON r.product_id = p.id
                    WHERE c.type = ? AND i.is_thumbnail = 1 AND i.entity_type = 'Product'
                """
        );

        List<Object> params = new ArrayList<>();
        params.add(type);
        if (search != null) {
            sql.append(" AND p.product_name LIKE ?");
            params.add("%" + search + "%");
        }

        if (categoryId > 0) {
            sql.append(" AND p.category_id = ?");
            params.add(categoryId);
        }
        if (brand != null) {
            sql.append(" AND p.brand = ?");
            params.add(brand);
        }

        sql.append(" GROUP BY p.id, p.product_name, p.category_id, p.description_thumbnail, p.brand, p.origin_price,p.discount,p.price, i.img_name");

        switch (sort) {
            case "priceAsc" -> sql.append(" ORDER BY p.price ASC");
            case "priceDesc" -> sql.append(" ORDER BY p.price DESC");
            default -> sql.append(" ORDER BY avg_rating IS NULL, avg_rating DESC"); // ORDER BY avg_rating IS NULL,
        }

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            try(ResultSet rs = ps.executeQuery();){
                while (rs.next()) {
                    Product p = new Product();


                    p.setId(rs.getInt("id"));
                    p.setCategoryId(rs.getInt("category_id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                    p.setBrand(rs.getString("brand"));
                    p.setOriginPrice(rs.getDouble("origin_price"));
                    p.setPrice(rs.getDouble("price"));
                    p.setAvgRating(rs.getDouble("avg_rating"));
                    p.setDiscount(rs.getDouble("discount"));

                    String imgName = rs.getString("img_name");
                    if (imgName != null && !imgName.trim().isEmpty()) {

                        p.setThumbnail("images/upload/" + rs.getString("img_name"));
                    } else {
                        p.setThumbnail("images/logo.webp"); // Ảnh mặc định nếu thiếu
                    }

                    list.add(p);

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }


    public List<Product> getProductForManagement() {
        List<Product> products = new ArrayList<>();

        String sql = """
        SELECT p.id, p.product_name, p.price, p.stock_quantity, c.type, i.img_name
        FROM product p
        JOIN category c ON c.id = p.category_id
        LEFT JOIN image i 
               ON i.entity_id = p.id 
              AND i.entity_type = 'Product'
              AND i.is_thumbnail = 1
        ORDER BY p.id DESC
    """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product();

                p.setId(rs.getInt("id"));
                p.setProductName(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setStockQuantity(rs.getInt("stock_quantity"));
                p.setType(rs.getString("type"));

                String imgName = rs.getString("img_name");
                if (imgName != null && !imgName.trim().isEmpty()) {
                    p.setThumbnail("images/upload/" + imgName.trim());
                } else {
                    p.setThumbnail("images/logo.webp");
                }

                products.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }


    public boolean deleteProductById(int id){
        String sql = """
                DELETE FROM product
                WHERE id =?
                """;
        try(Connection conn = DBConnect.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql) ){
            ps.setInt(1, id);
            int rowDeleted = ps.executeUpdate();
            return rowDeleted >0;
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Product getProductForEditById(int idProduct) {
        String sql = """
        SELECT p.id, p.category_id, p.product_name, p.price, p.origin_price, p.discount,
               p.description_thumbnail, p.product_description, p.product_detail, p.stock_quantity,
               c.type,
               i.img_name
        FROM product p
        JOIN category c ON c.id = p.category_id
        LEFT JOIN image i ON i.entity_id = p.id
            AND i.entity_type = 'Product'
            AND i.is_thumbnail = 1
        WHERE p.id = ?
    """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idProduct);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setCategoryId(rs.getInt("category_id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setOriginPrice(rs.getDouble("origin_price"));
                    product.setDiscount(rs.getDouble("discount"));
                    product.setDescriptionThumbnail(rs.getString("description_thumbnail"));
                    product.setProductDescription(rs.getString("product_description"));
                    product.setProductDetail(rs.getString("product_detail"));
                    product.setStockQuantity(rs.getInt("stock_quantity"));
                    product.setType(rs.getString("type"));

                    String imgName = rs.getString("img_name");
                    if (imgName != null && !imgName.trim().isEmpty()) {
                        product.setThumbnail("images/upload/" + imgName.trim());
                    } else {
                        product.setThumbnail("logo.webp");
                    }

                    return product;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean insertImage(Connection conn, int entityId, String entityType, String imgName, boolean isThumbnail) throws Exception {
        String sql = "INSERT INTO image(entity_id, entity_type, img_name, is_thumbnail) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, entityId);
            ps.setString(2, entityType);
            ps.setString(3, imgName);
            ps.setByte(4, (byte) (isThumbnail ? 1 : 0));
            return ps.executeUpdate() > 0;
        }
    }



    public boolean updateProduct(Product p) throws Exception {
        String sql = """
        UPDATE product
        SET category_id = ?, product_name = ?, product_description = ?, product_detail = ?,
            origin_price = ?, price = ?, stock_quantity = ?
        WHERE id = ?
    """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getCategoryId());
            ps.setString(2, p.getProductName());
            ps.setString(3, p.getProductDescription());
            ps.setString(4, p.getProductDetail());
            ps.setDouble(5, p.getOriginPrice());
            ps.setDouble(6, p.getPrice());
            ps.setInt(7, p.getStockQuantity());
            ps.setInt(8, p.getId());

            return ps.executeUpdate() > 0;
        }
    }
    //SEARCH
    public List<Product> searchProductForAdmin(String keyword) {
        List<Product> list = new ArrayList<>();


        String sql = """
        SELECT p.id, p.product_name, p.price, p.stock_quantity, c.type, i.img_name
        FROM product p
        JOIN category c ON c.id = p.category_id
        LEFT JOIN image i 
               ON i.entity_id = p.id 
              AND i.entity_type = 'Product'
              AND i.is_thumbnail = 1
        WHERE p.product_name LIKE ? 
        ORDER BY p.id DESC
    """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Nếu keyword rỗng thì tìm tất cả (%%), ngược lại thì tìm theo từ khóa
            String search = (keyword == null || keyword.trim().isEmpty()) ? "%%" : "%" + keyword.trim() + "%";

            ps.setString(1, search);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = new Product();
                    p.setId(rs.getInt("id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setStockQuantity(rs.getInt("stock_quantity"));
                    p.setType(rs.getString("type"));

                    String imgName = rs.getString("img_name");
                    if (imgName != null && !imgName.isEmpty()) {
                        p.setThumbnail("images/upload/" + imgName);
                    } else {
                        p.setThumbnail("images/logo.webp");
                    }
                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // Thêm vào class ProductDAO

    // Đếm tổng số sản phẩm => số trang
    public int countProducts(String keyword) {
        String sql = "SELECT COUNT(*) FROM product WHERE product_name LIKE ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String search = (keyword == null || keyword.trim().isEmpty()) ? "%%" : "%" + keyword.trim() + "%";
            ps.setString(1, search);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Lấy danh sách sản phẩm có Phân trang & Tìm kiếm
    public List<Product> getProductsPagination(String keyword, int page, int pageSize) {
        List<Product> list = new ArrayList<>();

        // Tính vị trí bắt đầu( số sp_trang cần bỏ qua để đến trang cần tìm)
        int offset = (page - 1) * pageSize; // (page -1): tính từ trang 0

        String sql = """
        SELECT p.id, p.product_name, p.price, p.stock_quantity, c.type, i.img_name
        FROM product p
        JOIN category c ON c.id = p.category_id
        LEFT JOIN image i 
               ON i.entity_id = p.id 
              AND i.entity_type = 'Product'
              AND i.is_thumbnail = 1
        WHERE p.product_name LIKE ?
        ORDER BY p.id DESC
        LIMIT ? OFFSET ?
    """;

        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String search = (keyword == null || keyword.trim().isEmpty()) ? "%%" : "%" + keyword.trim() + "%";

            ps.setString(1, search);
            ps.setInt(2, pageSize); // số dòng lấy
            ps.setInt(3, offset);   // số dòng bỏ qua

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product p = new Product();
                    p.setId(rs.getInt("id"));
                    p.setProductName(rs.getString("product_name"));
                    p.setPrice(rs.getDouble("price"));
                    p.setStockQuantity(rs.getInt("stock_quantity"));
                    p.setType(rs.getString("type"));

                    String imgName = rs.getString("img_name");
                    p.setThumbnail((imgName != null && !imgName.isEmpty()) ? "images/upload/" + imgName.trim() : "images/logo.webp");

                    list.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}




