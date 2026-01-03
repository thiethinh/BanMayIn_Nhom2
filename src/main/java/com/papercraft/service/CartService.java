package com.papercraft.service;

import com.papercraft.dao.ProductDAO;
import com.papercraft.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartService {


    public static class CartResult {
        public List<Map<String, Object>> items;
        public BigDecimal subTotal;
        public BigDecimal vat;
        public BigDecimal grandTotal;

        public CartResult() {
            this.items = new ArrayList<>();
            this.subTotal = BigDecimal.ZERO;
            this.vat = BigDecimal.ZERO;
            this.grandTotal = BigDecimal.ZERO;
        }
    }


    public CartResult calculateCart(Map<Integer, Integer> sessionCart) {
        CartResult result = new CartResult();

        // Nếu giỏ hàng trống thì trả về kết quả rỗng luôn
        if (sessionCart == null || sessionCart.isEmpty()) {
            return result;
        }

        ProductDAO productDAO = new ProductDAO();

        // Duyệt qua từng ID trong session
        for (Map.Entry<Integer, Integer> entry : sessionCart.entrySet()) {
            int productId = entry.getKey();
            int qty = entry.getValue();

            Product p = productDAO.getProductById(productId);
            if (p == null) continue; // Bỏ qua nếu không tìm thấy SP

            // LOGIC TÍNH GIÁ

            BigDecimal price = BigDecimal.valueOf(p.getSalePrice());

            // Tính tổng tiền cho tưngf sản phẩm   (Giá bán * Số lượng)
            BigDecimal lineTotal = price.multiply(BigDecimal.valueOf(qty));

            // Cộng dồn Subtotal
            result.subTotal = result.subTotal.add(lineTotal);

            // Tạo Map để lưu thông tin hiển thị ra JSP
            Map<String, Object> item = new HashMap<>();
            item.put("product", p);
            item.put("quantity", qty);
            item.put("total", lineTotal);

            result.items.add(item);
        }

        // TÍNH TOÁN THUẾ & TỔNG CỘNG
        // VAT 5%
        result.vat = result.subTotal.multiply(new BigDecimal("0.05"));

        // Tổng cộng = Tạm tính + VAT
        result.grandTotal = result.subTotal.add(result.vat);

        return result;
    }
}