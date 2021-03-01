<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	
      <!-- Required meta tags -->
 
	<title>Trade Entry</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>

.green {
    color: green;
}

.thead-inverse th {
            color: #fff;
            background-color: #373a3c;
}

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
<%@ include file="navrussell.html" %>

<div style="padding-left:1px">
<!-- BEGIN specific page code -->
	<center>
		<h1>Trade Entry</h1>
	</center>
    <div align="center">
        <table table class="table table-sm table-bordered ">
            <thead class="thead-inverse">
            <tr>
                <th>Symbol</th>
                <th>Exchange</th>
                <th>Name</th>
                <th>Sector</th>
                <th>Industry</th>
                <th>Quote</th>
                <th>Trade</th>
            </tr>
            </thead>
            <c:forEach var="russell" items="${allRussell}">
                <tr>
                    <td><c:out value="${russell.tkr}" /></td>
                    <td><c:out value="${russell.exchange}" /></td>
                    <td><c:out value="${russell.name}" /></td>
                    <td><c:out value="${russell.sector}" /></td>
                    <td><c:out value="${russell.industry}" /></td>           
             		<td> <a href="quoteform/${russell.tkr}"> <span class="glyphicon glyphicon-ok green"></span></a> </td>
                    <td> <a href="tradeform/${russell.tkr}">Trade</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
<!-- END specific page code -->
</div>

</body>
</html>