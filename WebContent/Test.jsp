<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>table模块快速使用</title>
  <link rel="stylesheet" href="dist/layui/css/layui.css" media="all">
</head>
<body>
 
<table class="layui-table" lay-data="{height:315, url:'http://127.0.0.1:8080/Saiita/pages/tables/GetAllUserInfo', page:true, id:'test'}" lay-filter="test">
  <thead>
    <tr>
      <th lay-data="{field:'id', width:80, sort: true}">ID</th>
      <th lay-data="{field:'username', width:80}">用户名</th>
      <th lay-data="{field:'sex', width:80, sort: true}">性别</th>
      <th lay-data="{field:'city'}">城市</th>
      <th lay-data="{field:'sign'}">签名</th>
      <th lay-data="{field:'experience', sort: true}">积分</th>
      <th lay-data="{field:'score', sort: true}">评分</th>
      <th lay-data="{field:'classify'}">职业</th>
      <th lay-data="{field:'wealth', sort: true}">财富</th>
    </tr>
  </thead>
</table>
 
<script src="dist/layui/layui.js"></script>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 315
    ,url: 'http://127.0.0.1:8080/Saiita/pages/tables/GetAllUserInfo' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
      {field: 'username', title: '用户名', width:80, sort: true, fixed: 'left'}
      ,{field: 'creatime', title: '创建时间', width:80}
      ,{field: 'loginfailure', title: '登陆失败次数', width:80, sort: true}
      ,{field: 'loginSuccess', title: '登陆成功次数', width:80} 
      ,{field: 'lastLoginTime', title: '最后登陆时间', width: 177}
      ,{field: 'experience', title: '积分', width: 80, sort: true}
      ,{field: 'score', title: '评分', width: 80, sort: true}
      ,{field: 'classify', title: '职业', width: 80}
      ,{field: 'wealth', title: '财富', width: 135, sort: true}
    ]]
  });
  
});
</script>
</body>
</html>