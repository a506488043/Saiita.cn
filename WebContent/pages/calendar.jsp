<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Saiita.cn.service.GetInfo.*"%>
<%@page import="Saiita.cn.entity.calendar"%>
<%@page import="java.util.*"%>
<%@page import="Saiita.cn.service.GetInfo.Log.LogRecord"%>
<html>
<%
	LogRecord log = new LogRecord();
	HttpServletRequest req = (HttpServletRequest) request;
	HttpServletResponse res = (HttpServletResponse) response;
	session = req.getSession();
	String username = (String) session.getAttribute("username");
	log.log(username, request.getHeader("User-Agent"), request.getRemoteAddr(), "操作日志", "查询日历计划", "2");
%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- fullCalendar 2.2.5-->
<link rel="stylesheet"
	href="../plugins/fullcalendar/fullcalendar.min.css">
<link rel="stylesheet"
	href="../plugins/fullcalendar/fullcalendar.print.css" media="print">
<!-- Theme style -->
<link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header"> </header>
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-md-3">
					<div class="box box-solid">
						<div class="box-header with-border">
							<h4 class="box-title">可拖计划</h4>
						</div>
						<div class="box-body">
							<!-- the events -->
							<div id="external-events">
								<%
									List<calendar> list = getCalendarInfo.getCalendar();
									for (int i = 0; i < list.size(); i++) {
										calendar calendar = (calendar)list.get(i);
								%>
								<%=calendar.getDraggableEvents()%>
								<%
									}
								%>
								<div class="checkbox">
									<label for="drop-remove"> <input type="checkbox"
										id="drop-remove"> 移除计划
									</label>
								</div>
							</div>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /. box -->
					<div class="box box-solid">
						<div class="box-header with-border">
							<h3 class="box-title">创建计划</h3>
						</div>
						<div class="box-body">
							<div class="btn-group" style="width: 100%; margin-bottom: 10px;">
								<!--<button type="button" id="color-chooser-btn" class="btn btn-info btn-block dropdown-toggle" data-toggle="dropdown">Color <span class="caret"></span></button>-->
								<ul class="fc-color-picker" id="color-chooser">
									<li><a class="text-aqua" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-blue" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-light-blue" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-teal" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-yellow" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-orange" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-green" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-lime" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-red" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-purple" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-fuchsia" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-muted" href="#"><i
											class="fa fa-square"></i></a></li>
									<li><a class="text-navy" href="#"><i
											class="fa fa-square"></i></a></li>
								</ul>
							</div>
							<!-- /btn-group -->
							<div class="input-group">
								<input id="new-event" type="text" class="form-control"
									placeholder="计划标题">

								<div class="input-group-btn">
									<button id="add-new-event" type="button"
										class="btn btn-primary btn-flat">添加计划</button>
								</div>
								<!-- /btn-group -->
							</div>
							<!-- /input-group -->
						</div>
					</div>
				</div>
				<!-- /.col -->
				<div class="col-md-9">
					<div class="box box-primary">
						<div class="box-body no-padding">
							<!-- THE CALENDAR -->
							<div id="calendar"></div>
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /. box -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.control-sidebar -->
	<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
	<div class="control-sidebar-bg"></div>
	<!-- ./wrapper -->

	<!-- jQuery 2.2.3 -->
	<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<!-- Slimscroll -->
	<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="../plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="../dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="../dist/js/demo.js"></script>
	<!-- fullCalendar 2.2.5 -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
	<script src="../plugins/fullcalendar/fullcalendar.min.js"></script>
	<!-- Page specific script -->
	<script>
		$(function() {

			/* 初始化外部事件
			 -----------------------------------------------------------------*/
			function ini_events(ele) {
				ele.each(function() {

					// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
					// 它不需要有一个开始或结束
					var eventObject = {
						title : $.trim($(this).text())
					// 使用元素的文本作为事件标题
					};

					// 将事件对象存储在DOM元素中，以便稍后可以使用
					$(this).data('eventObject', eventObject);

					// 使用jQuery UI使事件可拖动
					$(this).draggable({
						zIndex : 1070,
						revert : true, // 会导致事件回到它的
						revertDuration : 0
					//  拖动后的原始位置
					});

				});
			}

			ini_events($('#external-events div.external-event'));

			/* 初始化日历
			 -----------------------------------------------------------------*/
			//日历事件的日期(虚拟数据)
			var date = new Date();
			var d = date.getDate(), m = date.getMonth(), y = date.getFullYear();
			$('#calendar').fullCalendar(
					{
						header : {
							left : 'prev,next today',
							center : 'title',
							right : 'month,agendaWeek,agendaDay'
						},
						buttonText : {
							today : '今天',
							month : '月份',
							week : '星期',
							day : '天'
						},
						//随机的违约事件
						events : [ {
							title : 'All Day Event',
							start : new Date(y, m, 1),
							backgroundColor : "#f56954", //red
							borderColor : "#f56954" //red
						}, {
							title : 'Long Event',
							start : new Date(y, m, d - 5),
							end : new Date(y, m, d - 2),
							backgroundColor : "#f39c12", //yellow
							borderColor : "#f39c12" //yellow
						}, {
							title : 'Meeting',
							start : new Date(y, m, d, 10, 30),
							allDay : true,
							backgroundColor : "#0073b7", //Blue
							borderColor : "#0073b7" //Blue
						}, {
							title : 'Lunch',
							start : new Date(y, m, d, 12, 0),
							end : new Date(y, m, d, 14, 0),
							allDay : false,
							backgroundColor : "#00c0ef", //Info (aqua)
							borderColor : "#00c0ef" //Info (aqua)
						}, {
							title : 'Birthday Party',
							start : new Date(y, m, d + 1, 19, 0),
							end : new Date(y, m, d + 1, 22, 30),
							allDay : false,
							backgroundColor : "#00a65a", //Success (green)
							borderColor : "#00a65a" //Success (green)
						}, {
							title : 'Click for Google',
							start : new Date(y, m, 28),
							end : new Date(y, m, 29),
							url : 'http://google.com/',
							backgroundColor : "#3c8dbc", //Primary (light-blue)
							borderColor : "#3c8dbc" //Primary (light-blue)
						} ],
						editable : true,
						droppable : true, // 这允许事情被放到日历上!!!
						drop : function(date, allDay) { // 当某个东西被删除时，将调用此函数

							// retrieve the dropped element's stored Event Object
							var originalEventObject = $(this).data(
									'eventObject');

							// 我们需要复制它，这样多个事件就不会有对同一个对象的引用
							var copiedEventObject = $.extend({},
									originalEventObject);

							// assign it the date that was reported
							copiedEventObject.start = date;
							copiedEventObject.allDay = allDay;
							copiedEventObject.backgroundColor = $(this).css(
									"background-color");
							copiedEventObject.borderColor = $(this).css(
									"border-color");

							// render the event on the calendar
							// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
							$('#calendar').fullCalendar('renderEvent',
									copiedEventObject, true);

							// is the "remove after drop" checkbox checked?
							if ($('#drop-remove').is(':checked')) {
								// if so, remove the element from the "Draggable Events" list
								$(this).remove();
							}

						}
					});

			/* ADDING EVENTS */
			var currColor = "#3c8dbc"; //Red by default
			//Color chooser button
			var colorChooser = $("#color-chooser-btn");
			$("#color-chooser > li > a").click(function(e) {
				e.preventDefault();
				//Save color
				currColor = $(this).css("color");
				//Add color effect to button
				$('#add-new-event').css({
					"background-color" : currColor,
					"border-color" : currColor
				});
			});
			$("#add-new-event").click(function(e) {
				e.preventDefault();
				//Get value and make sure it is not null
				var val = $("#new-event").val();
				if (val.length == 0) {
					return;
				}

				//Create events
				var event = $("<div />");
				event.css({
					"background-color" : currColor,
					"border-color" : currColor,
					"color" : "#fff"
				}).addClass("external-event");
				event.html(val);
				$('#external-events').prepend(event);

				//Add draggable funtionality
				ini_events(event);

				//Remove event from text input
				$("#new-event").val("");
			});
		});
	</script>
</body>
</html>
