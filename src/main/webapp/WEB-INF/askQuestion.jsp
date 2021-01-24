<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: scc
  Date: 1/21/2021
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>
<div class="container mt-5">
<form:form action="/askQuestion" method="post" modelAttribute="question">
    <p>
        <form:label path="title">Title</form:label>
    <form:input path="title"  class="form-control" />
    </p>
    <p>
        <form:label path="body" >Body</form:label>
        <form:input path="body" class="form-control"/>
    </p>
        <form:hidden value="${ currentUser.id }" path="creator"/>
    <form:hidden value="${kind.id }" path="typeO" class="form-control"/>
    <p>

    <c:forEach items="${ tags }" var="tag">
        <div class="form-check">
        <form:checkbox id="${ tag.id }" value="${ tag.id }" path="tags"/>${ tag.label}
        </div>
    </c:forEach>



    </p>

    <button type="submit" class="btn btn-warning">Ask!</button>







</form:form>
</div>
</body>
</html>
