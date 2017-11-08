
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="spacer">
	<p class="menu">
		<a href="#">Welcome 
        <% if(session.getAttribute("name")!=null) 
        	out.print(session.getAttribute("name"));
        else
        	out.print("Guest");
        	%></a> | <a href="/OnlineVideoGameStore/login.jsp">LOG IN</a> | <a
			href="/OnlineVideoGameStore/register.jsp">SIGN UP</a> | <a
			href="/OnlineVideoGameStore/search.jsp">Search games</a> | <a
			href="/OnlineVideoGameStore/specials">Specials</a>
	</p>
</div>
<div class="left-div-wrapper">
	<p>
		<img src="css/images/banner.jpg" alt="" width="353" height="538" />
	</p>
	<p>
		<img src="css/images/our-tech-partners.gif" alt="" width="177"
			height="17" /><img src="css/images/ubi-logo.jpg" alt="" width="86"
			height="67" class="ubi-logo" />
	</p>
	<div class="spacer">&nbsp;</div>
</div>