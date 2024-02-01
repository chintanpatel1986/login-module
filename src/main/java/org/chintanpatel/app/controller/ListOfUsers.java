package org.chintanpatel.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.chintanpatel.app.bean.User;
import org.chintanpatel.app.dao.UserDao;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListOfUsers", value = "/ListOfUsers")
public class ListOfUsers extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        List<User>userList = userDao.getAllUserList();
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("users.jsp").forward(req,resp);
    }
}
