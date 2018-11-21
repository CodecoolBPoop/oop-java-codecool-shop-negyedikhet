package com.codecool.shop.order;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final String NEW = "new";
    public static final String CHECKED = "checked";
    public static final String PAYED = "payed";
    private int orderId;
    private static int idCounter = 0;
    private String status;

    private List<LineItem> cartContent = new ArrayList<>();
    private int cartSize = 0;


    public int getOrderId() {
        return orderId;
    }

    public int getCartSize() {
        return cartSize;
    }

    public List<LineItem> getCartContent() {
        return cartContent;
    }

    public void addItemToCart(Product product) {

        for (LineItem item : cartContent) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity();
                item.calculateTotalPrice();
                calculateCartSize();
                System.out.println("Cart content:" + cartContent);
                System.out.println("Cart size:" + cartSize);
                return;
            }
        }

        cartContent.add(new LineItem(product));
        calculateCartSize();
        System.out.println("Cart content:" + cartContent);
        System.out.println("Cart size:" + cartSize);
    }

    public void calculateCartSize() {
        cartSize = cartContent.stream().mapToInt(LineItem::getQuantity).sum();
    }

    public Order(){
        this.orderId = idCounter++;
        this.status = NEW;
    }
}
