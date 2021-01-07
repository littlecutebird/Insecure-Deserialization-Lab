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
		<h2>Check your info</h2>
		<p>Submit base64 string and get your information! So easy right?</p>
		<form method="POST" action="${pageContext.request.contextPath}/check">
			 <div class="form-group">
			  <label for="base64str">Base64 String:</label>
			  <input type="text" class="form-control" name="base64str" value=${base64str}>
			</div>
			<span class="help-block"> ${errorString} </span>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<p>Username: ${username}</p>
		<p>Email: ${email}</p>
		<p>Year of birth: ${year}</p>
		<p>Sex: ${sex}</p>
		
	</div>
</body>
</html>