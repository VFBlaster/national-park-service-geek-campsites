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
	
		<h1 id="welcome">Campsite Availability Search for ${parkCampGround.name} Campground</h1>
		
			<div class="dateInput">
				<p>Please Select a Start Date</p>
			
				<form method="GET" action="siteSearchResults">
					<input type="hidden" name="campgroundId" value="${parkCampGround.campgroundId}" />
					<input type="date" min="2016-03-01" name="begindate" required="true"/>
					
 				<p>Please Select an End Date</p>
					<input type="date" min="2016-03-02" name="enddate" required="true"/>
					<br>
					<br>
					<input type="submit" value="Search for availability" />
				</form>
			</div>	
			
	</body>
</html>