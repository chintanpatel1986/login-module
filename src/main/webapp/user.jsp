<%--
  Created by IntelliJ IDEA.
  User: chintanpatel
  Date: 01/02/24
  Time: 1:06 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <script type="text/javascript" href="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" href="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-5" align="right">
    Welcome, <b><%= session.getAttribute("currentSessionUser") %></b>
    &nbsp;|&nbsp; <a href="Logout" class="link-success">SignOut</a>
</div>
</body>
</html>
