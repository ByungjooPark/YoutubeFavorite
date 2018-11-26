<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<c:url value="/login" var="loginUrl" />
	<form:form name="f" action="${loginUrl }" method="POST">
		<c:if test="${param.error != null }">
			<p>아이디와 비밀번호가 잘 못 되었습니다.</p>
		</c:if>
		
		<p>
			<label for="username">아이디</label>
			<input type="text" id="username" name="username" />
		</p>
		<p>
			<label for="password">비밀번호</label>
			<input type="password" id="password" name="password" />
		</p>
		<button type="submit" class="btn">로그인</button>
	</form:form>
</body>
</html>