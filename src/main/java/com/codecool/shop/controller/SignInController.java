package com.codecool.shop.controller;

import com.codecool.shop.dao.implementation.UserDaoJdbc;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/signin"})

public class SignInController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoJdbc userDataStore = UserDaoJdbc.getInstance();
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (BCrypt.checkpw(password, userDataStore.find(email).getPassword())) {
            System.out.println("It matches");
            HttpSession mySession = req.getSession();
            String[] array = email.split("@");
            mySession.setAttribute("username", array[0]);
        }  else {
            System.out.println("It does not match");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
