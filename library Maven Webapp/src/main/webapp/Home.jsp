<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<title>今日图书</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bookInfomation.css" rel="stylesheet">
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Metushi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
 <script src="js/init.js"></script>
 <script type="text/javascript">
	 jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
				});
 		var baseUrl='${pageContext.request.contextPath}';
 		let readerId =null;
 		var tab = 1;
 		/* var readerId = GetQueryString("rid");
 		console.log(readerId); */
 		$.ajax({
		type: "post",
	    url: `loading.action`,
	    data: null,
	    contentType: "application/json;charset=UTF-8", //发送数据的格式
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	console.log(data);
	    	if(data!=null){
	    		readerId = data.id;
	    		getReader(baseUrl, readerId);
					getBorrowInfo(baseUrl, readerId, tab);
					MyBookListClick(baseUrl, readerId);
	    	}
	    }
		});		
		});
	</script>
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
			<h3><span>书籍</span>是人类进步的阶梯！</h3>
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
      <div class="user-title">
        
      </div>
      <div class="user-content">
        
      </div>
      <div class="MyBookList">
        <div class="menu">
					<ul>						
						<li>
              <a class="active" tab="1">
                <div class="glyphicon glyphicon-time"></div>
                	已借图书
              </a>
            </li>
						<li>
              <a tab="2">
                <div class="glyphicon glyphicon-exclamation-sign"></div>
              	  历史逾期
              </a>
            </li>
						<li>
              <a tab="3">
                <div class="glyphicon glyphicon-list-alt"></div>
                	所有记录
              </a>
            </li>
					</ul>
        </div>
        <div>
          <table class="book-table">
            <thead>
              <!-- <tr>
                <th>图书信息</th>
                <th>借书时间</th>
                <th>还书时间</th>
                <th>是否逾期</th>
              </tr> -->
            </thead>
            <tbody class="borrowbook-detail">
              <!-- <tr>
                <th>
                  <div class="book-img">
                    <a><img src="./images/book1.jpg"></a>
                  </div>
                  <div class="book-detail">
                    <h3>老人与海</h3>
                    <p>作者：<span>海明威</span></p>
                  </div>
                </th>
                <th>借书时间</th>
                <th>还书时间</th>
                <th>是否逾期</th>
              </tr> -->
            </tbody>
          </table>
        </div>
      </div>
    </div>

	</div>
	
	<div class="footer">
		<div class="footer-top">
			<div class="container">
				<div class="col-md-4 footer-grid">
					<h5>ABOUT US</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla in purus nibh. Donec ornare felis neque. Nullam tortor nulla, sodales quis posuere quis, tristique nec libero. Proin vitae convallis odio. Morbi nec enim nisi. Aliquam erat volutpat. </p>
				</div>
				<div class="col-md-4 footer-grid">
					<h5>TWITTER FEED</h5>
					<p>Check out th best Themes online in the world <br>at <a href="mail-to:example@gmail.com">http://example.com </a></p>
					<span>1 day ago</span>
					<p><a href="#">@envanto</a>, Motive wordpress theme full responsive is coming soon...</p>
					<span>4 day ago</span>
				</div>
				<div class="col-md-4 footer-grid">
					<h5>FOLLOW US</h5>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla in purus nibh. Donec ornare felis neque. Nullam tortor! </p>
					
			<div class="social-icons">
				<a href="#"><i class="twitter"></i></a>
				<a href="#"><i class="facebook"></i></a>
				<a href="#"><i class="dribble"></i></a>
				<a href="#"><i class="rss"></i></a>
			</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="copyrights">
					<p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
				</div>
				<div class="go-top">
					<a href="#header" class="scroll"><img src="images/go-to-top.png" alt="" /></a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</body>
</html>

