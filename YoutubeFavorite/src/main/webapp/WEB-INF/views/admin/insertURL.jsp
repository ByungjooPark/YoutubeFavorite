<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertURL</title>
</head>
<body>
	<form:form id="frm" onsubmit="return beforeSend()">
		<p>
			<label for="y_url">URL</label>
			<input type="text" id="y_url" name="y_url" />
		</p>		
		<input type="hidden" id="y_title" name="y_title" />
		<input type="submit" value="등록완료" />
	</form:form>
	
	<script>
		function beforeSend() {
			var form = document.getElementById("frm");
			var y_url = form.y_url.value;
			
			var target = "https://www.googleapis.com/youtube/v3/videos?id=" + y_url + "&key=AIzaSyCy9kqtqb-I5gIYaXCfyFz9YtlL0wx8cGY&part=snippet,statistics";
			
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange = function() {
				if(this.readyState == 4 && this.status == 200) {
					var obj = JSON.parse(this.responseText); // json으로 파싱해서 오브젝트에 담음
					
					if(obj.items[0] != undefined) { // 자료가 없다면 undefined임
						var y_title = document.getElementById("y_title");
						y_title.value = obj.items[0].snippet.title;
						form.submit(); // form을 서브밋 함.
					}
				}
			};
			xhttp.open("GET", target, true);
		    xhttp.send(); 
		    
			return false;
		}		
	</script>
	
</body>
</html>