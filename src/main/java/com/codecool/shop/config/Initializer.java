package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier lipoti = new Supplier("Lipoti", "Freshly baked products");
        supplierDataStore.add(lipoti);
        Supplier gucci = new Supplier("Gucci", "Clothing");
        supplierDataStore.add(gucci);
        Supplier surefire = new Supplier("Surefire", "Christmas decorations");
        supplierDataStore.add(surefire);
        Supplier milka = new Supplier("Milka", "Christmas chocolates");
        supplierDataStore.add(milka);
        Supplier rudolf = new Supplier("Rudolf", "Artificial christmas trees");
        supplierDataStore.add(rudolf);
        Supplier ginger = new Supplier("GingerFactory", "Christmas cookies");
        supplierDataStore.add(ginger);


        //setting up a new product category
        ProductCategory clothes = new ProductCategory("Clothes", "Clothes", "Festive sweaters.");
        productCategoryDataStore.add(clothes);
        ProductCategory cookie = new ProductCategory("Cookie", "Food", "Finest freshly baked christmas cookies.");
        productCategoryDataStore.add(cookie);
        ProductCategory decor = new ProductCategory("Decoration", "Decoration", "Small christmas decorations");
        productCategoryDataStore.add(decor);
        ProductCategory chocolatecandy = new ProductCategory("ChocolateCandy", "Food", "Hungarian Christmas-candy speciality");
        productCategoryDataStore.add(chocolatecandy);
        ProductCategory tree = new ProductCategory("Christmas Tree", "Decoration", "Christmas trees");
        productCategoryDataStore.add(tree);


        //setting up products and printing it
        productDataStore.add(new Product("Sweater with bow", 25, "USD", "Beautiful gift for your loved ones.", clothes, lipoti));
        productDataStore.add(new Product("Star Wars sweater", 32, "USD", "The perfect present for Star Wars fans. ", clothes, lipoti));
        productDataStore.add(new Product("Kitten sweater", 39, "USD", "How else could you surprise your beloved girlfriend?", clothes, lipoti));
        productDataStore.add(new Product("Gingerbread - Tree", 9, "USD", "Finest freshly baked gingerbread.", cookie, ginger));
        productDataStore.add(new Product("Gingerbread - Classic", 2, "USD", "Classic gingerbread figure.", cookie, ginger));
        productDataStore.add(new Product("Gingerbread - House", 19, "USD", "Handmade gingerbread house.", cookie, ginger));
        productDataStore.add(new Product("Christmas Bejgli", 9, "USD", "Walnut flavoured hungarian cookie speciality.", cookie, ginger));
        productDataStore.add(new Product("Xmas Ball - Red", 1, "USD", "Shiny red christmas decoration ball", decor, surefire));
        productDataStore.add(new Product("Xmas Ball - Blue", 1, "USD", "Shiny blue christmas decoration ball", decor, surefire));
        productDataStore.add(new Product("Xmas Ball - Purple", 1, "USD", "Shiny purple christmas decoration ball", decor, surefire));
        productDataStore.add(new Product("Wreath - Simple", 19, "USD", "Simple, but beautiful Christmas wreath", decor, surefire));
        productDataStore.add(new Product("Wreath - Classic", 25, "USD", "Classic, decorated Christmas wreath", decor, surefire));
        productDataStore.add(new Product("Wreath - Silver", 39, "USD", "Special silver colored Christmas wreath ", decor, surefire));
        productDataStore.add(new Product("Xmas candy - Marzipan ", 9, "USD", "Marzipan flavoured hungarian choco-candy speciality.", chocolatecandy, milka));
        productDataStore.add(new Product("Xmas candy - Selection", 15, "USD", "Selection of hungarian choco-candy specialities.", chocolatecandy, milka));
        productDataStore.add(new Product("Xmas candy - Nut", 9, "USD", "Nut flavoured hungarian choco-candy speciality.", chocolatecandy, milka));
        productDataStore.add(new Product("Xmas Tree - Silver", 59, "USD", "Silver colored Christmas tree", tree, rudolf));
        productDataStore.add(new Product("Xmas Tree - Soft", 49, "USD", "Christmas tree with especially soft leaves", tree, rudolf));
        productDataStore.add(new Product("Xmas Tree - Forest", 79, "USD", "Forest Christmas tree", tree, rudolf));
        productDataStore.add(new Product("Xmas Tree - Classic", 39, "USD", "Classic Christmas tree", tree, rudolf));

    }
}
