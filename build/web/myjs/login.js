$(document).ready(function () {    
    $('form').on('submit', function (e) {
        e.preventDefault();
        $.ajax({
            type: 'post',
            url: 'User',
            data: $(this).serialize(),
            beforeSend: function () {
                $("#message").html("<img src='img/ajax-loader.gif' /> Loading...");
            },
            error: function (xhr, ajaxOptions, thrownError) {
                $("#message").html("<p style ='color:red;'>Can't connect to server, try again.</p>");
            },
            success: function (data) {
                if (data == "pass") {
                    $("#message").html("<p style ='color:red;'>Password doesn't correct.</p>");
                } else if (data == "user") {
                    $("#message").html("<p style ='color:red;'>Username have not been register.<a href='register.jsp'>Register here</a></p>");
                } else if (data == "success") {
                    $("#message").html("<p style ='color:green;'>Login success, wait ... or you can click here <a href='index.jsp'>Home</a></p>");
                    document.location.href = 'vacxin.jsp';
                }
                //alert(data);
                //$("#message").html(data);
            },
        });
        return false;
    });
});