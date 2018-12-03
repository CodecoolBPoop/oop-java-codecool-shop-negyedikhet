package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.stream.Stream;

public class ProductDaoJdbc implements ProductDao {
    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Stream<Product> getAll() {
        return null;
    }

    @Override
    public Stream<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public Stream<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
