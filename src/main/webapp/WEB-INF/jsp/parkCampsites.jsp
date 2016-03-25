<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Campsites</title>
		<c:url var="cssHref" value="/css/site.css" />
		<link type="text/css" rel="stylesheet" href="${cssHref}" />
	</head>

	<body>
		<header>
			<c:url var="logoSrc" value="/img/logo.png" />
			<img id="logo" src="${logoSrc}" alt="Campsite Logo" />
		</header>
	
		<h1 id="welcome">Please select a Campground in ${selectedPark.name} National Park</h1>
		<ul>

		<c:forEach var="campsite" items="${parkCampSiteList}">
			<li class="park">
				<b><c:out value="${campsite.name}"/></b><br><br>
				Open from <c:out value="${campsite.openFrom}"/> through <c:out value="${campsite.openTo}"/><br>
				Daily fee $ <c:out value="${campsite.dailyFee}"/><br>
				Number of Sites on Campground: <c:out value="${campsite.site_number}"/>
				<form method="GET" action="campsite_search">
					<input type="hidden" name="campgroundId" value="${campsite.campgroundId}" /><br>
					<input type="submit" value="FIND AVAILABILITY"/>
				</form>
				
			
			</li>
			
		</c:forEach>
	</ul>


	</body>
</html>