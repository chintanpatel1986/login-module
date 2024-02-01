package org.chintanpatel.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.chintanpatel.app.bean.User;
import org.chintanpatel.app.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "GetUser", value = "/GetUser")
public class GetUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setUserName(req.getParameter("userName"));
        UserDao userDao = new UserDao();
        user = userDao.findUserByUserName(user.getUserName());
        req.setAttribute("user",user);
        req.getRequestDispatcher("editProfile.jsp").forward(req,resp);
    }
}
