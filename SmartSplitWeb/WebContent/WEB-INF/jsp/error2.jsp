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
        <title>Smart Split | Erroe</title>
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
        <link href="<c:url value="/assets/stylesheets/error.css" />" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <!-- END THEME LAYOUT STYLES -->
        </head>
    <!-- END HEAD -->
	<body class="page-500-full-page">
	<form name='error2' method='GET'>
        <div class="row">
            <div class="col-md-12 page-500">
                <div class=" number font-red"> Sorry</div>
                <div class=" details">
                    <h3 style="color:white;">Oops! Something went wrong.</h3>
                    <p style="color:white;" > We are fixing it! Please come back in a while.
                        <br/> </p>
                    <p>
                        <a href="index.html" class="btn red btn-outline"> Return to Dashboard </a>
                        <br> </p>
                </div>
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
    <script>
    function gotologin()
    {
    	document.forms['error2'].action ='/SmartSplitWeb/dashboard';
		document.forms['error2'].submit();
    }
    </script>

</html>