;
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

}();