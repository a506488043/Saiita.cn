<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="utf-8">
</head>
<body style="height: 60%; margin: 0">
	<div id="container" style="height: 100%"></div>
	<script src="../../bootstrap/js/echarts.min.js"></script>
	<script src="../../bootstrap/js/jquery-2.1.4.min.js"></script>
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
</body>
</html>