<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
<style type="text/css">
.nav li {
	height: 70px;
}

.form-inline {
	padding-left: 30px;
}

.carousel img {
	width: 100%;
	height: 100%;
}
</style>



<meta charset="utf-8">


<!-- The styles -->
<link id="bs-css" href="<%=path%>/css/bootstrap-cerulean.min.css"
	rel="stylesheet">

<link href="<%=path%>/css/charisma-app.css" rel="stylesheet">
<link
	href='<%=path%>/bower_components/fullcalendar/dist/fullcalendar.css'
	rel='stylesheet'>
<link
	href='<%=path%>/bower_components/fullcalendar/dist/fullcalendar.print.css'
	rel='stylesheet' media='print'>
<link href='<%=path%>/bower_components/chosen/chosen.min.css'
	rel='stylesheet'>
<link href='<%=path%>/bower_components/colorbox/example3/colorbox.css'
	rel='stylesheet'>
<link
	href='<%=path%>/bower_components/responsive-tables/responsive-tables.css'
	rel='stylesheet'>
<link
	href='<%=path%>/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<link href='<%=path%>/css/jquery.noty.css' rel='stylesheet'>
<link href='<%=path%>/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%=path%>/css/elfinder.min.css' rel='stylesheet'>
<link href='<%=path%>/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%=path%>/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%=path%>/css/uploadify.css' rel='stylesheet'>
<link href='<%=path%>/css/animate.min.css' rel='stylesheet'>

<!-- jQuery -->
<script src="<%=path%>/bower_components/jquery/jquery.min.js"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="<%=path%>/http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->


</head>

<body>
	<!-- topbar starts -->

	<!-- topbar ends -->



	<div id="content">
		<!-- content starts -->
		<div>
			<ul class="breadcrumb">
				<li><a href="#">我的首页</a></li>
				<li><a href="#"></a></li>
			</ul>
		</div>
		<div class="row">

			<div class="box-content">
				<div id="slidershow" class="carousel" data-ride="carousel"
					data-wrap="true" data-interval="1000">
					<div id="myCarousel" class="carousel slide">
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img src="<%=path %>/img/1.jpg" alt="">
								<div class="carousel-caption">
									<h4>镜月湖</h4>
									<p>云销雨霁&nbsp;彩彻区明</p>
								</div>
							</div>
							<div class="item">
								<img src="<%=path %>/img/2.jpg" alt="">
								<div class="carousel-caption">
									<h4>镜月湖</h4>
									<p>落霞与孤鹜齐飞</p>
								</div>
							</div>
							<div class="item">
								<img src="<%=path %>/img/3.jpg" alt="">
								<div class="carousel-caption">
									<h4>镜月湖</h4>
									<p>秋水共长天一色</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#myCarousel"
							data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
							href="#myCarousel" data-slide="next">&rsaquo;</a>
					</div>
					<script>
    $('.carousel').carousel();
    </script>
					<script src="Finance/bower_components/jquery/jquery.js"></script>
					<script
						src="Finance/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
				</div>
			</div>
		</div>



		<!--/span-->

	</div>
	<!--/row-->



	<!-- Ad ends -->





	<!-- external javascript -->

	<script
		src="<%=path%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- library for cookie management -->
	<script src="<%=path%>/js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script src='<%=path%>/bower_components/moment/min/moment.min.js'></script>
	<script
		src='<%=path%>/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='<%=path%>/js/jquery.dataTables.min.js'></script>

	<!-- select or dropdown enhancer -->
	<script src="<%=path%>/bower_components/chosen/chosen.jquery.min.js"></script>
	<!-- plugin for gallery image view -->
	<script
		src="<%=path%>/bower_components/colorbox/jquery.colorbox-min.js"></script>
	<!-- notification plugin -->
	<script src="<%=path%>/js/jquery.noty.js"></script>
	<!-- library for making tables responsive -->
	<script
		src="<%=path%>/bower_components/responsive-tables/responsive-tables.js"></script>
	<!-- tour plugin -->
	<script
		src="<%=path%>/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<!-- star rating plugin -->
	<script src="<%=path%>/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="<%=path%>/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="<%=path%>/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="<%=path%>/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="<%=path%>/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="<%=path%>/js/charisma.js"></script>
</body>
</html>

