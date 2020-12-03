<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
	<table class="styled-table">
		<thead>
			<tr>
			<th> 메뉴 </th>
			</tr>
		</thead>
		<tbody>
			<tr><th> <a href="${pageContext.request.contextPath }/courses"> 학기별 이수 학점 조회 </a></th></tr>
			<tr><th> <a href="${pageContext.request.contextPath }/registercourse"> 수강 신청하기 </a></th></tr>
			<tr><th><a href="${pageContext.request.contextPath }/showregister"> 수강 신청 조회 </a></th></tr>
		</tbody>
	</table>
	
	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<c:redirect url="login"/>
	</c:if>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">로그아웃</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

</body>
</html>
