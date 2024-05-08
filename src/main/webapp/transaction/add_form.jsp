<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Transaction</title>
</head>
<body>
<h2>Add Transaction</h2>
<form action="AddTransactionServlet" method="post">
    <label for="userID">User ID:</label>
    <input type="text" id="userID" name="userID"><br>
    <label for="amount">Amount:</label>
    <input type="text" id="amount" name="amount"><br>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description"><br>
    <label for="transactionDate">Transaction Date:</label>
    <input type="date" id="transactionDate" name="transactionDate"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
