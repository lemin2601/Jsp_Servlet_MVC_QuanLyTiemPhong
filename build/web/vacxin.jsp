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
                <div class="panel-heading">Vacxin Manager<span id='message' class="pull-right"><img src='img/ajax-loader.gif' /> Loading...</span></div>
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
                            <th>Tên Vắcxin</th>
                            <th>Số Mũi</th>
                            <th>Mô Tả</th>
                            <th>Giá Vắcxin</th>
                            <th>Tên Hãng</th>
                            
                            <th class="text-center">Hành động</th>
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
        <ul id="pagination" class="pagination-sm"></ul>


        <!-- view Item Modal -->
        <div class="modal fade" id="view-item" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title" id="myModalLabel">View Vacxin</h4>
                    </div>
                    <div class="modal-body">
                        <form data-toggle="validator" >
                            <input type="hidden" name="command" value="view">
                            <input type="hidden" name="id" class="view-id">	
                            <div class="form-group">
                                <label class="control-label" for="title">Tên Vacxin:</label>
                                <input type="text" name="tenvacxin" class="form-control" placeholder="Tên Vắc xin"  data-error="Vui lòng nhập tên Vắc xin"  readonly/>
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">Số mũi:</label>
                                <input type="text" name="somui" class="form-control"  placeholder="0 (Số mũi)" data-error="Vui lòng nhập số mũi tiêm" readonly />
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Giá Vacxin:</label>
                                <input type="text" name="giavacxin" class="form-control"  placeholder="1000" data-error="Vui lòng nhập giá Vắc xin" readonly aria-label="Amount (to the nearest dollar)" />
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Tên Hãng:</label>
                                <input type="text" name="tenhang" class="form-control"  placeholder="Tên hãng" data-error="Vui lòng nhập giá Vắc xin" readonly />
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Mô tả:</label>
                                <textarea name="mota" class="form-control" data-error="Vui lòng nhập mô tả" readonly></textarea>
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
                        <h4 class="modal-title" id="myModalLabel">Create Vacxin</h4>
                    </div>
                    <div class="modal-body">
                        <form data-toggle="validator" name="create-item">
                            <input type="hidden" name="command" value="register">
                            <div class="form-group">
                                <label class="control-label" for="title">Tên Vacxin:</label>
                                <input type="text" name="tenvacxin" class="form-control" placeholder="Tên Vắc xin"  data-error="Vui lòng nhập tên Vắc xin"  required/>
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">Số mũi:</label>
                                <input type="text" name="somui" class="form-control"  placeholder="0 (Số mũi)" data-error="Vui lòng nhập số mũi tiêm" required />
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Giá Vacxin:</label>
                                <input type="text" name="giavacxin" class="form-control"  placeholder="1000" data-error="Vui lòng nhập giá Vắc xin" required aria-label="Amount (to the nearest dollar)"/>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Mô tả:</label>
                                <textarea name="mota" class="form-control" data-error="Vui lòng nhập mô tả"></textarea>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Tên Hãng:</label>
                                <input type="text" name="tenhang" class="form-control"  placeholder="Tên hãng" data-error="Vui lòng nhập giá Vắc xin" />
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
                        <h4 class="modal-title" id="myModalLabel">Edit Vacxin</h4>
                    </div>
                    <div class="modal-body">
                        <form data-toggle="validator"  name="form-edit-item">
                            <input type="hidden" name="command" value="edit">
                            <input type="hidden" name="id" class="edit-id" value ="">	
                            <div class="form-group">
                                <label class="control-label" for="title">Tên Vacxin:</label>
                                <input type="text" name="tenvacxin" class="form-control" placeholder="Tên Vắc xin"  data-error="Vui lòng nhập tên Vắc xin"  required/>
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">Số mũi:</label>
                                <input type="text" name="somui" class="form-control"  placeholder="0 (Số mũi)" data-error="Vui lòng nhập số mũi tiêm" required />
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Giá Vacxin:</label>
                                <input type="text" name="giavacxin" class="form-control"  placeholder="1000" data-error="Vui lòng nhập giá Vắc xin" required aria-label="Amount (to the nearest dollar)"/>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="title">Mô tả:</label>
                                <textarea name="mota" class="form-control" data-error="Vui lòng nhập mô tả" ></textarea>
                                <div class="help-block with-errors"></div>
                            </div>	
                            <div class="form-group">
                                <label class="control-label" for="title">Tên Hãng:</label>
                                <input type="text" name="tenhang" class="form-control"  placeholder="Tên hãng" data-error="Vui lòng nhập giá Vắc xin"/>
                                <div class="help-block with-errors"></div>
                            </div>
                            <div class="form-group">
                                <div id='message-edit' class="col-sm-offset-2 col-sm-10">
                                </div>
                            </div>	
                            <div class="form-group">
                                <button type="submit" class="btn btn-success form-edit-submit btn-block">Update</button>
                                <button  data-dismiss="modal" class="btn btn-block btn-warning">Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>		
        <script src="myjs/vacxin.js"></script>
        <script src="js/jquery.twbsPagination.js" type="text/javascript"></script>
    </body>
</html>