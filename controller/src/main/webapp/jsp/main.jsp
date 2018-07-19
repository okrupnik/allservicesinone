<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title>All services in one</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width">
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/icomoon-social.css">	
	<link
		href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800'
		rel='stylesheet' type='text/css'>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/leaflet.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/main.css">

	<script
	src="${pageContext.request.contextPath}/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_press.jsp"></jsp:include>
	
	
	<!-- Javascripts -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"><\/script>')</script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.fitvids.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.sequence-min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.bxslider.js"></script>
        <script src="${pageContext.request.contextPath}/js/main-menu.js"></script>
        <script src="${pageContext.request.contextPath}/js/template.js"></script>   
</body>
</html>