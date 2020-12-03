<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.year}년 ${param.semester }학기 수강 내역</title>

<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
	<table class="styled-table">
		<thead>
			<tr>
			<th> 년도 </th>
			<th> 학기 </th>
			<th> 교과목명 </th>
			<th> 교과구분 </th> 
			<th> 담당교수 </th> 
			<th> 학점 </th> 
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${courses}">
				<c:if test="${course.year == param.year && course.semester == param.semester}">
					<tr>
					<td> <c:out value="${course.year}"> </c:out></td>
					<td> <c:out value="${course.semester}"> </c:out> </td> 
					<td> <c:out value="${course.name}"> </c:out></td> 
					<td> <c:out value="${course.type}"> </c:out></td> 
					<td> <c:out value="${course.prof}"> </c:out></td> 
					<td> <c:out value="${course.credit}"> </c:out></td> 
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<a href="<c:url value="/courses"/>"> back </a>

</body>
</html>