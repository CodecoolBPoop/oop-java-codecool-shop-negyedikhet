package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.SupplierDaoJdbc;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierDaoTest {
    private SupplierDao memory;
    private Supplier dummySupplier;

    @BeforeEach
    void setUp() {
        this.memory = SupplierDaoJdbc.getInstance();
        this.dummySupplier = new Supplier("Test", "Test desc");
    }

    @org.junit.jupiter.api.Test
    void assertAddNotNull() {
        memory.add(dummySupplier);
        assertNotNull(memory.find(1));
    }


    @org.junit.jupiter.api.Test
    void assertRemoveSetsNull() {
        memory.remove(0);
        assertNull(memory.find(0));
    }

    @org.junit.jupiter.api.Test
    void assertGetAllSize() {
        memory.add(dummySupplier);
        memory.add(dummySupplier);
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
            memory.add(new Supplier("name", null));
        });
    }
}