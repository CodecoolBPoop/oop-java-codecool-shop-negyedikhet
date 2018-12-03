package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.model.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryDaoTest {
    private ProductCategoryDao memory;
    private ProductCategory dummyCategory;

    @BeforeEach
    void setUp() {
        this.memory = ProductCategoryDaoMem.getInstance();
        this.dummyCategory = new ProductCategory("Test", "Test", "Test desc");
    }


    @org.junit.jupiter.api.Test
    void assertAddNotNull() {
        memory.add(dummyCategory);
        assertNotNull(memory.find(1));
    }


    @org.junit.jupiter.api.Test
    void assertRemoveSetsNull() {
        memory.remove(0);
        assertNull(memory.find(0));
    }

    @org.junit.jupiter.api.Test
    void assertGetAllSize() {
        memory.add(dummyCategory);
        memory.add(dummyCategory);
        assertTrue(memory.getAll().size() > 1);
    }

    @Test
    void assertRemoveNotThrowsError() {
        memory.remove(999);
    }

    @Test
    void assertFindNotThrowsError() {
        memory.find(-999);
    }

    @Test
    void assertAddThrowsError() {
        assertThrows(IllegalArgumentException.class, ()-> {
            memory.add(new ProductCategory("name", null,null));
        });
    }

}