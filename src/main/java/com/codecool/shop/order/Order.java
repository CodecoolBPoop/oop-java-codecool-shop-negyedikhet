package com.codecool.shop.order;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static List<LineItem> cartContent = new ArrayList<>();
    private static int cartSize = 0;

    public static int getCartSize() {
        return cartSize;
    }

    public static List<LineItem> getCartContent() {
        return cartContent;
    }

    public static void addItemToCart(Product product) {

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

    public static void calculateCartSize() {
        cartSize = cartContent.stream().mapToInt(LineItem::getQuantity).sum();
    }
}
