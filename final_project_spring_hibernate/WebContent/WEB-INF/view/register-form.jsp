<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>


	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Register Form</h1>
			<form:form action="registerUser" modelAttribute="user" method="POST">
				<div class="form-group">
					<label for="fullname">FullName:</label> 
					<form:input cssClass="form-control" path="fullname" placeholder="FullName" />
				</div>
				
				<div class="form-group">
					<label for="username">User Name:</label> 
					<form:input cssClass="form-control" path="username" placeholder="User Name" />
				</div>

				<div class="form-group">
					<label for="password">Password:</label> 
					<form:input type="password"  cssClass="form-control" path="password" placeholder="password" />
				</div>


			<button type="submit" class="btn btn-primary">Submit</button>
				
			</form:form>
	<a href="<%=request.getContextPath()%>/auth/login">login</a>
	</div>
	
	<!-- <h2>Message: ${message}</h2> -->
</body>
</html>