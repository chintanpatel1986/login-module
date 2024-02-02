package org.chintanpatel.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.chintanpatel.app.bean.User;
import org.chintanpatel.app.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "DeleteUser", value = "/DeleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setUserId(Integer.parseInt(req.getParameter("userId")));
        UserDao userDao = new UserDao();
        boolean isDeleteUser = userDao.deleteUserById(user.getUserId());
            if (isDeleteUser) {
                req.getRequestDispatcher("ListOfUsers").forward(req,resp);
            } else {
                req.getRequestDispatcher("error.jsp").include(req,resp);
            }
    }
}
