package com.codecool.shop.order;

import com.codecool.shop.model.Product;

public class LineItem {

    private transient Product product;
    private String productName;
    private double productPrice;
    private int quantity;
    private double totalPrice;

    public Product getProduct() {
        return product;
    }

    public String getProductName() {
        return productName;
    }

    public void  setProductName(String productName) {
        this.productName = productName;
    }

    public double  getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int  getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public void calculateTotalPrice() {
        this.totalPrice = quantity * productPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LineItem(Product product) {
        this.product = product;
        this.productName = product.getName();
        this.productPrice = product.getDefaultPrice();
        this.quantity = 1;
        this.totalPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Name: " + productName + ", quantity: " + quantity + ", price per unit: " + productPrice + ", total price: " + totalPrice;
    }
}
