<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/style.css"
	type="text/css" rel="stylesheet">
<title>Registration</title>
</head>
<body>

	<c:out value="${message}" />
	<jsp:include page="menu.jsp" />
	<div class="right-div-wrapper">
		<form action="register" method="post">
			Enter your username: <input type="text" name="user"><br>
			Enter your password: <input type="password" name="pw"><br>
			Enter your password again: <input type="password" name="pwRe"><br>

			User information: <br> first name: <input type="text"
				name="firstName"><br> last name: <input type="text"
				name="lastName"><br> email: <input type="text"
				name="email"><br> address 1: <input type="text"
				name="address1"><br> address 2: <input type="text"
				name="address2"><br> city: <input type="text"
				name="city"><br> state: <input type="text" name="state"><br>
			zip: <input type="text" name="zip"><br> country: <input
				type="text" name="country"><br> <br> <input
				type="submit" name="register" value="register">
		</form>
	</div>
</body>
</html>