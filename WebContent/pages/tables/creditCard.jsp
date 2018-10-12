<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Saiita.cn.service.GetInfo.getSafetyLog"%>
<%@page import="Saiita.cn.entity.SafeLog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Saiita.cn.service.GetInfo.Log.LogRecord"%>
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
<body class="hold-transition skin-blue sidebar-mini">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">登陆日志</h3>
				</div>
				<!-- /.box-header -->
				<div class="overlay" id="divprogressbar">
					<i class="fa fa-refresh fa-spin"> </i>
				</div>
				<div class="box-body">
					<div>
						<input type="text" placeholder="输入金额" id="amount">
						<button type="submit" onclick="rs();" id="button" name="">计算</button>
					</div>
					<table id="example1" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>编号</th>
						<th>项目</th>
						<th>总支出数</th>
						<th>总支出(元)</th>
						<th>总收入数</th>
						<th>总收入(元)</th>
						<th>信用卡/网商/京东/花呗</th>
						<th>逆差</th>
					</tr>
				</thead>
			</table>
					<table id="example2" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>期数</th>
								<th>费率</th>
								<th>每期本金</th>
								<th>单期手续费</th>
								<th>本金+手续费</th>
								<th>每日手续费</th>
								<th>总手续费</th>
							</tr>
						</thead>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.box -->
	<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
	<div class="control-sidebar-bg"></div>

	<!-- jQuery 2.2.3 -->
	<script src="../../plugins/jQuery/jquery-3.3.1.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="../../bootstrap/js/bootstrap.min.js"></script>
	<!-- DataTables -->
	<script src="../../plugins/datatables/jquery.dataTables.min2.js"></script>
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
	<script>
		$(function() {
			$('#example1').DataTable({
				"paging" : false,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : false,
				"info" : false,
				"autoWidth" : false,
				ajax : {
					url : 'getTotalSpending',
					dataSrc : ''
				},
				columns : [ {
					data : 'id'
				}, {
					data : 'projects'
				}, {
					data : 'totalDisbursement'
				}, {
					data : 'totalExpenditure'
				}, {
					data : 'totalRevenue'
				}, {
					data : 'grossIncome'
				}, {
					data : 'creditCardOverdraft'
				}, {
					data : 'deficit'
				}  ]
			});
		});
	</script>
	<script>
		function rs() {
			$('#example2').DataTable({
				"bProcessing" : false, //DataTables载入数据时，是否显示‘进度’提示 
				"paging" : false,
				"lengthChange" : false,
				"searching" : false,
				"ordering" : true,
				"info" : false,
				"autoWidth" : true,
				"deferRender" : true,
				"destroy" : true,
				//"ajax" : "getSafeLog",
				ajax : {
					url : 'getcreditCard',
					type : 'get',
					//data:"...",//设置发送给服务器的数据（名称、格式）  
					data : {
						"amount" : $('#amount').val(),
					},
					dataSrc : "",//这是从服务器接受的数据（名称、格式）  
				//success:'...'//回调函数。不要修改！DT会默认使用它。想改交互参数找前两项就行  
				},

				//"columnDefs" : [ {
				//	"targets" : 0,//这一列是id，但是不想再前端显示，"visible": false,表示隐藏
				//	"visible" : true,
				//}, {
				//	targets : 0,//把第九列的样式改为超链接
				//	render : function(data, type, row) {
				//		return '<input type="text" value="******" id="password">';
				//	}
				//} ],
				columns : [ {
					data : 'id'
				}, {
					data : 'nper'
				}, {
					data : 'rate'
				}, {
					data : 'each_of_the_principal'
				}, {
					data : 'single_handling_charge'
				}, {
					data : 'principal_handling_fee'
				}, {
					data : 'daily_handling_charge'
				}, {
					data : 'total_fee'
				} ]
			});
		}
	</script>
	<script type="text/javascript" language="JavaScript">
		//: 判断网页是否加载完成   
		document.onreadystatechange = function() {
			if (document.readyState == "complete") {
				document.getElementById('divprogressbar').style.display = 'none';
			}
		}
	</script>
</body>
</html>