package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.cert.CollectionCertStoreParameters;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoTest {
    private ProductDao productMemory;
    private ProductCategoryDao categoryMemory;
    private SupplierDao supplierMemory;
    private Product dummyProduct;
    private ProductCategory dummyCategory;
    private Supplier dummySupplier;

    @BeforeEach
    void setUp() {
        this.productMemory = ProductDaoMem.getInstance();
        this.categoryMemory = ProductCategoryDaoMem.getInstance();
        this.supplierMemory = SupplierDaoMem.getInstance();
        this.dummyCategory = new ProductCategory("Test", "Test", "Test desc");
        this.dummySupplier = new Supplier("Test", "Test desc");
        this.categoryMemory.add(dummyCategory);
        this.supplierMemory.add(dummySupplier);
        this.dummyProduct = new Product("Test", 42, "USD", "TestDesc ", dummyCategory, dummySupplier);
    }

    @org.junit.jupiter.api.Test
    void assertAddNotNull() {
        productMemory.add(dummyProduct);
        assertNotNull(productMemory.find(1));
    }


    @org.junit.jupiter.api.Test
    void assertRemoveSetsNull() {
        productMemory.remove(0);
        assertNull(productMemory.find(0));
    }

    @org.junit.jupiter.api.Test
    void assertGetAllSize() {
        productMemory.add(dummyProduct);
        productMemory.add(dummyProduct);
        assertTrue(productMemory.getAll().collect(Collectors.toList()).size() > 1);
    }

    @Test
    void assertRemoveNotThrowsError() {
        productMemory.remove(999);
    }

    @Test
    void assertFindNotThrowsError() {
        productMemory.find(-999);
    }

    @Test
    void assertAddThrowsError() {
        assertThrows(IllegalArgumentException.class, ()-> {
            productMemory.add(new Product("Test", 42, "USD", "TestDesc ", null, null));
        });
        assertThrows(IllegalArgumentException.class, ()-> {
            productMemory.add(new Product("Test", -77, "USD", "TestDesc ", dummyCategory, dummySupplier));
        });
    }

    @Test
    void getBy() {
    }

    @Test
    void getBy1() {
    }

    @Test
    void getBy2() {
    }
}