<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>UPDATE USER</title>

	<!-- JAVASCRIPT -->
	<script >
		function loadResponse() {
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open("DELETE", "http://localhost:8085/RESTfullWebService_01/backend/user/service", true);
			xmlhttp.send();
		}
	</script>
</head>
<body>
	<div id="myDiv">The Response Text would come Here</div>
	<button type="button" onclick="loadResponse()">Submit</button>
</body>
</html>