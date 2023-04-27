pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Password Change form</h1>

<div class="alert alert-success" role="alert">
<h1>Enter New Password</h1>
</div>


<form method="post" action="./change-password">

<div class="form-group text-centre" >

<input name="newpassword" type="password" required="required" class="form-control" placeholder="Enter your Password" />

<div class="container text-centre">
<button class="btn-btn-primary">Submit</button>
</div>
</div>

</form>
</body>
</html>