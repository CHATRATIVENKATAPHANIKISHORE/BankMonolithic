<%@ page language="java" contentType="text/html; charset=ISO-8859-1"


    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bank</title>
</head>
<body><h3>Recent Transactions page</h3>
<form action="" method="post">

<table border="1">
  
//table tag with border

  <tr>	
  	        
  	         <th>Transaction ID</td>
  	         <th>From Account Number</td>
  	         <th>To Account Number</td>	
  	        <th>Amount</td>
  	      
  	        
  	           <th>Timestamp</td>
  	           <th>Transaction Type</td>
  	           
  	            
    </tr>
       <c:forEach var="item" items="${recent}" >
       
  
  <tr>	
  	        
  	         <td><p>${item.transactionId}</p></td>
  	         <td>${item.fromAccount}</td>
  	         <td>${item.toAccount}</td>	
  	        <td>${item.transferAmount}</td>
  	      
  	        
  	           <td>${item.timestamp}</td>
  	           <td>${item.transactionType}</td>
  	           
  	            
    </tr>
  
</c:forEach>
     
    
  
      </table>


</form>
</body>
<br>
<a href="/customer/home/${accountnumber}">Home</a>
<a href="/customer/logout">Logout</a>



</html>