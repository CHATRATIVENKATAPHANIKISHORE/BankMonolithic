<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bank</title>
</head>
<body><h3>Transfer page</h3>
<form action="/customer/transfer/${accountnumber}" method="post">

<p> Enter Amount</p></br>

<input type="number" id="deposit" name="deposit" required>

<p> To Account Number </p></br>
<input type="text" id="toaccount" name="toaccount"value=${toaccount}>

<input type="submit"  value="Transfer Now" /></br
</form></body>

<br>
<br>
<a href="/customer/home/${accountnumber}">Home</a>
<a href="/customer/logout">Logout</a>




</html>