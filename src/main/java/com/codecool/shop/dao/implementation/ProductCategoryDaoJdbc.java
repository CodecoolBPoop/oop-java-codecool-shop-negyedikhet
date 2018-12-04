package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoJdbc extends ConnectionHandler implements ProductCategoryDao {
    @Override
    public void add(ProductCategory category) {
        String query = "INSERT INTO productcategories (name, department, description) " +
                "VALUES ('" + category.getName() + "', '" + category.getDepartment() + "', '" + category.getDescription() + "');";
        executeQuery(query);
    }

    @Override
    public ProductCategory find(int id) {
        String query = "SELECT * FROM productcategories WHERE id ='" + id + "';";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            if (resultSet.next()){
                ProductCategory result = new ProductCategory(
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getString("description"));
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

    @Override
    public void remove(int id) {
        String query = "DELETE FROM productcategories WHERE id = '" + id + "';";
        executeQuery(query);
    }

    @Override
    public List<ProductCategory> getAll() {
        String query = "SELECT * FROM productcategories;";
        int id = 1;
        List<ProductCategory> resultList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                ProductCategory result = new ProductCategory(resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getString("description"));
                result.setId(id);
                id++;
                resultList.add(result);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

}
