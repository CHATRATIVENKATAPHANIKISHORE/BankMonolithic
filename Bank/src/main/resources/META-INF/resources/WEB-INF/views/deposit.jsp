<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bank</title>
</head>
<body><h3>Customer Self-Deposit page </h3>
<p> ${accountnumber}</p>
<form action="/customer/deposit/${accountnumber}" method="post">

<p> Enter Amount</p> </br>

<input type="number" id="deposit" name="deposit" required> </br>
<p> Your account number </p></br>
<input disabled="true" type="text" id="accountnumber" name="accountnumber"value=${accountnumber} required>

<input type="submit"  value="depositNow" />
</br>
</form>
</body>

<br>
<a href="/customer/home/${accountnumber}">Home</a>
<a href="/customer/logout">Logout</a>


</html>