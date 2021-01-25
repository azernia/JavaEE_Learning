package com.rui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet的使用流程
 * 1.创建Java类并继承HttpServlet
 * 2.复写service方法
 * 3.在service方法中书写逻辑
 * 4.在WebRoot目录下WEB-INF中的web.xml中配置servlet
 * @author Rui
 * Date 2021年1月19日 下午5:36:07
 */
public class MyServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Servelet 初始化完成");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("this is my first servlet");
		System.out.println("this is my first servlet");
	}
}
