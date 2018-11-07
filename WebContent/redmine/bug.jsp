<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="utf-8">
</head>
<body style="height: 100%; margin: 0">
	<div id="container" style="height: 100%"></div>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
	<script type="text/javascript"
		src="https://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
	<script type="text/javascript"
		src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
	<script type="text/javascript">
		var dom = document.getElementById("container");
		var myChart = echarts.init(dom);
		
		
		 myChart.setOption({
             title: {
                  text: '日Bug数量统计',
                  left:'left'
              },
              legend:{
                 data:['Bug数量']
              },
              xAxis:{
                 data:[]
              },
              yAxis:{},
             series : [{
                name:'Bug数量',
                type:'bar',
                data:[]
             }
             ]
         });
 
         myChart.showLoading({text: '数据正在加载中...'  }); 
         //这里设置定时器模拟数据延时加载
         setTimeout(function(){
            $.ajax({  
            	type:"get",
                url:"getTheBugDayReport",
				dataType : "json",
				success : function(jsonData) {
					myChart.setOption({
						xAxis : {
							data : jsonData.times
						},
						series : [ {
							// 根据名字对应到相应的系列  
							name : 'Bug数量',
							data : jsonData.datas
						} ]
					});
					// 设置加载等待隐藏  
					myChart.hideLoading();
				}
			});
		}, 2000);
	</script>
</body>
</html>