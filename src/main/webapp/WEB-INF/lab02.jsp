<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab02</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="vendor/navbar.jsp"%>
    <div class="container">
        <div class="row-cols-5">
            <form action="/addCar" method="post">
                <div class="input-group input-group-sm mr-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">NAME</span>
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="input-group input-group-sm mr-3">
                    <span class="input-group-text">Model</span>
                    <input type="text" class="form-control" name="model">
                </div>
                <div class="input-group input-group-sm mr-3">
                    <span class="input-group-text">Year</span>
                    <input type="text" class="form-control" name="year">
                </div>
                <div class="input-group input-group-sm mr-3">
                    <span class="input-group-text">Volume</span>
                    <input type="text" class="form-control" name="volume">
                </div>
            </form>
        </div>
    </div>
</body>
</html>