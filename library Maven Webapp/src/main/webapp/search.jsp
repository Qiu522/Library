<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   	<title>今日图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
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
  var baseUrl='${pageContext.request.contextPath}';
  var action = "bookPage.action";
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
		});
		getReaderInfo();
		searchBook(baseUrl);
			
	});
		
		
	</script>
  </head>
  
  <body>
   	<!-- header-section-starts -->
		<div class="header" id="header">
			<div class="container">
				<div class="logo">
					<a href="index.jsp"><img src="images/logo-l.png" alt="" /></a>
				</div>
				<!-- <div class="social-icons header-social-icons">
					<a href="#"><i class="twitter"></i></a>
					<a href="#"><i class="facebook"></i></a>
					<a href="#"><i class="dribble"></i></a>
					<a href="#"><i class="rss"></i></a>
				</div> -->
				<div class="user-login">
					<a href="login.jsp" class="link-login">您好！请登录</a>&nbsp;&nbsp;
					<a href="regist.jsp" class="link-regist">免费注册</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="header-bottom">
			<div class="container">
	      <h3><span>书籍</span>是人类进步的阶梯！</h3>
			</div>
		</div>
		<div class="navigation-strip">
			<div class="container">
				<div class="nav_content">
				<div class="home">
						<a href="index.jsp"><img src="images/home1.png" alt="" /></a>
					</div>
					<div class="search">
						<form  method="get" action="${pageContext.request.contextPath}/search.action">
							<select name="searchWay">
								<option value="bookName">书名</option>
								<option value="author">作者</option>
							</select>
							<input type="text" name="name" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
							<input type="submit" value="">
						</form>
					</div>
					<span class="menu"></span>
					<div class="top-menu">
						<ul class="category">
							<!-- <li><a href="#">文学</a></li>
							<li><a href="#">青春</a></li>
							<li><a class="#" href="blog.html">传记</a></li>
							<li><a href="#">悬疑</a></li>
							<li><a href="#">科幻</a></li>
							<li><a href="#">影视</a></li>
							<div class="#"></div> -->
						</ul>
					</div>
					<!-- script for menu -->
					<script>
					$( "span.menu" ).click(function() {
					  $( ".top-menu" ).slideToggle( "slow", function() {
					    // Animation complete.
					  });
					});
				    </script>
				    <!-- script for menu -->
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<div class="content">
			<div class="container">
				<div class="exhibit-posts-section">		
					<!-- head-section -->
						<div class="head-section text-center">
							<h2>今日图书</h2>
							<span> </span>
						</div>
						<!-- /head-section -->	
					<div class="exhibit-post-grids exhibit_grids">
						<div class="col-md-4 exhibit-posts">
							<!-- <div class="exhibit-post">
								<div class="exhibit-img"><a href="#"><img src="images/book2.jpg"></a></div>
								<a href="#" class="exhibit-title">人间失格</a>
								<p class="sub_head">作者为： <a href="#">太宰治</a> on 12/04/2014</p>
								<span></span>
	              <p>人间失格，即丧失为人的资格。由序、第一手札、第二手札、第三手札、后记共五个部分构成，其中序和后记以作者口吻叙说，三个手札则以主人公叶藏的口吻叙述。主人公叶藏胆小懦弱，惧怕世间的情感，不了解人类复杂的思想，继而通过搞笑取乐别人，隐藏真实的自己。后来发现饮酒作乐似乎更能逃避这个世界，于是终日放浪形骸，通过酒精、药物、女人来麻痹自己，最终走向毁灭。他被身为人真切的痛苦所折磨，终其一生都在自我厌倦下寻求爱，逃避爱，最后只能毁灭自己。</p>
	            </div>	
							<div class="exhibit-post">
								<a href="single.html"><img src="images/b2.jpg"></a>
								<a href="single.html" class="exhibit-title">This is exhibit post title</a>
								<p class="sub_head">Posted by <a href="#">Admin</a> on 12/04/2014</p>
								<span></span>
								<p>Fusce placerat bibendum augue, non posuere lorem facilisis sit amet. Mauris malesuada nunc eget est pellentesque sit amet aliquet dolor pharetra. Integer placerat elit quis nisl dignissim non consectetur quam vestibulum. Suspendisse tincidunt adipiscing magna, ut dapibus nulla varius nec. Proin mi dolor, dapibus nec congue posuere, ornare sit.</p>
							</div>	
							<div class="exhibit-post">
								<a href="single.html"><img src="images/p5.jpg"></a>
								<a href="single.html" class="exhibit-title">This is exhibit post title</a>
								<p class="sub_head">Posted by <a href="#">Admin</a> on 12/04/2014</p>
								<span></span>
								<p>Phasellus in tincidunt velit. Etiam fermentum fringilla tristique. Aenean posuere aliquam interdum. Sed dignissim turpis eget leo ultricies ultricies. </p>
							</div> -->
						</div>
						<div class="col-md-4 exhibit-posts">
								
						</div>
						<div class="col-md-4 exhibit-posts span_66">
							
						</div>
						<div class="clearfix"></div>
					</div>
				<div class="pagination text-center">
					<ul class="pageList">
						<!-- <li><a class="prev" href="#">Prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">6</a></li>
						<li><a href="#">7</a></li>
						<li><a href="#">8</a></li>
						<li><span>.....</span></li>
						<li><a href="#">12</a></li>
						<li><a href="#" class="next">Next</a></li> -->
					</ul>
	      </div>
	      
	     
		<div class="footer">
			<div class="footer-top">
				<div class="container">
					<div class="col-md-4 footer-grid">
						<h5>ABOUT US</h5>
						<p>生活总是让我们遍体鳞伤，但到后来，那些受伤的地方一定会变成我们最强壮的地方。</p>
					</div>
					<div class="col-md-4 footer-grid">
						<h5>PROVERB</h5>
						<p>哪里有阴影，哪里就有光。</p>
						<span>one more</span>
						<p>Less interests, more interest</p>
						<span>by zyf and xhw</span>
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
						<p>Copyright &copy; 2015.Company name All rights reserved.</p>
					</div>
					<div class="go-top">
						<a href="#header" class="scroll"><img src="images/go-to-top.png" alt="" /></a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	<script src="js/bookanimation.js"></script>
  </body>
</html>
