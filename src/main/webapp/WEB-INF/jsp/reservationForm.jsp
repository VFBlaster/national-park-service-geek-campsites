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
	
		<h1 id="welcome">Please enter your name <br>
		to reserve <em>Site ID ${siteIdReserve}</em> <br>
		in your <em>Campground ${campgroundNameFinal}</em><br>
		from ${beginD} to ${endD}</h1>
		
		<form method="POST" action="reserveWithName" >
	  		<input type="hidden" name="siteIdRes" value="${siteIdReserve}"/>
			<input type="hidden" name="beginD" value="${beginD}"/>
			<input type="hidden" name="endD" value="${endD}"/>		
			<label for="entry">Enter your Name to make Reservation: </label><br><br>
			<input type="text" name="guestName" required="true"/>
			<input type="submit" value="Reserve!" />
		</form>
		
		
	</body>
</html>
		