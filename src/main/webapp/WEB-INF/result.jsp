<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22/01/2021
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<style>
    .btn-outline-warning{
    color: #efd400;
    background-color: transparent;
    background-image: none;
    border-color: #efd400;
    }
    img{
    height: 55px;
    width:100px;
    }

    h5{
    margin-right: 15px;
    }
</style>

</head>
<body>

<jsp:include page="/WEB-INF/header.jsp"></jsp:include>


<div class="container mt-5">
    <c:forEach items="${ allreslut }" var="res">
    <div class="card">
        <div class="card-header">
                ${ res.title }
        </div>
        <div class="card-body">
            <p class="card-text">${ res.body}</p>
            <a href="question/${res.id}" class="btn btn-dark">View</a>
        </div>
    </div>
    </c:forEach>




</body>
</html>
