<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청</title>

<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/resources/css/main.css" >
</head>
<body>
	<sf:form method="post" action="${pageContext.request.contextPath}/doregister" modelAttribute="course" >
	<table class="styled-table">
		<thead>
			<tr>
			<th> 구분 </th>
			<th> 입력 </th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<th> 교과목명 </th>
			<th> <sf:input class="control" type="text" path="name"/> <br></br>
			<sf:errors class="error" path="name"/> </th>
			</tr>
			
			<tr>
			<th> 교과구분 </th>
			<th> <sf:input class="control" type="text" path="type"/> <br></br>
			<sf:errors class="error" path="type"/> </th>
			</tr>
			
			<tr>
			<th> 담당교수 </th>
			<th> <sf:input class="control" type="text" path="prof"/> <br></br>
			<sf:errors class="error" path="prof"/> </th>
			</tr>
			
			<tr>
			<th> 학점 </th>
			<th> <sf:input class="control" type="text" path="credit"/> <br></br>
			<sf:errors class="error" path="credit"/> </th>
			</tr>
			
			<tr>
			<th colspan="2" align="center"> 
				<sf:input class="control" type="hidden" path="year" value="2021"/>
				<sf:errors class="error" path="year"/>
				<sf:input class="control" type="hidden" path="semester" value="1"/>
				<sf:errors class="error" path="semester"/>
				<input type="submit" value="등록"/>
			</th>
			</tr>
		</tbody>
	</table>
	</sf:form>
	
	<a href="<c:url value="/"/>"> back </a>

</body>
</html>