<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./images/combined.css"
	charset="GB2312">
<LINK rel="stylesheet" type="text/css" href="./images/thickboxpay.css"
	charset="GB2312">

<script type="text/javascript" src="./images/jquery-1.8.3.js"></script>
<script type="text/javascript" src="./images/JScript.js"></script>
<script type="text/javascript" src="./images/ZeroClipboard.min.js"></script>
<title>报销</title>

<style>
.fkybtn {
	width: 60px;
	heigth: 30px;
	color: #ffffff;
	background-color: #73a839;
	border-color: #73a839;
	heigth: 30px;
}
</style>
<script>
	function message() {
		var mess="<%=session.getAttribute("fin_message")%>";
		if (mess!="null")
		{
			if(mess=="success"){
				alert("报销成功！");
			}
			else{
				alert(mess);
			}
			<%session.setAttribute("fin_message", "null");%>
		}
	}
</script>
</head>
<body onload="message()">
	<br>
	<br>
	<h1 align="center">东华大学财务报销系统</h1>
	<div class="content">

		<div class="order">
			<div class="order_content detail">
				<ul class="clearfix">
					<li><b>项目名称：</b><strong>${sessionScope.temp_pay_project }</strong></li>
					<li><b>收款人：</b><strong>${sessionScope.temp_pay_name }</strong></li>
					<li><b>报销金额：</b><strong>￥${sessionScope.temp_pay_money }</strong></li>
				</ul>

				<div class="findetail">
					<a href="#">报销信息</a>
				</div>
			</div>
		</div>

		<div class="select-tab">
			<ul>


				<li id="tab_SP000003" class=""><a href="#">付款报销</a></li>

			</ul>
		</div>

		<div class="contentwrap">


			<div class="paypanel" style="display: show;">
				<div class="content_left">
					<h4>
						<span>请仔细核对信息.</span>
					</h4>

					<ul class="clearfix">
						<li><span>1.项目名称是否正确</span></li>
						<li><span>2.收款人是否正确 </span></li>
						<li><span>3.金额是否正确 </span></li>
						<li><span>温馨提示:</span></li>
						<li><span>到账时间：付款成功后,<strong>耐心等待10秒钟</strong>.
						</span></li>
						<li><span><strong>---------------------------------------</strong></span></li>
						<li><span><strong>---------------------------------------</strong></span></li>
						<li><span><strong>---------------------------------------</strong></span></li>
					</ul>
					<div>
						<form
							action="<%=path%>/admins/FinanceAdmin_Fin.action?fid=${sessionScope.temp_fin.fid}"
							method="post">
							<div>
								<label><strong>支付密码：</strong></label> <input name="+" value="+"
									style="width:0;height:0;float:left;visibility:hidden" /> <input
									name="pass" type="password" /> <br /> <br /> <br />
							</div>
							<div>
								<button class="fkybtn">确认</button>

							</div>
						</form>
					</div>
					<br /> <br />


				</div>
				<div class="content_right_pc">
					<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
						width="410" height="410" id="demo" align="middle">
						<param name="movie" value="./images/play.swf">
						<param name="quality" value="high">
						<param name="bgcolor" value="#ffffff">
						<param name="play" value="true">
						<param name="loop" value="true">
						<param name="wmode" value="window">
						<param name="scale" value="showall">
						<param name="menu" value="true">
						<param name="devicefont" value="false">
						<param name="salign" value="">
						<param name="allowScriptAccess" value="sameDomain">
						<!--<![endif]-->
					</object>
					<!--[if !IE]>-->
					<object type="application/x-shockwave-flash"
						data="./images/play.swf" width="410" height="410">
						<param name="movie" value="css/img/play.swf">
						<param name="quality" value="high">
						<param name="bgcolor" value="#ffffff">
						<param name="play" value="true">
						<param name="loop" value="true">
						<param name="wmode" value="window">
						<param name="scale" value="showall">
						<param name="menu" value="true">
						<param name="devicefont" value="false">
						<param name="salign" value="">
						<param name="allowScriptAccess" value="sameDomain">
						<!--<![endif]-->
						<a href="http://www.adobe.com/go/getflash"> <img
							src="./images/get_flash_player.gif" alt="获得 Adobe Flash Player">
						</a>
						<!--[if !IE]>-->
					</object>
				</div>
			</div>

		</div>
	</div>


	<div id="footer"></div>
</body>
</html>