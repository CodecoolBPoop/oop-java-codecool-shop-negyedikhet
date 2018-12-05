package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJdbc extends ConnectionHandler implements SupplierDao {

    private static SupplierDaoJdbc instance = null;
    private SupplierDaoJdbc() {
    }
    public static SupplierDaoJdbc getInstance() {
        if (instance == null) {
            instance = new SupplierDaoJdbc();
        }
        return instance;
    }

    @Override
    public void add(Supplier supplier) {
        String query = "INSERT INTO suppliers (name, description) " +
                "VALUES ('" + supplier.getName() + "', '" + supplier.getDescription() + "');";
        executeQuery(query);
    }


    @Override
    public Supplier find(int id) {
        String query = "SELECT * FROM suppliers WHERE id ='" + id + "';";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            if (resultSet.next()){
                Supplier result = new Supplier(
                        resultSet.getString("name"),
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
        String query = "DELETE FROM suppliers WHERE id = '" + id + "';";
        executeQuery(query);
    }

    @Override
    public List<Supplier> getAll() {
        String query = "SELECT * FROM suppliers;";
        int id;
        List<Supplier> resultList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                Supplier result = new Supplier(resultSet.getString("name"),
                        resultSet.getString("description"));
                result.setId(id);
                resultList.add(result);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
}

