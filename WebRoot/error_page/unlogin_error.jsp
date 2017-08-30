<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'db_error' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta ht p-equiv="cache-cont ol" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<body onload='document.getElementById("relogin").click()'>
	<a id="relogin" href="<%=path%>/error_page/relogin.jsp" target="_top"></a>
	<br>
</body>
</html>
