package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoJdbc extends ConnectionHandler implements UserDao {

    private static UserDaoJdbc instance = null;
    private UserDaoJdbc() {
    }
    public static UserDaoJdbc getInstance() {
        if (instance == null) {
            instance = new UserDaoJdbc();
        }
        return instance;
    }

    @Override
    public void add(User user) {
        String query = "INSERT INTO users (email, password) " +
                "VALUES ('" + user.getEmail() + "', '" + user.getPassword() + "');";
        executeQuery(query);
    }


    @Override
    public User find(String email) {
        String query = "SELECT * FROM users WHERE email ='" + email + "';";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {
            if (resultSet.next()){
                User result = new User(
                        resultSet.getString("email"),
                        resultSet.getString("password"));
                return result;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

