<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="../css/login.css"/> "/>

</head>
<body>
<div class="container mt-5 justify-content-center" >
    <div class="row">

        <div class="col-4"></div>
        <div class="col-4 login-box">
            <c:if test="${logoutMessage != null}">
                <c:out value="${logoutMessage}"></c:out>
            </c:if>
            <h2>Login</h2>
            <p>Welcome back! Let's get coding.</p>
            <c:if test="${errorMessage != null}">
                <p class="error-message"><c:out value="${errorMessage}"></c:out></p>
            </c:if>
            <form method="POST" action="/login">
                <p>
                    <label for="username">Email</label>
                    <input type="text" id="username" name="username"  class="form-control"/>
                </p>
                <p>
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password"  class="form-control"/>
                </p>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Login!"  class="btn btn-dark login-submit"/>
            </form>
        </div>
        <div class="col-4"></div>
    </div>
</div>
</body>
</html>