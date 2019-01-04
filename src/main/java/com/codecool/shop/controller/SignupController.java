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
        EmailController emailController = EmailController.getInstance();
        String email = req.getParameter("email");
        String candidatePass = req.getParameter("password");
        String hashed = BCrypt.hashpw(candidatePass, BCrypt.gensalt());
        userDataStore.add(new User(email, hashed));
        String subjectString = "Registration Successful";
        String messageString = "Dear Customer,"
                + "\n\n You successfully registered to Jinglingwebshop!"
                + "\n\n Sincerely yours,\n Jingling";
        emailController.emailHandling(email, subjectString, messageString);
        String password = req.getParameter("password");
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            userDataStore.add(new User(email, hashed));
        } catch (RuntimeException e){
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        }
    }
}
