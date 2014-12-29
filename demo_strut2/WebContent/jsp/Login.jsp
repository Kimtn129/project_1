<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="../WEB-INF/custom.tld" prefix="ex" %>

<!-- - See more at: http://www.javabeat.net/struts-bean-define-tag-beandefine/#sthash.MBgC611q.dpuf -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo Strut2</title>
	<link href="<%= request.getContextPath() %>/resource/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>Hello World From Struts2</h1>
	<jsp:useBean id="user" class="demo.struts2.bean.UserBean" scope="request">
		<jsp:setProperty property="email" name="user"/>
		<jsp:setProperty property="password" name="user"/>
		<jsp:setProperty property="firstName" name="user"/>
		<jsp:setProperty property="lastName" name="user"/>
	</jsp:useBean>
	<div class="container">
		<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
		    <div class="panel panel-info">
		        <div class="panel-heading">
		            <div class="panel-title">Sign In</div>
		            <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
		        </div>     
		        <div style="padding-top:30px" class="panel-body">
		            <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
		            <form id="loginform" class="form-horizontal" action="login" method="POST">
		            	<c:if test='${error != null && error != ""}'>
		            		<div class="alert alert-danger" role="alert">
		            			<strong>${error }</strong>
		            		</div>
		            	</c:if>
		                <div style="margin-bottom: 25px" class="input-group">
		                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
		                    <input id="login-username" type="text" class="form-control" name="email" placeholder="username or email" value="${user.email }">
		                </div>
		                <div style="margin-bottom: 25px" class="input-group">
		                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
		                    <input id="login-password" type="password" class="form-control" name="password" placeholder="password" value="${user.password }"/>
		                </div>
		                <div class="input-group">
		                  <div class="checkbox">
		                    <label>
		                      <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
		                    </label>
		                  </div>
		                </div>
		                <div style="margin-top:10px" class="form-group">
		                    <!-- Button -->
		                    <div class="col-sm-12 controls">
		                        <input type="submit" id="btn-login" class="btn btn-success" value="Login"/>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <div class="col-md-12 control">
		                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%">
		                            Don't have an account! 
		                        <a href="#" onclick="$('#loginbox').hide(); $('#signupbox').show()">
		                            Sign Up Here
		                        </a>
		                        </div>
		                    </div>
		                </div>    
		            </form>
		        </div>
		    </div>  
		</div>
	</div>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<%= request.getContextPath() %>/resource/js/bootstrap.min.js"></script>
</body>
</html>