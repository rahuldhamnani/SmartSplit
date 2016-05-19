<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>  
</head>
<body>
${transaction}
<div id="main-container">
		<h1 id = "head1"></h1>
		<h2 id = "head2"></h2>
		<br>
    	<div id="postLoad"></div>
	</div>
	<input type="button" onclick="myFunction()" value="Delete Expense"/>
</body>
<script>
	var json= ${transaction}; 
	$(document).ready(function () {	  
	  	var tableData = '<table><tr>'+json.firstName+' '+json.lastName+' paid $'+json.totalAmount+'</tr><br><tr>'+json.otherFirstName+' '+json.otherLastName+' owes $'+(json.totalAmount - json.amountOwe)+'</tr></table>';
	  	$('#postLoad').html(tableData);
	  	$('#head1').html(json.title);
	  	$('#head2').html(json.category);
	});
	
</script>

</html>	