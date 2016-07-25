<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<!-- CSS -->
<link rel="stylesheet" href=" css/reset.css">
<link rel="stylesheet" href=" css/supersized.css">
<link rel="stylesheet" href=" css/style.css">
</head>
<body>
	<div class="page-container">
		<h1>注册您的信息</h1>
		<span>类别: 计算机网络技术 或 现代通信技术</span>
		<form action="regist.action" method="post">
			<input type="text" id="userNo" name="userNo" class="username" placeholder="学号">
			<input type="text" id="userName" name="userName" class="username" placeholder="姓名">
			<input type="password" id="password" name="password" class="password" placeholder="密码">
			<input type="text" id="stuType" name="stuType" class="username" placeholder="类别">
			<button type="submit">提交</button>
			<div class="error">
				<span>+</span>
			</div>
		</form>
		<div class="connect">
			<p>Or connect with:</p>
			<p>
				<a class="facebook" href=""></a> <a class="twitter" href=""></a>
			</p>
		</div>
	</div>

	<!-- Javascript -->
	<script src="js/jquery-1.8.2.min.js"></script>
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>