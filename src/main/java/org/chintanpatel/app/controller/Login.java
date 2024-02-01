package org.chintanpatel.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.chintanpatel.app.bean.User;
import org.chintanpatel.app.dao.UserDao;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (userName == null || password == null || userName.isEmpty() || password.isEmpty()) {
            String message = "Please Enter UserName and Password";
            req.setAttribute("message",message);
            req.getRequestDispatcher("login.jsp").include(req,resp);
        } else {

            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);

            UserDao userDao = new UserDao();

            if (userName.equals("Administrator") && password.equals("Admin@123")) {
                HttpSession session = req.getSession(true);
                session.setAttribute("currentSessionAdministrator",userName);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }
            else if (userDao.isAuthenticateUser(user)) {
                HttpSession session = req.getSession(true);
                session.setAttribute("currentSessionUser",user.getUserName());
                req.getRequestDispatcher("user.jsp").forward(req,resp);
            }
            else {
                String message = "Please Enter Valid UserName and Password Details";
                req.setAttribute("message",message);
                req.getRequestDispatcher("login.jsp").include(req,resp);
            }
        }
    }
}
