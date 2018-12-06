package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.order.Customer;
import com.codecool.shop.order.Order;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/checkout"})

public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        HttpSession mySession = req.getSession();
        Order myOrder = (Order) mySession.getAttribute("order");
        context.setVariable("recipient", "World");
        context.setVariable("description", "Jingling Webshop");
        context.setVariable("amountpaypal", myOrder.getCartTotalPrice());
        context.setVariable("amountcreditcard", myOrder.getCartTotalPrice()* 100);
        engine.process("checkout.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String billingAddress = req.getParameter("billingAddress");
        String shippingAddress = req.getParameter("shippingAddress");
        Customer customer = new Customer(name,email,phone,billingAddress,shippingAddress);
        HttpSession mySession = req.getSession();
        Order myOrder = (Order) mySession.getAttribute("order");
        myOrder.setCustomer(customer);
        System.out.println(myOrder.getCustomer());
    }
}
