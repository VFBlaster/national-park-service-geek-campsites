<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>National Parks</title>
<c:url var="cssHref" value="/css/site.css" />
<link type="text/css" rel="stylesheet" href="${cssHref}" />
</head>
<body>
	<header>
		<c:url var="logoSrc" value="/img/logo.png" />
		<img id="logo" src="${logoSrc}" alt="Campsite Logo" />
	</header>
	<h1 id="welcome">Please select a Park to see Campsites</h1>
	<ul>

		<c:forEach var="park" items="${parkList}">
			<li class="park">
			
			
			<c:url var="parkCampsitesHref" value="/parkCampsites">
				<c:param name="parkId" value="${park.park_id}" />
			</c:url>
			<a href="${parkCampsitesHref}"> 
			<c:url var="parkImgSrc" value="/img/parks/${park.name}.jpg" /> 
			<img src="${parkImgSrc}" />
			</a>
		<h2>
			<a href="${parkCampsitesHref}"><c:out value="${park.name} National Park" /></a>
		</h2>
		<p><strong>Location: </strong><c:out value="${park.location}"/></p>
		<p><strong>Visitors Per Year: </strong><c:out value="${park.visitors}"/></p>
		<p><c:out value="${park.description}"/></p>		
		</c:forEach>
	</ul>



</body>
</html>