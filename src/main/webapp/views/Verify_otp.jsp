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

<div class="alert alert-success" role="alert">
We have sent the OTP to your Register Email_ID.....
</div>


<form method="post" action="./verify-otp">

<div class="form-group text-centre" >

<input name="otp" type="text" required="required" class="form-control" placeholder="Enter your OTP" />

<div class="container text-centre">
<button class="btn-btn-success">Verify</button>
</div>
</div>

</form>
</body>
</html>