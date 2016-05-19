<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Friend</title>
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
<body class="login">
<div id="main-container">
	<div class="row">
            	<div class="col-md-12 col-sm-12">
                	<div class="portlet light ">
                    	<div class="portlet-title">
                        	<div class="caption caption-md">
                            	<i class="icon-bar-chart font-red"></i>
									<h1 id = "frnm"></h1>
		
							</div>
		<div class="portlet-body">
                 <div class="table-scrollable table-scrollable-borderless">
		<h2 class="caption-subject font-black bold uppercase" id = "frtot"></h2>
		</div>
		<br>
    	<div id="postLoad"></div>
    	</div>
    	</div>
    	<input  class="btn btn-transparent green btn-outline btn-circle btn-sm active" type="button" id="settleButton" onclick="settleUp()" value="Settle Balance Amount"/>
    	</div>
    	</div>
    	</div>
	</div>
	


<script>
   var json = ${friendsTransactions}; 
   var name = json.firstName;
   var checkbutton = json.whoOwesWho;
   var fullname = json.firstName + " " + json.lastName;
  $(document).ready(function() {
	  var tableData = '<table class="table table-hover table-light"><tr><td>Added By</td><td>category</td><td>title</td><td>amountOwe</td></tr>';
	  	$.each(json.transactions, function(index, data) {
	   	//tableData += '<tr><td>'+data.firstName+" "+data.lastName+'</td><td>'+data.category+'</td><td>'+data.title+'</td><td>'+data.amountOwe+'</td><td><input type="button" onclick="myDetails()" value="Show Details"/></td></tr>';
	  	 tableData += "<tr><td>"+data.firstName+" "+data.lastName+"</td><td>"+data.category+"</td><td>"+data.title+"</td><td>"+data.amountOwe+"</td><td><form name='friendform' method='post' action='transaction/"+data.idTransactions+"'><input type='submit' value='Show Details'/></form></td></tr>";

	  	});
	  	tableData +="</table>";
	  	$('#postLoad').html(tableData);
  });
  document.getElementById(id = 'frnm').innerHTML = name +" "+ json.lastName;
  document.getElementById(id = 'frtot').innerHTML = json.whoOwesWho +" $"+ json.totalAmt;
if(checkbutton == "owes you")
	  {
  		document.getElementById("settleButton").disabled = true;
	  }
  
  function settleUp()
  {
	alert("Hi " + fullname + " " + checkbutton+ " " + json.totalAmt +" "+"ready to payback?");		
	var amount = json.totalAmt;
	var newstring =  fullname + "-" + checkbutton+ "-" + json.totalAmt;
	document.forms['friendform'].action ='settleup/'+ newstring;
	document.forms['friendform'].submit();
  }
</script>
<!-- BEGIN CORE PLUGINS -->
        <script src='<c:url value="/assets/javascripts/jquery.js" />'></script>
        <script src='<c:url value="/assets/javascripts/bootstrap.min.js" />'></script>
        <script src='<c:url value="/assets/javascripts/js.cookie.min.js"/>'></script>
                <script src='<c:url value="/assets/javascripts/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" />'></script>
        <script src='<c:url value="/assets/javascripts/jquery-slimscroll/jquery.slimscroll.min.js"/>'></script>
        <script src='<c:url value="/assets/javascripts/jquery.blockui.min.js" />'></script>
        <script src='<c:url value="/assets/stylesheets/uniform/jquery.uniform.min.js"  />'></script>
        <script src='<c:url value="/assets/stylesheets/bootstrap-switch/js/bootstrap-switch.min.js" />'></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
         <script src='<c:url value="/assets/javascripts/jquery-validation/js/jquery.validate.min.js" />'></script>
        <script src='<c:url value="/assets/javascripts/jquery-validation/js/additional-methods.min.js" />'></script>
        <script src='<c:url value="/assets/stylesheets/select2/js/select2.full.min.js" />'></script>
        <!-- BEGIN PAGE LEVEL SCRIPTS -->
        <script src='<c:url value="/assets/javascripts/login.js" />'></script>
        <!-- END PAGE LEVEL SCRIPTS -->
        <!-- BEGIN THEME LAYOUT SCRIPTS -->
        <!-- END THEME LAYOUT SCRIPTS -->
</body>

</html>