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
	
		<h1 id="welcome">Campsite Availability Search</h1>
		
				<p>Please Select a Start Date</p>
				<form method="GET" action="campsite_search">
					<input type="hidden" name="campgroundId" value="${campsite.campgroundId}" />
					<input type="date" value="Select Beginning Date"/>
					
				</form>
				<p>Please Select a End Date</p>
				<form method="GET" action="campsite_search">
					<input type="hidden" name="campgroundId" value="${campsite.campgroundId}" />
					<input type="date" value="Select Beginning Date"/>
					
				</form>
				
			
			
			
		


	</body>
</html>