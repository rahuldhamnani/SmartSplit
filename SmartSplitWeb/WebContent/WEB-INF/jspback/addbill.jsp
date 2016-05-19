<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->

    <head>
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
    <!-- END HEAD -->

    <body class="login">
        <form name='addbill' modelAttribute='transaction' method='POST' action='newbill/${userid}'>
			<div class="row">
            	<div class="col-md-12 col-sm-12">
                	<div class="portlet light ">
                    	<div class="portlet-title">
                        	<div class="caption caption-md">
                            	<i class="icon-bar-chart font-red"></i>
                            	<span class="caption-subject font-red bold uppercase">Add Bill</span>
                        	</div>
                        
                        <div class="portlet-body">
                            <div class="table-scrollable table-scrollable-borderless">
                                <table class="table table-hover table-light">
                                    <input type="text" readonly="readonly" id = "addedBy" name="addedBy" value="${userid}"/><p class="caption-subject font-black bold uppercase">and</p><input type="text" name="addedTo"/>
                                    <tr><td>Category: </td><td><input type="text" name="category"/></td></tr>
                                    <tr><td>Description: </td><td><input type="text" name="title"/></td></tr>
                                    <tr><td>Total: </td><td><input type="text" name="totalAmount"/></td></tr>
                                    <tr><td>Owed: </td><td><input type="text" name="amountOwe"/></td></tr>
                                </table>
                            </div>
                        </div>
                        <Button class="btn btn-transparent green btn-outline btn-circle btn-sm active">
                                            Add</Button>
                    </div>
                </div>
              </form>
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