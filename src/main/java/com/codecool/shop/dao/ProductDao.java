package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public interface ProductDao {

    void add(Product product);
    Optional<Product> find(int id);
    void remove(int id);

    Stream<Product> getAll();
    Stream<Product> getBy(Supplier supplier);
    Stream<Product> getBy(ProductCategory productCategory);
    default Stream<Product> getBy(ProductCategory productCategory, Supplier supplier) {
        if (productCategory == null && supplier == null) {
            return getAll();
        } else if (productCategory == null) {
            return getBy(supplier);
        } else if (supplier) {
            return getBy(productCategory);
        }

        // TODO: intersect streams
    }
}
