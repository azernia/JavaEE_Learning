package com.rui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * service方法和doGet方法和都Post方法的区别
 * Servlet的常见错误
 * 1.404错误：资源未找到
 * 	原因一：请求地址servlet别名写错
 * 	原因二：虚拟项目名称拼写错误
 * 2.500错误：内部服务器错误
 * 	错误一：
 * 	java.lang.ClassNotFoundException: com.rui.servlet.ServletMethod
 * 	解决：
 * 	在web.xml中校验Servlet类全限定路径是否拼写错误
 * 	错误二：
 * 	service方法体的代码执行错误
 * 3.405错误：请求方式不支持
 * @author Rui
 * Date 2021年1月20日 上午9:44:48
 */
public class ServletMethod extends HttpServlet {
	/**
	 * 不管时post请求还是get请求service方法都可以处理
	 * 如果Servlet中有service方法会优先调用service方法对请求进行处理
	 * 如果在service方法中调用了父类的service方法，则在service处理完后会根据请求方式调用doGet和doPost方法
	 * 一般情况下不在service方法中调用父类的方法，避免出现405错误
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("I am service");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("I am doGet method");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("I am doPost");
	}
}
