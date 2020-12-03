<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청 완료</title>
</head>

<body>
	<c:out value='alert("${param.name} 과목 수강신청에 성공했습니다!")' />
	<c:redirect url="registercourse"/>
</body>
</html>