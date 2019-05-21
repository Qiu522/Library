/*
 * 还未完成的工作：
 * 		1、通过个人信息修改需要根据正在登录的reader的Id去查寻其信息，并在修改信息的文本框中显示
 *      2、用户名的正则表达式需要添加用户姓名或密码的正则表达式验证
 *      
 * 
 * */

//从这取得session中的Id
window.onload = function()  {


};


// 获取验证码
function refCode() {

	$("#refCode_update_img").prop("src", "checkCode.action?x=" + Math.random());
	$("#code").val("");
}
// 点击图片刷新验证码
$("#refCode_update_img").click(function() {
	refCode();
});

// 点击修改信息
$(".upInform").click(function() {
	var readerName = $("#readerName").val();
	var sex = $("#sex").val();
	var age = $("#age").val();
	var id = 11;
	alert(readerName);
	alert(sex);
	alert(age);
	alert(id);
	if (readerName == "" || sex == "" || age == "") {
		alert("信息不能为空");
	} else {
		if(age<=5 || age>=80){
			alert("年龄输入错误，必须在5~80岁");
		}else{
		$.ajax({
			url : "changInfo.action",
			type : "post",
			data : {
				"readerName" : readerName,
				"sex" : sex,
				"age" : age,
				"id"  : id
			},
			success : function(data) {
				if (data == "success") {
					alert("修改成功！");
					location.href = "Home.jsp";
				} else if (data == "failed") {
					alert("该用户名已存在");
					$("#readerName").val("");
					$("#sex").val("");
					$("#age").val("");
				} else {
					alert("sorry!修改失败");
					$("#readerName").val("");
					$("#sex").val("");
					$("#age").val("");
				}
			}
		});
		}
	}
});

$(".upPass").click(function() {
	$('.informationUpdate').css('display', 'none');
	$('.passwordUpdate').css('display', 'block');
	$("#password").val("");
	$("#repassword").val("");
	$("#code").val("");
});

$(".upinfo").click(function() {
	$('.informationUpdate').css('display', 'block');
	$('.passwordUpdate').css('display', 'none');
	$("#readerName").val("");
	$("#sex").val("");
	$("#age").val("");
});

$(".quit").click(function() {
	location.href = "Home.jsp";

});

// 点击修改信息
$(".commitPass").click(function() {
	var password = $("#password").val();
	var repassword = $("#repassword").val();
	var code = $("#code").val();
	var id = 11;

	if (readerName == "" || sex == "" || age == "") {
		alert("信息不能为空");
	} else {
		if (password == repassword) {
			$.ajax({
				url : "changePassword.action",
				type : "post",
				data : {
					"password" : password,
					"code" : code,
					"id"   : id
				},
				success : function(data) {
					if (data == "success") {
						alert("修改成功！");
						// 需要退出到主页并重新登录
						location.href = "Home.jsp";
					} else if (data == "codeError") {
						alert("验证码错误");
						$("#code").val("");
						refCode();
					} else {
						alert("sorry!密码修改失败");
						$("#password").val("");
						$("#repassword").val("");
						$("#code").val("");
					}
				}
			});
		} else {
			alert("两次密码不一致");
			$("#password").val("");
			$("#repassword").val("");
			$("#code").val("");
			refCode();
		}

	}
});
