<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.services.ref.readMore.text" var="readMoreText" />
<fmt:message bundle="${loc}" key="locale.services.ref.trucking.title" var="truckingTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.trucking.text" var="truckingText" />
<fmt:message bundle="${loc}" key="locale.services.ref.repair.title" var="repairTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.repair.text" var="repairText" />
<fmt:message bundle="${loc}" key="locale.services.ref.courier.title" var="courierTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.courier.text" var="courierText" />
<fmt:message bundle="${loc}" key="locale.services.ref.cleaning.title" var="cleaningTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.cleaning.text" var="cleaningText" />
<fmt:message bundle="${loc}" key="locale.services.ref.computer.title" var="computerTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.computer.text" var="computerText" />
<fmt:message bundle="${loc}" key="locale.services.ref.events.title" var="eventsTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.events.text" var="eventsText" />
<fmt:message bundle="${loc}" key="locale.services.ref.design.title" var="designTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.design.text" var="designText" />
<fmt:message bundle="${loc}" key="locale.services.ref.photo.title" var="photoTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.photo.text" var="photoText" />
<fmt:message bundle="${loc}" key="locale.services.ref.web.title" var="webTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.web.text" var="webText" />
<fmt:message bundle="${loc}" key="locale.services.ref.install.title" var="installTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.install.text" var="installText" />
<fmt:message bundle="${loc}" key="locale.services.ref.beauty.title" var="beautyTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.beauty.text" var="beautyText" />
<fmt:message bundle="${loc}" key="locale.services.ref.legal.title" var="legalTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.legal.text" var="legalText" />
<fmt:message bundle="${loc}" key="locale.services.ref.education.title" var="educationTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.education.text" var="educationText" />
<fmt:message bundle="${loc}" key="locale.services.ref.repairCar.title" var="repairCarTitle" />
<fmt:message bundle="${loc}" key="locale.services.ref.repairCar.text" var="repairCarText" />

<div class="section">
    <div class="container">
    	<c:if test="${not empty sessionScope.errorMessage}">
			<h1 style="color: #ff0000">
				<c:out value="${sessionScope.errorMessage}"></c:out>
				<% session.setAttribute("errorMessage", ""); %>
			</h1>
		</c:if>
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/trucks.png" alt="Service 1">
                    <h3>${truckingTitle}</h3>
                    <p>${truckingText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="trucking">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/driller.png" alt="Service 2">
                    <h3>${repairTitle}</h3>
                    <p>${repairText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="repair">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/courier.png" alt="Service 3">
                    <h3>${courierTitle}</h3>
                    <p>${courierText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="courier">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/vacuum-cleaner.png" alt="Service 4">
                    <h3>${cleaningTitle}</h3>
                    <p>${cleaningText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="cleaning">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/computer.png" alt="Service 5">
                    <h3>${computerTitle}</h3>
                    <p>${computerText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="computer">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/balloon.png" alt="Service 6">
                    <h3>${eventsTitle}</h3>
                    <p>${eventsText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="events">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/paint-palette.png" alt="Service 7">
                    <h3>${designTitle}</h3>
                    <p>${designText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="design">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/photo-camera.png" alt="Service 8">
                    <h3>${photoTitle}</h3>
                    <p>${photoText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="photo">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/programming.png" alt="Service 9">
                    <h3>${webTitle}</h3>
                    <p>${webText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="web">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/plug.png" alt="Service 10">
                    <h3>${installTitle}</h3>
                    <p>${installText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="install">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/hairdresser.png" alt="Service 11">
                    <h3>${beautyTitle}</h3>
                    <p>${beautyText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="beauty">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/balance.png" alt="Service 12">
                    <h3>${legalTitle}</h3>
                    <p>${legalText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="legal">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/library.png" alt="Service 13">
                    <h3>${educationTitle}</h3>
                    <p>${educationText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="education">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="service-wrapper">
                    <img src="img/service-icon/car-repair.png" alt="Service 14">
                    <h3>${repairCarTitle}</h3>
                    <p>${repairCarText}</p>
                    <form method="post" action="/controller/Controler" role="form" role="form">
                    	<input type="hidden" name="command" value="cn.choose.specialization.page">
                    	<input type="hidden" name="specialization" value="repairtransport">
                    	<button type="submit" class="btn">${readMoreText}</button>                    
                    </form>
                </div>
            </div>            
        </div>
    </div>
</div>