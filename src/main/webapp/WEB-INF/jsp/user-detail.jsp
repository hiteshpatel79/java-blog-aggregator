<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<h1>${user.name}</h1>

<c:forEach items="${user.blogs }" var="blog">

	<h1>${blog.name }</h1>
	<p>${blog.url }</p>
	
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<td>Title</td>
				<td>Link</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${blog.items }" var="item">
			<tr>
				<td>${item.title }</td>
				<td>${item.link }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</c:forEach>

<%-- 

<table class="table table-bordered table-hover table-striped">
<thead>
	<tr>
		<th>User Name</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${users}" var="user">
		<tr>
		<td>
			<a href='<spring:url value="/users/${user.id}.html"/>'>
			${user.name}
			</a>		
		</td>
		</tr>	
	</c:forEach>
	<tr>
		
	</tr>

</tbody>

</table> --%>