<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Page</title>
</head>
<body>
<h1>Register New User </h1>

<p><form:errors path="user.*"/></p>

<form:form method="POST" action="/admin" modelAttribute="user">
    <input  type="hidden" name="UserTag" value="user">
    <p>
        <form:label path="username">Email:</form:label>
        <form:input path="username"/>
    </p>

    <p>
        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="password">Password:</form:label>
        <form:password path="password"/>
    </p>

    <input type="submit" value="Register!"/>
</form:form>

<form:form method="POST" action="/admin" modelAttribute="tag">
    <p><form:label path="label">Title</form:label>
        <form:input path="label">Title</form:input>
    </p>
    <p><form:label path="description">Description</form:label>
        <form:input path="description"/>
    </p>
    <input  type="hidden" name="UserTag"  value="tag">
<button>Add Tag</button>
</form:form>
</body>
</html>
