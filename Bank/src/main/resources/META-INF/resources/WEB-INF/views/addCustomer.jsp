<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Admin</title>
</head>
<body><h3>Add Customer</h3>
<form action="addCustomers" method="post">
<label for="customerName"> Name <label>
<input type="text" id="customerName" name="customerName" required>

<input type="submit" name="submit" value="Submit"/>
</form>
</body>
<a href="/bank/admin/home">Admin </a>
</html>