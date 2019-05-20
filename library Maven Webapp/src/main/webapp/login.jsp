<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>登录 - 今日图书</title>
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" href="css/login.css">
	</head>

	<body>
		<div class="layui-carousel video_mask" id="login_carousel">
			<div carousel-item>
				<div class="carousel_div1"></div>
				<div class="carousel_div2"></div>
				<div class="carousel_div3"></div>
			</div>
			<div class="login layui-anim layui-anim-up">
				<div class="layui-logo">
					<a href="#" target="_blank"><img src="images/logo.png" /></a>
				</div>
				<fieldset class="layui-elem-field layui-field-title">
					<legend class="text-white">今日图书网上借书平台登录</legend>
				</fieldset>
				<div class="layui-form" action="" method="post">
					<div class="layui-form-item">
						<input type="text" id="account" lay-verify="required|account" maxlength="20" placeholder="请输入用户名" autocomplete="off" autofocus="autofocus" class="layui-input">
					</div>
					<div class="layui-form-item">
						<input type="password" id="password" lay-verify="required" maxlength="20" placeholder="请输入密码" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-item form_code">
						<input type="text" id="code" lay-verify="required|code" maxlength="4" placeholder="请输入验证码" autocomplete="off" class="layui-input">
						<div class="code"><img src="checkCode.action" id="refCode_login_img" class="passcode" style="height:38px; width:110px;cursor:pointer;"></div>
					</div>

					<button id="login" class="login_btn layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="login">登录</button>
					<strong class="text-white">还没有账号？ <a href="regist.jsp" style="color: cornflowerblue;">立即注册&raquo;</a></strong>
				</div>
				<hr class="layui-bg-gray">
				<div class="layui-footer text-white">
					<!-- 底部固定区域 -->
					&copy;xhw&&zyf
				</div>
			</div>
		</div>

		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="layui/layui.all.js"></script>
		<script type="text/javascript" src="js/logins.js"></script>
	</body>

</html>
