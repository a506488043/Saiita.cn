<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="RSA.RSAUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Log in</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="./dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="./plugins/iCheck/square/blue.css">
<script src="./plugins/iCheck/icheck.min.js"></script>

<script src="./bootstrap/js/RSA.js"></script>
<script src="./bootstrap/js/BigInt.js"></script>
<script src="./bootstrap/js/Barrett.js"></script>
<script src="./bootstrap/js/md5.js"></script>

<!-- jQuery 2.2.3 -->
<script src="./plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="./bootstrap/js/bootstrap.min.js"></script>
<script>
	
</script>
</head>
<body class="hold-transition login-page">
	<form action="LoginPost.do" method="post" name="loginForm">
		<div class="login-box">
			<div class="login-logo">
				<a href="../index2.html"><b>个人管理系统</b>LTE</a>
			</div>
			<!-- /.login-logo -->
			<div class="login-box-body">
				<p class="login-box-msg">开始输入登陆账号信息</p>
				<div class="form-group has-feedback">

					<input type="text" class="form-control" placeholder="账号"
						name="username" id="username"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" placeholder="密码"
						id="password"> <input type="hidden" id="pwd"
						name="user_psw">
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat"
								onclick="rsalogin();">登陆</button>
						</div>
					</div>
				</div>
				<!-- /.col -->
			</div>
		</div>
		<script type="text/javascript">
			function rsalogin() {
				bodyRSA();
				alert("3");
				var password = $("#password").val();
				var rsaPwd = encryptedString(key, password);
				//alert(rsaPwd);
				$("#pwd").val(rsaPwd);
			}
			var key;
			function bodyRSA() {
				$.ajax({
					type : 'get',
					url : '/getRsaPublicKey.do',
					dataType : "json",
					success : function(data) {
						alert("1");
						$.each(data, function(n, value) {
							alert(value.publicKey);
							setMaxDigits(130);
							key = new RSAKeyPair("10001", "", value.publicKey);
						});
					},
					error : function(errorMsg) {
						alert("2");
					}
				});
			}
		</script>
	</form>
</body>
</html>