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
            <th>TransactionId</th>
            <th>UserID</th>
            <th>TransactionTypeId</th>
            <th>Amount</th>
            <th>Description</th>
            <th>TransactionDate</th>
            <th>CreatedAt</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${transactionList}" var="transaction">
            <tr>
                <td>${transaction.transactionID}</td>
                <td>${transaction.userID}</td>
                <td>${transaction.transactionTypeID}</td>
                <td>${transaction.amount}</td>
                <td>${transaction.description}</td>
                <td>${transaction.transactionDate}</td>
                <td>${transaction.createdAt}</td>
                <td>
                    <a class="btn btn-info" href="users?action=show&id=${transaction.transactionID}">View</a>
                    <a class="btn btn-primary" href="users?action=edit&id=${transaction.transactionID}">Edit</a>
                    <a class="btn btn-danger" href="users?action=delete&id=${transaction.transactionID}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-success" href="users?action=add">Add New User</a>
</div>
</body>
</html>
