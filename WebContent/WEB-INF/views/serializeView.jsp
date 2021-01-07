<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Submit info</title>
	<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<h2>Submit your information</h2>
		<p>The result is a Base64 Java object</p>
		<form method="POST" action="${pageContext.request.contextPath}/submit">
			 <div class="form-group">
			  <label for="username">Username:</label>
			  <input type="text" class="form-control" name="username" value=${username}>
			</div>
			<div class="form-group">
			  <label for="email">Email:</label>
			  <input type="email" class="form-control" name="email" value=${email}>
			</div>
			<div class="form-group">
			  <label for="year">Year of birth:</label>
			  <input type="number" class="form-control" name="year" value=${year}>
			</div>
			<div class="form-group">
			  <label for="sex">Sex:</label>
			  <input type="text" class="form-control" name="sex" value=${sex}>
			</div>
			<span class="help-block"> ${errorString} </span>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<p>Base64: ${base64Object}</p>
		
	</div>
</body>
</html>