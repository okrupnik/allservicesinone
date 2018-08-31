<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.titlepage.text" var="titleText" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.titleperformer.text" var="titlePerformerText" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.info.text" var="infoText" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.email.text" var="emailText" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.phone.text" var="phoneText" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.address.text" var="addressText" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.requisites.text" var="requisitesText" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.agent.text" var="agentText" />
<fmt:message bundle="${loc}" key="locale.user.order.previous.text" var="previousText" />
<fmt:message bundle="${loc}" key="locale.user.order.next.text" var="nextText" />
<fmt:message bundle="${loc}" key="locale.all.user.performer.description.text" var="descriptionText" />

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
    <jsp:include page="_press.jsp"></jsp:include>

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

    <div class="section section">
        <div class="container">
            <ul class="list-group">
                <c:forEach var="user" items="${sessionScope.userperformerlist}">
                    <p></p>
                    <c:if test="${user.performer.ownership.formOwnership == 'legal'}">
                        <div class="row">
                            <div class="testimonial col-md-4 col-sm-4">
                                <div class="author-photo">
                                    <c:choose>
                                        <c:when test="${not empty user.photo}">
                                            <img src="${pageContext.request.contextPath}/img/avatar/${user.photo}" alt="User">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="${pageContext.request.contextPath}/img/avatar/noname.png" alt="No Name">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="testimonial-bubble">
                                    <blockquote>
                                        ${user.performer.legalPerformerInfo.name} ${user.performer.legalPerformerInfo.surname}
                                    </blockquote>
                                    <div class="sprite arrow-speech-bubble"></div>
                                </div>
                            </div>
                            <div class="col-md-8 col-sm-8">
                                <li class="list-group-item list-group-item-action">
                                    <h3 class="list-group-item-heading">${titlePerformerText}: ${user.username}</h3>
                                    <hr>
                                    <div>
                                        <h4 class="list-group-item-text"><b>${infoText}:</b></h4>
                                        <p></p>                                        
                                        <p>${emailText} - ${user.email}</p>
                                        <p>${phoneText}: ${user.phoneNumber}</p>
                                        <p>${addressText}: ${user.address}</p>
                                    </div>
                                    <hr>
                                    <div>
                                        <p>${requisitesText}: ${user.performer.requisites}</p>
                                    </div>
                                </li>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${user.performer.ownership.formOwnership == 'company'}">
                        <div class="row">
                            <div class="testimonial col-md-4 col-sm-4">
                                <div class="author-photo">
                                    <c:choose>
                                        <c:when test="${not empty user.photo}">
                                            <img src="${pageContext.request.contextPath}/img/avatar/${user.photo}" alt="User">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="${pageContext.request.contextPath}/img/avatar/noname.png" alt="No Name">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="testimonial-bubble">
                                    <blockquote>
                                        ${user.performer.companyPerformerInfo.nameCompany}
                                    </blockquote>
                                    <div class="sprite arrow-speech-bubble"></div>
                                </div>
                            </div>
                            <div class="col-md-8 col-sm-8">
                                <li class="list-group-item list-group-item-action">
                                    <h3 class="list-group-item-heading">${titlePerformerText}: ${user.username}</h3>
                                    <hr>
                                    <div>
                                        <h4 class="list-group-item-text"><b>${infoText}:</b></h4>
                                        <p></p>
                                        <p>${agentText} - ${user.performer.companyPerformerInfo.nameAgent} ${user.performer.companyPerformerInfo.surnameAgent}</p>
                                        <p>${emailText} - ${user.email}</p>
                                        <p>${phoneText}: ${user.phoneNumber}</p>
                                        <p>${addressText}: ${user.address}</p>
                                    </div>
                                    <hr>
                                    <div>
                                        <p>${requisitesText}: ${user.performer.requisites}</p>
                                    </div>
                                    <hr>
                                    <div>
                                        <p>${descriptionText}: ${user.performer.companyPerformerInfo.description}</p>
                                    </div>
                                </li>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </ul>

            <!-- Pagination -->
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">

                    <%--For displaying Previous link except for the 1st page --%>
                        <c:choose>
                            <c:when test="${currentpage != 1}">
                                <li class="page-item">
                                    <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=${sessionScope.currentpage - 1}" tabindex="-1">${previousText}</a>
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
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=${i}">${i}</a></li>
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
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:when test="${(currentpage > 3) and (noofpages - currentpage >= 3)}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage-2}" end="${currentpage+2}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=${i}">${i}</a></li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=${noofpages}">${noofpages}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach begin="${currentpage}" end="${noofpages}" var="i">
                                            <c:choose>
                                                <c:when test="${currentpage eq i}">
                                                    <li class="page-item"><a class="page-link" href="#">${i}</a></li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=${i}">${i}</a></li>
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
                                        <a class="page-link" href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page&page=${currentpage + 1}" tabindex="-1">${nextText}</a>
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

</body>
</html>