<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function onsubmitaddbill()
{
	alert('hiiiiiiiii');
	var user = ${userid};
	document.forms['addbill'].action ='newbill/'+user;
	//document.forms['addbill'].submit();
}
</script>
</head>
<body>
	<form name='addbill' modelAttribute='transaction' method='POST' action='newbill/${userid}'>
		<div>
			<Table>
				<tr><td><input type="text" readonly="readonly" id = "addedBy" name="addedBy" value="${userid}"/></td><td> and</td><td><input type="text" name="addedTo"/></td></tr>
				<tr><td>Category: </td><td><input type="text" name="category"/></td></tr>
				<tr><td>Description: </td><td><input type="text" name="title"/></td></tr>
				<tr><td>Total: </td><td><input type="text" name="totalAmount"/></td></tr>
				<tr><td>Owed: </td><td><input type="text" name="amountOwe"/></td></tr>
			</Table>
		</div>
		<input type="submit" value="Add"/>
	</form>
</body>
</html>