<%--
  Created by IntelliJ IDEA.
  User: chintanpatel
  Date: 01/02/24
  Time: 12:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <script type="text/javascript" href="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" href="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-5 border border-1">
    <div class="fs-1 fw-bold">
        <h1>Login</h1>
    </div>
    <div class="container">
        <%
            String message = (String) request.getAttribute("message");
            if (message != null && !message.trim().isEmpty()) {
        %>
        <span style="color: red;"><%= message %></span>
        <%
            }
        %>
    </div>
    <form action="Login" method="post" class="row g-3">
        <div class="col-12 mt-5">
            <label class="form-label fw-bold">UserName</label>
            <input type="text" name="userName" class="form-control">
        </div>
        <div class="col-12">
            <label class="form-label fw-bold">Password</label>
            <input type="password" name="password" class="form-control">
        </div>
        <div class="col-12 d-grid gap-2">
            <input type="submit" name="Sign In" class="btn btn-success">
        </div>
        <div class="col-12">
            New User ? &nbsp;<a href="registration.jsp" class="link-success fw-bold">Create an Account !</a>
        </div>
    </form>
</div>
</body>
</html>