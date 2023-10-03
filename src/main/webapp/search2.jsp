<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Customer"%>
<%@ page import="java.sql.Date"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>詳細</title>
    <!-- Bootstrap CSSをリンク -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">得意先登録</h1>

    <form method="get" action="update_customer">
        <div class="form-group">
            <input type="text" name="search" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">検索</button>
    </form>
    <br>
    <br>

    <%
        Customer customer = (Customer) request.getAttribute("customer");
    %>

    <%
        if (customer != null) {
    %>
    <form action="register_customer2" method="post">
    <input type="text" name="customerCode" class="form-control" value="<%= customer.getCustomerCode() %>" hidden>
        <div class="form-group">
            <label for="name">名前:</label>
            <input type="text" name="customerName" class="form-control" value="<%= customer.getCustomerName() %>" required>
        </div>

        <div class="form-group">
            <label for="birthday">電話番号:</label>
            <input type="date" name="customerTelno" class="form-control" value="<%= customer.getCustomerTelno() %>">
        </div>

        <div class="form-group">
            <label for="birthday">郵便番号:</label>
            <input type="date" name="customerPostalcode" class="form-control" value="<%= customer.getCustomerPostalcode() %>">
        </div>

        <div class="form-group">
            <label for="joinDate">住所:</label>
            <input type="date" name="customerAddress" class="form-control" value="<%= customer.getCustomerAddress() %>">
        </div>

        <div class="form-group">
            <label for="homeTown">割引率:</label>
            <input type="text" name="discountRate" class="form-control" value="<%= customer.getDiscountRate() %>">
        </div>

        <button type="submit" name="button" value="input" class="btn btn-primary">登録</button>
    </form>
    <%
        }
    %>
</div>

<!-- Bootstrap JavaScriptをリンク -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
