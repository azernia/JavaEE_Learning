package com.rui.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Request对象
 * 		Request对象中封存了当前请求信息的所有信息
 * 		作用：
 * 			获取请求头数据:键值对
 * 			行数据
 * 			用户数据
 * 		Request对象有Tomcat服务器创建，并作为实参传递给Servlet
 * @author Rui
 * Date 2021年1月20日 上午10:34:52
 */
public class RequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求头数据
		//获取请求方式
			String method = req.getMethod();
			System.out.println(method);
		//获取URL
			StringBuffer url = req.getRequestURL();
			System.out.println(url);
		//获取URI
			String uri = req.getRequestURI();
			System.out.println(uri);
		//获取协议
			String scheme = req.getScheme();
			System.out.println(scheme);
			
		//获取请求行
			String value = req.getHeader("");
			System.out.println(value);
		//获取全部的键名
			Enumeration e = req.getHeaderNames();
			while(e.hasMoreElements()) {
				String name = (String) e.nextElement();
				System.out.println(name);
			}
		//获取用户数据
		//getParameter不能获取同键不同值的多项选择数据
			String uname = req.getParameter("uname");
			String pwd = req.getParameter("pwd");
			String[] favs = req.getParameterValues("fav");
			System.out.println(uname + "-" + pwd);
	}
}
