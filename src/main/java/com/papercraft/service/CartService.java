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
        public List<Map<String, Object>> items; //Danh sách SP trong giỏ (SP + số lượng + tổng tiền từng dòng)
        public BigDecimal subTotal; //Tổng tiền hàng
        public BigDecimal vat;
        public BigDecimal shippingFee;
        public BigDecimal grandTotal;

        public CartResult() {
            this.items = new ArrayList<>();
            this.subTotal = BigDecimal.ZERO;
            this.vat = BigDecimal.ZERO;
            this.shippingFee = BigDecimal.ZERO;
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
        // Tính phí vận chuyển
        BigDecimal threshold = new BigDecimal("5000000"); // Từ 5 triệu

        BigDecimal fee = new BigDecimal("50000"); // phí ship 50k

        // Nếu Tạm tính >= 5.000.000 thì Miễn phí, ngược lại là 50.000
        if (result.subTotal.compareTo(threshold) >= 0) {
            result.shippingFee = BigDecimal.ZERO;
        } else {
            result.shippingFee = fee;
        }

        // TÍNH TOÁN THUẾ & TỔNG CỘNG (5%)
        result.vat = result.subTotal.multiply(new BigDecimal("0.05"));

        // Tổng cộng = Tạm tính + VAT + ShippingFee
        result.grandTotal = result.subTotal.add(result.vat).add(result.shippingFee);

        return result;
    }
}