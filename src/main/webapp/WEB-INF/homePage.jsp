<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="<c:url value="../css/home.css"/> "/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome Page</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp"></jsp:include>

<div class="main">
    <img  class="homeImg" src="<c:url value="/img/login.jpg"/>"/>
<h4 class="top-right">We <3 people who code! <br><br>
    Join our community where we
    empower  <br> developers and connect
    them to solutions <br> that enable
    productivity, growth, <br> and discovery.<br>
  <br>Enjoy!
</h4>
</div>

<div class="tags d-flex justify-content-space">
    <div class="row">

    <c:forEach items="${ tags }" var="t">

    <div class="card col-4" style="width: 18rem;">
        <div class="card-body ">
            <h5 class="card-title">${t.label}</h5>
            <p class="card-text">${t.description}</p>
            <div class="links-qp">
            <a href="/tag/${t.id}/questions" class="btn btn-warning">Questions</a>
            <a href="#" class="btn btn-warning">Post</a>
            </div>
        </div>
    </div>

    </c:forEach>
</div>
</div>

</form>
</body>
</html>