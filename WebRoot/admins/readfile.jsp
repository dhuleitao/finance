<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'readfile.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<script>
	function read() {
		var fso,
			ts,
			s;
		var ForReading = 1;

		alert(1);
		fso = new ActiveXObject("Scripting.FileSystemObject");
		ts = fso.OpenTextFile("D:/Project/MyEclipse/fff/readfile/readfile.txt", ForReading);
		s = ts.ReadLine();
		alert(s);

		document.getElementById("aa").value = s;
		alert(s);
	}

	function readTextFile(file) {
		var rawFile = new XMLHttpRequest();
		rawFile.open("GET", file, false);
		rawFile.onreadystatechange = function() {
			if (rawFile.readyState === 4) {
				if (rawFile.status === 200 || rawFile.status == 0) {
					var allText = rawFile.responseText;
					alert(allText);
				}
			}
		}
		rawFile.send(null);
	}

	function test() {
	}
</script>

<%
	String str = "str:";
	String temp = "";
	try {
		FileReader reader = new FileReader("D:/Project/MyEclipse/fff/readfile/readfile.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuffer txt = new StringBuffer();

		while ((temp = bufferedReader.readLine()) != null) {
			txt.append(temp);
			str += temp;
		}
		bufferedReader.close();
		RF rf = new RF();
		session.setAttribute("ff", str);
		System.out.println("ffffffss");
	} catch (Exception e) {
		out.println("An exception occurred: " + e.getMessage());
	}
	
	
%>


<body>
	<%!public class RF {
		RF() {
		}

		String read() {
			return "111";
		}
	}%>


	<form method="get">
		<input type="text" name="text" value="<%=str%>" />
		<button type="submit">按鈕</button>

	</form>
	<input type="text" name="what" value="<%=str%>" />
	<textarea rows="20" cols="60">
	<%=str%>
</textarea>
	<input id="aa" value="fff"></input>
	<button
		onclick="readTextFile('file:///D:/Project/MyEclipse/fff/readfile/readfile.txt')">read
		file</button>
</body>
</html>
