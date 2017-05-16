$(document).ready(function() {
			$('form').on('submit', function(e) {
				e.preventDefault();
				$.ajax({
					type : 'post',
					url : 'User',
					data : $(this).serialize(),
				    beforeSend:function() {
				    	$("#message").html("<img src='img/ajax-loader.gif' /> Loading...");						
					},
				    error: function(xhr, ajaxOptions, thrownError){
				    	$("#message").html("<p style ='color:red;'>Can't connect to server, try again.</p>");
				    },
					success : function(data) {
						 if (data == "pass"){
							 $("#message").html("<p style ='color:red;'>Password doesn't matched.</p>");
						 }else if(data == "user"){
							 $("#message").html("<p style ='color:red;'>Username have been used.<a href='login.jsp'>Login here</a></p>");
						 }else if(data == "success"){
							 $("#message").html("<p style ='color:green;'>Register success, <a href='login.jsp'>Login here</a></p>");
							 document.form.reset();
						 }
						//alert(data);
						//$("#message").html(data);
					}			   
				});
				return false; 
			});
		});