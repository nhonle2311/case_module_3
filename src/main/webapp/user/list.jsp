<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">User List</h1>
    <table class="table mt-3">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>UserName</th>
            <th>Password</th>
            <th>Email</th>
            <th>FullName</th>
            <th>CreatedAt</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.fullName}</td>
                <td>${user.createdAt}</td>
                <td>
                    <a class="btn btn-info" href="users?action=show&id=${user.id}">View</a>
                    <a class="btn btn-primary" href="users?action=edit&id=${user.id}">Edit</a>
                    <a class="btn btn-danger" href="users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-success" href="users?action=add">Add New User</a>
</div>
</body>
</html>
