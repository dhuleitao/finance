<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

.carousel img {
	width: 100%;
	height: 100%;
}
.modal-body img {
	width: 100%;
	height: 100%;
}
</style>
<meta charset="utf-8">
<title>东华大学财务报销系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">

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
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="<%=path%>/img/favicon.ico">

<!-- jQuery -->
<script src="<%=path%>/bower_components/jquery/jquery.min.js"></script>

<script>
	function update_financing_count() {
		var flag="<%=session.getAttribute("update_flag")%>";
		
		if(flag=="update"){
			obj = document.getElementById("viewFinancingLink");
			//obj.click();
		}
		<%session.putValue("update_flag", "null");%>
	}
	
	</script>
	
<script>
	window.onresize=function(){
		var ts=document.getElementById("iframepage");
		ts.height=ts.contentWindow.document.documentElement.scrollHeight;
	}
</script>
</head>

<body onload="update_financing_count()">
	<!-- topbar starts -->
	<div class="navbar navbar-default" role="navigation">

		<div class="navbar-inner">
			<button type="button" class="navbar-toggle pull-left animated flip">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=path%>/users_page/home.jsp"> <img
				alt="Charisma Logo" src="<%=path %>/img/logo20.png"
				class="hidden-xs" /> <span>DHU</span></a>

			<!-- user dropdown starts -->
			<div class="btn-group pull-right">
				<button class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i><span
						class="hidden-sm hidden-xs">${sessionScope.cur_user.name}</span> <span
						class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="<%=path%>/users/Users_toInfo.action" target="iframepage">个人信息</a></li>
					<li class="divider"></li>
					<li><a href="<%=path%>/users/Users_logout.action">退出</a></li>
				</ul>
			</div>
			<!-- user dropdown ends -->


			<!-- theme selector starts -->
			<div class="btn-group pull-right theme-container animated tada">
				<button class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<i class="glyphicon glyphicon-tint"></i><span
						class="hidden-sm hidden-xs"> 换肤</span> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" id="themes">
					<li><a data-value="classic" href="#"><i class="whitespace"></i>
							Classic</a></li>
					<li><a data-value="cerulean" href="#"><i
							class="whitespace"></i> Cerulean</a></li>
					<li><a data-value="cyborg" href="#"><i class="whitespace"></i>
							Cyborg</a></li>
					<li><a data-value="simplex" href="#"><i class="whitespace"></i>
							Simplex</a></li>
					<li><a data-value="darkly" href="#"><i class="whitespace"></i>
							Darkly</a></li>
					<li><a data-value="lumen" href="#"><i class="whitespace"></i>
							Lumen</a></li>
					<li><a data-value="slate" href="#"><i class="whitespace"></i>
							Slate</a></li>
					<li><a data-value="spacelab" href="#"><i
							class="whitespace"></i> Spacelab</a></li>
					<li><a data-value="united" href="#"><i class="whitespace"></i>
							United</a></li>
				</ul>
			</div>
			<!-- theme selector ends -->

			<ul class="collapse navbar-collapse nav navbar-nav top-menu">
				<li><a data-toggle="modal" href="#mymodal" target="iframepage"><i class="glyphicon glyphicon-globe"></i>
						微信公众号</a></li>
	<!-- 模态弹出窗 -->
<div class="modal fade"  id="mymodal" >
    <div class="modal-dialog" style="width:30%">
        <div class="modal-content" >
        <!-- 模态弹出窗内容 -->
        <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title  glyphicon glyphicon-camera "> 微信扫一扫 </h4>
                <h11 class="glyphicon glyphicon-hand-down"></h11>
            </div>
            <div class="modal-body">
             
              <img src="img/11.jpg" class="img-rounded img-responsive ">
            </div>
            <div class="modal-footer">
  
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
            
          <!-- 模态弹出窗内容 -->
        </div>
    </div>
