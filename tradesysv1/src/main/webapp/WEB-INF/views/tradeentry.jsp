<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

      <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Trade Entry</title>
</head>
<body>
	<center>
		<h1>Trade Entry</h1>
	</center>
    <div align="center">
     
		<c:if test="${order != null}">
			<form action="update" method="post"> 
        </c:if>
        <c:if test="${order == null}">
			<form action="insert" method="post"> 
        </c:if>
        <table border="1" cellpadding="5">
        		
        	<tr>
                <th>Side: </th>
                <td>
                	<input type="text" name="side" size="45"
                			value="<c:out value='${order.side}' />"
                		/>
                </td>
            </tr>
        		           
            <tr>
                <th>Symbol: </th>
                <td>
                	<input type="text" name="symbol" size="45"
                			value="<c:out value='${order.symbol}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Qty: </th>
                <td>
                	<input type="text" name="qty" size="45"
                			value="<c:out value='${order.qty}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Limit Price: </th>
                <td>
                	<input type="text" name="limit_price" size="45"
                			value="<c:out value='${order.limit_price}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Type: </th>
                <td>
                	<input type="text" name="type" size="5"
                			value="<c:out value='${order.type}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input id="submit" type="submit" value="Submit" />
            	</td>
            </tr>
        </table>
        
    </div>	
    
          <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
</body>
</html>
