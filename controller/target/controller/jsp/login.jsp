<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.login.ref.title.text" var="titleText" />
<fmt:message bundle="${loc}" key="locale.login.ref.username.text" var="usernameText" />
<fmt:message bundle="${loc}" key="locale.login.ref.password.text" var="passwordText" />
<fmt:message bundle="${loc}" key="locale.login.ref.remember.text" var="rememberText" />
<fmt:message bundle="${loc}" key="locale.login.ref.forgot.text" var="forgotText" />
<fmt:message bundle="${loc}" key="locale.login.button.text" var="buttonText" />
<fmt:message bundle="${loc}" key="locale.login.ref.choicelogin.text" var="choiceLoginText" />
<fmt:message bundle="${loc}" key="locale.login.ref.facebook.text" var="facebookText" />
<fmt:message bundle="${loc}" key="locale.login.ref.twitter.text" var="twitterText" />

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
            <div class="row">
                <div class="col-sm-5">
                    <div class="basic-login">
                        <form method="post" action="Controler" role="form" role="form">
                        <input type="hidden" name="command" value="sign_in">
                            <div class="form-group">
                                <label for="login-username"><i class="icon-user"></i> <b>${usernameText}</b></label>
                                <input class="form-control" id="login-username" type="text" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="login-password"><i class="icon-lock"></i> <b>${passwordText}</b></label>
                                <input class="form-control" id="login-password" type="password" placeholder="">
                            </div>
                            <div class="form-group">
                                <label class="checkbox">
                                    <input type="checkbox"> ${rememberText}
                                </label>
                                <a href="${pageContext.request.contextPath}/jsp/password_recovery.jsp" class="forgot-password">${forgotText}?</a>
                                <button type="submit" class="btn pull-right">${buttonText}</button>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-sm-7 social-login">
                    <p>${choiceLoginText}</p>
                    <div class="social-login-buttons">
                        <a href="#" class="btn-facebook-login">${facebookText}</a>
                        <a href="#" class="btn-twitter-login">${twitterText}</a>
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