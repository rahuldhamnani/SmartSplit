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
        <title>Smart Split | Dashboard</title>
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
        <link rel="stylesheet" href="<c:url value="/assets/stylesheets/creative.css" />">
         <link rel="stylesheet" href="<c:url value="/assets/stylesheets/animate.min.css" />">
         <link rel="stylesheet" href='<c:url value="/assets/stylesheets/bootstrap.css" />'>
         
        <!-- END PAGE LEVEL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <!-- END THEME LAYOUT STYLES -->
        </head>
    <!-- END HEAD -->
</head>
<body class="login" id="page-top">
		<div id="main-container" class="row ">
			<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand page-scroll" href="#page-top" onclick="redirect()">SmartSplit</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <form name='first' method='GET'>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
            	 <li>
            	 	 <a class="btn btn-warning" href="#" onclick="edituser()">
  					<i class="fa fa-cog" aria-hidden="true"></i>Profile</a>
            	 </li>
                 <li>
                    <a  class="btn btn-danger" href="#Logout" onclick="logoutFunction()">Logout</a>
                </li>
            </ul>
        </div>
        </form>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<section>
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
    		<form name = 'dashboardfun' method='post'>
    	
    	<input type="button" onclick="myFunction()" value="Add Bill" class="btn btn-transparent red btn-outline btn-circle btn-sm active"/>
    	    	</form>
    	
    	</div>
    	
    	</div>

	</div>
	</section>
<script>
var json= ${friendsBal}; 
var amtOwed = json.amtOwed;
var amtowe = json.amtOwe;
var who = "owes";

$(document).ready(function () {	  
  	var tableData = '<table class="table table-hover table-light"><tr><th>First Name</th><th>Last Name</th><th></th><th>Amount</th></tr>';
  	$.each(json.userBalances, function(index, data) {
  		$my_global_var ='dfdsfdsf';// a json object which has title and name property
  		who = "owes";
  		if(parseFloat(data.balance) < 0)
  		{
  			who = "paid";
  			data.balance = Math.abs(parseFloat(data.balance));
  		}
   //	tableData += "<tr><td>"+data.firstName+"</td><td>"+data.lastName+"</td><td>"+data.balance+"</td><td><input type='button' onclick='myDetails('sdfds)' value='Show Details'/></td></tr></table>";
  		tableData += "<tr><td>"+data.firstName+"</td><td>"+data.lastName+"</td><td>"+who+"</td><td>"+data.balance+"</td><td><form name = 'dashboard' method='post' action='dashboard/friend/"+data.friendsEmail+"'><input class='btn btn-transparent green btn-outline btn-circle btn-sm active' type='submit' value='Show Details'/></form></td></tr>";
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
    document.forms['dashboardfun'].method = 'get';
	document.forms['dashboardfun'].action ='dashboard/addt/'+user;
	document.forms['dashboardfun'].submit();
}
function logoutFunction()
{
    document.forms['first'].method = 'get';
	document.forms['first'].action ='/SmartSplitWeb/logout';
	document.forms['first'].submit();
}
function edituser()
{
	document.forms['dashboardfun'].method = 'get';
	document.forms['dashboardfun'].action ='dashboard/updateuser';
	document.forms['dashboardfun'].submit();
}
function redirect()
{
	window.location="http://localhost:8080/SmartSplitWeb/dashboard"
	}	
</script>
<!-- jQuery -->
<script src='<c:url value="/assets/javascripts/jquery.js" />'></script>

<!-- Bootstrap Core JavaScript -->
<script src='<c:url value="/assets/javascripts/bootstrap.min.js" />'></script>

<!-- Plugin JavaScript -->
<script src='<c:url value="/assets/javascripts/jquery.easing.min.js"/>'></script>
<script src='<c:url value="/assets/javascripts/jquery.fittext.js" />'></script>
<script src='<c:url value="/assets/javascripts/wow.min.js" />'></script>

<!-- Custom Theme JavaScript -->
<script src='<c:url value="/assets/javascripts/creative.js"/>'></script>
</body>	


</html>