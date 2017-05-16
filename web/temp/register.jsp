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

	<!-- <button onclick="document.getElementById('id01registerregister').style.display='block'" class="w3-btn w3-green w3-large">Sign Up</button> -->

	<div id="id01register" class="w3-modal"
		style="cursor: pointer; background-color: rgba(0, 0, 0, 0.7);">
		<span onclick="document.getElementById('id01register').style.display='none'"
			title="Close Modal"
			class="w3-hover-text-red w3-container w3-text-white w3-display-topright w3-xxxlarge"
			style="right: 50px;">&times;</span>
		<div class="w3-modal-content w3-card-4 w3-animate-zoom"
			style="max-width: 600px; cursor: auto">

			<div class="w3-container">
				<div class="w3-section">
					<label><b>Email</b></label> <input
						class="w3-input w3-border w3-margin-bottom" type="text"
						placeholder="Enter email">
				</div>
				<div class="w3-section">

					<label><b>Password</b></label> <input class="w3-input w3-border"
						type="text" placeholder="Enter Password">
				</div>
				<div class="w3-section">

					<label><b>Repeat Password</b></label> <input
						class="w3-input w3-border" type="text"
						placeholder="Repeat Password"> <input
						class="w3-check w3-margin-top" type="checkbox" checked="checked">
					Remember me
					<p>
						By creating an account you agree to our <a
							href="javascript:void(0)">Terms & Privacy</a>.
					</p>
				</div>
				<div class="w3-row">
					<div class="w3-half">
						<button
							onclick="document.getElementById('id01register').style.display='none'"
							type="button" class="w3-button w3-block w3-red w3-padding-16">Cancel</button>
					</div>
					<div class="w3-half">
						<button
							onclick="document.getElementById('id01register').style.display='none'"
							type="button" class="w3-button w3-block w3-green w3-padding-16">Sign
							Up</button>
					</div>
				</div>
				<br>
			</div>

		</div>
	</div>

	<script>
		// Get the modal
		var modal = document.getElementById('id01register');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>