<%@page import="org.ssts.entity.TopicInfo"%>
<%@page import="org.ssts.entity.StudentInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>个人中心</title>

   
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elbents and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">欢迎您${user }</a>
                <a class="navbar-brand" href="login.jsp">退出登录</a>
            </div>
            <!-- Top Menu Itbs -->
           
            <!-- Sidebar Menu Itbs - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="index_all.action"><i class="fa fa-fw fa-dashboard"></i> 所有课题</a>
                    </li>
                    <li>
                        <a href="index_network.action"><i class="fa fa-fw fa-bar-chart-o"></i> 计算机网络类课题</a>
                    </li>
                    <li>
                        <a href="index_communication.action"><i class="fa fa-fw fa-table"></i> 现代通信类课题</a>
                    </li>
                    <li>
                        <a href="index_selected.action"><i class="fa fa-fw fa-edit"></i> 我选择的课题</a>
                    </li>
                    <li>
                        <a href="index_search.action"><i class="fa fa-fw fa-desktop"></i> 查询课题</a>
                    </li>
                    <li>
                        <a href="index_user.action"><i class="fa fa-fw fa-wrench"></i>服务中心</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">
        	<h1>修改密码</h1>
        	<b>我的姓名：</b><input type="text" name="myUsername" value="${stu.userName }" disabled="disabled" /><br />
        	<b>我的学号：</b><input type="text" name="myStuNo" id="myStuNo" value="${stu.userNo }" disabled="disabled" /><br />
        	<b>我的类别：</b><input type="text" name="myType" value="${stu.stuType }" disabled="disabled" /><br />
        	<b>请输入原始密码：</b><input type="password" name="oldPassword" id="oldPassword"  /><br />
        	<b>请输入新密码：</b><input type="password" name="newPassword1" id="newPassword1"  /><br />
        	<b>确认密码：</b><input type="password" name="newPassword2" id="newPassword2" /><br />
        	<button type="button" id="btn">提交</button>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="js/jquery-3.0.0.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#btn").click(function(){
    			$.post("changePassword.action",{
    				stuNo : $("#myStuNo").val(),
    				oldPassword : $("#oldPassword").val(),
    				newPassword1 : $("#newPassword1").val(),
    				newPassword2 : $("#newPassword2").val()
    			},function(data){
    				alert(data);
    				location.href = "login.jsp";
    			});
    		});
    	});
    </script>

</body>

</html>
