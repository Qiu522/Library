<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>今日图书</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bookInfomation.css" rel="stylesheet">
<link href="css/HomeUpdate.css" rel="stylesheet">
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Metushi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




</script>
<!--webfont-->


</head>
<body>
	<!-- header-section-starts -->
	<div class="header" id="header">
		<div class="container">
			<div class="logo">
				<a href="index.html"><img src="images/logo-l.png" alt="" /></a>
			</div>

			<div class="clearfix"></div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="container">
			<h3>
				<span>书籍</span>是人类进步的阶梯！
			</h3>
		</div>
	</div>
	<div class="container">
		<div class="nav_content">
			<div class="home">
				<a href="index.jsp"><img src="images/home.png" alt="" /></a>
			</div>
		</div>
	</div>
	<div class="userContent">
		<div class="uerInfo">
			<div class="user-title"></div>

		</div>

		<div class="readerUpdate">
			<div class="informationUpdate" style="display: inherit;">
				<table id="table-1">
					<!-- Replace "table-1" with any of the design numbers -->

					<tr style="font-size: 15px">
						<td style="font-size: 15px">用户名:</td>
						<td><input id="readerName" type="text"></td>
					</tr>
					<tr style="font-size: 15px">
						<td style="font-size: 15px">性别:</td>
						<td>男:<input id="sex" name="sex" type="radio" value="1" checked="checked"> &nbsp;&nbsp;&nbsp;
							女:<input id="sex" name="sex" type="radio" value="2"></td>
					</tr>
					<tr style="font-size: 15px">
						<td style="font-size: 15px">年龄</td>
						<td><input maxlength="2" id="age" type="text"></td>
					</tr>
					<tr>
						<td colspan="2">
						    <input style="height: 32px; width: 100px" class="upInform" type="button" value="确认修改">&nbsp;&nbsp;&nbsp;&nbsp;
							<input style="height: 32px; width: 100px" class="upPass" type="button" value="修改密码">&nbsp;&nbsp;&nbsp;&nbsp;
							<input style="height: 32px; width: 100px" class="quit" type="button" value="退出"></td>
					</tr>
				</table>
			</div>
			<div class="passwordUpdate" style="display: none;">
				<table id="table-2">
					<!-- Replace "table-1" with any of the design numbers -->


					<tr>
						<td style="font-size: 15px">请输入密码:</td>
						<td><input maxlength="16" id="password" type="password"></td>
					</tr>
					<tr>
						<td style="font-size: 15px">请确认密码:</td>
						<td><input maxlength="16" id="repassword" type="password"></td>
					</tr>
					<tr>
						<td style="font-size: 15px">请输入验证码:</td>
						<td><input maxlength="4" id="code" type="text"
							style="width: 75px;height: 25px"><img
							src="checkCode.action" id="refCode_update_img" class="code"
							style="height:38px; width:110px;cursor:pointer;"></td>
					</tr>
					<tr>
						<td colspan="2">
						<input style="height: 32px; width: 100px" class="commitPass" type="button" value="确认修改">&nbsp;&nbsp;&nbsp;&nbsp; 
						<input style="height: 32px; width: 100px" class="upinfo" type="button" value="修改信息">&nbsp;&nbsp;&nbsp;&nbsp;
						<input style="height: 32px; width: 100px" class="quit" type="button" value="退出"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>



	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="col-md-4 footer-grid">
					<h5>ABOUT US</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Nulla in purus nibh. Donec ornare felis neque. Nullam tortor
						nulla, sodales quis posuere quis, tristique nec libero. Proin
						vitae convallis odio. Morbi nec enim nisi. Aliquam erat volutpat.
					</p>
				</div>
				<div class="col-md-4 footer-grid">
					<h5>TWITTER FEED</h5>
					<p>
						Check out th best Themes online in the world <br>at <a
							href="mail-to:example@gmail.com">http://example.com </a>
					</p>
					<span>1 day ago</span>
					<p>
						<a href="#">@envanto</a>, Motive wordpress theme full responsive
						is coming soon...
					</p>
					<span>4 day ago</span>
				</div>
				<div class="col-md-4 footer-grid">
					<h5>FOLLOW US</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Nulla in purus nibh. Donec ornare felis neque. Nullam tortor!</p>

					<div class="social-icons">
						<a href="#"><i class="twitter"></i></a> <a href="#"><i
							class="facebook"></i></a> <a href="#"><i class="dribble"></i></a> <a
							href="#"><i class="rss"></i></a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="copyrights">
					<p>
						Copyright &copy; 2015.Company name All rights reserved.<a
							target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
					</p>
				</div>
				<div class="go-top">
					<a href="#header" class="scroll"><img
						src="images/go-to-top.png" alt="" /></a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/HomeUpdate.js"></script>
</body>
</html>

