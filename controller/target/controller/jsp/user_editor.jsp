<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.user.edit.title.text" var="titleText" />
<fmt:message bundle="${loc}" key="locale.user.edit.username.text" var="userNameText" />
<fmt:message bundle="${loc}" key="locale.user.edit.email.text" var="emailText" />
<fmt:message bundle="${loc}" key="locale.user.edit.phoneNumber.text" var="phoneNumberText" />
<fmt:message bundle="${loc}" key="locale.user.edit.address.text" var="addressText" />
<fmt:message bundle="${loc}" key="locale.user.edit.role.text" var="roleText" />
<fmt:message bundle="${loc}" key="locale.user.edit.typePerson.text" var="typePersonText" />
<fmt:message bundle="${loc}" key="locale.user.edit.edit.text" var="editText" />
<fmt:message bundle="${loc}" key="locale.user.edit.delete.text" var="deleteText" />
<fmt:message bundle="${loc}" key="locale.user.edit.orderoroffer.text" var="orderOrOfferText" />
<fmt:message bundle="${loc}" key="locale.user.edit.order.text" var="orderText" />
<fmt:message bundle="${loc}" key="locale.user.edit.offer.text" var="offerText" />
<fmt:message bundle="${loc}" key="locale.user.edit.previous.text" var="previousText" />
<fmt:message bundle="${loc}" key="locale.user.edit.next.text" var="nextText" />
<fmt:message bundle="${loc}" key="locale.user.edit.modal.title.text" var="modalTitleText" />
<fmt:message bundle="${loc}" key="locale.user.edit.modal.yes.text" var="yesText" />
<fmt:message bundle="${loc}" key="locale.user.edit.modal.no.text" var="noText" />


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

    <!-- Modal window delete -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title" id="deleteModalLabel">${modalTitleText}</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body delete-user">
                	<form method="post" action="/controller/Controler" role="form" role="form">
						<input type="hidden" name="command" value="cn.user.delete.page">
						<input type="hidden" id="login-username" name="username" value="">
                    	<label for="user" id="user-label"></label>
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
                        <th scope="col">${userNameText}</th>
                        <th scope="col">${emailText}</th>
                        <th scope="col">${phoneNumberText}</th>
                        <th scope="col">${addressText}</th>
                        <th scope="col">${roleText}</th>
                        <th scope="col">${typePersonText}</th>
                        <th scope="col">${editText}</th>
                        <th scope="col">${deleteText}</th>
                        <th scope="col">${orderOrOfferText}</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${sessionScope.userlist}">
                        <tr>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.phoneNumber}</td>
                            <td>${user.address}</td>
                            <td>${user.role.typeRole}</td>
                            <td>${user.person.typePerson}</td>
                            <td>
                                <form method="get" action="/controller/Controler" role="form" role="form">
                                    <input type="hidden" name="command" value="cn.admin.to.user.settings.page">
                                    <input type="hidden" name="username" value="${user.username}">
                                    <button type="submit" class="btn btn-primary">${editText}</button>
                                </form>
                            </td>
                            <td>                            	
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#deleteModal" data-usernamedel="${user.username}">${deleteText}</button>
                            </td>
                            <td>        
                            	<c:if test="${user.role.typeRole=='user' && user.person.typePerson=='customer'}">
                                	<form method="get" action="/controller/Controler" role="form" role="form">
                                   		<input type="hidden" name="command" value="cn.admin.show.orders.user.page">
                                   		<input type="hidden" name="username" value="${user.username}">
                                   		<c:remove var="selecteduser" scope="session" />
                                   		<button type="submit" class="btn btn-primary">${orderText}</button>
                                	</form>
                            	</c:if>
                            	<c:if test="${user.role.typeRole=='user' && user.person.typePerson=='performer'}">
                                	<form method="get" action="/controller/Controler" role="form" role="form">
                                   		<input type="hidden" name="command" value="cn.admin.show.offering.user.page">
                                   		<input type="hidden" name="username" value="${user.username}">
                                   		<c:remove var="selecteduser" scope="session" />
                                   		<button type="submit" class="btn btn-primary">${offerText}</button>
                                	</form>
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
                                    <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=${sessionScope.currentpage - 1}" tabindex="-1">${previousText}</a>
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
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=${i}">${i}</a></li>
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
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:when test="${(currentpage > 3) and (noofpages - currentpage >= 3)}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage-2}" end="${currentpage+2}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage}" end="${noofpages}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=${i}">${i}</a></li>
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
                                        <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page&page=${currentpage + 1}" tabindex="-1">${nextText}</a>
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
    	$('#deleteModal').on('show.bs.modal', function(e) {
    		var $modal = $(this),
    			usernamedel = e.relatedTarget.dataset.usernamedel;
    		document.getElementById('login-username').value = usernamedel;
    		document.getElementById('user-label').innerHTML = usernamedel;
    	})
 	</script>
</body>

</html>