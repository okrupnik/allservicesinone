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
<fmt:message bundle="${loc}" key="locale.order.repair.title.order.text" var="titleOrderText" />
<fmt:message bundle="${loc}" key="locale.order.repair.specialization.text" var="specializationText" />
<fmt:message bundle="${loc}" key="locale.order.repair.subspecialization.text" var="subspecializationText" />
<fmt:message bundle="${loc}" key="locale.order.repair.description.text" var="descriptionText" />
<fmt:message bundle="${loc}" key="locale.order.repair.date.text" var="dateText" />
<fmt:message bundle="${loc}" key="locale.order.repair.address.text" var="addressText" />
<fmt:message bundle="${loc}" key="locale.order.repair.attachment.text" var="attachmentText" />
<fmt:message bundle="${loc}" key="locale.order.repair.button.text" var="buttonText" />

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
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/daterangepicker.css">

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
			<form method="get" action="/controller/Controler" role="form" role="form">
			<input type="hidden" name="command" value="cn.create.order.repair.page">
			<input type="hidden" name="idspecialization" value="2">
			<input type="hidden" name="status" value="choose">
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
			<c:if test="${not empty sessionScope.errorMessage}">
                <div class="form-group">
                    <h3 style="color: #ff0000">
						<c:out value="${sessionScope.errorMessage}"></c:out>
						<c:set var="errorMessage" value="" scope="session"/>
					</h3>
				</div>
            </c:if>
			<div class="form-group">
				<label for="order-title"><i class="icon-order"></i> <b>${titleOrderText}* <font color="red"><c:out value="${sessionScope.errorInput['titleOrder']}"/></font></b></label>
				<input class="form-control" id="order-title" name="title" type="text" placeholder="${titleOrderText}" >
			</div>
			<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label for="order-specialization"><i class="icon-lock"></i> <b>${specializationText}</b></label>
					<input class="form-control" id="order-specalization" type="text" name="specialization" value="${sessionScope.specialization.description}">
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label for="order-subspecialization"><i class="icon-lock"></i> <b>${subspecializationText}</b></label>
					<select class="form-control" id="listsubspecialization" name="subspecialization">
  						<c:forEach items="${sessionScope.specialization.subspecialization}" var="subSpecalizationList">
    						<option value="${subSpecalizationList}">${subSpecalizationList}</option>
  						</c:forEach>
					</select>					
				</div>
			</div>
			</div>
			<div class="form-group">
				<label for="order-description"><i class="icon-order"></i> <b>${descriptionText}</b></label>
				<c:choose>
					<c:when test="${not empty sessionScope.errorTempData['descriptionOrder']}">
                    	<textarea class="form-control" id="order-description" name="description" rows="4" >${sessionScope.errorTempData['descriptionOrder']}</textarea>
                    </c:when>
                    <c:otherwise>
                    	<textarea class="form-control" id="order-description" name="description" rows="4" ></textarea>
                    </c:otherwise>
                </c:choose>
            </div>
			<div class="form-group">
				<label for="order-date"><i class="icon-order"></i> <b>${dateText}</b></label>
				<input type="date" class="order-date" id="date" name="enddate" placeholder="${dateText}">
            </div>
            <div class="form-group">
				<label for="order-address"><i class="icon-order"></i> <b>${addressText}</b></label>
				<c:choose>
					<c:when test="${not empty sessionScope.errorTempData['addressOrder']}">
                    	<input class="form-control" id="order-address" name="address" type="text" value="${sessionScope.errorTempData['addressOrder']}">
                    </c:when>
                    <c:otherwise>
                    	<input class="form-control" id="order-address" name="address" type="text" placeholder="${addressText}" >
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="form-group">
                <label for="order-attachment"><i class="icon-user"></i> <b>${attachmentText}</b></label>
            	<input id="order-attachment" name="attachment" type="file" placeholder="${attachmentText}">
            </div>
            <c:choose>
				<c:when test="${empty sessionScope.user || sessionScope.user.person.typePerson=='performer'}">
                   	<button type="submit" class="btn pull-right" disabled>${buttonText}</button>
                </c:when>
                <c:otherwise>
                   	<button type="submit" class="btn pull-right">${buttonText}</button>
            	</c:otherwise>
            </c:choose>
			<div class="clearfix"></div>
			</form>
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
    <script src="${pageContext.request.contextPath}/js/moment.js"></script>
	<script src="${pageContext.request.contextPath}/js/daterangepicker.js"></script>
	
	<script type="text/javascript">
	$(function(){
 	$('#date').daterangepicker();
	});
	</script>
	
	<script type="text/javascript">
	$(function(){
		 $('#date').daterangepicker({
		 singleDatePicker: true,
		 });
		});
	</script>
	
	<script type="text/javascript">
	$(function(){
 	$('#date').daterangepicker({
 	singleDatePicker: true,
 	locale: {
 	format: 'DD.MM.YYYY'
 	}
 	});
	});
	</script>
</body>

</html>