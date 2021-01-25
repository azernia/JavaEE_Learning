<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'my.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 
	Ajax学习：
		1、ajax的概念
			局部刷新技术。不是一门新技术，是多种技术的组合。是浏览器端的技术。
		2、ajax的作用
			实现在当前结果页中显示其他请求的响应内容
		3、ajax的使用
			ajax的基本流程
				//创建ajax引擎对象
				//复写onreadystatement函数
					//判断ajax状态码
						//判断响应状态码
							//获取响应内容(响应内容的格式)
								//普通字符串：responseText
								//json(重点)：responseText
									其实就是讲述数据按照json的格式拼接好的字符串，方便使用eval方法
									将接受的字符串数据直接转换为js的对象
									
									json格式：
										var 对象名={
												属性名:属性值,
												属性名:属性值,
												……
											}
									
								//XML数据：responseXML.返回document对象
									通过document对象将数据从xml中获取出来
							//处理响应内容(js操作文档结构)
				//发送请求
					//get请求
						get的请求实体拼接在URL后面，？隔开，键值对
						ajax.open("get","url");
						ajax.send(null);
					//post请求
						有单独的请求实体
						ajax.open("post", "url");
						ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
						ajax.send("name=张三&pwd=123");
			ajax的状态码
				ajax状态码:
					readyState：0,1,2,3,4
						4: 表示响应内容被成功接收
				响应状态码:
					status
					200:表示一切OK
					404:资源未找到
					500：内部服务器错误
			ajax的异步和同步
				ajax.open(method,urL,async)
				async：设置同步代码执行还是异步代码执行
					  true代表异步，默认是异步
					  false代表同步
 -->
	<!-- 声明js代码域 -->
	<script type="text/javascript">
		function getData(){
			//创建AJax引擎对象
			var ajax;
			if(window.XMLHttpRequest) {//火狐
				ajax = new XMLHttpRequest();
			} else if(window.ActiveXObject) {//IE
				ajax = new ActiveXObject("Msxml2.XMLHTTP");
			}
			//复写onreadystatement函数
			ajax.onreadystatechange = function() {
				//判断AJax状态码
				if(ajax.readyState == 4) {
					//判断响应状态码
					if(ajax.status == 200) {
						//获取响应内容
						var result = ajax.responseText;
						//获取元素对象
						var showdiv=document.getElementById("showdiv");
						showdiv.innerHTML=result;
					} else if(ajax.status == 404) {
						//获取元素对象
						var showdiv=document.getElementById("showdiv");
						showdiv.innerHTML="请求资源不存在";
					} else if(ajax.status == 500) {
						//获取元素对象
						var showdiv=document.getElementById("showdiv");
						showdiv.innerHTML="服务器繁忙";
					}
				} else {
						//获取元素对象
						var showdiv=document.getElementById("showdiv");
						showdiv.innerHTML="服务器繁忙";
				}
			}
			//发送请求 请求方式和请求地址
			ajax.open("get", "ajax");
			//post请求时有数据，放请求数据
			ajax.send(null);
			
		}
	</script>
	<style type="text/css">
		#showdiv{
			border:solid 1px;
			width:200px;
			height:100px; 
		}
	</style>
  </head>
  
  <body>
	<h3>欢迎登录403峡谷</h3>
	<hr>
	<input type="button" value="测试 " onclick="getData()"/>
	<div id="showdiv"></div>
  </body>
</html>
