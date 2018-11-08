<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<button type="button" onclick ="a()" >提交</button>
<script src="../../bootstrap/js/jquery.js"></script>
<script type="text/javascript">
function a(){
	$.ajax({
		type:'post',
		url:'getTheBugDayReport.do',
		dataType:"json",
		success:function(data){
			alert("1");
			$.each(data,function(n,value){
				alert(value.days);
				alert(value.times);
			});
		},
		error:function(errorMsg){
			alert("2");
		}
	});
}
</script>
</body>
</html>