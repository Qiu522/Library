//图书列表信息请求
getCategory = (baseUrl, pid) =>{
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

//生成图书列表
let createCategory =  (data) => {
	console.log(data);
	var oUl = document.querySelector(".category");
	for(var i = 0; i < data.length; i++){
		var oLi = `<li><a href="bookCategory.action?pid=${data[i].id}">${data[i].name}</a></li>`;
		oUl.innerHTML += oLi; 
	}     	
}

//获取url参数
let GetQueryString = (name) => {
var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
var r = window.location.search.substr(1).match(reg);
if(r!=null)return  unescape(r[2]); return null;
}
