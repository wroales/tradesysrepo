<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ tag import="org.springframework.util.StringUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pagedListHolder" required="true"
	type="org.springframework.beans.support.PagedListHolder"%>
<%@ attribute name="pagedLink" required="true" type="java.lang.String"%>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


<style>
.pagination ul {
  display: inline-block;
  padding: 0;
  margin: 0;
}

.pagination li {
  display: inline;
}

.pagination li a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination li.active a {
  background-color: black;
  color: white;
}

.pagination li:hover:not(.active) a {
  background-color: #ddd;
}
</style>
 
<c:if test="${pagedListHolder.pageCount > 1}">
	<ul class="pagination">
		<c:if test="${!pagedListHolder.firstPage}">
			<li class="previous"><a
				href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPage() - 1))%>"><</a></li>
		</c:if>
		<c:if test="${pagedListHolder.firstLinkedPage > 0}">
			<li><a href="<%=StringUtils.replace(pagedLink, "~", "0")%>">1</a></li>
		</c:if>
		<c:if test="${pagedListHolder.firstLinkedPage > 1}">
			<li><span class="pagingDots">...</span>
			<li>
		</c:if>
		<c:forEach begin="${pagedListHolder.firstLinkedPage}"
			end="${pagedListHolder.lastLinkedPage}" var="i">
			<c:choose>
				<c:when test="${pagedListHolder.page == i}">
					<li class="active"><a href="#">${i+1}</a></li>
				</c:when>
				<c:otherwise>
					<li><a
						href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(jspContext.getAttribute("i")))%>">${i+1}</a>
					</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if
			test="${pagedListHolder.lastLinkedPage < pagedListHolder.pageCount - 2}">
			<li><span class="pagingDots">...</span></li>
		</c:if>
		<c:if
			test="${pagedListHolder.lastLinkedPage < pagedListHolder.pageCount - 1}">
			<li><a
				href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPageCount() - 1))%>">${pagedListHolder.pageCount}</a></li>
		</c:if>
		<c:if test="${!pagedListHolder.lastPage}">
			<li class="next"><a
				href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(pagedListHolder.getPage() + 1))%>">></a></li>
		</c:if>
	</ul>
</c:if>