<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>  
	
</head>
<body>
${friendsBal}
	<div id="main-container">
		<h1>My Balance</h1>
		<div style="float:left" id = >You are owed: </div><div style="float:left" id="amtowed"></div><div style="float:left"> You owe: $</div><div style="float:left" id="amtowe"></div>
		<br>
    	<div id="postLoad"></div>
	</div>
	<input type="button" onclick="myFunction()" value="Add Bill"/>
	<input type="button" onclick="logoutFunction()" value="Logout"/>


<script>
	var json= ${friendsBal}; 
	var amtOwed = json.amtOwed;
	var amtowe = json.amtOwe;
	
	$(document).ready(function () {	  
	  	var tableData = '<table><tr><td>firstName</td><td>lastName</td><td>balance</td></tr>';
	  	$.each(json.userBalances, function(index, data) {
	  		$my_global_var ='dfdsfdsf';// a json object which has title and name property
	   //	tableData += "<tr><td>"+data.firstName+"</td><td>"+data.lastName+"</td><td>"+data.balance+"</td><td><input type='button' onclick='myDetails('sdfds)' value='Show Details'/></td></tr></table>";
	  		tableData += "<tr><td>"+data.firstName+"</td><td>"+data.lastName+"</td><td>"+data.balance+"</td><td><form name = 'dashboard' method='post' action='dashboard/friend/"+data.friendsEmail+"'><input type='submit' value='Show Details'/></form></td></tr>";
	  	});
	  	tableData +="</table>";
	  	$('#postLoad').html(tableData);
	  	$('#amtowed').val('amtOwed');
	});
	document.getElementById('amtowed').innerHTML = amtOwed;
	document.getElementById('amtowe').innerHTML = amtowe;
	function myFunction()
	{
		var user = json.userid;
	    document.forms['dashboard'].method = 'get';
		document.forms['dashboard'].action ='dashboard/addt/'+user;
		document.forms['dashboard'].submit();
	}
	function logoutFunction()
	{
	    document.forms['dashboard'].method = 'get';
		document.forms['dashboard'].action ='/SmartSplitWeb/logout';
		document.forms['dashboard'].submit();
	}
	
</script>
		
	</body>	
		

</html>