package com.codecool.shop.order;

import com.codecool.shop.model.Product;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public final String NEW = "new";
    public final String CHECKED = "checked";
    public final String PAYED = "payed";
    private int orderId;
    private static int idCounter = 0;
    private String status;
    private Customer customer;

    private List<LineItem> cartContent = new ArrayList<>();
    private int cartSize = 0;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCartSize() {
        return cartSize;
    }

    public  List<LineItem> getCartContent() {
        return cartContent;
    }

    public void addItemToCart(Product product) {

        for (LineItem item : cartContent) {
            if (item.getProduct().getId() == product.getId()) {
                item.increaseQuantity();
                item.calculateTotalPrice();
                calculateCartSize();
                System.out.println("Cart content:" + cartContent);
                System.out.println("Cart size:" + cartSize);
                return;
            }
        }

        product.setLineItem(new LineItem(product));
        cartContent.add(product.getLineItem());
        calculateCartSize();
        System.out.println("Cart content:" + cartContent);
        System.out.println("Cart size:" + cartSize);
    }

    public void subtractItemFromCart(Product product) {
        LineItem lineItemToRemove = null;
        for (LineItem item : cartContent) {
            if (item.getProduct().getId() == product.getId() && item.getQuantity() > 1) {
                item.decreaseQuantity();
                item.calculateTotalPrice();
                calculateCartSize();
                System.out.println("Cart content:" + cartContent);
                System.out.println("Cart size:" + cartSize);
                return;
            } else if (item.getProduct().getId() == product.getId() && item.getQuantity() == 1) {
                lineItemToRemove = item.getProduct().getLineItem();
                calculateCartSize();
                System.out.println("Cart content:" + cartContent);
                System.out.println("Cart size:" + cartSize);
            }
        }
        if (lineItemToRemove != null) {
            cartContent.remove(lineItemToRemove);
            calculateCartSize();
            System.out.println("Cart content:" + cartContent);
            System.out.println("Cart size:" + cartSize);
        }
    }


    public void calculateCartSize() {
        cartSize = cartContent.stream().mapToInt(LineItem::getQuantity).sum();
    }

    public Order(){
        this.orderId = idCounter++;
        this.status = NEW;
    }

}
