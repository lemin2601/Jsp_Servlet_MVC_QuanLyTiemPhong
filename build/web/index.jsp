<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@page import="controller.UserServlet"%>
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
                <div class="panel-heading">User Manager<span id='message' class="pull-right"><img src='img/ajax-loader.gif' /> Loading...</span></div>
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
                            <th>#</th>
                            <th>User Name</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th class="text-center">#</th>
                        </tr>
                    </thead>
                    <tbody>				
                    </tbody>
                </table>	
                <ul class=" pagination pull-right" id="pagination"></ul>
                <div class="panel-footer">
                    <div class="form-group">
                        <button type="button" data-backdrop="static" data-toggle="modal" data-target="#create-item" class="btn btn-success"><span class="glyphicon glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                    </div>
                </div>						
            </div>
        </div>
        <!-- <button type="button" class="btn btn-success" data-toggle="modal" data-target="#create-item">  Create Item	</button>
        <button data-toggle="modal" data-target="#edit-item" class="btn btn-primary edit-item">Edit</button>
        -->
        <ul id="pagination" class="pagination-sm"></ul>
      
        
        <!-- view Item Modal -->
        <div class="modal fade" id="view-item" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title" id="myModalLabel">Create User</h4>
                    </div>
                    <div class="modal-body">
                        <form data-toggle="validator" >
                            <input type="hidden" name="command" value="view">
                            <input type="hidden" name="id" class="view-id">	
                            <div class="form-group">
                                <label class="control-label" for="title">User name:</label>
                                <input type="text" name="username" class="form-control" placeholder="User name"  data-error="Please enter username"  readonly/>
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">First name:</label>
                                <input type="text" name="firstname" class="form-control"  placeholder="First name" data-error="Please enter firstname" readonly />
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">Last name:</label>
                                <input type="text" name="lastname" class="form-control"  placeholder="Last name" data-error="Please enter lastname" readonly />
                                <div class="help-block with-errors"></div>
                            </div>			
                            <div class="form-group">
                                <label class="control-label" for="title">Roles:</label>
                                <select  name="roles" class="form-control" data-error="Please enter roles" disabled >
                                    <option value="1">Admin</option>
                                    <option value="2">User</option>
                                    <option value="3">Visiter</option>
                                    <option value="4">Normal</option>
                                </select>
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <button  data-dismiss="modal" class="btn btn-block btn-warning">Close</button>
                            </div>	
                        </form>	
                    </div>
                </div>	
            </div>
        </div>

        <!-- Create Item Modal -->
        <div class="modal fade" id="create-item" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title" id="myModalLabel">Create User</h4>
                    </div>
                    <div class="modal-body">
                        <form data-toggle="validator" >
                            <input type="hidden" name="command" value="register">
                            <div class="form-group">
                                <label class="control-label" for="title">User name:</label>
                                <input type="text" name="username" class="form-control" placeholder="User name"  data-error="Please enter username"  required/>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Password:</label>
                                <input type="password" name="password" id="password"  placeholder="Password" class="form-control" data-error="Please enter password" required />
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">Re-password:</label>
                                <input type="password" name="password2" placeholder="Re-password" data-match="#password" data-match-error="Password doesn't matched." class="form-control" data-error="Please enter re-password" required />
                                <div class="help-block with-errors"></div>
                            </div>		
                            <div class="form-group">
                                <label class="control-label" for="title">First name:</label>
                                <input type="text" name="firstname" class="form-control"  placeholder="First name" data-error="Please enter firstname" required />
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">Last name:</label>
                                <input type="text" name="lastname" class="form-control"  placeholder="Last name" data-error="Please enter lastname" required />
                                <div class="help-block with-errors"></div>
                            </div>				
                            <div class="form-group">
                                <div id='message-create' class="col-sm-offset-2 col-sm-10">
                                </div>
                            </div>	
                            <div class="form-group">
                                <button type="submit" class="btn btn-block create-item-submit btn-success">Create</button>
                                <button  data-dismiss="modal" class="btn btn-block btn-warning">Close</button>
                            </div>	
                        </form>	
                    </div>
                </div>	
            </div>
        </div>

        <!-- Edit Item Modal -->
        <div class="modal fade" id="edit-item" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title" id="myModalLabel">Edit User</h4>
                    </div>
                    <div class="modal-body">
                        <form data-toggle="validator" >
                            <input type="hidden" name="command" value="edit">
                            <input type="hidden" name="idedit" class="edit-id" value ="">	
                            <div class="form-group">
                                <label class="control-label" for="title">User name:</label>
                                <input type="text" name="username" class="form-control" data-error="Please enter username"  disabled/>
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">First name:</label>
                                <input type="text" name="firstname" class="form-control" data-error="Please enter firstname" required />
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">Last name:</label>
                                <input type="text" name="lastname" class="form-control" data-error="Please enter lastname" required />
                                <div class="help-block with-errors"></div>
                            </div>					
                            <div class="form-group">
                                <label class="control-label" for="title">Roles:</label>
                                <select  name="roles" class="form-control" data-error="Please enter roles" required >
                                    <option value="1">Admin</option>
                                    <option value="2">User</option>
                                    <option value="3">Visiter</option>
                                    <option value="0">Normal</option>
                                </select>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <div id='message-edit' class="col-sm-offset-2 col-sm-10">
                                </div>
                            </div>	
                            <div class="form-group">
                                <button type="submit" class="btn btn-success edit-item-submit btn-block">Update</button>
                                <button  data-dismiss="modal" class="btn btn-block btn-warning">Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>		
        
        <script src="myjs/login.js"></script>
        <script src="myjs/register.js"></script>
        <script src="myjs/index.js"></script>
        <script src="js/jquery.twbsPagination.js" type="text/javascript"></script>
    </body>
</html>