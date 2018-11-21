package com.codecool.shop.order;

public class Customer {

    /*Given I have a Shopping Cart review page
    When I click on the "Checkout" button
    Then ensure it asks the following data from the User:
            - Name
  - Email
  - Phone number
  - Billing Address (Country, City, Zipcode, Address)
  - Shipping Address (Country, City, Zipcode, Address)
    And it stores the validated data to the Order
    Then it redirects to the Payment page*/

    private String name;
    private String email;
    private String phone;
    private String billingAddress;
    private String shippingAddress;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Customer(String name, String email, String phone, String billingAddress, String shippingAddress){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", email: " + email + ", phone: " + phone + ", billing address: " + billingAddress + ", shipping address: " + shippingAddress;
    }
}
