/*
 * ajax function
 * */
//图书列表信息请求
let getCategory = (baseUrl, pid, hasChild) =>{
	$.ajax({
		type: "post",
	    url: `${baseUrl}/getCategory.action?pid=${pid}`,
	    data: null,
	    contentType: "application/json;charset=UTF-8", //发送数据的格式
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	createCategory(data, action, hasChild, pid);
	    	
	    }
	});
}

//热门信息请求
var getHotBooks = (baseUrl) => {
	$.ajax({
		type: "post",
	    url: `${baseUrl}/getHotBook.action`,
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	//console.log(data);
	    	createHotBook(data);
	    }
	});
}

//最新图书请求
var getNewBook = (baseUrl) =>{
	$.ajax({
		type: "post",
	    url: `${baseUrl}/getNewBook.action`,
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	createNewBook(data);
	    }
	});
}
//获取图书详情
var getBookDetail = (baseUrl, bookid) =>{
	$.ajax({
		type: "post",
	    url: `${baseUrl}/getBookDetail.action?id=${bookid}`,
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	//console.log(data);
	    	createBookDetail(data);
	    }
	});
}

//分类书籍页面书籍数据
let getCategoryBooks = (baseUrl, id, pageNum) =>{
	$.ajax({
		type: "post",
	    url: `${baseUrl}/bookPage.action?id=${id}&pageNum=${pageNum}`,
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	createBookContent(data);
	    	categoryClick(baseUrl);
	    	pageClick(baseUrl, id);
	    }
	});
}

//查询
let searchBook = (baseUrl)=>{
	var searchWay = GetQueryString("searchWay");
	var name = GetQueryString("name");
	console.log(name + " " +searchWay);
	$.ajax({
		type: "post",
	    url: `${baseUrl}/getSearchResult.action?searchWay=${searchWay}&name=${name}`,
	    data: null,
	    contentType: "application/json;charset=UTF-8", //发送数据的格式
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	console.log(data);//TODO
	    	createHotBook(data);
	    }
	});
}


/*
 * page init function
 * */
//生成图书列表
let createCategory =  (data, action, hasChild, pid) => {
	//console.log(data);
	var oUl = document.querySelector(".category");
	var oLi = hasChild ? "" : `<li cid=${pid}><a class="active">全部结果</a></li>`;
	oUl.innerHTML += oLi;
	
	/*console.log(data.findIndex((obj) => {
		return obj.id == 2;
	}));*/
	
	for(var i = 0; i < data.length; i++){
		if(hasChild){
			oLi = `<li><a href="bookCategory.action?pid=${data[i].id}">${data[i].name}</a></li>`;
		}else {
			
			oLi = `<li cid=${data[i].id}><a>${data[i].name}</a></li>`; 
		}
		oUl.innerHTML += oLi; 
	}
	
	
}

/*
 * [
{
"id": 2,
"title": "人间失格",
"describe": "人间失格，即丧失为人的资格。由序、第一手札、第二手札、第三手札、后记共五个部分构成，其中序和后记以作者口吻叙说，三个手札则以主人公叶藏的口吻叙述。主人公叶藏胆小懦弱，惧怕世间的情感，不了解人类复杂的思想，继而通过搞笑取乐别人，隐藏真实的自己。后来发现饮酒作乐似乎更能逃避这个世界，于是终日放浪形骸，通过酒精、药物、女人来麻痹自己，最终走向毁灭。他被身为人真切的痛苦所折磨，终其一生都在自我厌倦下寻求爱，逃避爱，最后只能毁灭自己。\r\n",
"categoryId": 20,
"simgUrl": "//img10.360buyimg.com/n1/s200x200_jfs/t3715/66/1895635005/167409/c8a0c796/583408d8N807dd142.jpg",
"bimgUrl": "//img10.360buyimg.com/n1/jfs/t3715/66/1895635005/167409/c8a0c796/583408d8N807dd142.jpg",
"includeDate": 1557240821000,
"total": 4,
"remain": 4,
"publishDate": 1557377990000,
"publisher": "11",
"lendable": 1,
"site": "hhh",
"lendCount": 6,
"bookAuthorId": 2,
"author": {
"id": 2,
"name": "太宰治",
"birthplace": "日本",
"describe": "太宰治从学生时代起已希望成为作家，21岁时和银座咖啡馆女侍投海自杀未遂。1935年《晚年》一书中作品《逆行》列为第一届芥川奖的候选作品。结婚后，写出了《富岳百景》及《斜阳》等作品，成为当代流行作家。1948年6月13日深夜与崇拜他的女读者山崎富荣跳玉川上水自杀，时年39岁，留下了《人间失格》等作品。"
}
}
*/

