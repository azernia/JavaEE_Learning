package com.rui.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionContextServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取ServletContext的三种方式
		//第一种
		ServletContext sc = this.getServletContext();
		//第二种
		ServletContext sc2 = this.getServletConfig().getServletContext();
		//第三种
		ServletContext sc3 = req.getSession().getServletContext();
		//使用ServletContext进行数据共享
		sc.setAttribute("str", "13");
		//获取web.xml全局配置数据
		//需要在web.xml中配置context-param
		sc.getInitParameter("name");
		//获取项目根目录资源的绝对路径
		String path = sc.getRealPath("/doc/1.txt");
		//获取根目录下资源的流对象
		InputStream is = sc.getResourceAsStream("/doc/1.txt");
	}
}
