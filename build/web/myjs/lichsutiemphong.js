$(document).ready(function () {

    var is_ajax_fire = 0;
    var page = 1;
    var current_page = 1;
    var total_page = 0;
    var url = "LichSuTiemPhong"
    var search_key = "";
    /* run first time*/
    manageData();
    /* manage data list */
    function manageData() {
        $.ajax({
            dataType: 'json',
            type: 'post',
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
                visiblePages: 1,
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
            type: 'post',
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
            rows = rows + '<td>' + value.makh + '</td>';
            rows = rows + '<td>' + value.tenkh + '</td>';
            rows = rows + '<td>' + value.tenbenh + '</td>';
            rows = rows + '<td>' + value.mavacxin + '</td>';
            rows = rows + '<td>' + value.tenvacxin + '</td>';
            rows = rows + '<td>' + value.tongsomui + '</td>';
            console.log(value);
            rows = rows + '</tr>';
        });
        
        $("tbody").html(rows);
    }

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
