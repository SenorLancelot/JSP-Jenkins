<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="signin-form">
						<h2 class="form-title">Search</h2>
						<form method="post" action="data" class="register-form"
							id="search-form">
							<div class="form-group">
								<label for="lastname"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="lastname" id="lastname"
									placeholder="Your Name" />
							</div>
							<div class="form-group form-button">
								<input type="submit" name="search" id="search"
									class="form-submit" value="Search" />
							</div>
						</form>
						
					</div>
</body>
</html>