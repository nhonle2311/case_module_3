<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>users Form</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1 class="mt-5">users Form</h1>
    <form action="users?action=${action}" method="post">
        <input type="hidden" name="id" value="${users.id}">
        <div class="form-group">
            <label for="username">User Name:</label>
            <input type="text" class="form-control" id="username" name="userName" value="${users.userName}" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="text" class="form-control" id="password" name="password" value="${users.password}" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" name="email" value="${users.email}" required>
        </div>
        <div class="form-group">
            <label for="fullname">Full Name:</label>
            <input type="text" class="form-control" id="fullname" name="fullName" value="${users.fullName}" required>
        </div>
        <div class="form-group">
            <label for="createdAt">CreatedAt:</label>
            <input type="datetime-local" class="form-control" id="createdAt" name="createdAt" value="${users.createdAt}" required>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="users?action=list" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>