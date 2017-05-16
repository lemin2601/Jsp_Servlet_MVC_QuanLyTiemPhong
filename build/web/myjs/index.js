$(document).ready(function () {

    var is_ajax_fire = 0;
    var page = 1;
    var current_page = 1;
    var total_page = 0;
    var url = "User"
    var search_key = "";
    /* run first time*/
    manageData();
    /* manage data list */
    function manageData() {
        $.ajax({
            dataType: 'json',
            url: url,
            data: {page: page, command: 'view', key: search_key}
        }).done(function (data) {
            console.log(data.total);
            total_page = Math.ceil(data.total / 5);
            console.log(total_page+ 'page');
            current_page = page;
            $('#pagination').twbsPagination({
                totalPages: total_page,
                startPage: current_page,
                visiblePages: (total_page>2)?3:1,
                onPageClick: function (event, pageL) {
                    page = pageL;
                    if (is_ajax_fire != 0) {
                        getPageData();
                    }
                }
            });
            manageRow(data.data);
            is_ajax_fire = 1;
        });
    }
    /* Get Page Data*/
    function getPageData() {
        $.ajax({
            dataType: 'json',
            url: url,
            data: {page: page, command: 'view', key: search_key}
        }).done(function (data) {
            manageRow(data.data);
        });
    }
    /* Add new Item table row */
    function manageRow(data) {
        var rows = '';
        $.each(data, function (key, value) {
            rows = rows + '<tr>';
            rows = rows + '<td>' + value.id + '</td>';
            rows = rows + '<td>' + value.username + '</td>';
            rows = rows + '<td>' + value.firstname + '</td>';
            rows = rows + '<td>' + value.lastname + '</td>';
            rows = rows + '<td data-id="' + value.id + '" class="text-center">';
            rows = rows + '<input type="hidden" value="' + value.roles + '" />';
            rows = rows + '<button data-backdrop="static" data-toggle="modal" data-target="#view-item" class="view-item btn btn-info btn-xs"><i class="glyphicon glyphicon-eye-open"></i></button> ';
            rows = rows + '<button data-backdrop="static" data-toggle="modal" data-target="#edit-item" class="edit-item btn btn-warning btn-xs"><i class="glyphicon glyphicon-edit"></i></button> ';
            rows = rows + '<button class="btn btn-danger btn-xs"><i class="remove-item-submit glyphicon glyphicon-trash"></i></button> ';
            rows = rows + '</td>';
            rows = rows + '</tr>';
        });
        $("tbody").html(rows);
    }

    /* Create new Item */
    $(".create-item-submit").click(function (e) {
        e.preventDefault();
        var form_action = "User";
        var command = $("#create-item").find("input[name='command']").val();
        var username = $("#create-item").find("input[name='username']").val();
        var password = $("#create-item").find("input[name='password']").val();
        var password2 = $("#create-item").find("input[name='password2']").val();
        var lastname = $("#create-item").find("input[name='lastname']").val();
        var firstname = $("#create-item").find("input[name='firstname']").val();
        if (password != '' && password2 == password && username != '') {
            $.ajax({
                type: 'POST',
                url: url,
                data: {command: command, username: username, password: password, password2: password2, firstname: firstname, lastname: lastname},

                beforeSend: function () {
                    $("#message-create").html("<img src='img/ajax-loader.gif' /> Loading...");
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $("#message-create").html("<p style ='color:red;'>Can't connect to server, try again.</p>");
                },
                success: function (data) {
                    if (data == "pass") {
                        $("#message-create").html("<p style ='color:red;'>Password doesn't matched.</p>");
                    } else if (data == "user") {
                        $("#message-create").html("<p style ='color:red;'>Username have been used.<a href='login.jsp'>Login here</a></p>");
                    } else if (data == "success") {
                        $("#message-create").html("<p style ='color:green;'>Register success, <a href='login.jsp'>Login here</a></p>");
                        $("#create-item").find("input[name='username']").val('');
                        $("#create-item").find("input[name='password']").val('');
                        $("#create-item").find("input[name='password2']").val('');
                        $("#create-item").find("input[name='lastname']").val('');
                        $("#create-item").find("input[name='firstname']").val('');
                        toastr.success('Item Created Successfully.', 'Success Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
                        getPageData();
                    }
                }
            });
        } else {
            toastr.error('You are hack me. Try again', 'Error Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
        }
    });

    /* View Item */
    $("body").on("click", ".view-item", function () {
        var id = $(this).closest("tr").find("td:nth-child(1)").text();
        var username = $(this).closest("tr").find("td:nth-child(2)").text();
        var firstname = $(this).closest("tr").find("td:nth-child(3)").text();
        var lastname = $(this).closest("tr").find("td:nth-child(4)").text();
        var roles = $(this).closest("tr").find("input:hidden:eq(1)").val();
        //var roles=$(this).closest("tr").find("input:text:eq(0)").val();
        //var description = $(this).parent("td").prev("td").text();
        $("#view-item").find("input[name='username']").val(username);
        $("#view-item").find("input[name='firstname']").val(firstname);
        $("#view-item").find("input[name='lastname']").val(lastname);
        $("#view-item").find("select[name='roles']").val(roles);

    });

    /* Edit Item */
    $("body").on("click", ".edit-item", function () {

        var id = $(this).closest("tr").find("td:nth-child(1)").text();
        console.log('id nè:' + $(this).closest("tr").find("td:nth-child(1)").text());
        var username = $(this).closest("tr").find("td:nth-child(2)").text();
        var firstname = $(this).closest("tr").find("td:nth-child(3)").text();
        var lastname = $(this).closest("tr").find("td:nth-child(4)").text();
        var roles = $(this).closest("tr").find("input:hidden:eq(0)").val();
        //var roles=$(this).closest("tr").find("input:text:eq(0)").val();
        //var description = $(this).parent("td").prev("td").text();
        $("#edit-item").find("input[name='username']").val(username);
        $("#edit-item").find("input[name='firstname']").val(firstname);
        $("#edit-item").find("input[name='lastname']").val(lastname);
        $("#edit-item").find("select[name='roles']").val(roles);
        $("#edit-item").find(".edit-id").val(id);
        //$("#view-item").find("input[name='idedit']").val(id);
        console.log('aaaaaaroles:' + roles +
                'id:' + id +
                'user' + username +
                'first' + firstname);
    });

    /* Updated new Item */
    $(".edit-item-submit").click(function (e) {
        e.preventDefault();
        var form_action = "User";
        var command = $("#edit-item").find("input[name='command']").val();
        var username = $("#edit-item").find("input[name='username']").val();
//	     var password = $("#edit-item").find("input[name='password']").val();
//	     var password2 = $("#edit-item").find("input[name='password2']").val();
        var lastname = $("#edit-item").find("input[name='lastname']").val();
        var firstname = $("#edit-item").find("input[name='firstname']").val();
        var roles = $("#edit-item").find("select[name='roles']").val();
        var idedit = $("#edit-item").find(".edit-id").val();
//	     console.log( 'roles:'+roles+
//	    		 'id:'+idedit+
//	    		 'user'+username+
//	    		 'first'+firstname+
//	    		 'command'+command+
//	    		 'user'+username+ 
//	    		 'pass'+password2+ 
//	    		 'last'+lastname);
//	     if(password != '' && password2 == password && username != ''){
        $.ajax({
            type: 'POST',
            url: url,
            data: {command: command, idedit: idedit, username: username, firstname: firstname, lastname: lastname, roles: roles},

            beforeSend: function () {
                $("#message-create").html("<img src='img/ajax-loader.gif' /> Loading...");
            },
            error: function (xhr, ajaxOptions, thrownError) {
                $("#message-create").html("<p style ='color:red;'>Can't connect to server, try again.</p>");
            },
            success: function (data) {
                if (data == "pass") {
                    $("#message-edit").html("<p style ='color:red;'>Password doesn't matched.</p>");
                } else if (data == "user") {
                    $("#message-edit").html("<p style ='color:red;'>Username have been used.<a href='login.jsp'>Login here</a></p>");
                } else if (data == "roles") {
                    $("#message-edit").html("<p style ='color:red;'>Error Roles, Try Again...</p>");
                } else if (data == "success") {
                    $("#message-edit").html("<p style ='color:green;'>Register success, <a href='login.jsp'>Login here</a></p>");
                    $("#create-item").find("input[name='username']").val('');
//				    	     $("#create-item").find("input[name='password']").val('');
//				    	     $("#create-item").find("input[name='password2']").val('');
                    $("#create-item").find("input[name='lastname']").val('');
                    $("#create-item").find("input[name='firstname']").val('');
                    toastr.success('Item Updated Successfully.', 'Success Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
                    getPageData();
                }
            }
        });
//	     }else{
//	    	 toastr.error('You are hack me. Try again', 'Error Alert',{positionClass: 'toast-bottom-right'}, {timeOut: 3000});
//	     }	     	

    });


    /* Remove Item */
    $("body").on("click", ".remove-item-submit", function () {
//	 $(".remove-item-submit").click(function(e){
        var id = $(this).closest('td').attr('data-id');
        console.log('id delete:' + id);
        var sure = confirm('Are you sure?');
        if (sure) {
            var c_obj = $(this).parents("tr");
            var c_obj_html = c_obj.html();
            $.ajax({
                type: 'post',
                url: 'User',
                data: {command: 'delete', id: id},
                beforeSend: function () {
                    c_obj.html("<img src='img/ajax-loader.gif' /> Loading...");
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    c_obj.html(c_obj_html);
                    alert("Can't connect to server, try again.");
                },
                success: function (data) {
                    if (data == "failed") {
                        c_obj.html(c_obj_html);
                    } else if (data == "success") {
                        toastr.success('Item Remove Successfully.', 'Delete Success', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
                        c_obj.remove();
                        getPageData();
                    }
                },
            });

        }
    });

    /*search button*/
    $("#search-button").click(function (e) {
        key:search_key = $('#search-key').val();
        manageData();
    });
    $("#search-key").on('keyup', function (e) {
        if (e.keyCode == 13) {
            key:search_key = $('#search-key').val();
            manageData();
        }
    });
});