</div> 
				<li class="dropdown"><a href="#" data-toggle="dropdown"><i
						class="glyphicon glyphicon-star"></i> 友情链接 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">东华大学</a></li>
						<li><a href="#">东华大学财务处</a></li>
						<li><a href="#">东华大学教务处</a></li>
						<li class="divider"></li>
						<li><a href="#">东华大学信息门户</a></li>
						<li class="divider"></li>
						<li><a href="#">东华大学图书馆</a></li>
					</ul></li>
				<li>
					<div class="navbar-search pull-left">
						<input placeholder="Search"
							class="search-query form-control col-md-10" name="query"
							type="text">
					</div>
				</li>
			</ul>

		</div>
	</div>
	<!-- topbar ends -->
	<div class="ch-container">
		<div class="row">

			<!-- left menu starts -->
			<div class="col-sm-2 col-lg-2">
				<div class="sidebar-nav">
					<div class="nav-canvas">
						<div class="nav-sm nav nav-stacked"></div>
						<ul class="nav nav-pills nav-stacked main-menu">
							<li class="nav-header">菜单</li>
							<li><a class="ajax-link"
								<%-- 								href="<%=path%>/users/Users_toMessage.action" target="iframepage"><i --%>
								href="<%=path%>/users_page/message.jsp"
								target="iframepage"><i class="glyphicon glyphicon-home"></i><span>
										我的首页</span></a></li>
							<li><a class="ajax-link"
								href="<%=path%>/users/Users_toApply.action" target="iframepage"><i
									class="glyphicon glyphicon-home"></i><span> 申请报销</span></a></li>
							<li><a class="ajax-link" id="viewFinancingLink"
								href="<%=path%>/users/Finance_viewFinancing.action"
								target="iframepage"><i class="glyphicon glyphicon-eye-open"></i><span>
										正在报销</a></li>
							<li><a class="ajax-link"
								href="<%=path%>/users/Finance_viewFinsuccess.action"
								target="iframepage"><i class="glyphicon glyphicon-edit"></i><span>
										报销成功</span></a></li>
							<li><a class="ajax-link"
								href="<%=path%>/users/Finance_viewFinfailed.action"
								target="iframepage"><i class="glyphicon glyphicon-list-alt"></i><span>
										报销失败</span></a></li>
							<li><a class="ajax-link"
								href="<%=path%>/users/Finance_viewFincanceled.action"
								target="iframepage"><i class="glyphicon glyphicon-font"></i><span>
										撤销日志</span></a></li>
							<li><a class="ajax-link"
								href="<%=path%>/users/Users_toInfo.action" target="iframepage"><i
									class="glyphicon glyphicon-picture"></i><span> 个人信息</span></a></li>
							<li><a class="ajax-link"
								href="<%=path%>/users/Users_toPwd.action" target="iframepage"><i
									class="glyphicon glyphicon-picture"></i><span> 修改密码</span></a></li>
						</ul>
					</div>
				</div>
			</div>
			<!--/span-->
			<!-- left menu ends -->

			<noscript>
				<div class="alert alert-block col-md-12">
					<h4 class="alert-heading">Warning!</h4>

					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>



			<div id="content" class="col-lg-10 col-sm-10">
				<!-- content starts -->

				<div class="box col-md-12">

					<div class="box-contend">
						<iframe src="<%=path%>/users_page/message.jsp" id="iframepage"
							name="iframepage" scrolling="no" width="100%" frameborder="0"
							onload="this.height=this.contentWindow.document.documentElement.scrollHeight"></iframe>
					</div>

				</div>
				<!--/span-->

			</div>
			<!--/row-->


			<!-- content ends -->
		</div>
		<!--/#content.col-md-0-->
	</div>
	<!--/fluid-row-->
</body>
<hr>
<footer class="row">
	<p class="col-md-9 col-sm-9 col-xs-12 copyright">
		<a target="_blank">&nbsp;&nbsp;&nbsp;&copy; 软件工程课程设计</a> 2017a
	</p>

	<p class="col-md-3 col-sm-3 col-xs-12 powered-by">
		Powered by: <a>朱骁杰-雷涛-陈一洲&nbsp;&nbsp;&nbsp;</a>
	</p>
</footer>


<!--/.fluid-container-->

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
<script src="<%=path%>/bower_components/colorbox/jquery.colorbox-min.js"></script>
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

