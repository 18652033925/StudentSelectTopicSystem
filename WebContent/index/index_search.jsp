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

    <title>查询课题</title>
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
            <!-- Top Menu Items -->
           
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
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
                    <li class="active">
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
        <h1>查询课题</h1>
    		<input type="text" id="searchText" value="请输入老师姓名或者课题名称" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"/>
			<button id="btnText">查询</button>
			<br /> <br /> <br />
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>编号</th>
						<th>指导老师</th>
						<th>课题名称</th>
						<th>课题类别</th>
						<th>是否可选</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="one">
				</tbody>
			</table>
        </div>
        <!-- /#page-wrapper -->

    </div>
    <input type="hidden" value="${n }" id="n"/>
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
		$(function() {
			var n = $("#n").val(); //获取之前做的标记，表示该学生有没有选题
			$("#btnText").click(function() {
				$("#one").html("");	//显示查询数据前先清除原来的内容
				$.post("search.action", {
					search : $("#searchText").val()
				}, function(data) {
					var i = 1;
					var json = eval("(" + data + ")");	//将获取到的数据转为json格式
					$.each(json,function(key,value){
						var isSelected ;
						var btn ;
						var id = value.topicId;
						if(n == 1){	//该学生还未选题，显示出可以选题的按钮
							if(value.isSelectd == 0){
								isSelected = "<span class='label label-danger'>不可选</span>";
								btn = "<button type='button' class='btn btn-default disabled' id='selected'>选择</button>";
							} else {
								isSelected = "<span class='label label-primary'>可选</span>";
								btn = "<a href='detailed.jsp?topicId=" + id + "'><button type='button' class='btn btn-default' id='selected'>选择</button></a>";
							}
						}
						else { 	//该学生已经选题，无法选题，显示不可点击的按钮
							isSelected = "<span class='label label-danger'>不可选</span>";
							btn = "<button type='button' class='btn btn-default disabled' id='selected'>已选择其他课程,无法重复选择</button>";
						}
						var str = "<tr>";
						str += "<td>" + i++ + "</td>" + "<td>" + value.topicTea + "</td>" + "<td>" + value.topicName + "</td>" + "<td>" + value.topicType + "</td>" + "<td>" + isSelected + "</td>" + "<td>" + btn + "</td>";
						str += "</tr>";
						$("#one").append(str);
					});
				});
			});
		});
	</script>
</body>

</html>
