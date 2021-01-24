<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23/01/2021
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
        body{
            background-color: #EED500;
        }

    </style>


</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

<div class="container mt-5">
<c:forEach items="${ allquestions }" var="q">
    <div class="card">
        <div class="card-header">
                ${ t.label }
        </div>
        <div class="card-body">
            <h5 class="card-title">${ q.title }</h5>
            <p class="card-text">${ q.body }</p>
            <a href="question/${q.id}" class="btn btn-dark">View</a>
        </div>
    </div>
</c:forEach>
</div>
</body>
</html>
