<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Friend</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script> 
</head>
<body>
${friendsTransactions}
<div id="main-container">
		<h1 id = "frnm"></h1>
		<h2 id = "frtot"></h2>
		<br>
    	<div id="postLoad"></div>
	</div>
	<input type="button" onclick="myFunction()" value="Delete Expense"/>
<script>
   
   
   var json = ${friendsTransactions}; 
   var name = json.firstName;
  $(document).ready(function() {
	  var tableData = '<table><tr><td>Added By</td><td>category</td><td>title</td><td>Who paid</td><td>amount</td></tr>';
	  	$.each(json.transactions, function(index, data) {
	   	//tableData += '<tr><td>'+data.firstName+" "+data.lastName+'</td><td>'+data.category+'</td><td>'+data.title+'</td><td>'+data.amountOwe+'</td><td><input type="button" onclick="myDetails()" value="Show Details"/></td></tr>';
	  	 tableData += "<tr><td>"+data.firstName+"</td><td>"+data.lastName+"</td><td>"+data.category+"</td><td>"+data.title+"</td><td>"+data.amountOwe+"</td><td><form method='post' action='transaction/"+data.idTransactions+"'><input type='submit' value='Show Details'/></form></td></tr>";

	  	});
	  	tableData +="</table>";
	  	$('#postLoad').html(tableData);
  });
  document.getElementById(id = 'frnm').innerHTML = name +" "+ json.lastName;
  document.getElementById(id = 'frtot').innerHTML = json.whoOwesWho +" $"+ json.totalAmt;
</script>
</body>

</html>