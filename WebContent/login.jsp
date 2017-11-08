<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/style.css"
	type="text/css" rel="stylesheet">
<title>Login</title>
</head>
<body>
	 <c:out value="${message}" />
	<jsp:include page="menu.jsp" />
	<div class="right-div-wrapper">
		<h1>LOGIN</h1>
		<div>
			<form action="login">
				Enter your username: <input type="text" name="user"><br>
				Enter your password: <input type="password" name="pw"><br>
				<input type="submit" name="login" value="sign in">
			</form>
		</div>
		<p>
			Not a user yet! <a href="register.jsp">click her to register</a>
	</div>
</body>
</html>