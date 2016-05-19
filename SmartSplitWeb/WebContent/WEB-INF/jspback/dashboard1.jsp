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
	<meta charset="utf-8" />
        <title>Smart Split | User Login</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/assets/stylesheets/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/assets/stylesheets/simple-line-icons/simple-line-icons.min.css"/>" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/assets/stylesheets/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/assets/stylesheets/uniform/css/uniform.default.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/assets/stylesheets/bootstrap-switch/css/bootstrap-switch.min.css" />" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="<c:url value="/assets/stylesheets/select2/css/select2.min.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/assets/stylesheets/select2/css/select2-bootstrap.min.css" />" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="<c:url value="/assets/stylesheets/components.min.css" />"rel="stylesheet" id="style_components" type="text/css" />
        <link href="<c:url value="/assets/stylesheets/plugins.min.css" />" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN PAGE LEVEL STYLES -->
        <link href="<c:url value="/assets/stylesheets/login.min.css" />" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <!-- END THEME LAYOUT STYLES -->
        </head>
    <!-- END HEAD -->
</head>
<body class="login">
		<div id="main-container" class="row">
            <div class="col-md-12 col-sm-12">
                <div class="portlet light ">
                    <div class="portlet-title">
                        <div class="caption caption-md">
                            <i class="icon-bar-chart font-red"></i>
								<h1 class="caption-subject font-red bold uppercase">My Balance</h1>
					<div class="caption-subject font-black bold uppercase"  style="float:left">You are owed: $</div><div class="caption-subject font-black bold uppercase" id="amtowed"></div><div class="caption-subject font-black bold uppercase" style="float:left"> You owe: $</div><div class="caption-subject font-black bold uppercase" id="amtowe"></div>
		<br>
    	<div id="postLoad"></div>
    	</div>
    	</div>
    	<input type="button" onclick="myFunction()" value="Add Bill" class="btn btn-transparent green btn-outline btn-circle btn-sm active"/>
    	</div>
    	
    	</div>

	</div>

<script>
var json= ${friendsBal}; 
var amtOwed = json.amtOwed;
var amtowe = json.amtOwe;
var who = "owes";

$(document).ready(function () {	  
  	var tableData = '<table class="table table-hover table-light"><tr><td>firstName</td><td>lastName</td><td></td><td>balance</td></tr>';
  	$.each(json.userBalances, function(index, data) {
  		$my_global_var ='dfdsfdsf';// a json object which has title and name property
  		who = "owes";
  		if(parseFloat(data.balance) < 0)
  		{
  			who = "paid";
  			data.balance = Math.abs(parseFloat(data.balance));
  		}
   //	tableData += "<tr><td>"+data.firstName+"</td><td>"+data.lastName+"</td><td>"+data.balance+"</td><td><input type='button' onclick='myDetails('sdfds)' value='Show Details'/></td></tr></table>";
  		tableData += "<tr><td>"+data.firstName+"</td><td>"+data.lastName+"</td><td>"+who+"</td><td>"+data.balance+"</td><td><form name = 'dashboard' method='post' action='dashboard/friend/"+data.friendsEmail+"'><input type='submit' value='Show Details'/></form></td></tr>";
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

	
</script>
		
	</body>	
		

</html>