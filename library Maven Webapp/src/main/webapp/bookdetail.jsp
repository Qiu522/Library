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
<link href="css/bookInfomation.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Metushi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<!-- <link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'> -->
<script src="js/init.js"></script>
<script type="text/javascript">
	var baseUrl='${pageContext.request.contextPath}';
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
		});
		
		var id = GetQueryString("id");
		//console.log(id);
		getBookDetail(baseUrl, id);
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
			<div class="user-login">
				<a href="#" class="link-login">您好！请登录</a>&nbsp;&nbsp;
				<a href="#" class="link-regist">免费注册</a>
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
				<!-- <div class="search">
					<form>
						<input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
						<input type="submit" value="">
					</form>
				</div> -->
				<span class="menu"></span>
				<div class="top-menu">
					<!-- <ul>						
              <li><a href="book.html">童书</a></li>
              <li><a href="portfolio.html">文学小说</a></li>
              <li><a href="blog.html">教辅考试</a></li>
              <li><a href="404.html">人文科学</a></li>
              <li><a href="contact.html">经营管理</a></li>
              <li><a href="contact.html">科技IT</a></li>
              <li><a href="contact.html">生活艺术</a></li>
						<div class="clearfix"></div>
					</ul> -->
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
      <!-- start contact -->
      <div class="contact-page">
        <!-- head-section -->
          <div class="book-information">
            <!-- <div class="bookInfo-img">
                <img src="images/book2_Big.jpg" alt="" />
            </div>
            <div class="bookInfo-content">
              <div class="title"><h2>人间失格</h2><span class="author">大宰治</span>&nbsp;著</div>
              <div class="category"><span>文学</span></div>
              <div class="describe">
                  <p>《皮囊》是一部有着小说阅读质感的散文集，也是一本“认心又认人”的书。。</p>
              </div>
              <div>出版社：<span>新华出版社</span></div>
              <div>出版日期：<span>2019-10-10</span></div>
              <div>收录时间：<span>2019-03-09</span></div>
              <div class="info">
                <span>馆藏总量：<i>5</i></span>&nbsp;&nbsp;
                <span>在馆书册：<i>3</i></span>  
              </div>
              <div>馆藏位置：<span></span></div>
              <div class="lend"><a href="#">借书</a></div>
            </div> -->
          </div>
          <!-- /head-section -->	
          <div class="detail-content">
            <!-- <div class="item-mt">
              <h4>内容简介</h4>
            </div>
            <div class="item-mc">
              <div class="book-detail-content">
                <p>人间失格，即丧失为人的资格。由序、第一手札、第二手札、第三手札、后记共五个部分构成，其中序和后记以作者口吻叙说，三个手札则以主人公叶藏的口吻叙述。主人公叶藏胆小懦弱，惧怕世间的情感，不了解人类复杂的思想，继而通过搞笑取乐别人，隐藏真实的自己。后来发现饮酒作乐似乎更能逃避这个世界，于是终日放浪形骸，通过酒精、药物、女人来麻痹自己，最终走向毁灭。他被身为人真切的痛苦所折磨，终其一生都在自我厌倦下寻求爱，逃避爱，最后只能毁灭自己。</p>
              </div>
            </div>
          </div>
          <div class="detail-content">
            <div class="item-mt">
              <h4>作者简介</h4>
            </div>
            <div class="item-mc">
              <div class="author-detail-content">
                <p>人间失格，即丧失为人的资格。由序、第一手札、第二手札、第三手札、后记共五个部分构成，其中序和后记以作者口吻叙说，三个手札则以主人公叶藏的口吻叙述。主人公叶藏胆小懦弱，惧怕世间的情感，不了解人类复杂的思想，继而通过搞笑取乐别人，隐藏真实的自己。后来发现饮酒作乐似乎更能逃避这个世界，于是终日放浪形骸，通过酒精、药物、女人来麻痹自己，最终走向毁灭。他被身为人真切的痛苦所折磨，终其一生都在自我厌倦下寻求爱，逃避爱，最后只能毁灭自己。</p>
              </div>
            </div>
          </div> -->
      </div>
        <div class="clearfix"></div>
    </div>
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
</body>
</html>
