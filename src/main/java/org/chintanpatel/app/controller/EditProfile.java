package org.chintanpatel.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.chintanpatel.app.bean.User;
import org.chintanpatel.app.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "EditProfile", value = "/EditProfile")
public class EditProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setUserId(Integer.parseInt(req.getParameter("userId")));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));
        user.setMobile(Long.parseLong(req.getParameter("mobile")));
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));

        UserDao userDao = new UserDao();
        boolean isUpdateProfile = userDao.editUserProfile(user);
            if (isUpdateProfile) {
                req.getRequestDispatcher("user.jsp").forward(req,resp);
            } else {
                req.getRequestDispatcher("editProfile.jsp").include(req,resp);
            }
    }
}
