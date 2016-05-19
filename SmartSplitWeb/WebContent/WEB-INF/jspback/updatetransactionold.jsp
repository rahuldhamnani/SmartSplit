<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Expense</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<h1>Hello Check</h1>
<form name='upTrans' modelAttribute='uTransaction' method='POST' onsubmit="updatetrans();">
		<div>
			<Table>
				<tr><td><input type="text" readonly="readonly" id = "addedBy" name="addedBy" /></td><td> and</td><td><input type="text" id="addedTo" name="addedTo"/></td></tr>
				<tr><td>Category: </td><td><input type="text" id="category" name="category"/></td></tr>
				<tr><td>Description: </td><td><input type="text" id="title" name="title"/></td></tr>
				<tr><td>Total: </td><td><input type="text" id="totalAmount" name="totalAmount"/></td></tr>
				<tr><td>Owed: </td><td><input type="text" id="amountOwe" name="amountOwe"/></td></tr>	
			</Table>
		</div>
		<input type="submit" value="Update"/>
	</form>
</body>
<script>
	var json= ${transaction};
	
		$(document).ready(function () {	
		
		});
		document.getElementById('addedBy').value = json.addedBy;
		document.getElementById('addedTo').value = json.addedTo;
		document.getElementById('category').value = json.category;
		document.getElementById('title').value = json.title;
		document.getElementById('totalAmount').value = json.totalAmount;
		document.getElementById('amountOwe').value = json.amountOwe;
	
		function updatetrans()
		{
			document.forms['upTrans'].action ='/SmartSplitWeb/updatetr/'+json.idTransactions;
			document.forms['upTrans'].submit();
		}
</script>

</html>