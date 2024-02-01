<%--
  Created by IntelliJ IDEA.
  User: chintanpatel
  Date: 01/02/24
  Time: 4:41 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Your Profile</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <script type="text/javascript" href="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" href="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-5 border border-1">
    <div class="fs-1 fw-bold">
        <h1>Edit Your Profile</h1>
    </div>
    <form action="EditProfile" method="post" class="row g-3">
        <input type="hidden" name="userId" value="${user.userId}">
        <input type="hidden" name="password" value="${user.password}">
        <div class="col-12 mt-5">
            <label class="form-label fw-bold">FirstName</label>
            <input type="text" name="firstName" class="form-control" value="${user.firstName}">
        </div>
        <div class="col-12">
            <label class="form-label fw-bold">LastName</label>
            <input type="text" name="lastName" class="form-control" value="${user.lastName}">
        </div>
        <div class="col-12">
            <label class="form-label fw-bold">E-Mail</label>
            <input type="email" name="email" class="form-control" value="${user.email}">
        </div>
        <div class="col-12">
            <label class="form-label fw-bold">Mobile</label>
            <input type="text" name="mobile" class="form-control" value="${user.mobile}">
        </div>
        <div class="col-12">
            <label class="form-label fw-bold">UserName</label>
            <input type="text" name="userName" class="form-control" value="${user.userName}">
        </div>
        <div class="col-12 d-grid gap-2">
            <input type="submit" value="Submit" class="btn btn-success">
        </div>
    </form>
</div>
</body>
</html>
