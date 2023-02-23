<%@ page import="com.example.lab02.db.Car" %><%--
  Created by IntelliJ IDEA.
  User: nuxx
  Date: 023, 2/23/2023
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit-Lab02</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <script src="WEB-INF/vendor/toastPop.js"></script>
</head>
<body>
<%@include file="WEB-INF/vendor/navbar.jsp"%>
<div class="container-fluid">
    <div class="col-form-label-sm">
        <%
            Car car = (Car)request.getAttribute("car");
            System.out.println(car.getVolume());
            if (car != null) {
        %>
        <form action="/editCar" method="post">
            <div class="row">
                <div class="col">
                    <input type="text" name="name" class="form-control" value="<%=car.getName()%>">
                </div>
                <div class="col">
                    <input type="text" name="model" class="form-control" value="<%=car.getModel()%>">
                </div>
                <div class="col">
                    <input type="text" name="year" class="form-control" value="<%=car.getYear()%>">
                </div>
                <div class="col">
                    <input type="text" name="volume" class="form-control" value="<%=car.getVolume()%>">
                </div>
                <div class="col">
                    <button class="btn btn-primary">Save car</button>
                </div>
            </div>
        </form>

            <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteCar">
                Delete car
            </button>
        <%
            }
        %>
    </div>

    <div class="modal fade" id="deleteCar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/deleteCar" method="post">
                <input type="hidden" name="model" class="form-control" value="<%=car.getModel()%>">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Do you really want to delete car?</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    All data will be completely lost.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                    <button class="btn btn-danger">Yes</button>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>

<!-- Button trigger modal -->

<!-- Modal -->


</body>
</html>
