<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'method.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <!-- action中填写web.xml url-pattern对应的servlet -->
    <form action="req" method="get">
    	username: <input type="text" name="uname" value="">
    	pwd:<input type="text" name="pwd" value=""></br>
    	爱好：<br/>
    	<input type="checkbox" name="fav" value="1">唱歌
    	<input type="checkbox" name="fav" value="2">跳舞
    	<input type="checkbox" name="fav" value="3">看电影
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
