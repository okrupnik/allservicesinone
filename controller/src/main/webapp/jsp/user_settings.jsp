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
<fmt:message bundle="${loc}" key="locale.register.ref.photo.text" var="photoText" />
<fmt:message bundle="${loc}" key="locale.register.ref.email.text" var="emailText" />
<fmt:message bundle="${loc}" key="locale.register.ref.phone.text" var="phoneText" />
<fmt:message bundle="${loc}" key="locale.register.ref.name.text" var="nameText" />
<fmt:message bundle="${loc}" key="locale.register.ref.surname.text" var="surnameText" />
<fmt:message bundle="${loc}" key="locale.register.ref.address.text" var="addressText" />
<fmt:message bundle="${loc}" key="locale.register.ref.requisites.text" var="requisitesText" />
<fmt:message bundle="${loc}" key="locale.register.ref.fileregistration.text" var="fileregistrationText" />
<fmt:message bundle="${loc}" key="locale.register.ref.namecompany.text" var="namecompanyText" />
<fmt:message bundle="${loc}" key="locale.register.ref.nameagent.text" var="nameagentText" />
<fmt:message bundle="${loc}" key="locale.register.ref.surnameagent.text" var="surnameagentText" />
<fmt:message bundle="${loc}" key="locale.register.ref.description.text" var="descriptionText" />
<fmt:message bundle="${loc}" key="locale.usersettings.ref.button.text" var="buttonText" />
<fmt:message bundle="${loc}" key="locale.usersettings.ref.old.password.text" var="oldPasswordText" />
<fmt:message bundle="${loc}" key="locale.usersettings.ref.new.password.text" var="newPasswordText" />
<fmt:message bundle="${loc}" key="locale.usersettings.ref.confirm.password.text" var="confirmPasswordText" />

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
            
             <div class="testimonial col-md-4 col-sm-4">
                    <div class="author-photo">
                    	<c:choose>
                    		<c:when test="${not empty sessionScope.user.photo}">
                    			<img src="${pageContext.request.contextPath}/img/avatar/${sessionScope.user.photo}" alt="User">
                    		</c:when>
                    		<c:otherwise>
                    			<img src="${pageContext.request.contextPath}/img/avatar/noname.png" alt="No Name">
                   			</c:otherwise>
                   		</c:choose>                        
                    </div>
                    <div class="testimonial-bubble">
                        <blockquote>
                        	<c:if test="${sessionScope.user.person.typePerson=='servicePerson'}">
                                ${sessionScope.user.serviceStaffInfo.name} ${sessionScope.user.serviceStaffInfo.surname}
                            </c:if>
                        	<c:if test="${sessionScope.user.person.typePerson=='customer' && sessionScope.user.customer.ownership.formOwnership=='natural'}">
                                ${sessionScope.user.customer.naturalCustomerInfo.name} ${sessionScope.user.customer.naturalCustomerInfo.surname}
                            </c:if>
                            <c:if test="${sessionScope.user.person.typePerson=='customer' && sessionScope.user.customer.ownership.formOwnership=='legal'}">
                                ${sessionScope.user.customer.legalCustomerInfo.name} ${sessionScope.user.customer.legalCustomerInfo.surname}
                            </c:if>  
                            <c:if test="${sessionScope.user.person.typePerson=='customer' && sessionScope.user.customer.ownership.formOwnership=='company'}">
                                ${sessionScope.user.customer.companyCustomerInfo.nameAgent} ${sessionScope.user.customer.companyCustomerInfo.surnameAgent}
                            </c:if>  
                            <c:if test="${sessionScope.user.person.typePerson=='performer' && sessionScope.user.performer.ownership.formOwnership=='legal'}">
                                ${sessionScope.user.performer.legalPerformerInfo.name} ${sessionScope.user.performer.legalPerformerInfo.surname}
                            </c:if>  
                            <c:if test="${sessionScope.user.person.typePerson=='performer' && sessionScope.user.performer.ownership.formOwnership=='company'}">
                                ${sessionScope.user.performer.companyPerformerInfo.nameAgent} ${sessionScope.user.performer.companyPerformerInfo.surnameAgent}
                            </c:if>                           
                        </blockquote>
                        <div class="sprite arrow-speech-bubble"></div>
                    </div>
                </div>            
            <div class="col-md-8 col-sm-8">
                    <div class="panel-body">
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="tabUserSetting">             
                            	<c:if test="${sessionScope.user.person.typePerson=='servicePerson'}">   
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.admin.change.setting.page">
                                        <input type="hidden" name="typePerson" value="servicePerson">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<% session.setAttribute("errorMessage", ""); %>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="setting-name"><i class="icon-user"></i> <b>${nameText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['name']}">
                                                    <input class="form-control" id="setting-name" name="name" type="text" value="${sessionScope.errorTempData['name']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-name" name="name" type="text" value="${sessionScope.user.serviceStaffInfo.name}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-surname"><i class="icon-user"></i> <b>${surnameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surname']}">
                                                    <input class="form-control" id="setting-surname" name="surname" type="text" value="${sessionScope.errorTempData['surname']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-surname" name="surname" type="text" value="${sessionScope.user.serviceStaffInfo.surname}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.user.email}" laceholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.user.phoneNumber}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-address"><i class="icon-user"></i> <b>${addressText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.user.address}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="setting-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </c:if>               	
                            	<c:if test="${sessionScope.user.person.typePerson=='customer' && sessionScope.user.customer.ownership.formOwnership=='natural'}">   
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.customer.natural.change.setting.page">
                                        <input type="hidden" name="typePerson" value="customer">
                                        <input type="hidden" name="formOwnership" value="natural">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<% session.setAttribute("errorMessage", ""); %>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="setting-name"><i class="icon-user"></i> <b>${nameText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['name']}">
                                                    <input class="form-control" id="setting-name" name="name" type="text" value="${sessionScope.errorTempData['name']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-name" name="name" type="text" value="${sessionScope.user.customer.naturalCustomerInfo.name}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-surname"><i class="icon-user"></i> <b>${surnameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surname']}">
                                                    <input class="form-control" id="setting-surname" name="surname" type="text" value="${sessionScope.errorTempData['surname']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-surname" name="surname" type="text" value="${sessionScope.user.customer.naturalCustomerInfo.surname}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>                                            
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.user.email}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.user.phoneNumber}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-address"><i class="icon-user"></i> <b>${addressText}*</b></label>
                                             <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.user.address}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="setting-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </c:if>    
                                <c:if test="${sessionScope.user.person.typePerson=='customer' && sessionScope.user.customer.ownership.formOwnership=='legal'}">   
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.customer.legal.change.setting.page">
                                        <input type="hidden" name="typePerson" value="customer">
                                        <input type="hidden" name="formOwnership" value="legal">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<% session.setAttribute("errorMessage", ""); %>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="setting-name"><i class="icon-user"></i> <b>${nameText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['name']}">
                                                    <input class="form-control" id="setting-name" name="name" type="text" value="${sessionScope.errorTempData['name']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-name" name="name" type="text" value="${sessionScope.user.customer.legalCustomerInfo.name}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-surname"><i class="icon-user"></i> <b>${surnameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surname']}">
                                                    <input class="form-control" id="setting-surname" name="surname" type="text" value="${sessionScope.errorTempData['surname']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-surname" name="surname" type="text" value="${sessionScope.user.customer.legalCustomerInfo.surname}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.user.email}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.user.phoneNumber}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-address"><i class="icon-user"></i> <b>${addressText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.user.address}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-requisites"><i class="icon-user"></i> <b>${requisitesText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['requisites']}">
                                                    <input class="form-control" id="setting-requisites" name="requisites" type="text" value="${sessionScope.errorTempData['requisites']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-requisites" name="requisites" type="text" value="${sessionScope.user.customer.legalCustomerInfo.requisites}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-fileregistration"><i class="icon-user"></i> <b>${fileregistrationText}*</b></label>
                                            <input id="setting-fileregistration" name="fileregistration" type="file" placeholder="">
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="setting-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </c:if>    
                            	<c:if test="${sessionScope.user.person.typePerson=='customer' && sessionScope.user.customer.ownership.formOwnership=='company'}">   
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.customer.company.change.setting.page">
                                        <input type="hidden" name="typePerson" value="customer">
                                        <input type="hidden" name="formOwnership" value="company">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<% session.setAttribute("errorMessage", ""); %>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="setting-nameagent"><i class="icon-user"></i> <b>${nameagentText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['nameagent']}">
                                                    <input class="form-control" id="setting-nameagent" name="nameagent" type="text" value="${sessionScope.errorTempData['nameagent']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-nameagent" name="nameagent" type="text" value="${sessionScope.user.customer.companyCustomerInfo.nameAgent}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        <div class="form-group">
                                            <label for="setting-surnameagent"><i class="icon-user"></i> <b>${surnameagentText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surnameagent']}">
                                                    <input class="form-control" id="setting-surnameagent" name="surnameagent" type="text" value="${sessionScope.errorTempData['surnameagent']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-surnameagent" name="surnameagent" type="text" value="${sessionScope.user.customer.companyCustomerInfo.surnameAgent}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>                                        
                                        <div class="form-group">
                                            <label for="setting-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.user.email}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.user.phoneNumber}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-namecompany"><i class="icon-user"></i> <b>${namecompanyText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['namecompany']}">
                                                    <input class="form-control" id="setting-namecompany" name="namecompany" type="text" value="${sessionScope.errorTempData['namecompany']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-namecompany" name="namecompany" type="text" value="${sessionScope.user.customer.companyCustomerInfo.nameCompany}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-address"><i class="icon-user"></i> <b>${addressText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.user.address}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-requisites"><i class="icon-user"></i> <b>${requisitesText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['requisites']}">
                                                    <input class="form-control" id="setting-requisites" name="requisites" type="text" value="${sessionScope.errorTempData['requisites']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-requisites" name="requisites" type="text" value="${sessionScope.user.customer.companyCustomerInfo.requisites}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-description"><i class="icon-user"></i> <b>${descriptionText}</b></label>
                                            <textarea class="form-control" id="setting-description" name="description" rows="4">${sessionScope.user.customer.companyCustomerInfo.description}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="setting-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </c:if>  
                                 <c:if test="${sessionScope.user.person.typePerson=='performer' && sessionScope.user.performer.ownership.formOwnership=='legal'}">   
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.performer.legal.change.setting.page">
                                        <input type="hidden" name="typePerson" value="performer">
                                        <input type="hidden" name="formOwnership" value="legal">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<% session.setAttribute("errorMessage", ""); %>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="setting-name"><i class="icon-user"></i> <b>${nameText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['name']}">
                                                    <input class="form-control" id="setting-name" name="name" type="text" value="${sessionScope.errorTempData['name']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-name" name="name" type="text" value="${sessionScope.user.performer.legalPerformerInfo.name}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-surname"><i class="icon-user"></i> <b>${surnameText}</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surname']}">
                                                    <input class="form-control" id="setting-surname" name="surname" type="text" value="${sessionScope.errorTempData['surname']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-surname" name="surname" type="text" value="${sessionScope.user.performer.legalPerformerInfo.surname}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.user.email}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="register-phone" name="phone" type="tel" value="${sessionScope.user.phoneNumber}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-address"><i class="icon-user"></i> <b>${addressText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.user.address}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-requisites"><i class="icon-user"></i> <b>${requisitesText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['requisites']}">
                                                    <input class="form-control" id="setting-requisites" name="requisites" type="text" value="${sessionScope.errorTempData['requisites']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-requisites" name="requisites" type="text" value="${sessionScope.user.performer.requisites}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-fileregistration"><i class="icon-user"></i> <b>${fileregistrationText}*</b></label>
                                            <input id="setting-fileregistration" name="fileregistration" type="file" placeholder="">
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="setting-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </c:if>      
                                <c:if test="${sessionScope.user.person.typePerson=='performer' && sessionScope.user.performer.ownership.formOwnership=='company'}">   
                                    <form method="post" action="/controller/Controler" role="form" role="form">
                                        <input type="hidden" name="command" value="cn.performer.company.change.setting.page">
                                        <input type="hidden" name="typePerson" value="performer">
                                        <input type="hidden" name="formOwnership" value="company">
                                        <c:if test="${not empty sessionScope.errorMessage}">
                                            <div class="form-group">
                                                <h3 style="color: #ff0000">
													<c:out value="${sessionScope.errorMessage}"></c:out>
													<% session.setAttribute("errorMessage", ""); %>
												</h3>
                                            </div>
                                        </c:if>
                                        <div class="form-group">
                                            <label for="setting-nameagent"><i class="icon-user"></i> <b>${nameagentText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['nameagent']}">
                                                    <input class="form-control" id="setting-nameagent" name="nameagent" type="text" value="${sessionScope.errorTempData['nameagent']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-nameagent" name="nameagent" type="text" value="${sessionScope.user.performer.companyPerformerInfo.nameAgent}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-surnameagent"><i class="icon-user"></i> <b>${surnameagentText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['surnameagent']}">
                                                    <input class="form-control" id="setting-surnameagent" name="surnameagent" type="text" value="${sessionScope.errorTempData['surnameagent']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-surnameagent" name="surnameagent" type="text" value="${sessionScope.user.performer.companyPerformerInfo.surnameAgent}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>                                        
                                        <div class="form-group">
                                            <label for="setting-email"><i class="icon-user"></i> <b>${emailText}* <font color="red"><c:out value="${sessionScope.errorInput['email']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['email']}">
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.errorTempData['email']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-email" name="email" type="text" value="${sessionScope.user.email}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-phone"><i class="icon-user"></i> <b>${phoneText}* <font color="red"><c:out value="${sessionScope.errorInput['phoneNumber']}"/></font></b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['phoneNumber']}">
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.errorTempData['phoneNumber']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-phone" name="phone" type="tel" value="${sessionScope.user.phoneNumber}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-namecompany"><i class="icon-user"></i> <b>${namecompanyText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['namecompany']}">
                                                    <input class="form-control" id="setting-namecompany" name="namecompany" type="text" value="${sessionScope.errorTempData['namecompany']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-namecompany" name="namecompany" type="text" value="${sessionScope.user.performer.companyPerformerInfo.nameCompany}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-address"><i class="icon-user"></i> <b>${addressText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['address']}">
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.errorTempData['address']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-address" name="address" type="text" value="${sessionScope.user.address}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-requisites"><i class="icon-user"></i> <b>${requisitesText}*</b></label>
                                            <c:choose>
                                                <c:when test="${not empty sessionScope.errorTempData['requisites']}">
                                                    <input class="form-control" id="setting-requisites" name="requisites" type="text" value="${sessionScope.errorTempData['requisites']}">
                                                </c:when>
                                                <c:otherwise>
                                                    <input class="form-control" id="setting-requisites" name="requisites" type="text" value="${sessionScope.user.performer.requisites}" placeholder="">
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-description"><i class="icon-user"></i> <b>${descriptionText}</b></label>
                                            <textarea class="form-control" id="setting-description" name="description" rows="4">${sessionScope.user.performer.companyPerformerInfo.description}</textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="setting-photo"><i class="icon-user"></i> <b>${photoText}</b></label>
                                            <input id="setting-photo" name="photo" type="file" placeholder="${photoText}">
                                        </div>
                                        <button type="submit" class="btn pull-right">${buttonText}</button>
                                        <div class="clearfix"></div>
                                    </form>
                                </c:if>  
                           		<form method="post" action="/controller/Controler" role="form" role="form">
                                    <input type="hidden" name="command" value="cn.user.password.settings.page">
                                    <div class="form-group">
                                        <label for="setting-oldpassword"><i class="icon-user"></i> <b>${oldPasswordText}* <font color="red"><c:out value="${sessionScope.errorInput['oldpassword']}"/></font></b></label>
                                        <input class="form-control" id="setting-username" name="oldpassword" type="password" placeholder="">
                                    </div>                                    
                                    <div class="form-group">
                                        <label for="setting-newpassword"><i class="icon-user"></i> <b>${newPasswordText}* <font color="red"><c:out value="${sessionScope.errorInput['newpassword']}"/></font></b></label>
                                        <input class="form-control" id="setting-password" name="newpassword" type="password" placeholder="">
                                    </div>
                                    <div class="form-group">
                                        <label for="setting-confirmpassword"><i class="icon-user"></i> <b>${confirmPasswordText}* <font color="red"><c:out value="${sessionScope.errorInput['confirmpassword']}"/></font></b></label>
                                        <input class="form-control" id="setting-password" name="confirmpassword" type="password" placeholder="">
                                    </div>
                                    <button type="submit" class="btn pull-right">${buttonText}</button>
                                    <div class="clearfix"></div>
                                </form>
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