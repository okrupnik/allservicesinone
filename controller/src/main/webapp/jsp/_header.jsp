<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.header.button.lang.text" var="buttonLang" />
<fmt:message bundle="${loc}" key="locale.header.button.ru.text"	var="buttonRu" />
<fmt:message bundle="${loc}" key="locale.header.button.en.text"	var="buttonEn" />
<fmt:message bundle="${loc}" key="locale.header.button.home.text"	var="buttonHome" />
<fmt:message bundle="${loc}" key="locale.header.button.performers.text"	var="buttonPerformer" />
<fmt:message bundle="${loc}" key="locale.header.button.createtask.text"	var="buttonCreateTask" />
<fmt:message bundle="${loc}" key="locale.header.button.alltasks.text"	var="buttonAllTask" />
<fmt:message bundle="${loc}" key="locale.header.loginform.button.signin.text"	var="buttonSignIn" />
<fmt:message bundle="${loc}" key="locale.header.loginform.button.create.text"	var="buttonCreateAccount" />
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.editor.text"	var="buttonEditor" />
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.order.text"	var="buttonOrder" />
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.offering.text"	var="buttonOffering" />
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.message.text"	var="buttonMessage" />
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.settings.text"	var="buttonSetting" />
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.exit.text"	var="buttonExit" />

<fmt:message bundle="${loc}" key="locale.services.ref.trucking.title" var="truckingTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.repair.title" var="repairTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.courier.title" var="courierTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.cleaning.title" var="cleaningTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.computer.title" var="computerTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.events.title" var="eventsTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.design.title" var="designTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.photo.title" var="photoTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.web.title" var="webTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.install.title" var="installTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.beauty.title" var="beautyTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.legal.title" var="legalTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.education.title" var="educationTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.repairCar.title" var="repairCarTitle" />

