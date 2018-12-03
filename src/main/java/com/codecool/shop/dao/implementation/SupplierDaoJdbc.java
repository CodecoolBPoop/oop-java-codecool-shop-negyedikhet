package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJdbc implements SupplierDao {

    private static final String DATABASE = "jdbc:postgresql://localhost:5432/codecoolshop";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    public int calculateNextId(){
        String query = "SELECT id FROM suppliers ORDER BY id DESC LIMIT 1;";
        int result;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            if (resultSet.next()){
                 result = Integer.parseInt(resultSet.getString("id"));
                return result+1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 3;
    }
    @Override
    public void add(Supplier supplier) {
        supplier.setId(calculateNextId());

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
        int id = 1;
        List<Supplier> resultList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                Supplier result = new Supplier(resultSet.getString("name"),
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

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DATABASE,
                DB_USER,
                DB_PASSWORD);
    }

    private void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

