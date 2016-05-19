<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>  
</head>
<body class="login">
${transaction}
<div id="main-container">
		<div class="row">
            	<div class="col-md-12 col-sm-12">
                	<div class="portlet light ">
                    	<div class="portlet-title">
                        	<div class="caption caption-md">
                            	<i class="icon-bar-chart font-red"></i>
								<h1 id = "head1"></h1>
							<div class="portlet-body">
                            <div class="table-scrollable table-scrollable-borderless">
								<h2 class="caption-subject font-black bold uppercase" id = "head2"></h2>
							</div>
						
		
		<br>
    	<div id="postLoad"></div>
	</div>
	</div>
	</div>
	<form name='deleteexp'>
		<input class="btn btn-transparent red btn-outline btn-circle btn-sm active" type="button" onclick="updateexp()" value="Update Expense"/>
		<input class="btn btn-transparent red btn-outline btn-circle btn-sm active" type="button" onclick="deleteExp()" value="Delete Expense"/>
	</form>
	</div>
	
	</div>
	</div>
	</div>
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
<script>
	var json= ${transaction}; 
	$(document).ready(function () {	  
		//json.totalAmount = Math.abs(parseFloat(json.totalAmount));
	  	var tableData = '<table class="table table-hover table-light"><tr>'+json.firstName+' '+json.lastName+' paid $'+json.totalAmount+'</tr><br><tr>'+json.otherFirstName+' '+json.otherLastName+' owes $'+Math.abs(parseFloat(json.totalAmount - json.amountOwe))+'</tr></table>';
	  	$('#postLoad').html(tableData);
	  	$('#head1').html(json.title);
	  	$('#head2').html(json.category);
	});
	 function deleteExp()
	  {
		alert("This transaction will be deleted!!");		
		document.forms['deleteexp'].action ='deleteexp/'+ json.idTransactions;
		document.forms['deleteexp'].submit();
	  }
	 function updateexp()
	  {
		alert("This Transaction will be updated!!");		
		document.forms['deleteexp'].action ='/SmartSplitWeb/dashboard/updatetrans/'+ json.idTransactions;
		document.forms['deleteexp'].submit();
	  }
</script>
</html>