<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String picPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/Finance_upload_pics/";
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

.file {
	position: relative;
	display: inline-block;
	background: #D0EEFF;
	border: 1px solid #99D3F5;
	border-radius: 4px;
	padding: 4px 12px;
	overflow: hidden;
	color: #1E88C7;
	text-decoration: none;
	text-indent: 0;
	line-height: 20px;
}

.file input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
}

.file:hover {
	background: #AADFFD;
	border-color: #78C3F3;
	color: #004974;
	text-decoration: none;
}

.btn-file {
	position: relative;
	overflow: hidden;
}

.btn-file input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	min-width: 100%;
	min-height: 100%;
	font-size: 100px;
	text-align: right;
	filter: alpha(opacity = 0);
	opacity: 0;
	outline: none;
	background: white;
	cursor: inherit;
	display: block;
}
</style>
<meta charset="utf-8">


<!-- The styles -->
<link id="bs-css" href="<%=path %>/css/bootstrap-cerulean.min.css"
	rel="stylesheet">

<link href="<%=path %>/css/charisma-app.css" rel="stylesheet">
<link
	href='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.css'
	rel='stylesheet'>
<link
	href='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.print.css'
	rel='stylesheet' media='print'>
<link href='<%=path %>/bower_components/chosen/chosen.min.css'
	rel='stylesheet'>
<link href='<%=path %>/bower_components/colorbox/example3/colorbox.css'
	rel='stylesheet'>
<link
	href='<%=path %>/bower_components/responsive-tables/responsive-tables.css'
	rel='stylesheet'>
<link
	href='<%=path %>/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
	rel='stylesheet'>
<link href='<%=path %>/css/jquery.noty.css' rel='stylesheet'>
<link href='<%=path %>/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%=path %>/css/elfinder.min.css' rel='stylesheet'>
<link href='<%=path %>/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%=path %>/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%=path %>/css/uploadify.css' rel='stylesheet'>
<link href='<%=path %>/css/animate.min.css' rel='stylesheet'>

<!-- jQuery -->
<script src="<%=path%>/bower_components/jquery/jquery.min.js"></script>
<script src="<%=path%>/js/pic.js" type="text/javascript"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="<%=path%>/http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->
<script>
	$(function() {
		$("#file").uploadPreview({
			Img : "pic",
			Width : 280,
			Height : 500
		});
	});
</script>


<script>
	function message() {
		var mess="<%=session.getAttribute("apply_message")%>";
		if (mess!="null")
		{
			if(mess=="success"){
				alert("重新申请成功！");
				location.href = "<%=path%>/users_page/financing.jsp";
			}
			else{
				alert(mess);
			}
			<%session.putValue("apply_message", "null");%>
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
				<li><a href="#">失败报销单修改</a></li>
			</ul>
		</div>
		<div class="row">

			<div class="box-inner">
				<div class="box-header well" data-original-title="">
					<h2>
						<i class="glyphicon glyphicon-user"></i> 失败报销单修改
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

				<form class="form-inline" role="form" method="post" enctype="multipart/form-data"
					action='<%=path%>/users/Finance_failedRefin.action?fid=<s:property value="#session.temp_fin.fid"/>'>
					<table>
						<tr>
							<td><input type="hidden" class="form-control"
								id="inputSuccess4" name="fid"
								value='<s:property value="#session.temp_fin.fid"/>'>

								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">发票号码:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="fnum"
										value='<s:property value="#session.temp_fin.fnum"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">发票类型:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="type"
										value='<s:property value="#session.temp_fin.type"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">发票代码:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="serial"
										value='<s:property value="#session.temp_fin.serial"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">申&nbsp;&nbsp;请&nbsp;&nbsp;人:</label>
									<input readonly type="text" class="form-control"
										id="inputSuccess4" name="applyname"
										value='<s:property value="#session.temp_fin.applyname"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
									<input readonly type="text" class="form-control"
										id="inputSuccess4" name="jnum"
										value='<s:property value="#session.temp_fin.jnum"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">项目名称:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="projectname"
										value='<s:property value="#session.temp_fin.projectname"/>'>
								</div></td>
							<td>
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">申报金额:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="money"
										value='<s:property value="#session.temp_fin.money"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">银行卡号:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="cardnum"
										value='<s:property value="#session.temp_fin.cardnum"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">开&nbsp;&nbsp;户&nbsp;&nbsp;名:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="cardname"
										value='<s:property value="#session.temp_fin.cardname"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">开户类型:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="cardtype"
										value='<s:property value="#session.temp_fin.cardtype"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">申请日期:</label>
									<input readonly type="text" class="form-control"
										id="inputSuccess4"
										value='<s:date name="#session.temp_fin.applydate" format="yyyy-MM-dd"/>'>
								</div> <br> <br />
								<div class="form-group has-success has-feedback">
									<label class="control-label" for="inputSuccess4">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</label>
									<input type="text" class="form-control" id="inputSuccess4"
										name="comment"
										value='<s:property value="#session.temp_fin.comment"/>'>
								</div>
							</td>
							
							<td style="text-align:center;vertical-align:middle;"><img
								id="pic" class="img-responsive"
								style="height:280px;width:500px;border:3px  double #545565;"
								src='<%=picPath%>/<s:property value="#session.temp_fin.imgPath"/>' /> <br /> <br /> <span
								class="btn btn-default btn-file btn-info"> 更改图片 <input
									name="file" id="file" type="file">
							</span></td>
						</tr>
						<tr>
							<td>
								<button class="btn btn-success" style="margin-left:35%"
									onclick="javascript:history.back(-1);">
									<i class="glyphicon glyphicon-zoom-in icon-white"></i> 返回
								</button> <br> <br> <br>
							</td>
							<td><button class="btn btn-info" type="submit">
									<i class="glyphicon glyphicon-edit icon-white"></i> 重新申请
								</button> <br> <br> <br></td>

						</tr>
					</table>
				</form>
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

