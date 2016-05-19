<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SmartSplit</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href='<c:url value="/assets/stylesheets/bootstrap.css" />'>

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value="assets/stylesheets/font-awesome/css/font-awesome.min.css" />" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="<c:url value="/assets/stylesheets/animate.min.css" />">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value="/assets/stylesheets/creative.css" />">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <script type="text/javascript">
		function onlogin(form)
		{
    		document.forms[form].action ='login';
    		document.forms[form].submit();
		}
		function onregister()
		{
			document.forms['reg'].action ='/SmartSplitWeb/reg';
    		document.forms['reg'].submit();
		}
	</script>

</head>

<body id="page-top">
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
            <a class="navbar-brand page-scroll" href="#page-top">SmartSplit</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <form name='first' method='GET'>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a class="page-scroll" href="#about">About</a>
                </li>
                <li>
                    <a class="page-scroll" href="#services">Services</a>
                </li>
       
                <li>
                    <a class="page-scroll" href="#contact">Contact</a>
                </li>
                 <li>
                    <a class="page-scroll" href="#Login" onclick="onlogin('first')">Login</a>
                </li>
            </ul>
        </div>
        </form>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<header>
    <div class="header-content">
        <div class="header-content-inner">
            <h1>Split expenses with friends</h1>
            <hr>
            <p> Share bills and IOUs. Make sure everyone gets paid back.</p>
            <a href="#about" class="btn btn-primary btn-xl page-scroll">Find Out More</a>
        </div>
    </div>
</header>

<section class="bg-primary" id="about">
<form name='second' method='GET'>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <h2 class="section-heading">IOUs made easy.</h2>
                <hr class="light">
                <p class="text-faded">SmartSplit takes the trouble out of sharing expenses – with friends, with roommates, with anyone.</p>
                <a  href="#login" class="btn btn-default btn-xl" onclick="onlogin('second')">Get Started!</a>
            </div>
        </div>
    </div>
    </form>
</section>

<section id="services">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">Use SmartSplit Today!</h2>
                <hr class="primary">
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6 text-center">
                <div class="service-box">
                    <i class="fa fa-4x fa-diamond wow bounceIn text-primary"></i>
                    <h3>Best way to solve IOUS</h3>
                    <p class="text-muted">We do the math for you.</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 text-center">
                <div class="service-box">
                    <i class="fa fa-4x fa-paper-plane wow bounceIn text-primary" data-wow-delay=".1s"></i>
                    <h3>Payback your Money</h3>
                    <p class="text-muted">Easy to pay someone back.!</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 text-center">
                <div class="service-box">
                    <i class="fa fa-4x fa-newspaper-o wow bounceIn text-primary" data-wow-delay=".2s"></i>
                    <h3>Track your history</h3>
                    <p class="text-muted">We update transaction to keep things fresh.</p>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 text-center">
                <div class="service-box">
                    <i class="fa fa-4x fa-heart wow bounceIn text-primary" data-wow-delay=".3s"></i>
                    <h3>Share with friends</h3>
                    <p class="text-muted">Hangout with friends!</p>
                </div>
            </div>
        </div>
    </div>
</section>

<form name='reg' method='GET'>
	<aside class="bg-dark">
    	<div class="container text-center">
        	<div class="call-to-action">
            	<h2>Free to use SmartSplit!</h2>
            	<a href="#" class="btn btn-default btn-xl wow tada" onclick="onregister()">Register Now!</a>
        	</div>
    	</div>
	</aside>
</form>

<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 text-center">
                <h2 class="section-heading">Let's Get In Touch!</h2>
                <hr class="primary">
                <p>Ready to give SmartSplit a spin? </p>
            </div>
            <div class="col-lg-4 col-lg-offset-2 text-center">
                <i class="fa fa-phone fa-3x wow bounceIn"></i>
                <p>123-456-6789</p>
            </div>
            <div class="col-lg-4 text-center">
                <i class="fa fa-envelope-o fa-3x wow bounceIn" data-wow-delay=".1s"></i>
                <p><a href="mailto:your-email@your-domain.com">feedback@smartSplit.com</a></p>
            </div>
        </div>
    </div>
</section>

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
    