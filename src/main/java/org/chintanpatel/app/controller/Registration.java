package org.chintanpatel.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.chintanpatel.app.bean.User;
import org.chintanpatel.app.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "Registration", value = "/Registration")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        user.setMobile(Long.parseLong(req.getParameter("mobile")));
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));

        UserDao userDao = new UserDao();
        boolean isRegisterUser = userDao.registerUser(user);
            if (isRegisterUser) {
                req.getRequestDispatcher("success.jsp").forward(req,resp);
            } else {
                req.getRequestDispatcher("registration.jsp").include(req,resp);
            }
    }
}
