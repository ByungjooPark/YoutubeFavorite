<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
클라이언트 리스트 화면
<c:forEach var="item" items="${list }">
	<div>
		${item.y_no } - ${item.y_title } - ${item.y_regdate }
		<br>
		<a href="https://www.youtube.com/watch?v=${item.y_url }">
		<img alt="" src="https://img.youtube.com/vi/${item.y_url }/0.jpg">
		</a>
	</div>
	<br>
</c:forEach>
</body>
</html>

