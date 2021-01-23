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

<img  class="homeImg" src="<c:url value="/img/login.jpg"/>"/>
<p>We <3 people who code!</p>
<p>Join our community where there are people to help you </p>
<p>overcoming the  challenges that you will face while</p>
<p>learning coding.Also you can help to :’)</p>
<p>Enjoy!</p>

</form>
</body>
</html>