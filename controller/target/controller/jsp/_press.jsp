<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local" var="loc" />
<fmt:message bundle="${loc}" key="locale.press.ref.advantages.text" var="refAdvantage" />
<fmt:message bundle="${loc}" key="locale.press.ref.performers.text" var="refPerformer" />
<fmt:message bundle="${loc}" key="locale.press.ref.reviews.text" var="refReview" />
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-6">
                <div class="in-press press-wired">
                    <a href="#">${refAdvantage}</a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="in-press press-mashable">
                    <a href="#">${refPerformer}</a>
                </div>
            </div>
            <div class="col-md-4 col-sm-6">
                <div class="in-press press-techcrunch">
                    <a href="#">${refReview}</a>
                </div>
            </div>
        </div>
    </div>
</div>