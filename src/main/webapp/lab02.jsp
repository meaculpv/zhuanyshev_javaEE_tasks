<%@ page import="com.example.lab02.db.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab02</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="WEB-INF/vendor/navbar.jsp"%>
<div class="container">
    <div class="col-form-label-sm">
        <form action="/addCar" method="post">
            <div class="row">
                <div class="col">
                    <input type="text" name="name" class="form-control" placeholder="Car name" aria-label="Car name">
                </div>
                <div class="col">
                    <input type="text" name="model" class="form-control" placeholder="Car model" aria-label="Car model">
                </div>
                <div class="col">
                    <input type="text" name="year" class="form-control" placeholder="Car year" aria-label="Year">
                </div>
                <div class="col">
                    <input type="text" name="volume" class="form-control" placeholder="Car volume" aria-label="Car volume">
                </div>
                <div class="col">
                    <button class="btn btn-primary">Add new car</button>
                </div>
            </div>
        </form>
    </div>

    <div class="row mt-5">
        <div class="col-sm-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">NAME</th>
                    <th scope="col">MODEL</th>
                    <th scope="col">YEAR</th>
                    <th scope="col">VOLUME</th>
                    <th scope="col">DETAILS</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Car> cars = (ArrayList<Car>) request.getAttribute("cars");

                    if (cars != null) {
                        for (Car car : cars) {
                %>
                <tr>
                    <th scope="row">
                        <%
                            out.print((car.getName()));
                        %>
                    </th>
                    <td>
                        <%=car.getModel()%>
                    </td>
                    <td>
                        <%=car.getYear()%>
                    </td>
                    <td>
                        <%=car.getVolume()%>
                    </td>
                    <td>
                        <a href="/detailsCar?model=<%=car.getModel()%>" class="btn btn-secondary">Details</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>