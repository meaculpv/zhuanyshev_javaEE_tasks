<%@ page import="com.example.lab02.db.Car" %><%--
  Created by IntelliJ IDEA.
  User: nuxx
  Date: 023, 2/23/2023
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car details</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="WEB-INF/vendor/navbar.jsp"%>
    <div class="container">
        <%
            Car car = (Car)request.getAttribute("car");
            if (car != null) {
        %>
            <div class="mt-4 p-5 bg-secondary text-white rounded">
                <h1>
                    <%=car.getName()%>
                </h1>
                <p>
                    <%=car.getModel()%>
                </p>
                <p>
                    <%=car.getYear()%>
                </p>
                <p>
                    <%=car.getVolume()%>
                </p>
                <a class="btn btn-primary brn-lg" href="/editCar?model=<%=car.getModel()%>">Edit</a>
            </div>
        <%
            }
        %>
    </div>
</body>
</html>
