<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Email form</h1>
<form method="post" action="./send-otp" >

<div class="form-group text-centre" >

<input name="email" type="email" required="required" class="form-control" placeholder="Enter your Email" />

<div class="container text-centre">
<button class="btn-btn-warning">Send OTP</button>
</div>
</div>

</form>
</body>
</html>