<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: scc
  Date: 1/23/2021
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value="../css/header.css"/> "/>
</head>
<body>


<nav class="navbar navbar-light bg-light justify-content-between">
    <a href="/"><img src="<c:url value="/img/logonew.jpg"/>"/> </a>
    <form action="/search" class="form-inline">
        <input class="form-control mr-sm-2" name="se" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
        <a href="/askQuestion" class="btn btn-outline-dark my-2 my-sm-0 ml-2" type="submit">Ask Question</a>

    </form>
    <div class="d-flex">
   <h5>${currentUser.name}</h5>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input class="btn btn-outline-dark my-2 my-sm-0" type="submit" value="Logout" />
    </form>
    </div>
</nav>

</body>
</html>