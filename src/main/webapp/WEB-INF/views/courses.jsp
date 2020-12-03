<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 이수 학점 조회</title>

<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
	<table class="styled-table">
		<thead>
			<tr>
			<th> 년도 </th>
			<th> 학기 </th>
			<th> 취득 학점 </th>
			<th> 상세보기 </th> 
			</tr>
		</thead>
		<tbody>
			<c:set var="totalcredit" value="0"/>
			<c:forEach var="year" items="${years}">
				<c:set var="semesters">1,2</c:set>
				<c:forEach var="semester" items="${semesters }">
					<c:set var="credits" value="0"/>
					<c:forEach var="course" items="${courses}">
						<c:if test="${course.year == year && course.semester == semester}">
							<c:set var="credits" value="${credits + course.credit }"/>
						</c:if>
					</c:forEach>
					<c:if test="${credits != 0 }">
						<c:set var="totalcredit" value="${totalcredit + credits }"/>
						<tr>
						<td><c:out value="${year}"> </c:out> </td>
						<td><c:out value="${semester}"> </c:out> </td>
						<td><c:out value="${credits }"> </c:out> </td>
						<td><a href="<c:url value="/detailview">
						<c:param name="year" value="${year}"/>
						<c:param name="semester" value="${semester}"/>
						</c:url>"> link </a></td>
						</tr>
					</c:if>
				</c:forEach>
			</c:forEach>
			
			<tr class="bold">
			<td> 총계 </td>
			<td>  </td>
			<td> ${totalcredit } </td>
			<td>  </td> 
			</tr>
		</tbody>
		
	</table>
	
	<a href="<c:url value="/"/>"> back </a>

</body>
</html>