package com.codecool.shop.controller;

import com.codecool.shop.dao.implementation.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.order.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/add-to-cart"})
public class AddToCartController extends HttpServlet {
    ProductDaoJdbc productDataStore = ProductDaoJdbc.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        Product product = productDataStore.find(productId);
        HttpSession mySession = req.getSession();
        Order myOrder = (Order) mySession.getAttribute("order");
        myOrder.addItemToCart(product);
    }
}
