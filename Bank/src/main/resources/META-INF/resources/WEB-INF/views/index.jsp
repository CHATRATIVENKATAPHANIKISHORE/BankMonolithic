<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank</title>
</head>
<body><h3>Bank Login page</h3>
<form action="validateLogin" method="post">
<label for="accountnumber"> Account Number <label>
<input type="text" id="accountnumber" name="accountnumber" required>
<input type="submit" name="btnLogin" value="LOGIN"/>
</form>
</body>
<a href="/bank/admin/login">Show Admin Login</a>
</html>