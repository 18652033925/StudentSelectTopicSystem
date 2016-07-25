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
    

    <title>所选课题</title>

	
	<script src="js/jquery-3.0.0.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>
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
                    <li class="active">
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
        <h1>我选择的课题</h1>
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>指导老师</th>
						<th>课题名称</th>
						<th>课题类别</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<%
						StudentInfo studentInfo = (StudentInfo) request.getAttribute("selectedTopic");
						List<TopicInfo> topicInfos = (List<TopicInfo>) request.getAttribute("topicAll");
						int i = 1;
						String btn;
						if (studentInfo != null) {
							String str3 = "<button type='button' class='btn btn-default' id='btn'>通知老师</button>      ";
							String str4 = "<a id='modal-926579' href='#modal-container-926579' role='button' class='btn' data-toggle='modal'><button type='button' class='btn btn-default' id='lookTeacherInfo'>查看老师信息</button></a>";
					%>
					<input type="hidden" id="stuNo" value="<%=studentInfo.getStuNo() %>" />
					<input type="hidden" id="stuName" value="<%=studentInfo.getStuName() %>" />
					<input type="hidden" id="teaName" value="<%=studentInfo.getSelectedTeacher() %>" />
					<tr>
						<td><%=studentInfo.getSelectedTeacher()%></td>
						<td><%=studentInfo.getSelectedTopic()%></td>
						<td><%=studentInfo.getStuType()%></td>
						<td><%=str3%><%=str4 %></td>
					</tr>
					<%
						} else if (studentInfo == null) {
							out.print("<span class='label label-danger'>你未选择课程</span>");
						}
					%>
				</tbody>
			</table>
        </div>
        <div class="modal fade" id="modal-container-926579" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">
							所选老师的详细信息
						</h4>
					</div>
					<div class="modal-body" id="text-body"></div>
					<div class="modal-footer">
						 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
        <!-- /#page-wrapper -->

    </div>
	<script type="text/javascript">
		$(function(){
			//Ajax传递到后台，以便发送邮件通知老师
			$("#btn").click(function(){
				$.post("tellTeacher.action",{
					stuNo : $("#stuNo").val(),
					stuName : $("#stuName").val()
				},function(data){
					alert(data);	//发送成功，提示信息
				});
			});
			//Ajax传递后台，以便查看老师信息
			$("#lookTeacherInfo").click(function(){
				$.post("lookTeacherInfo.action",{
					teaName : $("#teaName").val()
				},function(data){
					var json = eval("(" + data + ")");
					console.log(json);
					$.each(json,function(key,value){
						text = "<p>老师姓名：" + value.teaName + "</p><p>老师QQ：" + value.teaQQ + "</p><p>老师办公室：" + value.officeLocation + "</p><p>\n老师所属团队：" + value.team + "</p>";
						
					});
					$("#text-body").html(text);
				});
			});
		});
	</script>
</body>

</html>