<div class="mainmenu-wrapper">
    <div class="container">
        <div class="menuextras">
            <div class="extras">
                <ul>
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            <li>
                                <div class="dropdown choose-user-option">
                                    <a class="#" data-toggle="dropdown" href="#">
                                        <img src="${pageContext.request.contextPath}/img/user/user.png" alt="User">${sessionScope.user.username}
                                    </a>
                                    <ul class="dropdown-menu" role="menu">
                                    	<c:if test="${sessionScope.user.role.typeRole=='admin' || sessionScope.user.role.typeRole=='editor'}">
                                    	<li role="menuitem">
                                            <a href="${pageContext.request.contextPath}/Controler?command=cn.user.edit.page">
                                                <img src="${pageContext.request.contextPath}/img/user/user-edit.png" alt="Editor"> ${buttonEditor}
                                            </a>
                                        </li>
                                    	</c:if>
                                    	<c:if test="${sessionScope.user.person.typePerson=='customer'}">
                                    	<li role="menuitem">
                                            <a href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.user.page">
                                                <img src="${pageContext.request.contextPath}/img/user/user-order.png" alt="Order"> ${buttonOrder}
                                            </a>
                                        </li>
                                    	</c:if>
                                    	<c:if test="${sessionScope.user.person.typePerson=='performer'}">
                                    	<li role="menuitem">
                                            <a href="${pageContext.request.contextPath}/Controler?command=cn.user.show.offering.orders.page">
                                                <img src="${pageContext.request.contextPath}/img/user/user-order.png" alt="Offering"> ${buttonOffering}
                                            </a>
                                            <a href="${pageContext.request.contextPath}/Controler?command=cn.user.show.orders.performer.page">
                                                <img src="${pageContext.request.contextPath}/img/user/user-order.png" alt="Order"> ${buttonOrder}
                                            </a>
                                        </li>
                                    	</c:if>
                                        <li role="menuitem">
                                            <a href="${pageContext.request.contextPath}/jsp/user_messages.jsp">
                                                <img src="${pageContext.request.contextPath}/img/user/user-message.png" alt="Messages"> ${buttonMessage}
                                            </a>
                                        </li>
                                        <li role="menuitem">
                                            <a href="${pageContext.request.contextPath}/Controler?command=cn.to.user.settings.page"> <img src="${pageContext.request.contextPath}/img/user/user-setting.png" alt="Settings"> ${buttonSetting}
                                            </a>
                                        </li>
                                        <li role="menuitem">
                                            <a href="${pageContext.request.contextPath}/Controler?command=cn.signout.page"> <img src="${pageContext.request.contextPath}/img/user/user-exit.png" alt="Exit"> ${buttonExit}
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </c:when>
                        <c:otherwise>
                        	<li><a href="${pageContext.request.contextPath}/Controler?command=cn.to.signin.page">${buttonSignIn}</a></li>
                            <li><a href="${pageContext.request.contextPath}/Controler?command=cn.to.registration.page">${buttonCreateAccount}</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li>
                        <div class="dropdown choose-country">
                            <a class="#" data-toggle="dropdown" href="#">
                                <c:if test="${sessionScope.local=='en'}">
                                    <img src="${pageContext.request.contextPath}/img/flags/gb.png" alt="Language"> ${buttonLang}
                                </c:if>
                                <c:if test="${sessionScope.local=='ru'}">
                                    <img src="${pageContext.request.contextPath}/img/flags/ru.png" alt="Language"> ${buttonLang}
                                </c:if>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li role="menuitem">
                                    <a href="${pageContext.request.contextPath}/Controler?command=cn.localization.page&local=ru"> <img src="${pageContext.request.contextPath}/img/flags/ru.png" alt="Russian"> ${buttonRu}
                                    </a>
                                </li>
                                <li role="menuitem">
                                    <a href="${pageContext.request.contextPath}/Controler?command=cn.localization.page&local=en"> <img src="${pageContext.request.contextPath}/img/flags/gb.png" alt="English"> ${buttonEn}
                                    </a>
                                </li>
                                <!-- <li role="menuitem"><a href="#"> <img
										src="${pageContext.request.contextPath}/img/flags/es.png"
										alt="Spain"> ES
								</a></li>  -->
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <nav id="mainmenu" class="mainmenu">
            <ul>
                <li class="logo-wrapper">
                    <a href="${pageContext.request.contextPath}/Controler?command=cn.main.page">
                        <c:if test="${sessionScope.local=='en'}">
                            <img src="${pageContext.request.contextPath}/img/mPurpose-logo-en.png" alt="All Service In One">
                        </c:if>
                        <c:if test="${sessionScope.local=='ru'}">
                            <img src="${pageContext.request.contextPath}/img/mPurpose-logo-ru.png" alt="All Service In One">
                        </c:if>
                    </a>
                </li>
                <li class="active"><a href="${pageContext.request.contextPath}/Controler?command=cn.main.page">${buttonHome}</a></li>
                <li><a href="${pageContext.request.contextPath}/Controler?command=cn.show.all.performer.page">${buttonPerformer}</a></li>
                <li class="has-submenu"><a href="#">${buttonCreateTask}</a>
                    <div class="mainmenu-submenu">
                        <div class="mainmenu-submenu-inner">
                            <div>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=trucking"><h4>${truckingTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=repair"><h4>${repairTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=courier"><h4>${courierTitle}</h4></a>                                	
                            </div>
                            <div>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=cleaning"><h4>${cleaningTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=computer"><h4>${computerTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=events"><h4>${eventsTitle}</h4></a>                                	
                            </div>
                            <div>    
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=photo"><h4>${photoTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=web"><h4>${webTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=install"><h4>${installTitle}</h4></a>
                            </div>    
                            <div>    
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=beauty"><h4>${beautyTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=legal"><h4>${legalTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=education"><h4>${educationTitle}</h4></a>
                                <a href="${pageContext.request.contextPath}/Controler?command=cn.choose.specialization.page&specialization=repairtransport"><h4>${repairCarTitle}</h4></a>
                            </div>                            
                        </div>
                        <!-- /mainmenu-submenu-inner -->
                    </div>
                    <!-- /mainmenu-submenu -->
                </li>
                <li><a href="${pageContext.request.contextPath}/Controler?command=cn.show.all.orders.of.users.page">${buttonAllTask}</a></li>
            </ul>
        </nav>
    </div>
</div>