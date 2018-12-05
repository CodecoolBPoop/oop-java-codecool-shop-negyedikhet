package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductDaoJdbc extends ConnectionHandler implements ProductDao {
    private static ProductDaoJdbc instance = null;
    private ProductDaoJdbc() {
    }
    public static ProductDaoJdbc getInstance() {
        if (instance == null) {
            instance = new ProductDaoJdbc();
        }
        return instance;
    }

    @Override
    public void add(Product product) {

        /**
         * Added +1 to id's because the list indexing in Initializer.java starts at 0
         * Remove the +1 when the database is filled with data from sql file, not from Initializer
         * */

        String query = "INSERT INTO products (name, defaultprice, currency, description, productcategory_id, supplier_id ) " +
                "VALUES ('" + product.getName() + "', '" + product.getDefaultPrice() + "', '" + product.getDefaultCurrency() + "', '" + product.getDescription() + "', '" + product.getProductCategory().getId()+1 + "', '" + product.getSupplier().getId()+1 + "');";
        executeQuery(query);
    }

    @Override
    public Product find(int id) {
        String query = "SELECT * FROM products WHERE id ='" + id + "';";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            if (resultSet.next()) {
                ProductCategory category = getProductCategoryOfProduct(resultSet.getInt("productcategory_id"));
                Supplier supplier = getSupplierOfProduct(resultSet.getInt("supplier_id"));

                Product result = new Product(
                        resultSet.getString("name"),
                        resultSet.getFloat("defaultprice"),
                        resultSet.getString("currency"),
                        resultSet.getString("description"),
                        category,
                        supplier);

                result.setId(id);
                return result;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Supplier getSupplierOfProduct(int id) {
        SupplierDaoJdbc supplier = SupplierDaoJdbc.getInstance();
        return supplier.find(id);
    }

    public ProductCategory getProductCategoryOfProduct(int id) {
        ProductCategoryDaoJdbc category = ProductCategoryDaoJdbc.getInstance();
        return category.find(id);
    }

    @Override
    public void remove(int id) {
        String query = "DELETE FROM products WHERE id = '" + id + "';";
        executeQuery(query);
    }

    @Override
    public Stream<Product> getAll() {
        String query = "SELECT * FROM products;";
        return getProductStream(query);
    }


    @Override
    public Stream<Product> getBy(Supplier supplier) {
        String query = "SELECT * FROM products WHERE supplier_id ='" + supplier.getId() + "';";
        return getProductStream(query);
    }


    @Override
    public Stream<Product> getBy(ProductCategory productCategory) {
        String query = "SELECT * FROM products WHERE productcategory_id ='" + productCategory.getId() + "';";
        return getProductStream(query);
    }

    public Stream<Product> getByCategoryAndSupplier(ProductCategory category, Supplier supplier){
        if (category == null && supplier == null) {
            return this.getAll();
        } else if (category == null) {
            return this.getBy(supplier);
        } else if (supplier == null) {
            return this.getBy(category);
        } else {
            String query = "SELECT * FROM products WHERE productcategory_id ='" + category.getId() + "' AND supplier_id ='" + supplier.getId() + "' ;";
            return getProductStream(query);
        }
    }

    private Stream<Product> getProductStream(String query) {
        int id;
        Stream.Builder<Product> resultList = Stream.builder();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                ProductCategory resultCategory = getProductCategoryOfProduct(resultSet.getInt("productcategory_id"));
                Supplier resultSupplier = getSupplierOfProduct(resultSet.getInt("supplier_id"));

                Product result = new Product(
                        resultSet.getString("name"),
                        resultSet.getFloat("defaultprice"),
                        resultSet.getString("currency"),
                        resultSet.getString("description"),
                        resultCategory,
                        resultSupplier);

                result.setId(id);
                resultList.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList.build();
    }

}
