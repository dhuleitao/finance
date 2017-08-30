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
	padding-left: 5%;
	padding-bottom: 3%;
	padding-right: 5%;
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
<script>
	function message() {
		var mess="<%=session.getAttribute("update_message")%>";
		if (mess!="null")
		{
			if(mess=="success"){
				alert("修改成功！");
			}
			else{
				alert(mess);
			}
			<%session.putValue("update_message", "null");%>
		}
	}
</script>
</head>

<body onload="message()">
	<!-- topbar starts -->

	<!-- topbar ends -->


	
	<div id="content" class="col-lg-10 col-sm-10">
		<!-- content starts -->
		<div>
			<ul class="breadcrumb">
				<li><a href="#">首页</a></li>
				<li><a href="#">个人信息</a></li>
			</ul>
		</div>

		<div class="row">

			<div class="span12 pagination-centered">
				<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-user"></i> 个人信息
						</h2>

						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round btn-default"><i
								class="glyphicon glyphicon-cog"></i></a> <a href="#"
								class="btn btn-minimize btn-round btn-default"><i
								class="glyphicon glyphicon-chevron-up"></i></a> <a href="#"
								class="btn btn-close btn-round btn-default"><i
								class="glyphicon glyphicon-remove"></i></a>
						</div>
					</div>




					<br>




					<form class="form-inline" role="form"
						action="<%=path%>/users/Users_changePwd.action" method="post">
						<div class="form-group has-success has-feedback">
							<label class="control-label" for="inputSuccess4">当前密码:</label> <input
								type="password" name="p0" class="form-control"
								id="inputSuccess4"> <label class="control-label"
								for="inputSuccess4"> <s:fielderror>
									<s:param>pswError</s:param>
								</s:fielderror></label>
						</div>
						<br /> <br />
						<div class="form-group has-success has-feedback">
							<label class="control-label" for="inputSuccess4">&nbsp&nbsp&nbsp&nbsp新密码:</label>
							<input type="password" name="p1" class="form-control"
								id="inputSuccess4">
						</div>
						<br /> <br />
						<div class="form-group has-success has-feedback">
							<label class="control-label" for="inputSuccess4">确认密码:</label> <input
								type="password" name="p2" class="form-control"
								id="inputSuccess4"> <label class="control-label"
								for="inputSuccess4"> <s:fielderror>
									<s:param>inputError</s:param>
								</s:fielderror></label>
						</div>
						<br /> <br />
						<button class="btn btn-success" type="submit"
							style="margin-left:135px;">
							<i class="glyphicon glyphicon-zoom-in icon-white"></i> 确认
						</button>
					</form>

				</div>

			</div>


			<!--/span-->

		</div>
		<!--/row-->

	</div>

	<!-- Ad ends -->





	<!-- external javascript -->

	<script
		src="<%=path%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- library for cookie management -->
	<script src="<%=path%>/js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script src='<%=path %>/bower_components/moment/min/moment.min.js'></script>
	<script src='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='<%=path %>/js/jquery.dataTables.min.js'></script>

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

