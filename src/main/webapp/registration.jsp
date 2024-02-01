<%--
  Created by IntelliJ IDEA.
  User: chintanpatel
  Date: 01/02/24
  Time: 12:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <script type="text/javascript" href="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" href="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-5 border border-1">
    <div class="fs-1 fw-bold">
        <h1>Registration</h1>
    </div>
    <form action="Registration" method="post" class="row g-3">
        <div class="col-6 mt-5">
            <label class="form-label fw-bold">FirstName</label>
            <input type="text" name="firstName" class="form-control">
        </div>
        <div class="col-6 mt-5">
            <label class="form-label fw-bold">LastName</label>
            <input type="text" name="lastName" class="form-control">
        </div>
        <div class="col-6">
            <label class="form-label fw-bold">E-Mail</label>
            <input type="email" name="email" class="form-control">
        </div>
        <div class="col-6">
            <label class="form-label fw-bold">Mobile</label>
            <input type="text" name="mobile" class="form-control">
        </div>
        <div class="col-6">
            <label class="form-label fw-bold">UserName</label>
            <input type="text" name="userName" class="form-control">
        </div>
        <div class="col-6">
            <label class="form-label fw-bold">Password</label>
            <input type="password" name="password" class="form-control">
        </div>
        <div class="col-12 d-grid gap-2">
            <input type="submit" value="Sign In" class="btn btn-success">
        </div>
        <div class="col-12">
            Already Account ! <a href="login.jsp" class="link-success fw-bold">Sign In</a>
        </div>
    </form>
</div>
</body>
</html>
