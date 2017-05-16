$(document).ready(function () {
    var is_ajax_fire = 0;  
    var url = "ThongKe"
    /* run first time*/
    manageData();
    /* manage data list */
    function manageData() {
        $.ajax({
            dataType: 'json',
            url: url,
            type: 'post',
            data: {}
        }).done(function (data) {            
            manageRow(data.data);
            is_ajax_fire = 1;
        });
    }
    /* Get Page Data*/
    function getPageData() {
        $.ajax({
            dataType: 'json',
            url: url,
            data: {}
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
            rows = rows + '<td>' + value.sotien + '</td>';
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
