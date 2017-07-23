<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<sec:authentication var="principal" property="principal" />
    
    <!-- Meta info -->
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="footer, address, phone, icons" />
    
    <!-- StyleSheets -->
	<link href="<spring:url value="/resources/css/Footer.css" />" rel="stylesheet">
	<link href="<spring:url value="/resources/css/NavStyle.css" />" rel="stylesheet">

	<!-- Fonts -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
    <link rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Fresca">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    
    <!-- Scripts -->
	<script src="<spring:url value="/resources/js/main.js"/>"></script>
	<script src="<spring:url value="/resources/js/jquery-ui.min.js"/>"></script>


</head>
    
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
</body>
<div id="clearer"></div>
<tiles:insertAttribute name="footer"/>
</html>