<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

	<sec:authentication var="principal" property="principal" />
    
    <!-- Meta info -->
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta description="viewport" content="width=device-width, initial-scale=1">
	<meta description="keywords" content="footer, addressList, phone, icons" />
    
    <!-- StyleSheets -->
	<link href="<spring:url value="/resources/css/Footer.css" />" rel="stylesheet">
	<link href="<spring:url value="/resources/css/NavStyle.css" />" rel="stylesheet">

	<!-- Fonts -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Advent+Pro" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Fresca">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    
    <!-- Scripts -->
	<script src="<spring:url value="/resources/js/main.js"/>"></script>
	<script src="<spring:url value="/resources/js/jquery-ui.min.js"/>"></script>


</head>
    
<body>

<div class="page-border" data-wow-duration="0.7s" data-wow-delay="0.2s">
	<div class="top-border wow fadeInDown animated"
		 style="visibility: visible; animation-name: fadeInDown;"></div>
	<div class="right-border wow fadeInRight animated"
		 style="visibility: visible; animation-name: fadeInRight;"></div>
	<div class="bottom-border wow fadeInUp animated"
		 style="visibility: visible; animation-name: fadeInUp;"></div>
	<div class="left-border wow fadeInLeft animated"
		 style="visibility: visible; animation-name: fadeInLeft;"></div>
</div>

<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
</body>
<div id="clearer"></div>
<%--<tiles:insertAttribute name="footer"/>--%>
</html>