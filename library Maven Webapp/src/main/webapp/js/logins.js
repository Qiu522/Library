;

!function() {
	var layer = layui.layer, form = layui.form, carousel = layui.carousel;

	// 背景图片轮播
	carousel.render({
		elem : '#login_carousel',
		width : '100%',
		height : '100%',
		interval : 3000,
		arrow : 'none',
		anim : 'fade',
		indicator : 'none'
	});

	// 获取验证码
	function refCode() {

		$("#refCode_login_img").prop("src",
				"checkCode.action?x=" + Math.random());
		$("#code").val("");
	}

	$("#refCode_login_img").on("click", function() {
		refCode();
	});
	// 自定义验证规则，此处通过layui实验动态验证功能
	/*
	 * form.verify({ account: function(value) { var regPhone =
	 * /^1[34578]\d{9}$/; if(!regPhone.test(value.trim())) { return "请输入正确的手机号"; } },
	 * code: function(value) { if(value.toUpperCase() != vailCode) { //
	 * refCode(); return "验证码不正确"; } } });
	 */

	// 监听提交 提交登陆
	$("#login").on("click", function() {
		var readername = $("#account").val();
		var password = $("#password").val();
		var code = $("#code").val();
		if (readername == "" || password == "" || code == "") {
		} else {
			if (code.length == 4) {
				$.ajax({
					url : "checkLogin.action",
					type : "post",
					data : {
						"readerName" : $("#account").val(),
						"password" : $("#password").val(),
						"code" : $("#code").val()
					},
					success : function(data) {
						if (data == "success") {
							location.href = "index.jsp";
						} else if (data == "error") {
							refCode();
							$("#account").val("");
							$("#password").val("");
							$("#code").val("");
							alert("账户或密码错误");
						} else {
							refCode();
							$("#code").val("");
							alert("验证码错误");

						}
					}
				})
			} else {
				alert("验证码错误");
				refCode();
				$("#code").val("");
			}
		}
	});

	/*
	 * form.on("submit(login)", function() { $.ajax({ url: "checkLogin.action",
	 * type: "post", data: { "account": $("#account").val(), "password":
	 * $("#password").val() }, success: function(result) { if(result.status ==
	 * 0) { location = "index.jsp"; } else { refCode(); $("#password").val("");
	 * layer.alert(result.msg, { title: '提交结果' }); } } });
	 * 
	 * return false; });
	 */
}();
