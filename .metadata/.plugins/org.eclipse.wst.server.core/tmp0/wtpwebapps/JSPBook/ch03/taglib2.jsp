<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<!-- 
	var : 변수
	1부터 10까지 1씩 증가
 -->
	<c:forEach var="k" begin="0" end="10" step="2">
		<!-- 변수 k값을 출력 -->
		<c:out value="${k}" />
	</c:forEach>
</body>
</html>