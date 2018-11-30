<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 업로드</title>
</head>
<body>
	<form:form id="frm" onsubmit="return beforeSend()" enctype="multipart/form-data">
		<p>
			제목 : <input type="text" name="title">
			이미지 : <input type="file" name="img" accept="image/*">
		</p>
		
		<input type="submit" value="등록">
	</form:form>
	
	<script>
		function beforeSend() {
			var form = document.getElementById("frm");
			
			if(form.title.value == "" || form.title.value == null || form.title.value == undefined) {
				alert("제목을 입력해 주세요.");
				return false;
			} else if(form.img.value == "" || form.img.value == null || form.img.value == undefined) {
				alert("이미지를 넣어주세요.");
				return false;
			}
			
			
		}
	</script>
	
</body>
</html>

