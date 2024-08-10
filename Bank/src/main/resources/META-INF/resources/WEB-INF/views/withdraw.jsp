<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bank</title>
</head>
<body><h3>Customer Withdrawl form</h3>
<form action="/customer/withdraw/${accountnumber}" method="post">

<p> Enter Amount</p>

<input type="number" id="withdraw" name="withdraw" required>
<input disabled="true" type="text" id="accountnumber" name="accountnumber"value=${accountnumber} required>

<input type="submit"  value="withdrawnow" />
</form>
</body>

<br>
<a href="/customer/home/${accountnumber}">Home</a>
<a href="/customer/logout">Logout</a>

</html>