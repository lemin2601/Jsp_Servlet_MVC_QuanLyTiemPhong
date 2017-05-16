<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/w3.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>


</head>
<body>
	<!-- <button onclick="document.getElementById('id01login').style.display='block'"
		class="w3-btn w3-green w3-large">Login</button>
 -->
	<div id="id01login" class="w3-modal" style="cursor: pointer;">
		<div class="w3-modal-content w3-card-4 w3-animate-zoom"
			style="max-width: 600px; cursor: auto">

			<div class="w3-center">
				<br> <span
					onclick="document.getElementById('id01login').style.display='none'"
					title="Close Modal"
					class="w3-button w3-hover-text-grey w3-container w3-display-topright w3-xxlarge">&times;</span>
				<img src="img/img_avatar2.png" alt="Avatar" style="width: 40%"
					class="w3-circle w3-margin-top">
			</div>

			<div class="w3-container">
				<div class="w3-section">
					<label><b>Username</b></label> <input
						class="w3-input w3-border w3-margin-bottom" type="text"
						placeholder="Enter Username"> <label><b>Password</b></label>
					<input class="w3-input w3-border" type="password"
						placeholder="Enter Password">

					<button class="w3-button w3-block w3-green w3-section w3-padding"
						onclick="document.getElementById('id01login').style.display='none'">Login</button>
					<input type="checkbox" checked="checked"> Remember me
				</div>
			</div>

			<div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
				<button
					onclick="document.getElementById('id01login').style.display='none'"
					type="button" class="w3-btn w3-red">Cancel</button>
				<span class="w3-right w3-padding w3-hide-small">Forgot <a
					href="javascript:void(0)"
					onclick="document.getElementById('id01login').style.display='none'">password?</a></span>
			</div>

		</div>
	</div>
	<script>
		// Get the modal
		var modal = document.getElementById('id01login');
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>