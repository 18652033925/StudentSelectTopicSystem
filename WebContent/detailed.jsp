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

    <title>所有课题</title>

   
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style type="text/css">
    	.form-control{
    		width:80%;
    	}
    </style>

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
                <a class="navbar-brand" href="index.html">欢迎您${user }</a>
            </div>
            <!-- Top Menu Items -->
           
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
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
                        <a href="index_user.action"><i class="fa fa-fw fa-wrench"></i>个人中心</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<h3 class="text-center text-warning">请填写您的联系方式</h3>
						<form class="form-horizontal" action="selectTopic.action" method="post">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">QQ</label>
								<div class="col-sm-10">
									<input class="form-control" id="qq" name="qq" />
								</div>
							</div>
							<input type="hidden" name="topicId" value="<%=request.getParameter("topicId") %>" />
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">电话</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="tel" name="tel" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">班级</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="grade" name="grade" />
								</div>
							</div>
							<button type="submit" class="btn btn-default btn-info" style="margin-left: 250px">提交</button>
						</form>
					</div>
				</div>
			</div>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>

</body>

</html>
