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
	
		<h1 id="welcome">Congratulations! <br></h1>
		<p>You have reserved <em>Site ${siteIdReserve}</em> <br>
		in ${selectedPark.name} National Park's <em>Campground ${campgroundNameFinal}</em><br>
		from ${beginD} to ${endD}<br>
		<strong>under your name ${guestName}</strong><br><br>
		Your camping site has a maximum guest number of ${chosenSite.max_occupancy}.<br>
		Maximum RV length (0 if RVs not permitted): ${chosenSite.max_rv_length}<br>
		Handycapped-accessible: ${chosenSite.accessible}<br>
		Utility hookups: ${chosenSite.utilities}<br>
			
		</p>
		<h1>Thank you!</h1><br><br>
		
		<c:url var="homeHref" value="/"></c:url>
				<a href="${homeHref}"> Return to Homepage </a>
	
		
	</body>
</html>