//生成热门图书
let createHotBook = (data) => {
	var hotBookDiv = document.querySelector(".exhibit-post-grids");
	var bookCols = hotBookDiv.querySelectorAll(".exhibit-posts");
	
	for(var i = 0; i < data.length; i++){
		var minIndex = minHeightCol(bookCols);
		
		var oDiv = `<div class="exhibit-post">
						<div class="exhibit-img"><a href="bookDetail.action?id=${data[i].id}"><img src="${data[i].simgUrl}"></a></div>
						<a href="bookDetail.action?id=${data[i].id}" class="exhibit-title">${data[i].title}</a>
						<p class="sub_head">作者： <a href="#">${data[i].author.name}</a> 【 ${data[i].author.birthplace} 】</p>
						<span></span>
						<p>总借阅数：<i>${data[i].lendCount}</i></p>
		              	<p>${data[i].describe}</p>
		              	<div class="sub_more"><a href="bookDetail.action?id=${data[i].id}">more >></a></div>
					</div>`;
		
		bookCols[minIndex].innerHTML += oDiv; 
	}
}


//生成上架新书
let createNewBook = (data) => {
	var latestProjects = document.querySelector(".latest-projects");
	
	for(var i = 0; i < data.length; i++){
		
		var oDiv = `<div class="col-md-3 project">
            <div class="book-post">
            <div class="book-img">
              <a href="bookDetail.action?id=${data[i].id}"><img src="${data[i].simgUrl}" alt="" /></a>
            </div>
            <div class="book-content">
              <h3 class="book-title"><a href="bookDetail.action?id=${data[i].id}">${data[i].title}</a></h3>
              <p>作者：<span>${data[i].author.name}</span></p>
              <p>上架时间：<span>${new Date(data[i].includeDate).Format("yyyy-MM-dd")}</span></p>
            </div>
        </div>
  	</div>`;
		
		latestProjects.innerHTML += oDiv; 
	}
	var clearFix = '<div class="clearfix"></div>';
	latestProjects.innerHTML += clearFix;
}

//生成图书详情
let createBookDetail = (data) => {
	var bookInformation = document.querySelector(".book-information");
	var detailContent = document.querySelector(".detail-content");
	
	var infoDiv = `<div class="bookInfo-img">
        <img src="${data.bimgUrl}" alt="" />
    </div>
    <div class="bookInfo-content">
      <div class="title"><h2>${data.title}</h2><span class="author">${data.author.name} 【 ${data.author.birthplace} 】 </span>&nbsp;著</div>
      <div class="category"><span>${data.category.name}</span></div>
      <div class="describe">
          <p>${data.describe.substr(0, 30)}...</p>
      </div>
      ${data.publisher == null ? "" : `<div>出版社：<span>${data.publisher}</span></div>`}
      ${data.publishDate == null ? "" : `<div>出版日期：<span>${new Date(data.publishDate).Format("yyyy-MM-dd")}</span></div>`}
      ${data.includeDate == null ? null : `<div>收录时间：<span>${new Date(data.includeDate).Format("yyyy-MM-dd")}</span></div>`}
      <div class="info">
        <span>馆藏总量：<i>${data.total}</i></span>&nbsp;&nbsp;
        <span>在馆书册：<i>${data.remain}</i></span>  
      </div>
      <div>馆藏位置：<span>${data.site}</span></div>
      <div class="lend"><a ${data.remain != 0 ? `class="lendable"` : ""}>借书</a></div>
    </div>`;
    
    var itemDiv = `<div class="item-mt">
	    <h4>内容简介</h4>
	  </div>
	  <div class="item-mc">
	    <div class="book-detail-content">
	      <p>${data.describe}</p>
	    </div>
	  </div>
	</div>
	${data.author == null ? "" : `<div class="detail-content">
							        <div class="item-mt">
							          <h4>作者简介</h4>
							        </div>
							        <div class="item-mc">
							          <div class="author-detail-content">
							            <p>${data.author.describe}</p>
							          </div>
							        </div>
							      </div>`}`; 
	
	bookInformation.innerHTML += infoDiv;
	detailContent.innerHTML += itemDiv;
}

