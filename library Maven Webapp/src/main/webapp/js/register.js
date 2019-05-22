let checkFrom = ()=>{
	let layuiForm = document.querySelector(".layui-form");
	let readername = layuiForm.querySelector("#readername");
	let password = layuiForm.querySelector("#password");
	let repassword = layuiForm.querySelector("#repassword");
	
	
	
	
	readername.addEventListener("focus", function(ev) {
		let nameTip = layuiForm.querySelector("#name-tip");
		nameTip.setAttribute("class", "");
		nameTip.innerHTML="昵称格式：需要是2-10个字符，只能以英文开头，包含英文数字下划线，不能包含空格。"
	}, false);
	readername.addEventListener("blur", function(e) {
		let nameTip = layuiForm.querySelector("#name-tip");
		let reg = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){1,9}$/;
		let value = readername.value;
		console.log(reg.test(value));
		if( !reg.test(value) ){
			nameTip.innerHTML="请输入正确格式";
		}else {
			
			$.ajax({
				type: "post",
			    url: `checkName.action?readerName=${value}`,
			    data: null,
			    contentType: "application/json;charset=UTF-8", //发送数据的格式
			    dataType: "json", //这是返回来是json，也就是回调json
			    success: function(data){
			    	console.log(data == 1);
			    	if(data == 1){
			    		nameTip.setAttribute("class", "");
			    		nameTip.innerHTML="用户名已经存在";
			    	}else {
			    		nameTip.setAttribute("class", "tipHidden");
			    	}
			    }
			});		
			
		}
	}, false);
	
	password.addEventListener("focus", function(ev) {
		let passTip = layuiForm.querySelector("#pass-tip");
		passTip.setAttribute("class", "");
		passTip.innerHTML="昵称格式：需要是6-18个字符，只能以英文开头，包含英文数字下划线，不能包含空格。"
	}, false);
	password.addEventListener("blur", function(e) {
		let passTip = layuiForm.querySelector("#pass-tip");
		let reg = /^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){5,17}$/;
		let value = password.value;
		console.log(reg.test(value));
		if( !reg.test(value) ){
			passTip.innerHTML="请输入正确格式";
		}else {
			passTip.setAttribute("class", "tipHidden");
		}
	}, false);
	
	repassword.addEventListener("blur", function(e) {
		let passTip = layuiForm.querySelector("#pass-tip");
		let repassTip = layuiForm.querySelector("#repass-tip");
		console.log(password.value == repassword.value);
		if( !(password.value == repassword.value) ){
			repassTip.setAttribute("class", "");
			repassTip.innerHTML="两次密码输入不同";
		}else {
			repassTip.setAttribute("class", "tipHidden");
		}
	}, false);
}
!function() {
	var layer = layui.layer, form = layui.form;

	// 当勾选不同意协议按钮后禁止注册
	form.on("checkbox(agreen-checkbox)", function(data) {
		if (!data.elem.checked) {
			$("#reg").addClass("layui-btn-disabled");
			$("#reg").prop("disabled", "disabled");
		} else {
			$("#reg").removeClass("layui-btn-disabled");
			$("#reg").removeAttr("disabled");
		}
	});

	// 获取验证码
	function refCode() {

		$("#refCode_Regist_img").prop("src",
				"checkCode.action?x=" + Math.random());
		$("#code").val("");
	}

	$("#refCode_Regist_img").on("click", function() {
		refCode();
	});

	// 监听提交 提交登陆
	$("#reg").on(
			"click",
			function() {
				let layuiForm = document.querySelector(".layui-form");
				let Ps = layuiForm.querySelectorAll("p");
				for(let i = 0; i < Ps.length; i++){
					if(Ps[i].getAttribute("class") != "tipHidden"){
						return ;
					}
				}
				
				
				var readername = $("#readername").val();
				var password = $("#password").val();
				var repassword = $("#repassword").val();
				var code = $("#code").val();
				if (readername == "" || password == "" || repassword == ""
						|| code == "") {
				} else {
					if (password == repassword) {
						if (code.length == 4) {
							$.ajax({
								url : "regist.action",
								type : "post",
								contentType: "application/json;charset=UTF-8", //发送数据的格式
								data : {
									"readerName" : readername,
									"password" : password,
									"code" : code
								},
								success : function(data) {
									if (data == "success") {
										location.href = "login.jsp";
									} else if (data == "error") {
										refCode();
										$("#readername").val("");
										$("#password").val("");
										$("#repassword").val("");
										$("#code").val("");
										alert("注册失败");
									} else {
										refCode();
										$("#code").val("");
										alert("验证码错误");

									}
								}
							})
						} else {
							alert("验证码错误");
							$("#code").val("");
						}
					} else {
						alert("两次密码不一致！");
						$("#password").val("");
						$("#repassword").val("");
						$("#code").val("");
					}
				}
			});
	
	checkFrom();
}();