<%@ page import="com.example.lab03.db.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab03.db.University" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab03</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="WEB-INF/vendor/navbar.jsp"%>
    <div class="container">
        <form class="row g-3" action="/addUser" method="post">
            <div class="col-md-6">
                <label for="inputName4" class="form-label">Name</label>
                <input type="text" class="form-control" name="name" id="inputName4">
            </div>
            <div class="col-md-6">
                <label for="inputSurname4" class="form-label">Surname</label>
                <input type="text" class="form-control" name="surname" id="inputSurname4">
            </div>
            <div class="col-md-4">
                <label for="inputState" class="form-label">Age</label>
                <select class="form-select" name="age">
                    <option selected></option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option>...</option>
                </select>
            </div>
            <%
                ArrayList<University> universities = (ArrayList<University>)request.getAttribute("universities");
            %>
            <div class="col-md-4">
                <label for="inputState" class="form-label">University</label>
                <select id="inputState" class="form-select" name="university_name">
                    <% if (universities != null) {%>
                    <option selected></option>
                    <%
                            for (University university : universities) {
                    %>
                    <option value="<%=university.getUniversity_id()%>"><%=university.getUniversityShortName()%></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>
            <div class="form-control-plaintext">
                <a class="link-primary m-2" href="/insertUni">Insert own</a>
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Add user</button>
            </div>
        </form>

        <div class="row mt-5">
            <div class="col-sm-12">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">NAME</th>
                        <th scope="col">SURNAME</th>
                        <th scope="col">AGE</th>
                        <th scope="col">UNIVERSITY ID</th>
                        <th scope="col">UNIVERSITY NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");

                        if (users != null) {
                            for (User user : users) {
                    %>
                    <tr>
                        <th scope="row">
                            <%
                                out.print((user.getId()));
                            %>
                        </th>
                        <td>
                            <%=user.getName()%>
                        </td>
                        <td>
                            <%=user.getSurname()%>
                        </td>
                        <td>
                            <%=user.getAge()%>
                        </td>
                        <td>
                            <%=user.getUniversity().getUniversity_id()%>
                        </td>
                        <td>
                            <%=user.getUniversity().getUniversityShortName()%>
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
