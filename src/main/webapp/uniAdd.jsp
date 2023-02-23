<%--
  Created by IntelliJ IDEA.
  User: nuxx
  Date: 023, 2/23/2023
  Time: 6:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert University</title>
  <link rel="stylesheet" href="/css/bootstrap.min.css">
  <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <div class="col-form-label-sm">
    <form action="/insertUni" method="post">
      <div class="row">
        <div class="col">
          <input type="text" name="name" class="form-control" placeholder="University name" aria-label="University name">
        </div>
        <div class="col">
          <input type="text" name="shortname" class="form-control" placeholder="University short name" aria-label="University short name">
        </div>
          <button class="btn btn-primary">Add new Uni</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
