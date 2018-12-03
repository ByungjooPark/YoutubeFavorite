<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GalleryDetail</title>
</head>
<body>
	${vo.g_no }<br>
	${vo.g_title }	${vo.g_regdate }<br>
	<img src="/yu/res/img/${vo.g_path}">
</body>
</html>