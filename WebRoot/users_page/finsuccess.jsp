<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<script
	src="<%=path %>/bower_components/jquery/jquery.min.js"></script>

<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="<%=path %>/http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- The fav icon -->


</head>

<body>


	<div id="content" class="col-lg-10 col-sm-10">
		<!-- content starts -->
		<div>
			<ul class="breadcrumb">
				<li><a href="#">首页</a></li>
				<li><a href="#">报销完成</a></li>
			</ul>
		</div>

		<div class="row">

			<div class="box-inner">
				<div class="box-header well" data-original-title="">
					<h2>
						<i class="glyphicon glyphicon-user"></i> 报销完成
						&nbsp;&nbsp; &nbsp;&nbsp;<i class="glyphicon glyphicon-print" ></i><a href="<%=path%>/admins/Finance_pFinsuccess2.action"> 打印</a>
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

					<table
						class="table table-striped table-bordered bootstrap-datatable datatable responsive">
						<thead>
							<tr>
								<th>单号</th>
								<th>类型</th>
								<th>发票</th>
								<th>申请</th>
								<th>工号</th>
								<th>项目</th>
								<th>金额</th>
								<th>卡号</th>
								<th>户名</th>
								<th>日期</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#session.temp_list" var="fin">
								<tr class="list">
									<td><s:property value="#fin.fnum" /></td>
									<td><s:property value="#fin.type" /></td>
									<td><s:property value="#fin.serial" /></td>
									<td><s:property value="#fin.applyname" /></td>
									<td><s:property value="#fin.jnum" /></td>
									<td><s:property value="#fin.projectname" /></td>
									<td><s:property value="#fin.money" /></td>
									<td><s:property value="#fin.cardnum" /></td>
									<td><s:property value="#fin.cardname" /></td>
									<td><s:date name="#fin.applydate" format="yyyy年MM月dd日" /></td>
									<td><s:property value="#fin.comment" /></td>
									<td><a class="btn btn-info"
										href='<%=path%>/users/Finance_detail.action?
										type=Finsuccess&fid=<s:property value="#fin.fid"/>'>
											<i class="glyphicon glyphicon-edit icon-white"></i> 详情
									</a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!--/span-->

	</div>
	<!--/row-->










	<!-- Ad, you can remove it -->


	</div>
	<!--/.fluid-container-->

	<!-- external javascript -->

	<script
		src="<%=path %>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- library for cookie management -->
	<script src="<%=path %>/js/jquery.cookie.js"></script>
	<!-- calender plugin -->
	<script src='<%=path %>/bower_components/moment/min/moment.min.js'></script>
	<script
		src='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='<%=path %>/js/jquery.dataTables.min.js'></script>

	<!-- select or dropdown enhancer -->
	<script src="<%=path %>/bower_components/chosen/chosen.jquery.min.js"></script>
	<!-- plugin for gallery image view -->
	<script
		src="<%=path %>/bower_components/colorbox/jquery.colorbox-min.js"></script>
	<!-- notification plugin -->
	<script src="<%=path %>/js/jquery.noty.js"></script>
	<!-- library for making tables responsive -->
	<script
		src="<%=path %>/bower_components/responsive-tables/responsive-tables.js"></script>
	<!-- tour plugin -->
	<script
		src="<%=path %>/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
	<!-- star rating plugin -->
	<script src="<%=path %>/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="<%=path %>/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="<%=path %>/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="<%=path %>/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="<%=path %>/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="<%=path %>/js/charisma.js"></script>


</body>
</html>

