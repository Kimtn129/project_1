<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="../WEB-INF/custom.tld" prefix="ex" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo Strut2</title>
	<link href="<%= request.getContextPath() %>/resource/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="padding-top: 60px;">
	<div class="container">
		<div>
		  <a href="/new/" class="btn btn-primary pull-left">New User</a>
		  <div class="pull-right">
		    <a style="margin-left: 10px;" href="/users/others/" class="btn btn-primary pull-right">Other</a>
		    <a href="/users/admins/" class="btn btn-primary pull-right">Admin</a>
		  </div>
		</div>
		<table class="table striped">
		    <thead>
		      <tr>
		        <th>Email</th>
		        <th>Password</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="list" items="${users }">
		        	<tr>
		            	<td><c:out value="${list.email }"></c:out></td>
		              	<td><c:out value="${list.password }"></c:out></td>
		              	<td><a href="/edit/{{ profile.id }}" class="btn">Edit</a></td>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>