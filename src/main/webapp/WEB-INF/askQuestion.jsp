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
</head>
<body>
<form:form action="/askQuestion" method="post" modelAttribute="question">
    <p>
    <form:label path="title"/>
    <form:input path="title"/>
    </p>
    <p>
        <form:label path="body"/>
        <form:input path="body"/>
    </p>
        <form:hidden value="${ currentUser.id }" path="creator"/>
    <form:hidden value="${kind.id }" path="type"/>
    <p>
        <form:checkbox path="tags">
    <c:forEach items="${ tags }" var="tag">
        <form:option value="${ tag.id }">"${ tag.label }"</form:option>
    </c:forEach>
         </form:checkbox>
    </p>
    <button>Ask!</button>







</form:form>
</body>
</html>
