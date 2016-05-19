<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name='register' id='loginForm'  modelAttribute='users' method='POST' action='/SmartSplitWeb/register'>
	<div>
		<table width = "500">
			<thead>
				<tr>
					<td>First name : </td>
					<td><input type="text" name="firstName" id="firstName" /></td>
				</tr>
				<tr>
					<td>Last name : </td>
					<td><input type="text" name="lastName" id="lastName" /></td>
				</tr>
				<tr>
					<td>User name : </td>
					<td><input type="text" id="email" name="email" /></td>
				</tr>
				<tr>
					<td>Password : </td>
					<td><input type="password" name="password" id="password" /></td>
				</tr>
				
			</table>
			<input type="submit" value="Register"/>
		</div>
	</form>
</body>
</html>