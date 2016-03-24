<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<h1 id="welcome">Hello World!</h1>
			<ul>
				<c:forEach var="park" items="${parkList}">
					<li class="park">
                    <h3>What the hell!?!
                        <c:url var="parkCampsitesHref" value="/parkCampsites">
                            <c:param name="parkId" value="${park.park_id}" />
                        </c:url>
                        <a href="${parkCampsitesHref}"><c:out value="${park.name}"/></a>
                    </h3>
				
	
				
				
					</li>
				</c:forEach>
			</ul>
	
	
	
	</body>
</html>




<%--                     <c:set var="parkImageName" value="${park.parkCode}"/> --%>
<%--                     <c:url var="parkImgSrc" value="/img/parks/${fn:toLowerCase(parkImageName)}.jpg" /> --%>
<%--                     <img src="${parkImgSrc}" alt="Picture of <c:out value="${park.name}"/>"/> --%>
                    
<!--                     <h3> -->
<%--                         <c:url var="parkDetailHref" value="/parkDetail"> --%>
<%--                             <c:param name="parkCode" value="${park.parkCode}" /> --%>
<%--                         </c:url> --%>
<%--                         <a href="${parkDetailHref}"><c:out value="${park.name}"/></a> --%>
<!--                     </h3> -->
                    
<%--                     <p><strong>Location: </strong><c:out value="${park.location}"/></p> --%>
<%--                     <p><c:out value="${park.description}"/></p>                 --%>
<!--                     </li> -->