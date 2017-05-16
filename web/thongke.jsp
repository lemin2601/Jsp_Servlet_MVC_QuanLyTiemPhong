<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@page import="controller.UserServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to quản lý Vắc xin</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.5/validator.min.js"></script>
        <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
        <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">

    </head>
    <body>
        <%
            // check session
            User user = (User) session.getAttribute(UserServlet.SESSION_USER);
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">Lịch sử tiêm phòng<span id='message' class="pull-right"><img src='img/ajax-loader.gif' /> Loading...</span></div>
                <div class="panel-body">
                    <div class="input-group">
                        <input class="form-control" id ="search-key" placeholder="Search for..."> <span
                            class="input-group-btn">
                            <button class="btn btn-default" type="button" id="search-button")>
                                <span class="glyphicon glyphicon-search"></span> Search
                            </button>
                        </span>
                    </div>
                </div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Mã</th>
                            <th>Tên KH</th>
                            <th>Tổng Số Tiền</th>
                        </tr>
                    </thead>
                    <tbody>				
                    </tbody>
                </table>	    					
            </div>
        </div>      
        <script src="myjs/thongke.js"></script>
        <script src="js/jquery.twbsPagination.js" type="text/javascript"></script>
    </body>
</html>