<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Balance</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>  
	
</head>
<body>
${friendsBal}


<script>
   
   
   var json= ${friendsBal};

 
   
 
  
  $(document).ready(function() {
	
	 

		
	 /*  var userIds = $.map(json, function(u) { return u.amtOwed; });
	  alert(userIds); */
	  
	  alert(json.userBalances[0].firstName);
	  
	  var a=json.amtOwed;
	  var c=json.amtOwe;
	  
	  var c=json[1];
	  
	  
	  alert(a);
	  
	  console.log(JSON.stringify(c));

	  
	  
  });
  
</script>


</body>
</html>