<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.performer.order.titlepage.text" var="titleText" />
<fmt:message bundle="${loc}" key="locale.user.order.title.text" var="titleOrderText" />
<fmt:message bundle="${loc}" key="locale.user.order.description.text" var="descriptionText" />
<fmt:message bundle="${loc}" key="locale.user.order.dateofcreating.text" var="dateCreateText" />
<fmt:message bundle="${loc}" key="locale.user.order.enddate.text" var="endDateText" />
<fmt:message bundle="${loc}" key="locale.user.order.address.text" var="addressText" />
<fmt:message bundle="${loc}" key="locale.user.order.status.text" var="statusText" />
<fmt:message bundle="${loc}" key="locale.user.order.process.text" var="processText" />
<fmt:message bundle="${loc}" key="locale.user.order.completed.text" var="completedText" />
<fmt:message bundle="${loc}" key="locale.performer.order.completed.text" var="completedText" />
<fmt:message bundle="${loc}" key="locale.user.order.previous.text" var="previousText" />
<fmt:message bundle="${loc}" key="locale.user.order.next.text" var="nextText" />
<fmt:message bundle="${loc}" key="locale.performer.order.modal.title.text" var="modalTitleText" />
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

    <!-- Modal window completed -->
    <div class="modal fade" id="completeModal" tabindex="-1" role="dialog" aria-labelledby="completeModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="completeModalLabel">${modalTitleText}</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body complete-order">
                	<form method="post" action="/controller/Controler" role="form" role="form">
						<input type="hidden" name="command" value="cn.order.completed.peformer.page">
						<input type="hidden" id="order-id" name="orderid" value="">
						<h3 for="order" id="order-title"></h3>
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
                        <th scope="col">${dateCreateText}</th>
                        <th scope="col">${endDateText}</th>
                        <th scope="col">${addressText}</th>
                        <th scope="col">${statusText}</th>
                        <th scope="col">${completedText}</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${sessionScope.orderlist}">
                        <tr>
                            <td>${order.title}</td>
                            <td>${order.description}</td>
                            <td>${order.dateOfCreating}</td>
                            <td>${order.endDate}</td>
                            <td>${order.address}</td>
                            <c:if test="${order.status == 'process'}">
                            	<td>${processText}</td>                            
                            </c:if>
                            <c:if test="${order.status == 'completed'}">
                            	<td>${completedText}</td>                            
                            </c:if>
                            <td>                   
                             	<c:if test="${order.status == 'process'}">         	
                                	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#completeModal" data-orderid="${order.idOrder}" data-ordertitle="${order.title}">${completedText}</button>
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
                                    <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=${sessionScope.currentpage - 1}" tabindex="-1">${previousText}</a>
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
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=${i}">${i}</a></li>
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
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:when test="${(currentpage > 3) and (noofpages - currentpage >= 3)}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage-2}" end="${currentpage+2}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage}" end="${noofpages}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=${i}">${i}</a></li>
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
                                        <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page&page=${currentpage + 1}" tabindex="-1">${nextText}</a>
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
    	$('#completeModal').on('show.bs.modal', function(e) {
    		var $modal = $(this),
    			orderid = e.relatedTarget.dataset.orderid,
    			ordertitle = e.relatedTarget.dataset.ordertitle;
    		document.getElementById('order-id').value = orderid;
    		document.getElementById('order-title').innerHTML = ordertitle;
    	})
 	</script>
</body>

</html>