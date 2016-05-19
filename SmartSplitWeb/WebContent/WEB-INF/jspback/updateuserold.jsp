<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Account</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
</head>
<body>
${user}
<form name='upUser' modelAttribute='updateUser' method='POST' onsubmit="updateuser()">
		<div>
			<Table>
				<tr><td>Email : </td><td><input type="text" readonly="readonly" id = "email" name="email" /></td></tr>
				<tr><td>First Name : </td><td><input type="text" id="firstName" name="firstName"/></td></tr>
				<tr><td>Last Name: </td><td><input type="text" id="lastName" name="lastName"/></td></tr>
				<tr><td>Password: </td><td><input type="text" id="password" name="password"/></td></tr>
			</Table>
		</div>
		<input type="submit" value="Update"/>
		</form>
</body>
<script>
	var json= ${user};
	
		$(document).ready(function () {	
		
		});
		document.getElementById('email').value = json.email;
		document.getElementById('firstName').value = json.firstName;
		document.getElementById('lastName').value = json.lastName;
		document.getElementById('password').value = json.password;
	
		function updateuser()
		{
			document.forms['upUser'].action ='/SmartSplitWeb/updateusr';
			document.forms['upUser'].submit();
		}
</script>
</html>