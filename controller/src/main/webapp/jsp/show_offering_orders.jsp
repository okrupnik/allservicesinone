<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.user.offering.username.performer.text" var="usernamePerformerText" />
<fmt:message bundle="${loc}" key="locale.user.offering.description.text" var="descriptionText" />
<fmt:message bundle="${loc}" key="locale.user.offering.about.performer.text" var="aboutPerormerText" />
<fmt:message bundle="${loc}" key="locale.user.offering.select.performer.text" var="selectPerformerText" />
<fmt:message bundle="${loc}" key="locale.user.order.previous.text" var="previousText" />
<fmt:message bundle="${loc}" key="locale.user.order.next.text" var="nextText" />
<fmt:message bundle="${loc}" key="locale.user.offering.modal.title.text" var="modalTitleText" />
<fmt:message bundle="${loc}" key="locale.user.offering.modalselect.title.text" var="modalSelectTitleText" />
<fmt:message bundle="${loc}" key="locale.user.order.modal.yes.text" var="yesText" />
<fmt:message bundle="${loc}" key="locale.user.order.modal.no.text" var="noText" />


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

    <!-- Modal window info -->
    <div class="modal fade" id="infoPerformerModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="infoPerformerModal">${modalTitleText}</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                	<div>
        				<label for="offering" id="firstname-label"></label>
        			</div>
        			<div>
        				<label for="offering" id="surname-label"></label>
        			</div>
        			<div>
        				<label for="offering" id="email-label"></label>
        			</div>
        			<div>
        				<label for="offering" id="phoneNumber-label"></label>
        			</div>
        			<div>
        				<label for="offering" id="requisites-label"></label>
        			</div>
        			<div>
        				<label for="offering" id="company-label"></label>
        			</div>        			
        			<div>
        				<label for="offering" id="description-label"></label>
        			</div>
      			</div>
                <div class="modal-footer">
        			<button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
      			</div>
            </div>
        </div>
    </div>
    
    <!-- Modal window select performer -->
    <div class="modal fade" id="selectPerformerModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="selectPerformerModal">${modalSelectTitleText}</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body select-user">
                	<form method="get" action="/controller/Controler" role="form" role="form">
						<input type="hidden" name="command" value="cn.select.performer.page">
						<input type="hidden" id="orderid" name="orderid" value="${sessionScope.orderid}">
						<input type="hidden" id="username" name="username" value="">
                    	<label for="user" id="username-label"></label>
                    	<div class="modal-footer">
                    		<button type="submit" class="btn btn-primary">${yesText}</button>   
                    		<button type="button" class="btn btn-secondary" data-dismiss="modal">${noText}</button>
                    	</div>                  
                    </form>                      
                </div>
            </div>
        </div>
    </div>

	<!-- Main table -->
    <div class="section section-breadcrumbs">
        <div class="container">
        	<c:if test="${not empty sessionScope.errorMessage}">
            	<div class="form-group">
  					<h3 style="color: #ff0000">
						<c:out value="${sessionScope.errorMessage}"></c:out>
						<% session.setAttribute("errorMessage", ""); %>
					</h3>
                </div>
            </c:if>
            <div class="row">
                <div class="col-md-12">
                    <h1 id="order-title">${sessionScope.orderTitle}</h1>
                </div>
            </div>
        </div>
    </div>
    <div class="section">
        <div class="container">
        	<table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">${usernamePerformerText}</th>
                        <th scope="col">${descriptionText}</th>
                        <th scope="col">${aboutPerormerText}</th>
                        <th scope="col">${selectPerformerText}</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="offering" items="${sessionScope.offeringList}">
                        <tr>
                            <td>${offering.user.username}</td>
                            <td>${offering.description}</td>
                        	<td>   
                        		<c:if test="${offering.user.performer.ownership.formOwnership == 'legal'}">                         	
                                	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#infoPerformerModal" data-firstname="${offering.user.performer.legalPerformerInfo.name}" data-surname="${offering.user.performer.legalPerformerInfo.surname}" data-email="${offering.user.email}" data-phoneNumber="${offering.user.phoneNumber}" data-requisites="${offering.user.performer.requisites}">${aboutPerormerText}</button>
                                </c:if>
                                <c:if test="${offering.user.performer.ownership.formOwnership == 'company'}">                         	
                                	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#infoPerformerModal" data-firstname="${offering.user.performer.companyPerformerInfo.nameAgent}" data-surname="${offering.user.performer.companyPerformerInfo.surnameAgent}" data-email="${offering.user.email}" data-phoneNumber="${offering.user.phoneNumber}" data-requisites="${offering.user.performer.requisites}" data-description="${offering.user.performer.companyPerformerInfo.description}">${aboutPerormerText}</button>
                                </c:if>
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#selectPerformerModal" data-username="${offering.user.username}">${selectPerformerText}</button>
                            </td>                                                        
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            	
	<!-- Pagination -->
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">

                    <%--For displaying Previous link except for the 1st page --%>
                        <c:choose>
                            <c:when test="${currentpage != 1}">
                                <li class="page-item">
                                    <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=${sessionScope.currentpage - 1}" tabindex="-1">${previousText}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1">${previousText}</a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                        <!-- Comment above code and Uncomment the below code for displaying page numbers
       				in range like (1 2 .. 10) in case if we have more number of pages -->
                        <c:choose>
                            <c:when test="${noofpages < 5}">
                                <c:forEach begin="1" end="${noofpages}" var="i">
                                    <c:choose>
                                        <c:when test="${currentpage eq i}">
                                            <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${(currentpage <= 3)}">
                                        <c:forEach begin="1" end="3" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:when test="${(currentpage > 3) and (noofpages - currentpage >= 3)}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage-2}" end="${currentpage+2}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage}" end="${noofpages}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>

                        <%--For displaying Next link --%>
                            <c:choose>
                                <c:when test="${currentpage lt noofpages}">
                                    <li class="page-item">
                                        <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.to.show.offer.page&page=${currentpage + 1}" tabindex="-1">${nextText}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item disabled">
                                        <a class="page-link" href="#" tabindex="-1">${nextText}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                </ul>
            </nav>
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
    
    <script data-require="jquery@*" data-semver="3.3.1" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script data-require="bootstrap@*" data-semver="3.1.1" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    
    <script data-require="jquery@*" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <script data-require="bootstrap@*" data-semver="3.1.1" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    
    <script>
    	$('#infoPerformerModal').on('show.bs.modal', function(e) {
    		var $modal = $(this),
    			firstname = e.relatedTarget.dataset.firstname,
    			surname = e.relatedTarget.dataset.surname,
    			email = e.relatedTarget.dataset.email,
    			phoneNumber = e.relatedTarget.dataset.phoneNumber,
    			requisites = e.relatedTarget.dataset.requisites,
    			description = e.relatedTarget.dataset.description;
    		document.getElementById('firstname-label').innerHTML = firstname;
    		document.getElementById('surname-label').innerHTML = surname;
    		document.getElementById('email-label').innerHTML = email;
    		document.getElementById('phoneNumber-label').innerHTML = phoneNumber;
    		document.getElementById('requisites-label').innerHTML = requisites;
    		document.getElementById('description-label').innerHTML = description;
    	})
 	</script>
 	<script>
    	$('#selectPerformerModal').on('show.bs.modal', function(e) {
    		var $modal = $(this),
    			username = e.relatedTarget.dataset.username;
    		document.getElementById('username').value = username;
    		document.getElementById('username-label').innerHTML = username;
    		
    	})
 	</script>
</body>

</html>