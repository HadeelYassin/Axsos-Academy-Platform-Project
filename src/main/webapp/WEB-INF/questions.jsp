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
    <ul>>

<c:forEach items="${ allquestions }" var="q">
   <li>${q.title}</li>
</c:forEach>

    </ul
</head>
<body>

</body>
</html>
