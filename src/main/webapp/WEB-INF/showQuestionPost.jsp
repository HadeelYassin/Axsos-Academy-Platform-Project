<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24/01/2021
  Time: 1:01
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
        .showq{
            background-color: #EED500;
        }

    </style>
</head>
<body class="showq">
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

<div class="container mt-3 mb-3" >
    <div class="card">
        <div class="card-body">
            <h5 class="card-title"><c:out value="${question.title}"/></h5>
            <p class="card-text"><c:out value="${question.body}"/></p>
            <p class="card-link"><strong><c:out value="${question.creator.name}"/></strong></p>
        </div>
    </div>

    <c:forEach items="${question.comments}" var="comment">
        <div class="card m-2" style="height: 100px">
            <div class="card-body">
                <p>${comment.commentCreator.name}</p>
                <p>${comment.comment}</p>            </div>
        </div>

    </c:forEach>
        <form:form action="/tag/${tag.id}/question/${question.id}"  method="post" modelAttribute="commentoo">
            <form:input path="comment" placeholder="Add your comment" class="form-control m-2"/>
            <form:input path="commentCreator" type="hidden"  value="${currentUser.id}"></form:input>
            <form:input path="qpost" type="hidden"  value="${question.id}"></form:input>
            <button  type="submit" class="btn btn-light mt-1">comment</button>
        </form:form>



</div>






</body>
</html>
