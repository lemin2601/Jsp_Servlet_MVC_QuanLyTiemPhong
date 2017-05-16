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
	<jsp:include page="../header.jsp"></jsp:include>

	<div class="col-md-2"></div>
	<div class="col-md-8 container-fluid">

		<div class="panel panel-default">
			<div class="panel-heading">Panel heading</div>
			<div class="panel-body">
				<div class="input-group">
					<input class="form-control " placeholder="Search for..."> <span
						class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Username</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
						<td class="text-center" colspan="1">
							<div class="btn-group">
								<a href="detail.php?id=<?php echo $arrayPhong['id'] ?>"
									class="btn btn-default btn-xs"><i
									class="glyphicon glyphicon-eye-open"></i></a> <a
									href="EditServlet?type=NhanVien&id="
									class="btn btn-default btn-xs"><i
									class="glyphicon glyphicon-edit"></i></a> <a
									href="delete.php?id=<?php echo $arrayPhong['id']; ?>"
									class="btn btn-danger btn-xs"
									onclick="return confirm('Are you sure?')"><i
									class="glyphicon glyphicon-trash"></i></a>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Jacob</td>
						<td>Thornton</td>
						<td>@fat</td>
						<td class="text-center" colspan="1">
							<div class="btn-group">
								<a href="detail.php?id=<?php echo $arrayPhong['id'] ?>"
									class="btn btn-default btn-xs"><i
									class="glyphicon glyphicon-eye-open"></i></a> <a
									href="EditServlet?type=NhanVien&id="
									class="btn btn-default btn-xs"><i
									class="glyphicon glyphicon-edit"></i></a> <a
									href="delete.php?id=<?php echo $arrayPhong['id']; ?>"
									class="btn btn-danger btn-xs"
									onclick="return confirm('Are you sure?')"><i
									class="glyphicon glyphicon-trash"></i></a>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td class="text-center" colspan="1">
							<div class="btn-group">
								<a href="detail.php?id=<?php echo $arrayPhong['id'] ?>"
									class="btn btn-default btn-xs"><i
									class="glyphicon glyphicon-eye-open"></i></a> <a
									href="EditServlet?type=NhanVien&id="
									class="btn btn-default btn-xs"><i
									class="glyphicon glyphicon-edit"></i></a> <a
									href="delete.php?id=<?php echo $arrayPhong['id']; ?>"
									class="btn btn-danger btn-xs"
									onclick="return confirm('Are you sure?')"><i
									class="glyphicon glyphicon-trash"></i></a>
							</div>
						</td>
					</tr>

				</tbody>
			</table>
			<h1 class="pagination no-margin pull-left">
				<a class="btn btn-primary pull-right"
					style="margin-top: -10px; margin-bottom: 5px"
					href="addphongban.php">Add New</a>
			</h1>
			<ul class="pagination no-margin pull-right">
				<li class="disabled"><span>«</span></li>
				<li class="active"><span>1</span></li>
				<li><a href="http://danang2.local/admin/tours?page=2">2</a></li>
				<li><a href="http://danang2.local/admin/tours?page=3">3</a></li>
				<li><a href="http://danang2.local/admin/tours?page=2"
					rel="next">»</a></li>
			</ul>


		</div>

		<div class="box-footer clearfix"></div>
	</div>


	<jsp:include page="login.jsp"></jsp:include>

	<jsp:include page="../register.jsp"></jsp:include>

</body>
</html>