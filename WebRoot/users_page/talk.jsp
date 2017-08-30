<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>东华大学财务报销系统</title>
<!--讨论区滚动条begin-->
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resources/css/jscrollpane1.css" />
<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"
	type="text/javascript"></script>
<!-- the mousewheel plugin -->
<script type="text/javascript"
	src="<%=basePath%>resources/js/common/jquery.mousewheel.js"></script>
<!-- the jScrollPane script -->
<script type="text/javascript"
	src="<%=basePath%>resources/js/common/jquery.jscrollpane.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>resources/js/common/scroll-startstop.events.jquery.js"></script>
<!--讨论区滚动条end-->
<script type="text/javascript"
	src="<%=basePath%>resources/js/front/talk.js" charset="utf8"></script>
	
	
	
	
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


<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="<%=path%>/http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->

	
</head>
<body>

	<!-- topbar starts -->

	<!-- topbar ends -->

	<div id="content" class="col-lg-10 col-sm-10">
		<!-- content starts -->
		<div>
			<ul class="breadcrumb">
				<li><a href="#">首页</a></li>
				<li><a href="#">常见问题</a></li>
			</ul>
		</div>

		<!-- 表格开始 -->
		<div class="row">

			<div class="box col-md-12">
				<div class="box-inner">
					<div class="box-header well" data-original-title="">
						<h2>
							<i class="glyphicon glyphicon-user"></i> 常见问题
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
					<div class="box-content">

						<input type="hidden" value="<%=basePath%>" id="basePath" /> <br />
						<div class="talk" style="width:100%;height:100%;">
							<div class="talk_title">
								<span>DHU智能机器人</span>
							</div>
							<div class="talk_record">
								<div id="jp-container" class="jp-container" ></div>
							</div>

							<div class="talk_word">
								&nbsp; <input class="add_face" id="facial" type="button"
									title="添加表情" value="" /> <input id="contents"
									class="messages emotion" /> <input class="talk_send"
									onclick="send();" type="button" title="发送" value="发送" />
							</div>
						</div>
						<div
							style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>

					</div>
				</div>
			</div>
			<!-- 表格结束 -->
			<!--/span-->

		</div>
		<!--/row-->
		
		
		<script
			src="<%=path%>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
		
</body>
</html>