<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>顧客情報確認</title>
    
    <!-- Bootstrap CSS を読み込む -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">顧客情報確認</h1>

        <!-- サーブレットにフォームデータを送信する -->
        <form action="register_customer" method="post">
        <table class="table">
            <tr>
                <td>顧客コード:</td>
                <td>${param.customerCode}</td>
                <input type="hidden" name="customerCode" value="${param.customerCode}">
            </tr>
            <tr>
                <td>顧客名:</td>
                <td>${param.customerName}</td>
                <input type="hidden" name="customerName" value="${param.customerName}">
            </tr>
            <tr>
                <td>電話番号:</td>
                <td>${param.customerTelno}</td>
                <input type="hidden" name="customerTelno" value="${param.customerTelno}">
            </tr>
            <tr>
                <td>郵便番号:</td>
                <td>${param.customerPostalcode}</td>
                <input type="hidden" name="customerPostalcode" value="${param.customerPostalcode}">
            </tr>
            <tr>
                <td>住所:</td>
                <td>${param.customerAddress}</td>
                <input type="hidden" name="customerAddress" value="${param.customerAddress}">
            </tr>
            <tr>
                <td>割引率:</td>
                <td>${param.discountRate}</td>
                <input type="hidden" name="discountRate" value="${param.discountRate}">
            </tr>
        </table>

            <p class="mt-4">この内容で登録して良いですか？</p>
            <button type="submit" class="btn btn-primary" name="button" value="register">はい</button>
            <a href="index.html" class="btn btn-secondary">キャンセル</a>
        </form>
    </div>

    <!-- Bootstrap JavaScript を読み込む -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
