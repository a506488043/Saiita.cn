<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Saiita.cn.service.GetInfo.getSafetyLog"%>
<%@page import="Saiita.cn.service.Page.PageUtil"%>
<%@page import="Saiita.cn.entity.SafeLog"%>
<%@page import="Saiita.cn.service.GetInfo.getSafetyLog"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆日志</title>
</head>
<body>
	<table>
		<tr>
			<th>用户名</th>
			<th>操作时间</th>
			<th>操作类型</th>
			<th>操作结果</th>
			<th>操作IP</th>
			<th>浏览器</th>
		</tr>
		<%
			String username = (String) request.getSession().getAttribute("username");
			String ip = (String) request.getSession().getAttribute("ip");
			String browserType = (String) request.getSession().getAttribute("browserType");
			getSafetyLog dao = new getSafetyLog();

			String pageStr = request.getParameter("page");
			int currentPage = 1;
			if (pageStr != null)
				currentPage = Integer.parseInt(pageStr);
			PageUtil pUtil = new PageUtil(10, dao.records(username, ip, browserType), currentPage);
			currentPage = pUtil.getCurrentPage();
		%>
		<%
			
		%>
		<%
			for (int i = pUtil.getFromIndex(); i < pUtil.getToIndex(); i++) {
				//PublisherModel model = (PublisherModel) records.get(i);
				List<SafeLog> list = getSafetyLog.getLogInfo(i);
				for (int j = 0; j < list.size(); j++) {
					SafeLog log = list.get(j);
		%>
		<tr>
			<td><%=log.getUsername()%></td>
			<td><%=log.getDatetime()%></td>
			<td><%=log.getOperation()%></td>
			<td><%=log.getResult()%></td>
			<td><%=log.getIp()%></td>
			<td><%=log.getBrowser()%></td>
		</tr>
		<%
			}
			}
		%>
		<tr>
			<td width=100% bgcolor="#eeeeee" colspan=6 align="center">记录总数<%=pUtil.getRecordCount()%>条
				当前页/总页数<%=currentPage%> /<%=pUtil.getPageCount()%>每页显示<%=pUtil.getPageSize()%>条
				<a href="SafetyLog.jsp?page=1">首页</a> <a
				href="SafetyLog.jsp?page=<%=(currentPage - 1)%>">上页</a> <a
				href="SafetyLog.jsp?page=<%=(currentPage + 1)%>">下页</a> <a
				href="SafetyLog.jsp?page=<%=pUtil.getPageCount()%>">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>