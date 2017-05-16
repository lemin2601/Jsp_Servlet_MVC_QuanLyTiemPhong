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
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<h2>Register</h2>

		<form class="form-horizontal" name ="form">
			<input type="hidden" name="command" value="register">

			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Username:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="username"
						placeholder="Enter username" name="username">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">First name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="firstname"
						placeholder="Enter first name" name="firstname">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Last name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastname"
						placeholder="Enter last name" name="lastname">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter password" name="password">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Re-Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Re-password" name="password2">
				</div>
			</div>
			<div class="form-group">
				<div id='message' class="col-sm-offset-2 col-sm-10">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success btn-block">Đăng
						ký</button>
				</div>
			</div>
		</form>
	</div>
	<script src="myjs/register.js"></script>
</body>
</html>