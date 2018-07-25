var reMethod = "GET",
	pwdmin = 6;	
$(document).ready(function() {
	//个人中心切换
	$('#information').click(function(){
		$('#changeInformation').css("display","inherit");
		$('#editItem').css("display","none");
		$('#addItem').css("display","none");
		$('#changPassword').css("display","none");
		$('#updateItem').css("display","none");
	})
	$('#editItem').click(function(){
		$('#changeInformation').css("display","none");
		$('#editItem').css("display","inherit");
		$('#addItem').css("display","none");
		$('#changPassword').css("display","none");
		$('#updateItem').css("display","none");
	})
	$('#addItem').click(function(){
		$('#changeInformation').css("display","none");
		$('#editItem').css("display","none");
		$('#addItem').css("display","inherit");
		$('#pwd').css("display","none");
		$('#updateItem').css("display","none");
	})
	$('#pwd').click(function(){
		$('#changeInformation').css("display","none");
		$('#editItem').css("display","none");
		$('#addItem').css("display","none");
		$('#changPassword').css("display","inherit");
		$('#updateItem').css("display","none");
	})
	$('#goToAdd').click(function(){
		$('#changeInformation').css("display","none");
		$('#editItem').css("display","none");
		$('#addItem').css("display","inherit");
		$('#changPassword').css("display","none");
		$('#updateItem').css("display","none");
	})
	
	//修改密码提交
	$('#btnpwd').click(function(){
		if ($('#newPassword1').val().length < pwdmin) {
			$('#newPassword1').focus();
			$('#userCue').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
			return false;
		}
		if ($('#newPassword1').val() != $('#newPassword2').val()) {
			$('#newPassword2').focus();
			$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		}
		if ($('#newPassword1').val() == "") {
			$('#newPassword1').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>新密码不能为空</b></font>");
			return false;
		}
		
		if ($('#OldPassword').val() == "") {
			$('#OldPassword').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>原来的密码不能为空</b></font>");
			return false;
		}
	})
	//修改个人信息提交
	var phonenumber = /^1[34578]\d{9}$/;
	$('#btnUpdateInformation').click(function(){
		if ($('#phone').val() == "") {
			$('#phone').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue1').html("<font color='red'><b>电话号码不能为空</b></font>");
			return false;
		}
	
		if (!phonenumber.test($('#phone').val()) || $('#phone').val().length < 5 || $('#phone').val().length > 12) {
			$('#phone').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue1').html("<font color='red'><b>×电话号码格式不正确</b></font>");return false;
		} else {
			$('#phone').css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
		});
			
		}
		if ($('#name').val() == "") {
			$('#name').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue1').html("<font color='red'><b>用户名不能为空</b></font>");
			return false;
		}
		
		if ($('#name').val().length < 4 || $('#name').val().length > 16) {

			$('#name').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue1').html("<font color='red'><b>×用户名位4-16字符</b></font>");
			return false;
		}
		if ($('#ageinput').val() == "") {
			$('#ageinput').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue1').html("<font color='red'><b>年龄不能为空</b></font>");
			return false;
		}
		
		if($("#ageinput").val() > 100 || $("#ageinput").val() < 0){
			$('#ageinput').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue1').html("<font color='red'><b>年龄必须在0-100之间</b></font>");
			return false;
		}
		if ($('#commentinput').val() == "") {
			$('#commentinput').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue1').html("<font color='red'><b>备注不能为空</b></font>");
			return false;
		}
	})
	
	//添加待办事项
	$('#btnAddItem').click(function(){
		if ($('#titleadd').val() == "") {
			$('#titleadd').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue2').html("<font color='red'><b>标题不能为空</b></font>");
			return false;
		}
	});
	//编辑待办事项
	
	$('#btnItemCheck').click(function(){
		if ($('#itemtitle').val() == "") {
			$('#itemtitle').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue3').html("<font color='red'><b>标题不能为空</b></font>");
			return false;
		}
	});
	
	
	$('.detailform button').click(function(){
		$('#changeInformation').css("display","none");
		$('#addItem').css("display","none");
		$('#changPassword').css("display","none");
		$('#editItem').css("display","inherit");
		$('#updateItem').css("display","none");
		
	})
	
	$('#login').click(function() {
		if ($('#u').val() == "") {
			$('#u').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userlg').html("<font color='red'><b>用户名不能为空</b></font>");
			return false;
		}
		
		if ($('#p').val() == "") {
			$('#p').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userlg').html("<font color='red'><b>密码不能为空</b></font>");
			return false;
		}
		$('#regUser').submit();
	});

	$('#reg').click(function() {

		if ($('#user').val() == "") {
			$('#user').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
			return false;
		}



		if ($('#user').val().length < 4 || $('#user').val().length > 16) {

			$('#user').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×用户名位4-16字符</b></font>");
			return false;

		}
		if($("#userage").val() > 100 || $("#userage").val() < 0){
			$('#userage').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>年龄必须在0-100之间</b></font>");
			return false;
		}
		


		if ($('#passwd').val().length < pwdmin) {
			$('#passwd').focus();
			$('#userCue').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
			return false;
		}
		if ($('#passwd2').val() != $('#passwd').val()) {
			$('#passwd2').focus();
			$('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
			return false;
		}

		var phonenumber = /^1[34578]\d{9}$/;
		if (!phonenumber.test($('#phonenumber').val()) || $('#phonenumber').val().length < 5 || $('#phonenumber').val().length > 12) {
			$('#phonenumber').focus().css({
				border: "1px solid red",
				boxShadow: "0 0 2px red"
			});
			$('#userCue').html("<font color='red'><b>×电话号码格式不正确</b></font>");return false;
		} else {
			$('#phonenumber').css({
				border: "1px solid #D7D7D7",
				boxShadow: "none"
			});
			
		}

		$('#regUser').submit();
	});
});






