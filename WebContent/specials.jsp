<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ page import="soen387.gameInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/style.css"
	type="text/css" rel="stylesheet">
<title>Games Specials</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="right-div-wrapper">
		<h1>Games on Discount</h1>



		<br>
		<div>
			<table class="darkTable">
				<thead>
					<th colspan=7>Game Title</th>
					<th colspan=5>Game Id</th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach items="${specials}" var="game">
						<tr>
							<td colspan=7><c:out value="${game.getGameTitle()}" /></td>
							<td colspan=3><c:out value="${game.getId()}" /></td>
							<td colspan=2><form action="detailedGameInfo" method="get">
									<button name="id" type="submit" value="${game.getId()}">Details...</button>
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>