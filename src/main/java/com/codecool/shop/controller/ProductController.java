package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.order.Order;
import com.google.gson.Gson;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

//        Map params = new HashMap<>();
//        params.put("category", productCategoryDataStore.find(1));
//        params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        HttpSession mySession = req.getSession();

        if (mySession.getAttribute("order") == null) {
            Order myOrder = new Order();
            mySession.setAttribute("order", myOrder);
        }

        Integer categoryID = null;
        Integer supplierID = null;
        context.setVariable("recipient", "World");
        context.setVariable("suppliers", supplierDataStore.getAll());
        context.setVariable("categories", productCategoryDataStore.getAll());

        if (!categoryIsNullOrOne(req)) {
            categoryID = Integer.parseInt(req.getParameter("categoryID"));
            context.setVariable("category", productCategoryDataStore.find(categoryID));
            context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(categoryID)));
        }
        if (!supplierIsNullOrOne(req)) {
            supplierID = Integer.parseInt(req.getParameter("supplierID"));
            context.setVariable("supplier", supplierDataStore.find(supplierID));
            context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(supplierID)));
        }

        if (!categoryIsNullOrOne(req) && !supplierIsNullOrOne(req)) {
            List<Product> productsByCategory = productDataStore.getBy(productCategoryDataStore.find(categoryID));
            List<Product> productsBySupplier = productDataStore.getBy(supplierDataStore.find(supplierID));
            List<Product> categorySupplierIntersection = productsByCategory.stream().filter(c -> productsBySupplier.contains(c)).collect(Collectors.toList());
            context.setVariable("products", categorySupplierIntersection);
        }

        if (categoryIsNullOrOne(req)) {
            context.setVariable("category", productCategoryDataStore.find(1));
        }

        if (supplierIsNullOrOne(req)) {
            context.setVariable("supplier", supplierDataStore.find(1));
        }

        if (categoryIsNullOrOne(req) && supplierIsNullOrOne(req)) {
            context.setVariable("category", productCategoryDataStore.find(1));
            context.setVariable("supplier", supplierDataStore.find(1));
            context.setVariable("products", productDataStore.getAll());
        }
        engine.process("product/index.html", context, resp.getWriter());
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();

        resp.setContentType("application/json;charset=UTF-8");
        HttpSession mySession = req.getSession();
        Order myOrder = (Order) mySession.getAttribute("order");
        out.print(new Gson().toJson(myOrder.getCartContent()));
    }

    public boolean categoryIsNullOrOne(HttpServletRequest req) {
        return req.getParameter("categoryID") == null || req.getParameter("categoryID").equals("1");
    }

    public boolean supplierIsNullOrOne(HttpServletRequest req) {
        return req.getParameter("supplierID") == null || req.getParameter("supplierID").equals("1");
    }
}
