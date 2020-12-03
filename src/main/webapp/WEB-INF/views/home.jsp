<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<p> <a href="${pageContext.request.contextPath }/courses"> 학기별 이수 학점 조회 </a> </p>
	<p> <a href="${pageContext.request.contextPath }/register"> 수강 신청하기 </a> </p>
	<p> <a href="${pageContext.request.contextPath }/showregister"> 수강 신청 조회 </a> </p>

	<p> <a href="${pageContext.request.contextPath }/offers"> Show current offers </a> </p>
	<p> <a href="${pageContext.request.contextPath }/createoffer"> Add a new offer </a> </p>
	
	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<c:redirect url="login"/>
	</c:if>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>


</body>
</html>
