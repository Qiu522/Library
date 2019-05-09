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
<script src="js/json2.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Metushi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<!-- <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'> -->
<script src="js/init.js"></script>
<script>
var baseUrl='${pageContext.request.contextPath}';
var pid = 0;
jQuery(document).ready(function($) {
	$(".scroll").click(function(event){		
		event.preventDefault();
		$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
	});
	
	getCategory(baseUrl, pid)
	
	
	
	getHotBook(baseUrl);
	
	/* var hotBookDiv = document.querySelector(".exhibit-post-grids");
	var bookCols = hotBookDiv.querySelectorAll(".exhibit-posts"); */
	
	//console.log(bookCols[1].offsetHeight)
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
			<div class="social-icons header-social-icons">
				<a href="#"><i class="twitter"></i></a>
				<a href="#"><i class="facebook"></i></a>
				<a href="#"><i class="dribble"></i></a>
				<a href="#"><i class="rss"></i></a>
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
					<a href="index.jsp"><img src="images/home.png" alt="" /></a>
				</div>
				<div class="search">
					<form>
						<input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
						<input type="submit" value="">
					</form>
				</div>
			<span class="menu"></span>
				<div class="top-menu">
					<ul class="category">						
						<!-- <li><a>童书</a></li>
						<li><a href="portfolio.html">文学小说</a></li>
						<li><a href="blog.html">教辅考试</a></li>
						<li><a href="404.html">人文科学</a></li>
						<li><a href="contact.html">经营管理</a></li>
						<li><a href="contact.html">科技IT</a></li>
						<li><a href="contact.html">生活艺术</a></li> -->
						
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
			<div class="projects-section">
				<h4 class="head">编辑推荐<span class="line"></span></h4>				
				<div class="latest-projects">
					<div class="col-md-3 project">
            <div class="book-post">
                <div class="book-img">
                  <a href="#"><img src="images/book1.jpg" alt="" /></a>
                </div>
                <div class="book-content">
                  <h3 class="book-title"><a href="#">老人与海</a></h3>
                  <p>作者：<span>海明威</span></p>
                  <p>总借阅数：<span>50</span></p>
                </div>
            </div>
          </div>
          <div class="col-md-3 project">
            <div class="book-post">
                <div class="book-img">
                  <a href="#"><img src="//img14.360buyimg.com/n1/s200x200_jfs/t25927/352/2130181065/306447/5dbfe8ec/5bc43b47N47775123.jpg" alt="" /></a>
                </div>
                <div class="book-content">
                  <h3 class="book-title"><a href="#">老人与海</a></h3>
                  <p>作者：<span>海明威</span></p>
                  <p>总借阅数：<span>50</span></p>
                </div>
            </div>
          </div>
          <div class="col-md-3 project">
            <div class="book-post">
                <div class="book-img">
                  <a href="#"><img src="//img13.360buyimg.com/n1/s200x200_jfs/t10072/231/1597945576/58010/1512bd1b/59e35198N2e697952.jpg
" alt="" /></a>
                </div>
                <div class="book-content">
                  <h3 class="book-title"><a href="#">老人与海</a></h3>
                  <p>作者：<span>海明威</span></p>
                  <p>总借阅数：<span>50</span></p>
                </div>
            </div>
          </div>
          <div class="col-md-3 project">
            <div class="book-post">
                <div class="book-img">
                  <a href="#"><img src="images/book1.jpg" alt="" /></a>
                </div>
                <div class="book-content">
                  <h3 class="book-title"><a href="#">老人与海</a></h3>
                  <p>作者：<span>海明威</span></p>
                  <p>总借阅数：<span>50</span></p>
                </div>
            </div>
          </div>
          <div class="col-md-3 project">
            <div class="book-post">
                <div class="book-img">
                  <a href="#"><img src="images/book1.jpg" alt="" /></a>
                </div>
                <div class="book-content">
                  <h3 class="book-title"><a href="#">老人与海</a></h3>
                  <p>作者：<span>海明威</span></p>
                  <p>总借阅数：<span>50</span></p>
                </div>
            </div>
          </div>
          <div class="col-md-3 project">
            <div class="book-post">
                <div class="book-img">
                  <a href="#"><img src="images/book1.jpg" alt="" /></a>
                </div>
                <div class="book-content">
                  <h3 class="book-title"><a href="#">老人与海</a></h3>
                  <p>作者：<span>海明威</span></p>
                  <p>总借阅数：<span>50</span></p>
                </div>
            </div>
          </div>
          <div class="col-md-3 project">
            <div class="book-post">
                <div class="book-img">
                  <a href="#"><img src="images/book1.jpg" alt="" /></a>
                </div>
                <div class="book-content">
                  <h3 class="book-title"><a href="#">老人与海</a></h3>
                  <p>作者：<span>海明威</span></p>
                  <p>总借阅数：<span>50</span></p>
                </div>
            </div>
          </div>
          <div class="col-md-3 project">
            <div class="book-post">
                <div class="book-img">
                  <a href="#"><img src="images/book1.jpg" alt="" /></a>
                </div>
                <div class="book-content">
                  <h3 class="book-title"><a href="#">老人与海</a></h3>
                  <p>作者：<span>海明威</span></p>
                  <p>总借阅数：<span>50</span></p>
                </div>
            </div>
          </div>
				
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="exhibit-section">
				<h4 class="head">热门图书<span class="line"></span></h4>		
				<div class="exhibit-post-grids">
					<div class="col-md-4 exhibit-posts">
						
					</div>
					<div class="col-md-4 exhibit-posts">
						
					</div>
					<div class="col-md-4 exhibit-posts span_66">
						
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
				<!---/start-text-slider----->
				<div class="testimonials">
			<h4>佳句赏析</h4>
		<div id="testimonials">
			 <div class="wmuSlider example1">
		 	<div class="container-flueid">
				 <article style="position: absolute;"> 
				   	<div class=" cont span_2_of_3  client-main">
							<div class="slide-text">
								<p>Praesent pulvinar, est eget pharetra euismod, metus felis condimentum massa, ut vestibulum ipsum risus vel ligula. In hac habitasse platea dictumst.</p>
						  		<a href="#">by Esmet Hajrizi</a>
								<div class="clearfix"></div>								
						 	</div> 
					</div>
				 </article>
				 <article style="position: absolute;"> 
				   	<div class=" cont span_2_of_3  client-main">
							<div class="slide-text">
								<p>66666euismod, metus felis condimentum massa, ut vestibulum ipsum risus vel ligula. In hac habitasse platea dictumst.</p>
						  		<a href="#">by Esmet Hajrizi</a>	
								<div class="clearfix"></div>
						 	</div> 
					</div>
				 </article>
				 <article style="position: absolute;"> 
				   	<div class=" cont span_2_of_3  client-main">
							<div class="slide-text">
								<p>Praesent pulvinar, est eget pharetra euismod, metus felis condimentum massa, ut vestibulum ipsum risus vel ligula. In hac habitasse platea dictumst.</p>
						  		<a href="#">by Esmet Hajrizi</a>
								<div class="clearfix"></div>
						 	</div> 
					</div>
				 </article>
				 <article style="position: absolute;"> 
				   	<div class=" cont span_2_of_3  client-main">
							<div class="slide-text">
								<p>Praesent pulvinar, est eget pharetra euismod, metus felis condimentum massa, ut vestibulum ipsum risus vel ligula. In hac habitasse platea dictumst.</p>
						  		<a href="#">by Esmet Hajrizi</a>
								<div class="clearfix"></div>
						 	</div> 
					</div>
				 </article>	 
                  <script src="js/jquery.wmuSlider.js"></script> 
					<script>
       				     $('.example1').wmuSlider();         
   					</script> 	
						<div class="clearfix"></div>
	         </div>
	     </div>
		 <div class="arrow">
			<div class="shows">
				<span class="a1"><img src="images/tes.png" alt="" /></span>
			</div>
		 </div>
	 <!---//text-slider----->

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