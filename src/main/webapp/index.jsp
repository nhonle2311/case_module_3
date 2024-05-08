<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Quản lý Thu Chi</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    body {
      font-family: 'Arial', sans-serif;
    }
    .highlight-box {
      background-color: #f8f9fa;
      padding: 20px;
      margin-bottom: 20px;
      border-radius: 10px;
    }
    .navbar {
      border-bottom: 3px solid #007bff;
    }
    footer {
      background-color: #343a40;
      color: white;
    }
    @font-face {
      font-family: 'Roboto';
      src: url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');
    }

    body {
      font-family: 'Roboto', sans-serif;
    }

  </style>
</head>
<body>
<!-- Header -->
<header>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#">Quản lý Thu Chi</a>
      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggle-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item"><a class="nav-link" href="#payment">Thanh toán</a></li>
          <li class="nav-item"><a class="nav-link" href="#account-management">Quản lý tài khoản</a></li>
          <li class="nav-item"><a class="nav-link" href="#security">Bảo mật và xác thực</a></li>
          <li class="nav-item"><a class="nav-link" href="#services">Tích hợp dịch vụ</a></li>
          <li class="nav-item"><a class="nav-link" href="#support">Hỗ trợ khách hàng</a></li>
        </ul>
      </div>
    </div>
  </nav>
</header>

<!-- Main Content -->
<main>
  <div class="container">
    <!-- Payment Section -->
    <div id="payment" class="highlight-box">
      <h2>Thanh toán</h2>
      <!-- Add payment content here -->
    </div>

    <!-- Account Management Section -->
    <div id="account-management" class="highlight-box">
      <h2>Quản lý Tài khoản</h2>
      <!-- Add account management content here -->
    </div>

    <!-- Security and Authentication Section -->
    <div id="security" class="highlight-box">
      <h2>Bảo mật và Xác thực</h2>
      <!-- Add security and authentication content here -->
    </div>

    <!-- Services Integration Section -->
    <div id="services" class="highlight-box">
      <h2>Tích hợp Dịch vụ</h2>
      <!-- Add services integration content here -->
    </div>

    <!-- Customer Support Section -->
    <div id="support" class="highlight-box">
      <h2>Hỗ trợ Khách hàng</h2>
      <!-- Add customer support content here -->
    </div>
  </div>
</main>

<!-- Footer -->
<footer class="text-center py-4">
  <div class="container">
    <p>&copy; 2024 Quản lý Thu Chi. All rights reserved.</p>
  </div>
</footer>

<!-- Bootstrap JavaScript libraries -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
