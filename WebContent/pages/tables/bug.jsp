<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html style="height: 100%">
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
</head>
<body style="height: 70%; margin: 2">
	<div id="container" style="height: 30%"></div>
	<div id="container1" style="height: 30%"></div>
	<div id="container2" style="height: 30%"></div>
	
	<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">Bug数量表格</h3>
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
					</table>
				</div>
			</div>
			<!-- BOX -->

		</div>
	</div>
	</section>
	<script src="../../bootstrap/js/echarts.min.js"></script>
	<script src="../../bootstrap/js/jquery-2.1.4.min.js"></script>
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
	<!-- 第一个 -->
	<script type="text/javascript">
		var myChart = echarts.init(document.getElementById('container'));
		var xdata = [];
		var ydata = [];
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '日Bug数量统计'
			},
			tooltip : {},
			legend : {
				data : [ 'Bug数量' ]
			},
			xAxis : {
				data : []
			},
			yAxis : {},
			series : [ {
				name : 'Bug数量',
				type : 'bar',
				data : []
			} ]
		};
		myChart.showLoading({
			text : '数据正在加载中...'
		});
		//这里设置定时器模拟数据延时加载
		setTimeout(function() {
			$.ajax({
				url : "getTheBugDayReport.do",
				dataType : "json",
				success : function(jsonData) {
					$.each(jsonData, function(n, value) {
						xdata.push(value.days);
						ydata.push(value.times);
					});
					myChart.setOption({
						xAxis : {
							data : xdata
						},
						series : [ {
							// 根据名字对应到相应的系列  
							name : 'Bug数量',
							data : ydata
						} ]
					});
					// 设置加载等待隐藏  
					myChart.hideLoading();
				}
			});
		}, 20);
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	</script>
	<!-- 第二个 -->
	<script type="text/javascript">
		var myChart1 = echarts.init(document.getElementById('container1'));
		var xdata1 = [];
		var ydata1 = [];
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '周Bug数量统计'
			},
			tooltip : {},
			legend : {
				data : [ 'Bug数量' ]
			},
			xAxis : {
				data : []
			},
			yAxis : {},
			series : [ {
				name : 'Bug数量',
				type : 'bar',
				data : []
			} ]
		};
		myChart1.showLoading({
			text : '数据正在加载中...'
		});
		//这里设置定时器模拟数据延时加载
		setTimeout(function() {
			$.ajax({
				url : "getTheBugDayReport.do",
				dataType : "json",
				success : function(jsonData) {
					$.each(jsonData, function(n, value) {
						xdata1.push(value.days);
						ydata1.push(value.times);
					});
					myChart1.setOption({
						xAxis : {
							data : xdata1
						},
						series : [ {
							// 根据名字对应到相应的系列  
							name : 'Bug数量',
							data : ydata1
						} ]
					});
					// 设置加载等待隐藏  
					myChart1.hideLoading();
				}
			});
		}, 20);
		// 使用刚指定的配置项和数据显示图表。
		myChart1.setOption(option);
	</script>
	<!-- 第三个 -->
	<script type="text/javascript">
		var myChart3 = echarts.init(document.getElementById('container2'));
		var xdata2 = [];
		var ydata2 = [];
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '月Bug数量统计'
			},
			tooltip : {},
			legend : {
				data : [ 'Bug数量' ]
			},
			xAxis : {
				data : []
			},
			yAxis : {},
			series : [ {
				name : 'Bug数量',
				type : 'bar',
				data : []
			} ]
		};
		myChart3.showLoading({
			text : '数据正在加载中...'
		});
		//这里设置定时器模拟数据延时加载
		setTimeout(function() {
			$.ajax({
				url : "getTheBugDayReport.do",
				dataType : "json",
				success : function(jsonData) {
					$.each(jsonData, function(n, value) {
						xdata2.push(value.days);
						ydata2.push(value.times);
					});
					myChart3.setOption({
						xAxis : {
							data : xdata2
						},
						series : [ {
							// 根据名字对应到相应的系列  
							name : 'Bug数量',
							data : ydata2
						} ]
					});
					// 设置加载等待隐藏  
					myChart3.hideLoading();
				}
			});
		}, 20);
		// 使用刚指定的配置项和数据显示图表。
		myChart3.setOption(option);
	</script>
	<!-- page script -->
	<script>
		$(function() {
			$("#example1").DataTable();
			$('#example2').DataTable({
				//"bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示 
				"paging" : true,
				"lengthChange" : false,
				"searching" : true,
				"ordering" : false,
				"info" : true,
				"autoWidth" : true,
				"deferRender" : true,
				ajax : {
					url : 'GetAllAlpayInfo',
					dataSrc : '',
					method : 'get'
				},
				columns : [ {
					data : 'id'
				}, {
					data : 'paymentTime'
				}, {
					data : 'sourceTransation'
				}, {
					data : 'theDealingParty'
				}, {
					data : 'commodityName'
				}, {
					data : 'amount'
				}, {
					data : 'balanceOfPayments'
				}, {
					data : 'transationStatus'
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
					},
				}
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