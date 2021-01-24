<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Page</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">UserName</th>
            <th scope="col">Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ users }" var="u">
            <tr>
            <th scope="row">${ u.id}</th>
            <td>${ u.username}</td>
            <td>${ u.name}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>


<p><form:errors path="user.*"/></p>
<form:form method="POST" action="/admin" modelAttribute="user">
    <input  type="hidden" name="UserTag"  value="user1">

    <p>
        <form:label path="username">Username:</form:label>
        <form:input path="username" class="form-control"/>
    </p>
    <p>
        <form:label path="name">Name:</form:label>
        <form:input path="name" class="form-control"/>
    </p>
    <p>
        <form:input  type="hidden" value="123456789" class="form-control" path="password"/>
    </p>
    <input type="submit" value="Register!" class="btn btn-warning"/>
</form:form>


<p><form:errors path="tag.*"/></p>

<form:form method="POST" action="/admin" modelAttribute="tag">
    <input  type="hidden" name="UserTag"  value="tag1">

    <p><form:label path="label">Title</form:label>
        <form:input path="label" class="form-control"/>
    </p>
    <p><form:label path="description">Description</form:label>
        <form:textarea    rows="5" cols="50" path="description" class="form-control"/>
    </p>
    <button class="btn btn-warning">Add Tag</button>
</form:form>


</div>
</body>
</html>