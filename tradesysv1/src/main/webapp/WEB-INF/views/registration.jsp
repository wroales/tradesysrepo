<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Register</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.topnav a.tname {
  background-color: red;
  color: white;
}
</style>
</head>
<body>
<div class="topnav"> 
  <a class="active" href="./register">Register</a>
  <a href="./login">Login</a>
  <a class="tname" href="#">Equity Trading</a>
</div>
	<form:form action="register" method="POST" modelAttribute="user">
		<div>
			<label>Username: </label>
			<form:input path="username" />
			<form:errors path="username"/>
		</div>
		<div>
			<label>Password: </label>
			<form:input path="password" />
			<form:errors path="password" />
		</div>
		<div>
			<input type="submit" value="Register">
		</div>
	</form:form>
</body>