<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>all.jsp</h1>
	
	<a href="/member"> member </a> <br>
	<a href="/admin"> admin </a> <br>
	
	<!-- isAnonymous() : 익명 사용자일때, 로그인 안했을때 -->
	<sec:authorize access="isAnonymous()">
		<a href="/customLogin">로그인</a>
	</sec:authorize>
	
	<!-- isAuthenticated() : 인증된 사용자 일때, 로그인 했을때 -->
	<sec:authorize access="isAuthenticated()">
		<a href="/customLogout">로그아웃</a>
	</sec:authorize>
	
	

</body>
</html>