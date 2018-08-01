<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.footer.ref.navigate.text" var="navigateText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.blog.text" var="blogText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.about.text" var="aboutText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.team.text" var="teamText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.rules.text" var="rulesText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.faq.text" var="faqText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.contacts.text" var="contactsText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.address.text" var="addressText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.phone.text" var="phoneText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.email.text" var="emailText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.connected.text" var="connectedText" />
<fmt:message bundle="${loc}" key="locale.footer.ref.rights.text" var="rightsText" />

<div class="footer">
    <div class="container">
        <div class="row">
            <!-- <div class="col-footer col-md-3 col-xs-6">
                <h3>Our Latest Work</h3>
                <div class="portfolio-item">
                    <div class="portfolio-image">
                        <a href="page-portfolio-item.html"><img src="img/portfolio6.jpg" alt="Project Name"></a>
                    </div>
                </div>
            </div>   -->
            <div class="col-footer col-md-3 col-xs-6">
                <h3>${navigateText}</h3>
                <ul class="no-list-style footer-navigate-section">   
                	<li><a href="page-blog-posts.html">${blogText}</a></li>                 
                    <li><a href="page-about-us.html">${aboutText}</a></li>
                    <li><a href="page-our-team.html">${teamText}</a></li>
                    <li><a href="page-rules.html">${rulesText}</a></li>
                    <li><a href="page-faq.html">${faqText}</a></li>
                </ul>
            </div>

            <div class="col-footer col-md-4 col-xs-6">
                <h3>${contactsText}</h3>
                <p class="contact-us-details">
                    <b>${addressText}:</b> Street, Minsk, Belarus
                    <br/>
                    <b>${phoneText}:</b> +375-29-555-55-55
                    <br/>                    
                    <b>${emailText}:</b> <a href="mailto:info@allservicesinone.com">info@allservicesinone.com</a>
                </p>
            </div>
            <div class="col-footer col-md-2 col-xs-6">
                <h3>${connectedText}</h3>
                <ul class="footer-stay-connected no-list-style">
                    <li>
                        <a href="#" class="facebook"></a>
                    </li>
                    <li>
                        <a href="#" class="twitter"></a>
                    </li>
                    <li>
                        <a href="#" class="googleplus"></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="footer-copyright">&copy; 2018. ${rightsText}.</div>
            </div>
        </div>
    </div>
</div>