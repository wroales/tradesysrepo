<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	
      <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
	<title>Session</title>
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
</style>
</head>
<body>
<div class="topnav">
  <a class="active" href="./admin">Admin</a>
  <a href="./logout">Logout</a>
</div>
<div style="padding-left:1px">
<!-- BEGIN specific page code -->
	<center>
		<h1>User Information</h1>
	</center>
    <div align="center">
        <table table class="table table-sm table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>User Identifier</th>
                <th>Login Name</th>
                <th>Password</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <c:forEach var="user" items="${allUsers}">
                <tr>
                    <td><c:out value="${user.userId}" /></td>                 
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td><c:out value="${user.userRole}" /></td>
                    <td><a href="editUser?id=${user.userId}">Edit</a></td>
					<td><a href="deleteUser/${user.userId}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
       <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<!-- END specific page code -->
  
</div>

</body>
</html>