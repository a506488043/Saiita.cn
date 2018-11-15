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
					<table id="example2" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>登陆时间</th>
								<th>用户名</th>
								<th>结果</th>
								<th>登陆IP</th>
								<th>浏览器类型</th>
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
			$('#example2').DataTable({
				"paging" : true,
				"lengthChange" : true,
				"searching" : true,
				"ordering" : false,
				"info" : false,
				"autoWidth" : true,
				ajax : {
					url : 'getSafeLog',
					dataSrc : ''
				},
				columns : [ {
					data : 'datetime'
				}, {
					data : 'username'
				}, {
					data : 'result'
				}, {
					data : 'ip'
				}, {
					data : 'browser'
				} ],
				"oLanguage" : {
					"sLengthMenu" : "每页显示 _MENU_ 条记录",
					"sZeroRecords" : "正在读取数据",
					"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_条记录",
					"sInfoEmtpy" : "找不到相关数据",
					"sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
					"sProcessing" : "正在加载中...",
					"sSearch" : "搜索",
					"oPaginate" : {
						"sFirst" : "第一页",
						"sPrevious" : " 上一页 ",
						"sNext" : " 下一页 ",
						"sLast" : " 最后一页 "
					},}
			});
		});
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