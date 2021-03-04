<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trade Entry</title>
	
      <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
	<title>Trade Entry</title>
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
<%@ include file="navrussell.html" %>
	<center>
		<h1>Trade Entry</h1>
	</center>
	<div class="container" style="margin-top: 20px;">
		<jsp:useBean id="pagedListHolder" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/russell" var="pagedLink">
			<c:param name="p" value="~" />
		</c:url>

		<table class="table table-sm table-bordered">
		<thead class="thead-dark">
		
			<tr>
               <th>Symbol</th>
                <th>Exchange</th>
                <th>Name</th>
                <th>Sector</th>
                <th>Industry</th>
                <th>Quote</th>
                <th>Trade</th>
			</tr>
			<c:forEach items="${pagedListHolder.pageList}" var="russell">
				<tr>
					<td><c:out value="${russell.tkr}" /></td>
                    <td><c:out value="${russell.exchange}" /></td>
                    <td><c:out value="${russell.name}" /></td>
                    <td><c:out value="${russell.sector}" /></td>
                    <td><c:out value="${russell.industry}" /></td>
                    <td> <a href="quoteform/${russell.tkr}">Quote</a> </td>
                    <td> <a href="tradeform/${russell.tkr}">Trade</a> </td>
				</tr>
			</c:forEach>
		</thead>	
		</table>
		<tg:paging pagedListHolder="${pagedListHolder}"
			pagedLink="${pagedLink}" />
	</div>

</body>
</html>