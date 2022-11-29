<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
	
</head>
<body>


	<div class="container" id="container">
		
      <div class="form-container sign-up-container">

        <form:form action="registerUser" modelAttribute="user" method="POST">
        	<h1>Create Account</h1>
          <span>or use your email for registration</span>
          <form:input cssClass="form-control" path="fullname" placeholder="FullName" />
          <form:input path="username" placeholder="User Name" />
          <form:input type="password" cssClass="form-control" path="password" placeholder="password" />
          <button type="submit">Sign Up</button>
        </form:form>
        
       
      </div>
      <div class="form-container sign-in-container">
         <form:form action="login" modelAttribute="user" method="POST">
        	<h1>Sign in</h1>
          <span>or use your email for registration</span>
          <form:input path="username" placeholder="User Name" />
          <form:input type="password" cssClass="form-control" path="password" placeholder="password" />
          <a href="#">Forgot your password?</a>
          <button type="submit">Sign in</button>
        </form:form>
      </div>
      
      
      <div class="overlay-container">
        <div class="overlay">
          <div class="overlay-panel overlay-left">
            <h1>Welcome Back!</h1>
            <p></p>
            <button class="ghost" id="signIn">Sign In</button>
          </div>
          <div class="overlay-panel overlay-right">
            <h1>Hello, Friend!</h1>
            <p>Enter your personal details and start journey with us</p>
            <button class="ghost" id="signUp">Sign Up</button>
          </div>
        </div>
      </div>
    </div>
</body>
<script>
    const signUpButton = document.getElementById("signUp");
    const signInButton = document.getElementById("signIn");
    const container = document.getElementById("container");

    signUpButton.addEventListener("click", () => {
      container.classList.add("right-panel-active");
    });

    signInButton.addEventListener("click", () => {
      container.classList.remove("right-panel-active");
    });
  </script>
</html>