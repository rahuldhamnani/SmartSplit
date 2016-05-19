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
<script type="text/javascript">
function onsubmitform()
{
    var user = document.getElementById('userid').value;
	document.login.action ='/SmartSplitWeb/dashboard/'+user;
  return true;
}
</script>
</head>
<body>
<form name='login' method='GET' onsubmit='return onsubmitform();'>
	<Table>
		<tr><td>Email: </td><td><input type="text" id = "userid" name="userid"/></td></tr>
		<tr><td>Password: </td><td><input type="password" name="pswrd"/></td></tr>
		<tr><td><input type="submit" value="Login"/></td></tr>
		<tr><td><input type="reset" value="Reset"/></td></tr>
	</Table>
</form>
</body>
</html>