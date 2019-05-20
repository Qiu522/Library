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
		<title>注册 - 今日图书</title>
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" href="css/register.css">
	</head>

	<body style="background-image: url(images/login-bg2.jpg);">
		<div class="layui-main user">
			<div class="layui-clear main">
				<div class="layui-logo">
					<a href="#" target="_blank"><img src="images/logo.png" /></a>
				</div>
				<fieldset class="layui-elem-field layui-field-title">
					<legend class="text-white">今日网上借书平台注册</legend>
				</fieldset>
				<div class="layui-form layui-form-pane">
					<div class="layui-form">
						<div class="layui-form-item">
							<input class="layui-input" id="readername" placeholder="请输入用户名" type="text" >
						</div>
						<div class="layui-form-item">
							<input class="layui-input" id="password" placeholder="请输入密码" type="password">
						</div>
						<div class="layui-form-item">
							<input class="layui-input" id="repassword" placeholder="请再次输入密码" type="password" maxlength="20" >
						</div>
						<div class="layui-form-item form_code">
							<input id="code" class="layui-input" placeholder="请输入图片验证码" type="text" maxlength="4">
							<div class="code"><img src="checkCode.action" id="refCode_Regist_img" class="passcode" style="height:38px; width:110px;cursor:pointer;"></div>
						</div>
						
						<div class="layui-form-item" style="float: left;margin-left: -10px;">
							<input lay-filter="agreen-checkbox" title="我同意" type="checkbox" lay-skin="primary" checked>
							<a href="#" target="_blank">《注册协议》</a>
						</div>
						<div class="layui-form-item">
							<button id="reg" type="submit" class="login_btn layui-btn layui-btn-radius layui-btn-normal" lay-submit lay-filter="register">立即注册</button>
						</div>
						<div>
							<small class="text-white">已经有账户了？</small>
							<a href="login.jsp">点此登录</a>
						</div>
					</div>
				</div>
				<hr class="layui-bg-gray">
				<div class="layui-footer text-white">
					<!-- 底部固定区域 -->
					&copy;xhw&&zyf
				</div>
			</div>
		</div>
	</body>

	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="layui/layui.all.js"></script>
	<script type="text/javascript" src="js/register.js"></script>

</html>