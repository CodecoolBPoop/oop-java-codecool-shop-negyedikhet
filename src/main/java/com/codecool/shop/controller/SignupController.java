package com.codecool.shop.controller;

import com.codecool.shop.dao.implementation.UserDaoJdbc;
import com.codecool.shop.model.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/signup"})

public class SignupController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoJdbc userDataStore = UserDaoJdbc.getInstance();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        userDataStore.add(new User(email, hashed));
    }
}
