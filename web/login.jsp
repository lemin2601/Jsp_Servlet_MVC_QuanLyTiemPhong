<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to login system</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<%
		//check cookie
		String username ="",password ="";
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();// Get an array of Cookies associated with the this domain
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if(cookie.getName().equals("username")) username = cookie.getValue();
				if(cookie.getName().equals("password")) password = cookie.getValue();
			}
		}
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h2>Login</h2>
		<form class="form-horizontal" name="form">
			<input type="hidden" name="command" value="login">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Username:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="username"
						placeholder="Enter username" name="username" value ="<%=username%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter password" name="password" value ="<%=password%>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" name="remember" checked>
							Remember me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div id='message' class="col-sm-offset-2 col-sm-10"></div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default btn-block">Đăng nhập</button>
				</div>
			</div>
		</form>
	</div>
	<script src="myjs/login.js"></script>
</body>
</html>