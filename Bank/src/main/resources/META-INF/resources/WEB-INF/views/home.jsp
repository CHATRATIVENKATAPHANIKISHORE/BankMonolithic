<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bank</title>
</head>



</body>
<h1> Customer Home </h1>
<p> welcome ${accountnumber} </p>
<a href="/customer/checkbal/${accountnumber}">Check Account Balance</a>
<br>
<a href="/customer/deposit/${accountnumber}">Deposit Form</a>
<br>
<a href="/customer/withdraw/${accountnumber}">Withdrawl Form</a>
<br>


<a href="/customer/transfer/${accountnumber}">Transfer Amount</a>
<br>
<a href="/customer/recent/${accountnumber}">Recent Transactions</a>
<br>
<a href="/customer/logout">Logout</a>


</html>