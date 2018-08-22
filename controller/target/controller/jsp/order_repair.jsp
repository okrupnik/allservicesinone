<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.order.repair.title.text" var="titleText" />
<fmt:message bundle="${loc}" key="locale.order.repair.user.empty.text" var="userEmptyText" />
<fmt:message bundle="${loc}" key="locale.order.repair.user.performer.text" var="userPerformerText" />
<fmt:message bundle="${loc}" key="locale.order.repair.specialization.text" var="specializationText" />
<fmt:message bundle="${loc}" key="locale.order.repair.subspecialization.text" var="subspecializationText" />

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>All services in one</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/icomoon-social.css">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/leaflet.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

    <script src="${pageContext.request.contextPath}/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<body>
    <jsp:include page="_header.jsp"></jsp:include>
    
    <div class="section section-breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>${titleText}</h1>
				</div>				
			</div>
		</div>
	</div>			
	<div class="section">
        <div class="container">
			<div class="row">
			<form method="post" action="/controller/Controler" role="form" role="form">
			<input type="hidden" name="command" value="cn.create.order.page">
			<c:if test="${empty sessionScope.user}">
				<div class="form-group">
					<h3 style="color: #ff0000">
						${userEmptyText}
					</h3>
				</div>
			</c:if>
			<c:if test="${sessionScope.user.person.typePerson=='performer'}">
				<div class="form-group">
					<h3 style="color: #ff0000">
						${userPerformerText}
					</h3>
				</div>
			</c:if>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="order-specialization"><i class="icon-lock"></i> <b>${specializationText}</b></label>
					<input class="form-control" id="order-specalization" type="text" name="specialization" value="${sessionScope.specialization.description}">
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label for="order-subspecialization"><i class="icon-lock"></i> <b>${subspecializationText}</b></label>
					<select class="form-control" id="listsubspecialization" >
  						<c:forEach items="${sessionScope.specialization.subspecialization}" var="subSpecalizationList">
    						<option value="${subSpecalizationList}">${subSpecalizationList}</option>
  						</c:forEach>
					</select>					
				</div>
			</div>
			</form>
			</div>	
						
						
			
			
        </div>
    </div>
    
    <jsp:include page="_footer.jsp"></jsp:include>

    <!-- Javascripts -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"><\/script>')
    </script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.fitvids.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.sequence-min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.bxslider.js"></script>
    <script src="${pageContext.request.contextPath}/js/main-menu.js"></script>
    <script src="${pageContext.request.contextPath}/js/template.js"></script>
</body>

</html>