<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Hello World - Input form</title>
	</head>
	<body>
		<form action="processForm" method="GET">
			<input type="text" name="studentName"
				placeholder="What's ur name?"/>
			<input type="submit"/>
		</form>
		<form action="processFormVersionTwo" method="GET">
			<input type="text" name="studentName"
				placeholder="What's ur name?"/>
			<input type="submit"/>
		</form>
		<form action="processFormVersionThree" method="GET">
			<input type="text" name="studentName"
				placeholder="What's ur name?"/>
			<input type="submit"/>
		</form>
	</body>
</html>