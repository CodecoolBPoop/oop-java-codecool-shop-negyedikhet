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
    private String billingAddress;
    private String shippingAddress;

    public String getName() {
        return name;
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

    public Customer(String name, String email, String billingAddress, String shippingAddress){
        this.name = name;
        this.email = email;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }
}
