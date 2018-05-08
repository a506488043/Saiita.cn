<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Saiita.cn.service.GetInfo.getAllUserInfo"%>
<%@page import="Saiita.cn.entity.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="../../plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
<script type="text/javascript">
	function GetAllAlpayInfo() {
		$.ajax({
			type : 'get',
			url : 'GetAllAlpayInfo',
			//data:'',
			dataType : 'json',
			timeout : 1000,
			success : function(data) {
				$.each(data,function(i,list){
					//alert($("#name").val(list.id));
					$("#GetAllAlpayInfo").append("<tr>")
					.append("<td>"+list.id+"</td>")
					.append("<td>"+list.tradeNumber+"</td>")
					.append("</tr>");
				})
			},
	        error: function (jqXHR, textStatus, errorThrown) {
	            alert("获取失败");
	        }
		})
	}
</script>
<body class="hold-transition skin-blue sidebar-mini"
	onload=GetAllAlpayInfo()>
	<form>
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">用户数据</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<table id="example1" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>交易号</th>
							<th>商户订单号</th>
						</tr>
					</thead>
					<tbody id="GetAllAlpayInfo">
						<!-- <tr></tr> -->
					</tbody>
				</table>
				<div class="overlay" id="divprogressbar">
					<i class="fa fa-refresh fa-spin"></i>
				</div>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>

		<!-- jQuery 2.2.3 -->
		<script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
		<!-- Bootstrap 3.3.6 -->
		<script src="../../bootstrap/js/bootstrap.min.js"></script>
		<!-- DataTables -->
		<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
		<script src="../../plugins/datatables/dataTables.bootstrap.min.js"></script>
		<!-- SlimScroll -->
		<script src="../../plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<!-- FastClick -->
		<script src="../../plugins/fastclick/fastclick.js"></script>
		<!-- AdminLTE App -->
		<script src="../../dist/js/app.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="../../dist/js/demo.js"></script>
		<!-- page script -->
		<script type="text/javascript" language="JavaScript">
			//: 判断网页是否加载完成   
			document.onreadystatechange = function() {
				if (document.readyState == "complete") {
					document.getElementById('divprogressbar').style.display = 'none';
				}
			}
		</script>
		<script>
			$(function() {
				$("#example1").DataTable();
				$('#example2').DataTable({
					"paging" : true,
					"lengthChange" : true,
					"searching" : true,
					"ordering" : true,
					"info" : true,
					"autoWidth" : true
				});
			});
		</script>
	</form>
</body>
</html>