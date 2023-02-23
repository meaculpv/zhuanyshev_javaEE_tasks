<%--
    Создайте Web Application, в котором мы можем видеть список стдуентов и делать поиск по ним.
    Создайте класс Students.java, который будет описывать студента.
    Students.java: long id, String name, String surname, String group, int addmitedYear
    Создайте геттеры и сеттеры для каждого поля
    В главной странице у вас должен стоять список всех пользователей. Над ними поисковик
    с выборкой, где в выборке по каким критериям будете делать поиск.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab01.db.Students" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab01</title>
    <!--import bootstrap v5.3-->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
    <!--decompose navbar into dedicated jsp-->
    <%@include file="WEB-INF/vendor/navbar.jsp"%>
    <div class="container">
        <div class="row mb-5 mt-5">
            <form action="/search" method="get">
                <select class="form-select col-form-label-sm" name="searchBy">
                    <option selected value="none">None</option>
                    <option value="name">Name</option>
                    <option value="surname">Surname</option>
                    <option value="group">Group</option>
                    <option value="addmited_year">Addmited year</option>
                </select>
                <input type="text" name="searchText" class="form-control" id="searchBy" placeholder="Search">
                <button class="btn btn-primary">Search</button>
            </form>

        </div>
        <div class="row mt-5">
            <div class="col-sm-12">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">NAME</th>
                            <th scope="col">SURNAME</th>
                            <th scope="col">GROUP</th>
                            <th scope="col">ADDMITED YEAR</th>
                        </tr>
                    </thead>
                    <tbody>
                    <!--Get list of student to show on the browser into table-->
                        <%
                            ArrayList<Students> students = (ArrayList<Students>) request.getAttribute("students");

                            if (students != null) {
                                for (Students student : students) {
                        %>
                            <tr>
                                <th scope="row">
                                    <%
                                        out.print((student.getId()));
                                    %>
                                </th>
                                <td>
                                    <%=student.getName()%>
                                </td>
                                <td>
                                    <%=student.getSurname()%>
                                </td>
                                <td>
                                    <%=student.getGroup()%>
                                </td>
                                <td>
                                    <%=student.getAddmitedYear()%>
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