/*{
"totalCount": 11,
"totalPage": 4,
"sizePage": 3,
"pageNum": 1,
"books": [
{
"id": 1,
"title": "月亮与六便士",
"describe": "\"“满地都是六便士，他却抬头看见了月亮。” \n　　银行家查尔斯，人到中年，事业有成，为了追求内心隐秘的绘画梦想，突然抛妻别子，弃家出走。他深知：人的每一种身份都是一种自我绑架，唯有失去是通向自由之途。 \n　　在异国他乡，他贫病交加，对梦想却愈发坚定执着。他说：我必须画画，就像溺水的人必须挣扎。 \n　　在经历种种离奇遭遇后，他来到南太平洋的一座孤岛，同当地一位姑娘结婚生子，成功创作出一系列惊世杰作。就在此时，他被绝症和双目失明击倒，临死之前，他做出了让所有人震惊的决定……\n\n　　人世漫长得转瞬即逝，有人见尘埃，有人见星辰。查尔斯就是那个终其一生在追逐星辰的人。 \"\r\n",
"categoryId": 20,
"simgUrl": "//img11.360buyimg.com/n1/s200x200_jfs/t1/33019/32/8443/309737/5cc65941E05e84bf2/8f0ee1726c1349da.jpg",
"bimgUrl": "//img11.360buyimg.com/n1/jfs/t1/33019/32/8443/309737/5cc65941E05e84bf2/8f0ee1726c1349da.jpg",
"includeDate": "2019-05-08 22:53:03",
"total": 6,
"remain": 6,
"publishDate": "2019-05-01 12:59:42",
"publisher": "11",
"lendable": 1,
"site": "hhh",
"lendCount": 5,
"bookAuthorId": 1,
"author": {
"id": 1,
"name": "威廉·萨默塞特·毛姆",
"birthplace": "英国",
"describe": "威廉·萨默塞特·毛姆（William Somerset Maugham,1874 -1965)，英国小说家，剧作家，被誉为“故事圣手”。 \r\n　　生于巴黎，十岁前父母双亡，由叔叔接回英国抚养，因身材矮小，说话结巴，总被同龄人欺凌，性格孤僻敏感。 \r\n　　18岁在伦敦学医，后弃医从文。23岁时发表首部小说《兰贝斯的丽莎》，从此走上文学创作的道路。人生经历奇特，他做过助产，做过间谍，做过演员，做过救护车司机；他做过丈夫，做过情人，拒绝过女人的求婚，他的求婚也被另一个女人拒绝；他自称“四分之三喜欢女人，只有四分之一喜欢男人”。 \r\n　　在文学界，毛姆是一个优雅、老到、冷漠的人性观察者，几乎每一个人都能在他的故事中看到自己，这也让毛姆成为二十世纪炙手可热的作家。 \r\n　　他的后半生住在一座仙境般的别墅里，晚年几乎获得了整个欧洲文学界的一切殊荣。91岁时，逝于法国。 \r\n　　经典代表作：《月亮与六便士》《人性的枷锁》。 "
},
"category": null
},*/

