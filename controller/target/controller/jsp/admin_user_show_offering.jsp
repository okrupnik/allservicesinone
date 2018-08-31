<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.user.offering.titlepage.text" var="titleText" />
<fmt:message bundle="${loc}" key="locale.user.order.title.text" var="titleOrderText" />
<fmt:message bundle="${loc}" key="locale.user.offering.description.text" var="descriptionText" />
<fmt:message bundle="${loc}" key="locale.user.order.status.text" var="statusText" />
<fmt:message bundle="${loc}" key="locale.user.order.edit.text" var="editText" />
<fmt:message bundle="${loc}" key="locale.user.order.delete.text" var="deleteText" />
<fmt:message bundle="${loc}" key="locale.user.order.previous.text" var="previousText" />
<fmt:message bundle="${loc}" key="locale.user.order.next.text" var="nextText" />
<fmt:message bundle="${loc}" key="locale.user.offering.modal.edit.title.text" var="modalEditTitleText" />
<fmt:message bundle="${loc}" key="locale.user.offering.modal.edit.button.text" var="modalEditButtonText" />
<fmt:message bundle="${loc}" key="locale.user.offering.modal.delete.title.text" var="modalDeleteTitleText" />
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

    <!-- Modal window edit offering -->
    <div class="modal fade" id="editOfferingModal" tabindex="-1" role="dialog" aria-labelledby="editOfferingModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="editOfferingModalLabel">${modalEditTitleText}</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body edit-offering">
                	<form method="post" action="/controller/Controler" role="form" role="form">
						<input type="hidden" name="command" value="cn.edit.offering.to.order.page">
						<input type="hidden" id="offering-id-edit" name="offeringid" value="">
						<h3 for="order" id="order-title-edit"></h3>
						<hr>
						<div>
							<label for="offering-description"><i class="icon-user"></i> <b>${descriptionText}</b></label>
                            <textarea class="form-control" id="offering-description-edit" name="description" rows="4"></textarea>
                        </div>
                    	<div class="modal-footer">
                    		<button type="submit" class="btn btn-primary">${modalEditButtonText}</button>   
                    		<button type="button" class="btn btn-secondary" data-dismiss="modal">${noText}</button>
                    	</div>                  
                    </form>                      
                </div>                
            </div>
        </div>
    </div>
    
    <!-- Modal window delete offering-->
    <div class="modal fade" id="deleteOfferingModal" tabindex="-1" role="dialog" aria-labelledby="deleteOfferingModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="deleteOfferingModalLabel">${modalDeleteTitleText}</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body delete-order">
                	<form method="post" action="/controller/Controler" role="form" role="form">
						<input type="hidden" name="command" value="cn.delete.offering.to.order.page">
						<input type="hidden" id="offering-id-delete" name="offeringid" value="">
						<h3 for="order" id="order-title-delete"></h3>
						<hr>
						<div>
							<label for="offering-description"><i class="icon-user"></i> <b>${descriptionText}</b></label>
                            <textarea class="form-control" id="offering-description-delete" name="description" rows="4" disabled></textarea>
                        </div>
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
            <div class="row">
                <div class="col-md-12">
                    <h1>${titleText}</h1>
                </div>
            </div>
        </div>
    </div>
    <div class="section">
        <div class="container">
        	<table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">${titleOrderText}</th>
                        <th scope="col">${descriptionText}</th>
                        <th scope="col">${statusText}</th>
                        <th scope="col">${editText}</th>
                        <th scope="col">${deleteText}</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="offering" items="${sessionScope.offeringList}">
                        <tr>
                            <td>${offering.titleOrder}</td>
                            <td>${offering.description}</td>
                            <td>${offering.statusOrder}</td>
                            <td>
                            	<c:if test="${offering.statusOrder == 'choose'}">
                                	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editOfferingModal" data-offeringid="${offering.id}" data-ordertitle="${offering.titleOrder}" data-description="${offering.description}">${editText}</button>
                                </c:if>
                            </td>
                            <td>   
                            	<c:if test="${offering.statusOrder == 'choose'}">                         	
                                	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteOfferingModal" data-offeringid="${offering.id}" data-ordertitle="${offering.titleOrder}" data-description="${offering.description}">${deleteText}</button>
                                </c:if>
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
                                    <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=${sessionScope.currentpage - 1}" tabindex="-1">${previousText}</a>
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
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=${i}">${i}</a></li>
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
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:when test="${(currentpage > 3) and (noofpages - currentpage >= 3)}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage-2}" end="${currentpage+2}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage}" end="${noofpages}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=${i}">${i}</a></li>
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
                                        <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page&page=${currentpage + 1}" tabindex="-1">${nextText}</a>
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
    	$('#editOfferingModal').on('show.bs.modal', function(e) {
    		var $modal = $(this),
    			offeringid = e.relatedTarget.dataset.offeringid,
    			ordertitle = e.relatedTarget.dataset.ordertitle,
    			description = e.relatedTarget.dataset.description;
    		document.getElementById('offering-id-edit').value = offeringid;
    		document.getElementById('order-title-edit').innerHTML = ordertitle;
    		document.getElementById('offering-description-edit').innerHTML = description;
    	})
 	</script>
    <script>
    	$('#deleteOfferingModal').on('show.bs.modal', function(e) {
    		var $modal = $(this),
    			offeringid = e.relatedTarget.dataset.offeringid,
    			ordertitle = e.relatedTarget.dataset.ordertitle,
    			description = e.relatedTarget.dataset.description;
    		document.getElementById('offering-id-delete').value = offeringid;
    		document.getElementById('order-title-delete').innerHTML = ordertitle;
    		document.getElementById('offering-description-delete').innerHTML = description;
    	})
 	</script>
   
</body>

</html>