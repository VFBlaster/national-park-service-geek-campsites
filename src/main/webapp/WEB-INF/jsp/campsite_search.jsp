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
			
				<p>Please Select a Start Date</p>
			<div class="dateInput">
				<form method="GET" action="select_date_search">
					<input type="date" min="2016-03-01" name="BeginningDate"/>
					
 				<p>Please Select an End Date</p>
					<input type="hidden" name="campgroundId" value="${parkCampGround.campgroundId}" />
					<input type="date" min="2016-03-02" name="EndDate"/>
					<br>
					<br>
					<input type="submit" value="Search for availability" />
				</form>
			</div>	
			
	</body>
</html>