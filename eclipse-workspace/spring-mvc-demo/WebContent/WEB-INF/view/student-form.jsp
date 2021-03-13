<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<title>Student Registration Form</title>
	</head>
	<body>
		<form:form action="processForm" modelAttribute="student">
			First Name: <form:input path="firstName"/>
			Last Name: <form:input path="lastName" />
			<form:select path="country">
				<form:option value="BRA" label="Brazil"/>
				<form:option value="FRA" label="france"/>
				<form:option value="GER" label="germany"/>
				<form:option value="IND" label="india"/>
				<form:option value="CHI" label="china"/>
				<form:option value="AMR" label="america"/>
			</form:select>
			<br><br>
			Country: 
			<form:select path="country">
				<form:options items="${student.countryOptions}"/>
			</form:select>
			<br><br>
			<form:select path="country"> 
		 		<form:options items="${theCountryOptions2}" />
			</form:select>
			
			<p>Favourite Language:
			<form:radiobutton path="favouriteLanguage" value="Java"/> Java 
			<form:radiobutton path="favouriteLanguage" value="Python"/> Python 
			<form:radiobutton path="favouriteLanguage" value="C++"/> C++ 
			<form:radiobutton path="favouriteLanguage" value="TypeScript"/> TypeScript 
			<form:radiobutton path="favouriteLanguage" value="Android"/> Android 		
			</p>
			<p>Operating Systems:
			<form:checkboxes path="operatingSystems" items="${student.operatingSystemsOptions}"/>
			</p>
			<br>
			
			<input type = "submit" value="Submit"/>
		</form:form>
	</body>
	
</html>