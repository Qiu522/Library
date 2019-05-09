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

//图书信息请求
let getHotBook = (baseUrl) => {
	$.ajax({
		type: "post",
	    url: `${baseUrl}/getHotBook.action`,
	    dataType: "json", //这是返回来是json，也就是回调json
	    success: function(data){
	    	console.log(data);
	    	createHotBook(data);
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
	
	for(let i = 0; i < data.length; i++){
		var minIndex = minHeightCol(bookCols);
		
		var oDiv = `<div class="exhibit-post">
			<div class="exhibit-img"><a href="#"><img src="${data[i].simgUrl}"></a></div>
			<a href="#" class="exhibit-title">${data[i].title}</a>
			<p class="sub_head">作者为： <a href="#">${data[i].author.name}</a> on 12/04/2014</p>
			<span></span>
			<p>${data[i].describe}</p>
		</div>`;
		
		bookCols[minIndex].innerHTML += oDiv;
	}
	
}



//获取最短列
let minHeightCol = (cols) => {
	let index = 0;
	for(let i = 1; i < cols.length; i++){
		if(bookCols[i].offsetHeight < bookCols[index].offsetHeight){
			index = i;
		}
	}
	return index;
}

//获取url参数
let GetQueryString = (name) => {
var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
var r = window.location.search.substr(1).match(reg);
if(r!=null)return  unescape(r[2]); return null;
}



/*
<div class="col-md-4 exhibit-posts">
	<div class="exhibit-post">
		<div class="exhibit-img"><a href="#"><img src="images/book2.jpg"></a></div>
		<a href="#" class="exhibit-title">人间失格</a>
		<p class="sub_head">作者为： <a href="#">太宰治</a> on 12/04/2014</p>
		<span></span>
		<p>人间失格，即丧失为人的资格。由序、第一手札、第二手札、第三手札、后记共五个部分构成，其中序和后记以作者口吻叙说，三个手札则以主人公叶藏的口吻叙述。主人公叶藏胆小懦弱，惧怕世间的情感，不了解人类复杂的思想，继而通过搞笑取乐别人，隐藏真实的自己。后来发现饮酒作乐似乎更能逃避这个世界，于是终日放浪形骸，通过酒精、药物、女人来麻痹自己，最终走向毁灭。他被身为人真切的痛苦所折磨，终其一生都在自我厌倦下寻求爱，逃避爱，最后只能毁灭自己。</p>
	</div>	
	<div class="exhibit-post">
		<a href="single.html"><img src="images/b2.jpg"></a>
		<a href="single.html" class="exhibit-title">This is blog post title</a>
		<p class="sub_head">Posted by <a href="#">Admin</a> on 12/04/2014</p>
		<span></span>
		<p>Fusce placerat bibendum augue, non posuere lorem facilisis sit amet. Mauris malesuada nunc eget est pellentesque sit amet aliquet dolor pharetra. Integer placerat elit quis nisl dignissim non consectetur quam vestibulum. Suspendisse tincidunt adipiscing magna, ut dapibus nulla varius nec. Proin mi dolor, dapibus nec congue posuere, ornare sit.</p>
	</div>
	<div class="exhibit-post">
		<a href="single.html"><img src="images/b2.jpg"></a>
		<a href="single.html" class="exhibit-title">This is blog post title</a>
		<p class="sub_head">Posted by <a href="#">Admin</a> on 12/04/2014</p>
		<span></span>
		<p>Fusce placerat bibendum augue, non posuere lorem facilisis sit amet. Mauris malesuada nunc eget est pellentesque sit amet aliquet dolor pharetra. Integer placerat elit quis nisl dignissim non consectetur quam vestibulum. Suspendisse tincidunt adipiscing magna, ut dapibus nulla varius nec. Proin mi dolor, dapibus nec congue posuere, ornare sit.</p>
	</div>
	</div>
	<div class="col-md-4 exhibit-posts">
	<div class="exhibit-post">
		<a href="single.html"><img src="images/b3.jpg"></a>
		<a href="single.html" class="exhibit-title">This is blog post title</a>
		<p class="sub_head">Posted by <a href="#">Admin</a> on 12/04/2014</p>
		<span></span>
		<p>Phasellus in tincidunt velit. Etiam fermentum fringilla tristique. Aenean posuere aliquam interdum. Sed dignissim turpis eget leo ultricies ultricies. </p>
	</div>	
	<div class="exhibit-post">
		<a href="single.html"><img src="images/b1.jpg"></a>
		<a href="single.html" class="exhibit-title">This is blog post title</a>
		<p class="sub_head">Posted by <a href="#">Admin</a> on 12/04/2014</p>
		<span></span>
		<p>Phasellus in tincidunt velit. Etiam fermentum fringilla tristique. Aenean posuere aliquam interdum. Sed dignissim turpis eget leo ultricies ultricies. Sed et felis leo, eget dapibus massa. Etiam volutpat vehicula dolor, vel placerat odio posuere non.</p>
	</div>	
</div>
 * 
 * 
 * */
