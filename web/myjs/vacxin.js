$(document).ready(function () {

    var is_ajax_fire = 0;
    var page = 1;
    var current_page = 1;
    var total_page = 0;
    var url = "Vacxin"
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
            current_page = page;
            $('#pagination').twbsPagination({
                totalPages: total_page,
                startPage: current_page,
                visiblePages: (total_page > 2) ? 3 : 1,
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
            rows = rows + '<td>' + value.mavacxin + '</td>';
            rows = rows + '<td>' + value.tenvacxin + '</td>';
            rows = rows + '<td>' + value.somui + '</td>';
            rows = rows + '<td>' + value.mota + '</td>';
            rows = rows + '<td>' + value.giavacxin + '</td>';

            rows = rows + '<td>' + value.tenhang + '</td>';
            rows = rows + '<td data-id="' + value.mavacxin + '" class="text-center">';
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
        var form = $("#create-item").find("form[name='create-item']");
        var command = $("#create-item").find("input[name='command']").val();
        var tenvacxin = $("#create-item").find("input[name='tenvacxin']").val();
        var giavacxin = $("#create-item").find("input[name='giavacxin']").val();
        var mota = $("#create-item").find("textarea[name='mota']").val();
        var somui = $("#create-item").find("input[name='somui']").val();
        var tenhang = $("#create-item").find("input[name='tenhang']").val();
        //console.log("Insert:"+ command +"|"+ tenvacxin +"|"+ giavacxin +"|"+ mota +"|"+ somui);
        if (tenvacxin != '' || giavacxin == '' || somui == '') {
            $.ajax({
                type: 'POST',
                url: url,
                //data: {command: command, tenvacxin: tenvacxin, giavacxin: giavacxin, mota: mota, somui: somui,tenhang:tenhang},
                data: form.serialize(),
                beforeSend: function () {
                    $("#message-create").html("<img src='img/ajax-loader.gif' /> Loading...");
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $("#message-create").html("<p style ='color:red;'>Can't connect to server, try again.</p>");
                },
                success: function (data) {
                    if (data == "falied") {
                        $("#message-create").html("<p style ='color:red;'>Thêm thất bại.</p>");
                    } else if (data == "success") {
                        $("#message-create").html("<p style ='color:green;'>Thêm thành công.</p>");
                        $("#create-item").find("input[name='tenvacxin']").val('');
                        $("#create-item").find("input[name='giavacxin']").val('');
                        $("#create-item").find("input[name='mota']").val('');
                        $("#create-item").find("input[name='somui']").val('');
                        $("#create-item").find("input[name='tenhang']").val('');
                        $("#create-item").find("textarea[name='mota']").val('');
                        toastr.success('Item Created Successfully.', 'Success Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
                        getPageData();
                    } else {
                        toastr.error('Insert Failed. Try again', 'Error Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
                       // alert(data);
                    }
                }
            });
        } else {
            toastr.error('You are hack me. Try again', 'Error Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
        }
    });

    /* View Item */
    $("body").on("click", ".view-item", function () {
        var tenvacxin = $(this).closest("tr").find("td:nth-child(2)").text();
        var somui = $(this).closest("tr").find("td:nth-child(3)").text();
        var mota = $(this).closest("tr").find("td:nth-child(4)").text();
        var giavacxin = $(this).closest("tr").find("td:nth-child(5)").text();
        var tenhang = $(this).closest("tr").find("td:nth-child(6)").text();
        //console.log("1:"+ tenvacxin + " 2:" + giavacxin +" 3:" +mota + " 4:" + somui);
        $("#view-item").find("input[name='tenvacxin']").val(tenvacxin);
        $("#view-item").find("input[name='giavacxin']").val(giavacxin);
        $("#view-item").find("textarea[name='mota']").val(mota);
        $("#view-item").find("input[name='somui']").val(somui);
        $("#view-item").find("input[name='tenhang']").val(tenhang);
    });

    /* Edit Item */
    $("body").on("click", ".edit-item", function () {
        var id = $(this).closest("tr").find("td:nth-child(1)").text();
        console.log('id nè:' + $(this).closest("tr").find("td:nth-child(1)").text());
        var tenvacxin = $(this).closest("tr").find("td:nth-child(2)").text();
        var somui = $(this).closest("tr").find("td:nth-child(3)").text();
        var mota = $(this).closest("tr").find("td:nth-child(4)").text();
        var giavacxin = $(this).closest("tr").find("td:nth-child(5)").text();
        var tenhang = $(this).closest("tr").find("td:nth-child(6)").text();
        $("#edit-item").find("input[name='tenvacxin']").val(tenvacxin);
        $("#edit-item").find("input[name='giavacxin']").val(giavacxin);
        $("#edit-item").find("textarea[name='mota']").val(mota);
        $("#edit-item").find("input[name='somui']").val(somui);
        $("#edit-item").find("input[name='tenhang']").val(tenhang);
        $("#edit-item").find(".edit-id").val(id);
        console.log("id" + id + " 1:" + tenvacxin + " 2:" + giavacxin + " 3:" + mota + " 4:" + somui);
    });
    /* Updated new Item */
    $(".form-edit-submit").click(function (e) {
        e.preventDefault();
        var form = $("#edit-item").find("form[name='form-edit-item']");
        var tenvacxin = $("#edit-item").find("input[name='tenvacxin']").val();
        var giavacxin = $("#edit-item").find("input[name='giavacxin']").val();
        var somui = $("#edit-item").find("input[name='somui']").val();
        //console.log("Insert:"+ command +"|"+ tenvacxin +"|"+ giavacxin +"|"+ mota +"|"+ somui);
        if (tenvacxin != '' || giavacxin == '' || somui == '') {
            $.ajax({
                type: 'POST',
                url: url,
                //data: {command: command, tenvacxin: tenvacxin, giavacxin: giavacxin, mota: mota, somui: somui,tenhang:tenhang},
                data: form.serialize(),
                beforeSend: function () {
                    $("#message-create").html("<img src='img/ajax-loader.gif' /> Loading...");
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $("#message-create").html("<p style ='color:red;'>Can't connect to server, try again.</p>");
                },
                success: function (data) {
                    if (data == "failed") {
                        $("#message-edit").html("<p style ='color:red;'>Sửa thất bại.</p>");
                        toastr.error('Item Updated Successfully.', 'Failed Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
                    } else if (data == "success") {
                        $("#message-create").html("<p style ='color:green;'>Thêm thành công.</p>");
                        $("#create-item").find("input[name='tenvacxin']").val('');
                        $("#create-item").find("input[name='giavacxin']").val('');
                        $("#create-item").find("input[name='mota']").val('');
                        $("#create-item").find("input[name='somui']").val('');
                        toastr.success('Item Created Successfully.', 'Success Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
                        getPageData();
                    } else {
                        alert(data);
                    }
                }
            });
        } else {
            toastr.error('You are hack me. Try again', 'Error Alert', {positionClass: 'toast-bottom-right'}, {timeOut: 3000});
        }
        return false;
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
                url: url,
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
        search(e);
    });
    $("#search-key").on('keyup', function (e) {
        if (e.keyCode == 13) {
            search(e);
        }
    });
    function search(e) {
        page = 1;
        current_page = 1;
        total_page = 0;
        is_ajax_fire = 0;
        key:search_key = $('#search-key').val();
        manageData();
    }
});