//分类书籍页面
let createBookContent = (data) => {
	var BookDiv = document.querySelector(".exhibit-post-grids");
	var bookCols = BookDiv.querySelectorAll(".exhibit-posts");
	//var obj = documnet.querySelector(".pagination");
	var pageList = document.querySelector(".pageList");
	var pageListContent = "";
	
	for(let i = 0; i < bookCols.length; i++){
		bookCols[i].innerHTML = "";
	}
	
	for(var i = 0; i < data.books.length; i++){
		var minIndex = minHeightCol(bookCols);	
		var oDiv = `<div class="exhibit-post">
								<div class="exhibit-img"><a href="bookDetail.action?id=${data.books[i].id}"><img src="${data.books[i].simgUrl}"></a></div>
								<a href="bookDetail.action?id=${data.books[i].id}" class="exhibit-title">${data.books[i].title}</a>
								<p class="sub_head">作者为： <a href="#">${data.books[i].author.name}</a> 【 ${data.books[i].author.birthplace} 】</p>
								<span></span>
	              <p>${data.books[i].describe}</p>
	            </div>`;
		
		bookCols[minIndex].innerHTML += oDiv; 
	}
	
	pageListContent += `<li  pageNum=${data.pageNum > 1 ? data.pageNum-1 : 1}><a class="prev">Prev</a></li>`;
	if(data.totalPage <= 10){
		for(let i = 1; i <= data.totalPage; i++){
			pageListContent += `<li ${data.pageNum == i ? `class="active"` : ""} pageNum=${i}><a>${i}</a></li>`;
		}
	}else if(data.totalPage <= 10){
		if(data.pageNum <= 5){
			for(let i = 1; i <= 8; i++){
				pageListContent += `<li ${data.pageNum == i ? `class="active"` : ""} pageNum=${i}><a>${i}</a></li>`;
			}
			pageListContent += `<li><span>.....</span></li>`;
			pageListContent += `<li pageNum=${i}><a>${data.totalPage}</a></li>`;
		}else if(data.pageNum > n-4){
			pageListContent += `<li pageNum=1><a>1</a></li>`;
			pageListContent += `<li><span>.....</span></li>`;
			for(let i = 7; i >= 0; i--){
				pageListContent += `<li ${data.pageNum == i ? `class="active"` : ""} pageNum=${data.totalPage - i}><a>${data.totalPage - i}</a></li>`;
			}
			
		}else{
			pageListContent += `<li pageNum=1><a>1</a></li>`;
			pageListContent += `<li pageNum=2><a>2</a></li>`;
			pageListContent += `<li><span>.....</span></li>`;
			for(let i = data.pageNum - 2; i <=  data.pageNum + 2; i++){
				pageListContent += `<li ${data.pageNum == i ? `class="active"` : ""} pageNum=${i}><a>${i}</a></li>`;
			}
			pageListContent += `<li><span>.....</span></li>`;
			pageListContent += `<li pageNum=${data.totalPage}><a>${data.totalPage}</a></li>`;
		}
	}
	pageListContent += `<li pageNum=${data.pageNum < data.totalPage ? data.pageNum+1 : data.totalPage}><a class="next">Next</a></li>`;
	pageList.innerHTML = pageListContent;
}


/*
 * animation function
 * */
//book page
pageClick = (baseUrl, pid)=>{
	var pageList = document.querySelector(".pageList");
	var aLi = pageList.querySelectorAll("li"); //0->prev end->next;
	//页码交互
	
	for(let i = 0; i < aLi.length; i++){
		aLi[i].addEventListener("click", function() {
			var pageNum = this.getAttribute("pagenum");
			getCategoryBooks(baseUrl, pid, pageNum);
		}, false);
	}
}

//list 
categoryClick = (baseUrl) => {
	var categoryList = document.querySelector(".category");
	var aLi = categoryList.querySelectorAll("li");
	var aA = categoryList.querySelectorAll("a");
	//页码交互
	for(let i = 0; i < aLi.length; i++){
		aLi[i].addEventListener("click", function() {
			var cid = this.getAttribute("cid");
			//console.log(cid);
			getCategoryBooks(baseUrl, cid, 1);
			
			//选中a active标记
			for(let j = 0; j < aA.length; j++){
				aA[j].setAttribute("class", "");
			}
			aA[i].setAttribute("class", "active")
		}, false);
	}
}

/*
 * tool function
 * */
//获取最短列
let minHeightCol = (cols) => {
	let index = 0;
	for(let i = 1; i < cols.length; i++){
		if(cols[i].offsetHeight < cols[index].offsetHeight){
			index = i;
		}
	}
	return index;
}

//格式化日期
Date.prototype.Format = function(fmt) {
    var o = {
        "M+" : this.getMonth() + 1,
        "d+" : this.getDate(),
        "h+" : this.getHours(),
        "m+" : this.getMinutes(),
        "s+" : this.getSeconds(),
        "q+" : Math.floor((this.getMonth() + 3) / 3),
        "S" : this.getMilliseconds()
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt))
        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

//获取url参数
let GetQueryString = (name) => {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null){
		if(name === "name"){
			console.log("name");
			return  decodeURI(r[2]);
		}

		console.log("fei name");
		return  unescape(r[2]);
	} 
	return null;
}


