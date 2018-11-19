package com.codecool.shop.order;

import com.codecool.shop.model.Product;

public class LineItem {

    private String productName;
    private double productPrice;
    private int quantity;
    private double totalPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

        public void setTotalPrice(int quantity){
            this.totalPrice = quantity * productPrice;
        }

        public double getTotalPrice(){
            return totalPrice;
        }

    public LineItem(Product product){
        this.productName = product.getName();
        this.productPrice = product.getDefaultPrice();
        this.quantity = 1;
        this.totalPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Name: " + productName + ", quantity: " + quantity + "price per unit" + productPrice + ", total price: " + totalPrice;
    }
}
