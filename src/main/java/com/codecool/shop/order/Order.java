package com.codecool.shop.order;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<LineItem> cartContent = new ArrayList<>();
    private int cartSize;

    public List<LineItem> getCartContent() {
        return cartContent;
    }

    public void setCartContent(List<LineItem> cartContent) {
        this.cartContent = cartContent;
    }

    public void numberOfCartItems(){
        cartContent.size();
    }

}
