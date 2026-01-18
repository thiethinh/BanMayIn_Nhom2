package com.papercraft.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {
    public Integer id;
    public Integer orderId;
    public Integer productId;
    public Integer quantity;
    public BigDecimal price;
    public Product product;
    public BigDecimal total;

    public OrderItem() {
    }

    public OrderItem(Integer id, Integer orderId, Integer productId, Integer quantity, BigDecimal price) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.product = null;
        this.total= price.multiply(BigDecimal.valueOf(quantity));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
