package com.papercraft.controller;

import com.papercraft.dao.ImageDAO;
import com.papercraft.dao.ProductDAO;
import com.papercraft.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProductServlet"})
//servlet nhận và giới hạn upload file ảnh
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,      // 1MB
        maxFileSize = 10 * 1024 * 1024,       // 10MB/file
        maxRequestSize = 30 * 1024 * 1024     // 30MB/request
)
public class AddProductServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "images" + File.separator + "upload";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/admin-product-add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            String name = trim(request.getParameter("name"));
            String categoryIdStr = trim(request.getParameter("categoryId"));
            String priceStr = trim(request.getParameter("price"));
            String discountStr = trim(request.getParameter("discount"));
            String stockStr = trim(request.getParameter("stock"));
            String description = trim(request.getParameter("description"));
            String details = trim(request.getParameter("details"));
            String specs = trim(request.getParameter("specs"));

            if (name.isEmpty() || categoryIdStr.isEmpty() || priceStr.isEmpty() || stockStr.isEmpty()) {
                request.setAttribute("error", "Vui lòng nhập đầy đủ Tên SP / Loại SP / Giá / Số lượng.");
                request.getRequestDispatcher("/admin-product-add.jsp").forward(request, response);
                return;
            }

            int categoryId = Integer.parseInt(categoryIdStr);
            double price = Double.parseDouble(priceStr);

            double discountPercent = discountStr.isEmpty() ? 0 : Double.parseDouble(discountStr);
            if (discountPercent < 0) discountPercent = 0;
            if (discountPercent > 100) discountPercent = 100;
            double discount = discountPercent / 100.0;

            int stock = Integer.parseInt(stockStr);
            if (stock < 0) stock = 0;

            String descriptionThumbnail = makeThumbnailText(description);
            String brand = extractBrandFromSpecs(specs);

            // ==== Upload =====
            String appPath = request.getServletContext().getRealPath("");
            String uploadPath = appPath + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            Part thumbPart = request.getPart("image");
            String thumbFileName = saveUploadIfPresent(thumbPart, uploadPath);

            List<String> galleryFiles = new ArrayList<>();
            for (Part part : request.getParts()) {
                if ("gallery".equals(part.getName()) && part.getSize() > 0) {
                    String fn = saveUploadIfPresent(part, uploadPath);
                    if (!fn.isEmpty()) galleryFiles.add(fn);
                }
            }
            if (galleryFiles.size() > 2) galleryFiles = galleryFiles.subList(0, 2);

            // ======== Insert Product =====
            Product p = new Product();
            p.setCategoryId(categoryId);
            p.setProductName(name);
            p.setDescriptionThumbnail(descriptionThumbnail);
            p.setProductDescription(description);
            p.setProductDetail(details);
            p.setBrand(brand);

            p.setOriginPrice(price);
            p.setDiscount(discount);
            p.setPrice(price * (1.0 - discount));
            p.setStockQuantity(stock);

            ProductDAO productDAO = new ProductDAO();
            ImageDAO imageDAO = new ImageDAO();

            boolean ok = productDAO.insertProduct(p);
            if (!ok) {
                request.setAttribute("error", "Thêm sản phẩm thất bại.");
                request.getRequestDispatcher("/admin-product-add.jsp").forward(request, response);
                return;
            }

            int newProductId = p.getId();

            if (!thumbFileName.isEmpty()) {
                imageDAO.insertImage(newProductId, "Product", thumbFileName, true);
            }

            for (String gf : galleryFiles) {
                imageDAO.insertImage(newProductId, "Product", gf, false);
            }

            response.sendRedirect(request.getContextPath() + "/admin-product?msg=add_success");



        } catch (NumberFormatException e) {
            request.setAttribute("error", "Dữ liệu số không hợp lệ (giá/giảm giá/số lượng).");
            request.getRequestDispatcher("/admin-product-add.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi hệ thống: " + e.getMessage());
            request.getRequestDispatcher("/admin-product-add.jsp").forward(request, response);
        }
    }

    private static String trim(String s) {
        return (s == null) ? "" : s.trim();
    }

    private static String makeThumbnailText(String description) {
        if (description == null) return "";
        String d = description.trim();
        return (d.length() <= 160) ? d : d.substring(0, 160) + "...";
    }

    private static String extractBrandFromSpecs(String specs) {
        if (specs == null) return "";
        String s = specs.trim();
        if (s.isEmpty()) return "";
        try {
            var m = java.util.regex.Pattern
                    .compile("\"brand\"\\s*:\\s*\"(.*?)\"")
                    .matcher(s);
            if (m.find()) return m.group(1);
        } catch (Exception ignored) {}
        return "";
    }

    private static String saveUploadIfPresent(Part part, String uploadPath) throws IOException {
        if (part == null || part.getSize() <= 0) return "";

        String submitted = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if (submitted == null || submitted.trim().isEmpty()) return "";

        String ext = "";
        int dot = submitted.lastIndexOf('.');
        if (dot >= 0) ext = submitted.substring(dot);

        String newName = UUID.randomUUID().toString().replace("-", "") + ext;
        part.write(uploadPath + File.separator + newName);

        return newName;
    }
}
