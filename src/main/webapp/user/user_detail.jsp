<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">User Details</h1>
    <table class="table mt-3">
        <tbody>
        <tr>
            <td><strong>ID:</strong></td>
            <td>${users.id}</td>
        </tr>
        <tr>
            <td><strong>User Name:</strong></td>
            <td>${users.userName}</td>
        </tr>
        <tr>
            <td><strong>Password:</strong></td>
            <td>${users.password}</td>
        </tr>
        <tr>
            <td><strong>Email:</strong></td>
            <td>${users.email}</td>
        </tr>
        <tr>
            <td><strong>Full Name:</strong></td>
            <td>${users.fullName}</td>
        </tr>
        <tr>
            <td><strong>CreatedAt :</strong></td>
            <td>${users.createdAt}</td>
        </tr>
        </tbody>
    </table>
    <a href="users?action=list" class="btn btn-secondary">Back to List</a>
</div>
</body>
</html>