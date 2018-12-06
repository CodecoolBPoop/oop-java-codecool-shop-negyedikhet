package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        this.productMemory = ProductDaoJdbc.getInstance();
        this.categoryMemory = ProductCategoryDaoJdbc.getInstance();
        this.supplierMemory = SupplierDaoJdbc.getInstance();
        this.dummyCategory = new ProductCategory("Test", "Test", "Test desc");
        this.dummySupplier = new Supplier("Test", "Test desc");
        this.categoryMemory.add(dummyCategory);
        this.supplierMemory.add(dummySupplier);
        this.dummyProduct = new Product("Test", 42, "USD", "TestDesc ", dummyCategory, dummySupplier);
        this.productMemory.add(dummyProduct);
    }

    @Test
    void assertAddNotNull() {
        productMemory.add(dummyProduct);
        assertNotNull(productMemory.find(1));
    }

    @Test
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
    void assertGetBySupplierReturnsElements() {
        Supplier supplier = supplierMemory.find(2);
        assertTrue(productMemory.getBy(supplier).collect(Collectors.toList()).size() > 0);
    }

    @Test
    void assertGetByCategoryReturnsElements() {
        ProductCategory category = categoryMemory.find(2);
        assertTrue(productMemory.getBy(category).collect(Collectors.toList()).size() > 0);
    }

    @Test
    void assertCrossedGetByReturnsElementsWhenGetsNulls() {
        assertTrue(productMemory.getBy(null, null).collect(Collectors.toList()).size() > 0);
    }
    @Test
    void assertCrossedGetByReturnsElementsWhenCategoryIsNull() {
        Supplier supplier = supplierMemory.find(2);
        assertTrue(productMemory.getBy(null, supplier).collect(Collectors.toList()).size() >= 1);
    }

    @Test
    void assertCrossedGetByReturnsElementsWhenSupplierIsNull() {
        ProductCategory category = categoryMemory.find(2);
        assertTrue(productMemory.getBy(category, null).collect(Collectors.toList()).size() >= 1);
    }

}