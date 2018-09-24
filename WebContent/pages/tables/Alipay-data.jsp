<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Saiita.cn.service.GetInfo.getAllAlpayInfo"%>
<%@page import="Saiita.cn.entity.alipayInfo"%>
<%@page import="java.util.*"%>
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
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">支付宝</h3>
				</div>
				<!-- /.box-header -->
				<div class="overlay" id="divprogressbar">
					<i class="fa fa-refresh fa-spin"> </i>
				</div>
				<div class="box-body">
					<table id="example2" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>付款时间</th>
								<th>交易来源地</th>
								<th>交易对方</th>
								<th>商品名称</th>
								<th>金额</th>
								<th>收/支</th>
								<th>交易状态</th>
							</tr>
						</thead>
						<tbody>
							<%
								LogRecord log = new LogRecord();
								HttpServletRequest req = (HttpServletRequest) request;
								HttpServletResponse res = (HttpServletResponse) response;
								session = req.getSession();
								String username = (String) session.getAttribute("username");
								log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), "操作日志", "查询支付宝账单", "2");

								List<alipayInfo> list = getAllAlpayInfo.getAllAlpay();
								for (int i = 0; i < list.size(); i++) {
									alipayInfo alipay = list.get(i);
							%>
							<tr>
								<td><%=alipay.getId()%></td>
								<td><%=alipay.getRecentModificationTime()%></td>
								<td><%=alipay.getSourceTransation()%></td>
								<td><%=alipay.getTheDealingParty()%></td>
								<td><%=alipay.getCommodityName()%></td>
								<td><%=alipay.getAmount()%></td>
								<td><%=alipay.getBalanceOfPayments()%></td>
								<td><%=alipay.getTransationStatus()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<!-- BOX -->
		</div>
	</div>
	</section>
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
	<script>
		$(function() {
			$("#example1").DataTable();
			$('#example2').DataTable({
				"paging" : true,
				"lengthChange" : false,
				"searching" : true,
				"ordering" : true,
				"info" : true,
				"autoWidth" : false
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