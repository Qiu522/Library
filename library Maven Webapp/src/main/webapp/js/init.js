//图书列表信息请求
let getCategory = (baseUrl, pid) =>{
	$.ajax({
		type: "post",
	    url: `${baseUrl}/getCategory.action?pid=${pid}`,
	    data: null,
	    contentType: "application/json;charset=UTF-8", //发送数据的格式
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	createCategory(data);
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

//热门信息请求
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

//生成图书列表
let createCategory =  (data) => {
	//console.log(data);
	var oUl = document.querySelector(".category");
	for(var i = 0; i < data.length; i++){
		var oLi = `<li><a href="bookCategory.action?pid=${data[i].id}">${data[i].name}</a></li>`;
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
						<a href="#" class="exhibit-title">${data[i].title}</a>
						<p class="sub_head">作者： <a href="#">${data[i].author.name}</a> 【 ${data[i].author.birthplace} 】</p>
						<span></span>
						<p>总借阅数：<i>${data[i].lendCount}</i></p>
		              	<p>${data[i].describe}</p>
		              	<div class="sub_more"><a href="#">more >></a></div>
					</div>`;
		
		bookCols[minIndex].innerHTML += oDiv; 
	}
}


//生成上架图书
let createNewBook = (data) => {
	var latestProjects = document.querySelector(".latest-projects");
	
	for(var i = 0; i < data.length; i++){
		
		var oDiv = `<div class="col-md-3 project">
            <div class="book-post">
            <div class="book-img">
              <a href="bookDetail.action?id=${data[i].id}"><img src="${data[i].simgUrl}" alt="" /></a>
            </div>
            <div class="book-content">
              <h3 class="book-title"><a href="#">${data[i].title}</a></h3>
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
      <div class="lend"><a href="#">借书</a></div>
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
	if(r!=null)return  unescape(r[2]); return null;
}


