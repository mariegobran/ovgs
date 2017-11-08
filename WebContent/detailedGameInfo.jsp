<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="soen387.gameInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/gameInfoTable.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.css"
	type="text/css" rel="stylesheet">
<title>
	
</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div class="right-div-wrapper">
		<h1>Game Details</h1>
		<br />
		<div>
			<table class="darkTable">
				<thead>
					<th><c:out value="${gameDetails.getGameTitle()}" /></th>
					<th><c:out value="${gameDetails.getId()}" /></th>
				</thead>
				<tbody>
					<tr>
						<td colspan=4>genre: <c:out value="${gameDetails.getGenre()}" />
						</td>
						<td colspan=4>release date: <c:out
								value="${game.getReleaseDate()}" /></td>
						<td colspan=4>platform: <c:out
								value="${gameDetails.getPlatform()}" /></td>
					</tr>

					<tr>
						<td colspan=5>publisher: <c:out
								value="${gameDetails.getPublisher()}" /></td>
						<td colspan=5>developer: <c:out
								value="${gameDetails.getDeveloper()}" /></td>
						<td colspan=2>number of Players: <c:out
								value="${gameDetails.getNumOfPlayers()}" /></td>
					</tr>
					<tr>
						<td colspan=12><c:out value="${gameDetails.getDescription()}" /></td>

					</tr>


				</tbody>
			</table>
		</div>
		<br />
	</div>
</body>
</html>