<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.register.ref.customernatural.text" var="customerNaturalText" />
<fmt:message bundle="${loc}" key="locale.register.ref.customerlegal.text" var="customerLegalText" />
<fmt:message bundle="${loc}" key="locale.register.ref.customercompany.text" var="customerCompanyText" />
<fmt:message bundle="${loc}" key="locale.register.ref.performerlegal.text" var="performerLegalText" />
<fmt:message bundle="${loc}" key="locale.register.ref.performercompany.text" var="performerComponyText" />
<fmt:message bundle="${loc}" key="locale.register.ref.username.text" var="usernameText" />
<fmt:message bundle="${loc}" key="locale.register.ref.password.text" var="passwordText" />
<fmt:message bundle="${loc}" key="locale.register.ref.photo.text" var="photoText" />
<fmt:message bundle="${loc}" key="locale.register.ref.email.text" var="emailText" />
<fmt:message bundle="${loc}" key="locale.register.ref.phone.text" var="phoneText" />
<fmt:message bundle="${loc}" key="locale.register.ref.or.text" var="orText" />
<fmt:message bundle="${loc}" key="locale.register.ref.name.text" var="nameText" />
<fmt:message bundle="${loc}" key="locale.register.ref.surname.text" var="surnameText" />
<fmt:message bundle="${loc}" key="locale.register.ref.address.text" var="addressText" />
<fmt:message bundle="${loc}" key="locale.register.ref.requisites.text" var="requisitesText" />
<fmt:message bundle="${loc}" key="locale.register.ref.fileregistration.text" var="fileregistrationText" />
<fmt:message bundle="${loc}" key="locale.register.ref.namecompany.text" var="namecompanyText" />
<fmt:message bundle="${loc}" key="locale.register.ref.nameagent.text" var="nameagentText" />
<fmt:message bundle="${loc}" key="locale.register.ref.surnameagent.text" var="surnameagentText" />
<fmt:message bundle="${loc}" key="locale.register.ref.description.text" var="descriptionText" />
<fmt:message bundle="${loc}" key="locale.register.ref.button.text" var="buttonText" />

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

    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel with-nav-tabs panel-default">
                        <div class="panel-heading">
                            <ul class="nav nav-tabs">
                            	<c:if test="${empty sessionScope.activeTab || sessionScope.activeTab == '1'}">
                                	<li class="active"><a href="#tabCustomerNatural" data-toggle="tab">${customerNaturalText}</a></li>
                                	<li><a href="#tabCustomerLegal" data-toggle="tab">${customerLegalText}</a></li>
                                	<li><a href="#tabCustomerCompany" data-toggle="tab">${customerCompanyText}</a></li>
                                	<li><a href="#tabPerformerLegal" data-toggle="tab">${performerLegalText}</a></li>
                                	<li><a href="#tabPerformerCompany" data-toggle="tab">${performerComponyText}</a></li>
                                </c:if>
                                <c:if test="${sessionScope.activeTab == '2'}">
                                	<li><a href="#tabCustomerNatural" data-toggle="tab">${customerNaturalText}</a></li>
                                	<li class="active"><a href="#tabCustomerLegal" data-toggle="tab">${customerLegalText}</a></li>
                                	<li><a href="#tabCustomerCompany" data-toggle="tab">${customerCompanyText}</a></li>
                                	<li><a href="#tabPerformerLegal" data-toggle="tab">${performerLegalText}</a></li>
                                	<li><a href="#tabPerformerCompany" data-toggle="tab">${performerComponyText}</a></li>
                                </c:if>
                                <c:if test="${sessionScope.activeTab == '3'}">
                               		<li><a href="#tabCustomerNatural" data-toggle="tab">${customerNaturalText}</a></li>
                                	<li><a href="#tabCustomerLegal" data-toggle="tab">${customerLegalText}</a></li>
                                	<li class="active"><a href="#tabCustomerCompany" data-toggle="tab">${customerCompanyText}</a></li>
                                	<li><a href="#tabPerformerLegal" data-toggle="tab">${performerLegalText}</a></li>
                                	<li><a href="#tabPerformerCompany" data-toggle="tab">${performerComponyText}</a></li>
                                </c:if>
                                <c:if test="${sessionScope.activeTab == '4'}">
                                	<li><a href="#tabCustomerNatural" data-toggle="tab">${customerNaturalText}</a></li>
                                	<li><a href="#tabCustomerLegal" data-toggle="tab">${customerLegalText}</a></li>
                                	<li><a href="#tabCustomerCompany" data-toggle="tab">${customerCompanyText}</a></li>
                                	<li class="active"><a href="#tabPerformerLegal" data-toggle="tab">${performerLegalText}</a></li>
                                	<li><a href="#tabPerformerCompany" data-toggle="tab">${performerComponyText}</a></li>
                                </c:if>
                                <c:if test="${sessionScope.activeTab == '5'}">
                                	<li><a href="#tabCustomerNatural" data-toggle="tab">${customerNaturalText}</a></li>
                                	<li><a href="#tabCustomerLegal" data-toggle="tab">${customerLegalText}</a></li>
                                	<li><a href="#tabCustomerCompany" data-toggle="tab">${customerCompanyText}</a></li>
                                	<li><a href="#tabPerformerLegal" data-toggle="tab">${performerLegalText}</a></li>
                                	<li class="active"><a href="#tabPerformerCompany" data-toggle="tab">${performerComponyText}</a></li>
                                </c:if>                                
                            </ul>
                        </div>
                        <div class="panel-body">
                            <div class="tab-content">
                            	<c:choose>
                            		<c:when test="${empty sessionScope.activeTab || sessionScope.activeTab == '1'}">
                            			<div class="tab-pane fade in active" id="tabCustomerNatural">
                            		</c:when>
                            		<c:otherwise>
                            			<div class="tab-pane fade" id="tabCustomerNatural">
                            		</c:otherwise>
                            	</c:choose>           	
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.registration.customer.natural.page">
                                        <input type="hidden" name="typePerson" value="customer">
                                        <input type="hidden" name="formOwnership" value="natural">
                                        <input type="hidden" name="active" value="1">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<c:set var="errorMessage" value="" scope="session"/>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="register-username"><i class="icon-user"></i> <b>${usernameText}* <font color="red"><c:out value="${sessionScope.errorInput['username']}"/></font></b></label>
                                            <c:choose>
                                            <c:when test="${not empty sessionScope.errorTempData['username']}">
                                            	<input class="form-control" id="register-username" name="username" type="text" value="${sessionScope.errorTempData['username']}" >
                                            </c:when>
                                            <c:otherwise>
                                            	<input class="form-control" id="register-username" name="username" type="text" placeholder="${usernameText}" >
                                            </c:otherwise>
                                            </c:choose>                                            
                                        </div>
                                        <div class="form-group">
                                            <label for="register-password"><i class="icon-user"></i> <b>${passwordText}* <font color="red"><c:out value="${sessionScope.errorInput['password']}"/></font></b></label>
                                            <input class="form-control" id="register-password" name="password" type="password" placeholder="${passwordText}">
                                        </div>
                                        <div class="form-group">
                                            <label for="register-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="register-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-email" name="email" type="text" placeholder="${emailText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" placeholder="${phoneText} +375291112233 ${orText} 80291112233">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-name"><i class="icon-user"></i> <b>${nameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['name']}">
                                                    <input class="form-control" id="register-name" name="name" type="text" value="${sessionScope.errorTempData['name']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-name" name="name" type="text" placeholder="${nameText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-surname"><i class="icon-user"></i> <b>${surnameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surname']}">
                                                    <input class="form-control" id="register-surname" name="surname" type="text" value="${sessionScope.errorTempData['surname']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-surname" name="surname" type="text" placeholder="${surnameText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-address"><i class="icon-user"></i> <b>${addressText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="register-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-address" name="address" type="text" placeholder="${addressText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="register-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>                                        
										<button type="submit" class="btn pull-right">${buttonText}</button>
										<div class="clearfix"></div>
                                    </form>                                    
                                </div>
                                
                                <c:choose>
                            		<c:when test="${sessionScope.activeTab == '2'}">
                            			<div class="tab-pane fade in active" id="tabCustomerLegal">
                            		</c:when>
                            		<c:otherwise>
                            			<div class="tab-pane fade" id="tabCustomerLegal">
                            		</c:otherwise>
                            	</c:choose>
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.registration.customer.legal.page">
                                        <input type="hidden" name="typePerson" value="customer">
                                        <input type="hidden" name="formOwnership" value="legal">
                                        <input type="hidden" name="active" value="2">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<c:set var="errorMessage" value="" scope="session"/>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="register-username"><i class="icon-user"></i> <b>${usernameText}* <font color="red"><c:out value="${sessionScope.errorInput['username']}"/></font></b></label>
                                            <c:choose>
                                            <c:when test="${not empty sessionScope.errorTempData['username']}">
                                            	<input class="form-control" id="register-username" name="username" type="text" value="${sessionScope.errorTempData['username']}" >
                                            </c:when>
                                            <c:otherwise>
                                            	<input class="form-control" id="register-username" name="username" type="text" placeholder="${usernameText}" >
                                            </c:otherwise>
                                            </c:choose>                                            
                                        </div>
                                        <div class="form-group">
                                            <label for="register-password"><i class="icon-user"></i> <b>${passwordText}* <font color="red"><c:out value="${sessionScope.errorInput['password']}"/></font></b></label>
                                            <input class="form-control" id="register-password" name="password" type="password" placeholder="${passwordText}">
                                        </div>
                                        <div class="form-group">
                                            <label for="register-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="register-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-email" name="email" type="text" placeholder="${emailText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" placeholder="${phoneText} +375291112233 ${orText} 80291112233">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-name"><i class="icon-user"></i> <b>${nameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['name']}">
                                                    <input class="form-control" id="register-name" name="name" type="text" value="${sessionScope.errorTempData['name']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-name" name="name" type="text" placeholder="${nameText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-surname"><i class="icon-user"></i> <b>${surnameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surname']}">
                                                    <input class="form-control" id="register-surname" name="surname" type="text" value="${sessionScope.errorTempData['surname']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-surname" name="surname" type="text" placeholder="${surnameText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-address"><i class="icon-user"></i> <b>${addressText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="register-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-address" name="address" type="text" placeholder="${addressText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-requisites"><i class="icon-user"></i> <b>${requisitesText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['requisites']}">
                                                    <input class="form-control" id="register-requisites" name="requisites" type="text" value="${sessionScope.errorTempData['requisites']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-requisites" name="requisites" type="text" placeholder="${requisitesText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-fileregistration"><i class="icon-user"></i> <b>${fileregistrationText}</b></label>
                                            <input id="register-fileregistration" name="fileregistration" type="file" placeholder="${fileregistrationText}">
                                        </div>
                                        <div class="form-group">
                                            <label for="register-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="register-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                                
                                <c:choose>
                            		<c:when test="${sessionScope.activeTab == '3'}">
                            			<div class="tab-pane fade in active" id="tabCustomerCompany">
                            		</c:when>
                            		<c:otherwise>
                            			<div class="tab-pane fade" id="tabCustomerCompany">
                            		</c:otherwise>
                            	</c:choose>
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.registration.customer.company.page">
                                        <input type="hidden" name="typePerson" value="customer">
                                        <input type="hidden" name="formOwnership" value="company">
                                        <input type="hidden" name="active" value="3">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<c:set var="errorMessage" value="" scope="session"/>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="register-username"><i class="icon-user"></i> <b>${usernameText}* <font color="red"><c:out value="${sessionScope.errorInput['username']}"/></font></b></label>
                                            <c:choose>
                                            <c:when test="${not empty sessionScope.errorTempData['username']}">
                                            	<input class="form-control" id="register-username" name="username" type="text" value="${sessionScope.errorTempData['username']}" >
                                            </c:when>
                                            <c:otherwise>
                                            	<input class="form-control" id="register-username" name="username" type="text" placeholder="${usernameText}" >
                                            </c:otherwise>
                                            </c:choose>                                            
                                        </div>
                                        <div class="form-group">
                                            <label for="register-password"><i class="icon-user"></i> <b>${passwordText}* <font color="red"><c:out value="${sessionScope.errorInput['password']}"/></font></b></label>
                                            <input class="form-control" id="register-password" name="password" type="password" placeholder="${passwordText}">
                                        </div>
                                        <div class="form-group">
                                            <label for="register-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="register-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-email" name="email" type="text" placeholder="${emailText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" placeholder="${phoneText} +375291112233 ${orText} 80291112233">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-namecompany"><i class="icon-user"></i> <b>${namecompanyText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['namecompany']}">
                                                    <input class="form-control" id="register-namecompany" name="namecompany" type="text" value="${sessionScope.errorTempData['namecompany']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-namecompany" name="namecompany" type="text" placeholder="${namecompanyText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-nameagent"><i class="icon-user"></i> <b>${nameagentText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['nameagent']}">
                                                    <input class="form-control" id="register-nameagent" name="nameagent" type="text" value="${sessionScope.errorTempData['nameagent']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-nameagent" name="nameagent" type="text" placeholder="${nameagentText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-surnameagent"><i class="icon-user"></i> <b>${surnameagentText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surnameagent']}">
                                                    <input class="form-control" id="register-surnameagent" name="surnameagent" type="text" value="${sessionScope.errorTempData['surnameagent']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-surnameagent" name="surnameagent" type="text" placeholder="${surnameagentText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-address"><i class="icon-user"></i> <b>${addressText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="register-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-address" name="address" type="text" placeholder="${addressText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-requisites"><i class="icon-user"></i> <b>${requisitesText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['requisites']}">
                                                    <input class="form-control" id="register-requisites" name="requisites" type="text" value="${sessionScope.errorTempData['requisites']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-requisites" name="requisites" type="text" placeholder="${requisitesText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-description"><i class="icon-user"></i> <b>${descriptionText}</b></label>
                                            <textarea class="form-control" id="register-description" name="description" rows="4" ></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="register-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                                
                                <c:choose>
                            		<c:when test="${sessionScope.activeTab == '4'}">
                            			<div class="tab-pane fade in active" id="tabPerformerLegal">
                            		</c:when>
                            		<c:otherwise>
                            			<div class="tab-pane fade" id="tabPerformerLegal">
                            		</c:otherwise>
                            	</c:choose>
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.registration.performer.legal.page">
                                        <input type="hidden" name="typePerson" value="performer">
                                        <input type="hidden" name="formOwnership" value="legal">
                                        <input type="hidden" name="active" value="4">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<c:set var="errorMessage" value="" scope="session"/>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="register-username"><i class="icon-user"></i> <b>${usernameText}* <font color="red"><c:out value="${sessionScope.errorInput['username']}"/></font></b></label>
                                            <c:choose>
                                            <c:when test="${not empty sessionScope.errorTempData['username']}">
                                            	<input class="form-control" id="register-username" name="username" type="text" value="${sessionScope.errorTempData['username']}" >
                                            </c:when>
                                            <c:otherwise>
                                            	<input class="form-control" id="register-username" name="username" type="text" placeholder="${usernameText}" >
                                            </c:otherwise>
                                            </c:choose>                                            
                                        </div>
                                        <div class="form-group">
                                            <label for="register-password"><i class="icon-user"></i> <b>${passwordText}* <font color="red"><c:out value="${sessionScope.errorInput['password']}"/></font></b></label>
                                            <input class="form-control" id="register-password" name="password" type="password" placeholder="${passwordText}">
                                        </div>
                                        <div class="form-group">
                                            <label for="register-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="register-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-email" name="email" type="text" placeholder="${emailText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" placeholder="${phoneText} +375291112233 ${orText} 80291112233">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-name"><i class="icon-user"></i> <b>${nameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['name']}">
                                                    <input class="form-control" id="register-name" name="name" type="text" value="${sessionScope.errorTempData['name']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-name" name="name" type="text" placeholder="${nameText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-surname"><i class="icon-user"></i> <b>${surnameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surname']}">
                                                    <input class="form-control" id="register-surname" name="surname" type="text" value="${sessionScope.errorTempData['surname']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-surname" name="surname" type="text" placeholder="${surnameText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-address"><i class="icon-user"></i> <b>${addressText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="register-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-address" name="address" type="text" placeholder="${addressText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-requisites"><i class="icon-user"></i> <b>${requisitesText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['requisites']}">
                                                    <input class="form-control" id="register-requisites" name="requisites" type="text" value="${sessionScope.errorTempData['requisites']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-requisites" name="requisites" type="text" placeholder="${requisitesText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-fileregistration"><i class="icon-user"></i> <b>${fileregistrationText}</b></label>
                                            <input id="register-fileregistration" name="fileregistration" type="file" data-buttonText="Your label here." placeholder="${fileregistrationText}">
                                        </div>
                                        <div class="form-group">
                                            <label for="register-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="register-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                                
                                <c:choose>
                            		<c:when test="${sessionScope.activeTab == '5'}">
                            			<div class="tab-pane fade in active" id="tabPerformerCompany">
                            		</c:when>
                            		<c:otherwise>
                            			<div class="tab-pane fade" id="tabPerformerCompany">
                            		</c:otherwise>
                            	</c:choose>
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.registration.performer.company.page">
                                        <input type="hidden" name="typePerson" value="performer">
                                        <input type="hidden" name="formOwnership" value="company">
                                        <input type="hidden" name="active" value="5">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<c:set var="errorMessage" value="" scope="session"/>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="register-username"><i class="icon-user"></i> <b>${usernameText}* <font color="red"><c:out value="${sessionScope.errorInput['username']}"/></font></b></label>
                                            <c:choose>
                                            <c:when test="${not empty sessionScope.errorTempData['username']}">
                                            	<input class="form-control" id="register-username" name="username" type="text" value="${sessionScope.errorTempData['username']}" >
                                            </c:when>
                                            <c:otherwise>
                                            	<input class="form-control" id="register-username" name="username" type="text" placeholder="${usernameText}" >
                                            </c:otherwise>
                                            </c:choose>                                            
                                        </div>
                                        <div class="form-group">
                                            <label for="register-password"><i class="icon-user"></i> <b>${passwordText}* <font color="red"><c:out value="${sessionScope.errorInput['password']}"/></font></b></label>
                                            <input class="form-control" id="register-password" name="password" type="password" placeholder="${passwordText}">
                                        </div>
                                        <div class="form-group">
                                            <label for="register-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="register-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-email" name="email" type="text" placeholder="${emailText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" placeholder="${phoneText} +375291112233 ${orText} 80291112233">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-namecompany"><i class="icon-user"></i> <b>${namecompanyText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['namecompany']}">
                                                    <input class="form-control" id="register-namecompany" name="namecompany" type="text" value="${sessionScope.errorTempData['namecompany']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-namecompany" name="namecompany" type="text" placeholder="${namecompanyText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-nameagent"><i class="icon-user"></i> <b>${nameagentText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['nameagent']}">
                                                    <input class="form-control" id="register-nameagent" name="nameagent" type="text" value="${sessionScope.errorTempData['nameagent']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-nameagent" name="nameagent" type="text" placeholder="${nameagentText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-surnameagent"><i class="icon-user"></i> <b>${surnameagentText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surnameagent']}">
                                                    <input class="form-control" id="register-surnameagent" name="surnameagent" type="text" value="${sessionScope.errorTempData['surnameagent']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-surnameagent" name="surnameagent" type="text" placeholder="${surnameagentText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-address"><i class="icon-user"></i> <b>${addressText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="register-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-address" name="address" type="text" placeholder="${addressText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-requisites"><i class="icon-user"></i> <b>${requisitesText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['requisites']}">
                                                    <input class="form-control" id="register-requisites" name="requisites" type="text" value="${sessionScope.errorTempData['requisites']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-requisites" name="requisites" type="text" placeholder="${requisitesText}">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-description"><i class="icon-user"></i> <b>${descriptionText}</b></label>
                                            <textarea class="form-control" id="register-description" name="description" rows="4"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="register-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="register-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </div>
                                <c:set var="errorInput" value="null" scope="session"/>
                                <c:set var="errorTempData" value="null" scope="session"/>
                            </div>
                        </div>
                    </div>
                </div>
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