<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/style.css"
	type="text/css" rel="stylesheet">
<title>Welcome to Online Video Store</title>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<div class="right-div-wrapper">
		
		<h1>Enter your search query</h1>
		<div>
			<form action="search" method="post">
				Search by <select name="searchBy">
					<option value="gameTitle" selected="selected">Game title</option>
					<option value="year">Release year</option>
					<option value="genre">Genre</option>
					<option value="publisher">publisher</option>
					<option value="developer">developer</option>
					<option value="platform">platform</option>
				</select> <input class="search" id="search" type="text" name="keyword"
					placeholder="Search.."> <input type="submit" name="search"
					value="search">
			</form>
		</div>
	</div>
</body>
</html>