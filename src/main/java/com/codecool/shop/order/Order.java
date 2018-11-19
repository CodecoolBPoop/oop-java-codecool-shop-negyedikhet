package com.codecool.shop.order;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private static List<LineItem> cartContent = new ArrayList<>();
    private static int cartSize = cartContent.size();

    public List<LineItem> getCartContent() {
        return cartContent;
    }

    public static void addItemToCart(Product product){
        cartContent.add(new LineItem(product));
        System.out.println("Cart content:"+cartContent);
        System.out.println("Cart size:"+cartSize);
    }

}
