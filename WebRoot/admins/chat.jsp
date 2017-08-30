<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
   
    .nav li{
        height: 70px;
    }
 
    .carousel img{
        width: 100%;
        height: 100%;
    }
    </style>
    <meta charset="utf-8">
    <title>东华大学财务报销系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="<%=path %>/css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="<%=path %>/css/charisma-app.css" rel="stylesheet">
    <link href='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='<%=path %>/bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='<%=path %>/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='<%=path %>/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='<%=path %>/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='<%=path %>/css/jquery.noty.css' rel='stylesheet'>
    <link href='<%=path %>/css/noty_theme_default.css' rel='stylesheet'>
    <link href='<%=path %>/css/elfinder.min.css' rel='stylesheet'>
    <link href='<%=path %>/css/elfinder.theme.css' rel='stylesheet'>
    <link href='<%=path %>/css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='<%=path %>/css/uploadify.css' rel='stylesheet'>
    <link href='<%=path %>/css/animate.min.css' rel='stylesheet'>

  
 <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="<%=path %>/img/favicon.ico">

</head>

<body>
   <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"> <img alt="Charisma Logo" src="<%=path %>/img/logo20.png" class="hidden-xs"/>
                <span>DHU</span></a>

           <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs">${sessionScope.cur_user.name}</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                   <li><a href="private.jsp">个人信息</a></li>
                    <li class="divider"></li>
                    <li><a href="<%=path%>/users/Users_logout.action">退出</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->


            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> 换肤</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                  <li><a href="<%=path%>/admins/Admins_listmm.action"><i class="glyphicon glyphicon-globe"></i> 常见问题</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> 友情链接 <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">东华大学</a></li>
                        <li><a href="#">东华大学财务处</a></li>
                        <li><a href="#">东华大学教务处</a></li>
                        <li class="divider"></li>
                        <li><a href="#">东华大学信息门户</a></li>
                        <li class="divider"></li>
                        <li><a href="#">东华大学图书馆</a></li>
                    </ul>
                </li>
                <li>
                    <form class="navbar-search pull-left">
                        <input placeholder="Search" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
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
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="<%=path%>/admins/index.jsp"><i class="glyphicon glyphicon-home"></i><span> 首页</span></a>
                        </li>
                        <li><a class="ajax-link" href="<%=path%>/admins/Admins_toInfo.action"><i class="glyphicon glyphicon-eye-open"></i><span> 个人信息</span></a>
                        </li>
                        <li><a class="ajax-link" href="<%=path%>/admins/FinanceAdmin_vFining.action"><i
                                    class="glyphicon glyphicon-edit"></i><span> 待处理<span class="badge">${sessionScope.list_size}</span></span></a></li>
                        <li><a class="ajax-link" href="<%=path%>/admins/FinanceAdmin_vFinsuccess.action"><i class="glyphicon glyphicon-check"></i><span> 已处理</span></a>
                        </li>
                        <li><a class="ajax-link" href="<%=path%>/admins/FinanceAdmin_vFinfail.action"><i class="glyphicon glyphicon-warning-sign"></i><span> 报销失败 </span></a>
                        </li>
                         <li><a class="ajax-link" href="<%=path%>/admins/changepass.jsp"><i class="glyphicon glyphicon-lock"></i><span> 修改密码 </span></a>
                        </li>
                        <li><a class="ajax-link" href="<%=path%>/admins/chat.jsp"><i class="glyphicon glyphicon-bullhorn"></i><span> 报销分析 </span></a>
                        </li>
                    </ul>
                    <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
    <ul class="breadcrumb">
        <li>
            <a href="#">首页</a>
        </li>
        <li>
            <a href="#">财务分析</a>
        </li>
    </ul>
</div>

<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-list-alt"></i> 报销总况     (月份/千元)</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content">
                <div id="stackchart" class="center" style="height:300px;"></div>

              

                <p class="graphControls center">
                    <input class="btn btn-primary" type="button" value="柱状图">
                    <input class="btn btn-primary" type="button" value="折线图">
                    <input class="btn btn-primary" type="button" value="清空">
                </p>
            </div>
        </div>
    </div>

</div><!--/row-->

<div class="row">
    <div class="box col-md-4">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-list-alt"></i> 报销类型分析</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content">
                <div id="piechart" style="height:300px"></div>
            </div>
        </div>
    </div>

    <div class="box col-md-4">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-list-alt"></i> 报销概况浏览</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content">
                <div id="realtimechart" style="height:190px;"></div>
                <p></p>

                <p><a>浏览时间设置:</a> <input id="updateInterval" type="text" value=""
                                                style="text-align: right; width:5em"> h</p>
            </div>
        </div>
    </div>

    <div class="box col-md-4">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-list-alt"></i> 报销学院分析</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content">
                <div id="donutchart" style="height: 300px;">
                </div>
            </div>
        </div>
    </div>
</div><!--/row-->

<!-- chart libraries start -->
<script src="bower_components/flot/excanvas.min.js"></script>
<script src="bower_components/flot/jquery.flot.js"></script>
<script src="bower_components/flot/jquery.flot.pie.js"></script>
<script src="bower_components/flot/jquery.flot.stack.js"></script>
<script src="bower_components/flot/jquery.flot.resize.js"></script>
<!-- chart libraries end -->
<script src="js/init-chart.js"></script>

    <!-- content ends -->
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->

   

    <hr>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>

    
  <footer class="row">
	<p class="col-md-9 col-sm-9 col-xs-12 copyright">
		<a target="_blank">&nbsp;&nbsp;&nbsp;&copy; 软件工程课程设计</a> 2017a
	</p>

	<p class="col-md-3 col-sm-3 col-xs-12 powered-by">
		Powered by: <a>朱骁杰-雷涛-陈一洲&nbsp;&nbsp;&nbsp;</a>
	</p>
</footer>

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="<%=path %>/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="<%=path %>/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='<%=path %>/bower_components/moment/min/moment.min.js'></script>
<script src='<%=path %>/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='<%=path %>/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="<%=path %>/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="<%=path %>/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="<%=path %>/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="<%=path %>/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="<%=path %>/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="<%=path %>/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
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
