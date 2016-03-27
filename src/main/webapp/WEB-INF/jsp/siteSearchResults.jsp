<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Sites</title>
		<c:url var="cssHref" value="/css/site.css" />
		<link type="text/css" rel="stylesheet" href="${cssHref}" />

	</head>

	<body>
		<header>
			<c:url var="logoSrc" value="/img/logo.png" />
			<img id="logo" src="${logoSrc}" alt="Campsite Logo" />
		</header>
	
		<h1 id="welcome">Available sites in your Campground from ${begin} to ${end}</h1>
		
		<c:if test="${sites == null}" >
			<p>No sites available in your selected Campground!
			Please return to 
				<c:url var="sitesearchHref" value="/campsite_search">
					<c:param name="campgroundIdFinal" value="${campgroundId}" />
				</c:url>
				<a href="${sitesearchHref}"> Date search form </a>
		</c:if>
		
		
		<c:forEach var="site" items="${sites}">
			<li class="park">
				<b>Site ID: <c:out value="${site.site_id}"/></b><br><br>
				Maximum occupancy <c:out value="${site.max_occupancy}"/> guests <br>
				Handicapped accessible: <c:out value="${site.accessible}"/><br>
				Utility hookup: <c:out value="${site.utilities}"/><br>
				Maximum RV length: <c:out value="${site.max_rv_length}"/><br>
				
				<form method="POST" action="reserve">
					<input type="hidden" name="siteIdReserve" value="${site.site_id}" />
					<input type="hidden" name="beginD" value="${begin}" />
					<input type="hidden" name="endD" value="${end}" /><br>
					<input type="hidden" name="utilities" value="${site.utilities}" /><br>
					<input type="hidden" name="RV" value="${site.max_rv_length}" /><br>
					<input type="hidden" name="accessible" value="${site.accessible}" /><br>
					<input type="hidden" name="occupancy" value="${site.max_occupancy}" /><br>
					
					<input type="submit" value="RESERVE"/>
				</form>
				
			</li>
			
		</c:forEach>
		
		
		
	</body>
</html>		