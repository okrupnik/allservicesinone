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
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.message.text"	var="buttonMessage" />
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.settings.text"	var="buttonSetting" />
<fmt:message bundle="${loc}" key="locale.header.usermenu.ref.exit.text"	var="buttonExit" />

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
                <li><a href="#">${buttonPerformer}</a></li>
                <li class="has-submenu"><a href="#">${buttonCreateTask}</a>
                    <div class="mainmenu-submenu">
                        <div class="mainmenu-submenu-inner">
                            <div>
                                <h4>Homepage</h4>
                                <ul>
                                    <li><a href="index.html">Homepage (Sample 1)</a></li>
                                    <li><a href="page-homepage-sample.html">Homepage
											(Sample 2)</a></li>
                                </ul>
                                <h4>Services & Pricing</h4>
                                <ul>
                                    <li><a href="page-services-1-column.html">Services/Features
											(Rows)</a></li>
                                    <li><a href="page-services-3-columns.html">Services/Features
											(3 Columns)</a></li>
                                    <li><a href="page-services-4-columns.html">Services/Features
											(4 Columns)</a></li>
                                    <li><a href="page-pricing.html">Pricing Table</a></li>
                                </ul>
                                <h4>Team & Open Vacancies</h4>
                                <ul>
                                    <li><a href="page-team.html">Our Team</a></li>
                                    <li><a href="page-vacancies.html">Open Vacancies
											(List)</a></li>
                                    <li><a href="page-job-details.html">Open Vacancies
											(Job Details)</a></li>
                                </ul>
                            </div>
                            <div>
                                <h4>Our Work (Portfolio)</h4>
                                <ul>
                                    <li><a href="page-portfolio-2-columns-1.html">Portfolio
											(2 Columns, Option 1)</a></li>
                                    <li><a href="page-portfolio-2-columns-2.html">Portfolio
											(2 Columns, Option 2)</a></li>
                                    <li><a href="page-portfolio-3-columns-1.html">Portfolio
											(3 Columns, Option 1)</a></li>
                                    <li><a href="page-portfolio-3-columns-2.html">Portfolio
											(3 Columns, Option 2)</a></li>
                                    <li><a href="page-portfolio-item.html">Portfolio Item
											(Project) Description</a></li>
                                </ul>
                                <h4>General Pages</h4>
                                <ul>
                                    <li><a href="page-about-us.html">About Us</a></li>
                                    <li><a href="page-contact-us.html">Contact Us</a></li>
                                    <li><a href="page-faq.html">Frequently Asked Questions</a>
                                    </li>
                                    <li><a href="page-testimonials-clients.html">Testimonials
											& Clients</a></li>
                                    <li><a href="page-events.html">Events</a></li>
                                    <li><a href="page-404.html">404 Page</a></li>
                                    <li><a href="page-sitemap.html">Sitemap</a></li>
                                    <li><a href="page-login.html">Login</a></li>
                                    <li><a href="page-register.html">Register</a></li>
                                    <li><a href="page-password-reset.html">Password Reset</a>
                                    </li>
                                    <li><a href="page-terms-privacy.html">Terms & Privacy</a>
                                    </li>
                                    <li><a href="page-coming-soon.html">Coming Soon</a></li>
                                </ul>
                            </div>
                            <div>
                                <h4>eShop</h4>
                                <ul>
                                    <li><a href="page-products-3-columns.html">Products
											listing (3 Columns)</a></li>
                                    <li><a href="page-products-4-columns.html">Products
											listing (4 Columns)</a></li>
                                    <li><a href="page-products-slider.html">Products
											Slider</a></li>
                                    <li><a href="page-product-details.html">Product
											Details</a></li>
                                    <li><a href="page-shopping-cart.html">Shopping Cart</a></li>
                                </ul>
                                <h4>Blog</h4>
                                <ul>
                                    <li><a href="page-blog-posts.html">Blog Posts (List)</a></li>
                                    <li><a href="page-blog-post-right-sidebar.html">Blog
											Single Post (Right Sidebar)</a></li>
                                    <li><a href="page-blog-post-left-sidebar.html">Blog
											Single Post (Left Sidebar)</a></li>
                                    <li><a href="page-news.html">Latest & Featured News</a></li>
                                </ul>
                            </div>
                        </div>
                        <!-- /mainmenu-submenu-inner -->
                    </div>
                    <!-- /mainmenu-submenu -->
                </li>
                <li><a href="credits.html">${buttonAllTask}</a></li>
            </ul>
        </nav>
    </div>
</div>