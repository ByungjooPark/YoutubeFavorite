<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/logout" method="POST">
		<input type="submit" value="Logout" />
		
	</form:form>
	<a href="insertURL"><button>등록</button></a>
	<a href="insertGallery"><button>겔러리로</button></a>
	
	
</body>
</html>