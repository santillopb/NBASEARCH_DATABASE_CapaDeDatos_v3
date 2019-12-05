<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		Bienvenido ${sessionScope.user}</span>
	</p>
	<button id="logout">Log out</button>

	<p>Click the button to display the UTC date and time as a string.</p>

	<p id="demo"></p>
	<script>
		function myFunction() {
			var d = new Date();
			var n = d.toUTCString();
			document.getElementById("demo").innerHTML = n;
		}

		window.onload = function() {
			window.setInterval(myFunction, 999);
		};
	</script>
	<script>
		document.getElementById("logout").addEventListener("click", function() {
			location.href = "RecibeLoginController";
		});
	</script>
</body>
</html>