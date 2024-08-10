<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Admin</title>
</head>
<body>
<h3>View Customer</h3>
<form action="" method="post">
<label> Search Account Details by Account Number <label>
<input type="text" name="accno"/>
<input type="submit" name="btnview" value="view customer"/>
</form>


<a href="/admin/modifyCustomer">Update Customer</a>
<br>
<a href="/admin/deleteCustomer">Delete Customer</a>
<br>




<br>
<a href="/admin/logout">Admin Logout</a>


</html>