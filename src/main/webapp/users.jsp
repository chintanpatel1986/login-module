<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chintanpatel
  Date: 01/02/24
  Time: 5:08 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Of Users</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <script type="text/javascript" href="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" href="js/bootstrap.min.js"></script>
</head>
<%@ include file="admin.jsp"%>
<body>
<div class="container mt-5 border border-1">
    <div class="fs-1 fw-bold" align="center">
        <h1>List Of Users</h1>
    </div>
    <c:if test="${!empty userList}">
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>FirstName</th>
                <th>LastName</th>
                <th>E-Mail</th>
                <th>Mobile</th>
                <th>UserName</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.mobile}"/></td>
                    <td><c:out value="${user.userName}"/></td>
                    <td>
                        <a href="DeleteUser?userId=${user.userId}" class="link-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
