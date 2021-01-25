package com.rui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet的生命周期
 * 在服务器未关闭时一直存在
 * 在服务器关闭时销毁
 * 若Servlet在web.xml中配置了load-on-startup，生命周期为服务器启动到服务器关闭
 * @author Rui
 * Date 2021年1月20日 上午8:48:47
 */
public class ServletLlfe extends HttpServlet {
	/**
	 * 初始化，在Servlet第一次加载内存时被调用
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("Servelet 初始化完成");
	}
	/**
	 * service方法真正处理请求的方法
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Servlet life");
		System.out.println("Servlet life");
	}
	/**
	 * 在服务器关闭时销毁,早服务器销毁时调用
	 */
	@Override
	public void destroy() {
		System.out.println("我被销毁了");
	}
}
