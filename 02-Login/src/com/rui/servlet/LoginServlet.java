package com.rui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rui.pojo.User;
import com.rui.service.LoginService;
import com.rui.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	//一次请求内的servlet共享同一个request对象，但是第二个Servlet需要第一个Servlet的处理建议
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//设置响应编码格式，在获取数据之前设置
		//req.setCharacterEncoding("utf-8"); 	//post方式
		req.setCharacterEncoding("utf-8");		//get方式还需修改serve.xml文件
		String uname = req.getParameter("uname");
		//uname = new String(uname.getBytes("ios8859-1"), "utf-8");	//转码万能的，不分请求方式
		String pwd = req.getParameter("pwd");
		System.out.println(uname + ":" + pwd);
		//获取业务层数据对象
		LoginService ls = new LoginServiceImpl();
		User u = ls.checkLogin(uname, pwd);
		System.out.println(u);
		if(u != null) {
			//resp.getWriter().write("Login Success");
			//重定向本地资源URI，网络资源URL
			//有两次请求，会生成两个request对象
			//在提交中有表单数据且数据重要时建议使用重定向或Servlet接收后无法处理重定向到可处理的资源
			resp.sendRedirect("/02-login/main");		//写法二:resp.sendRedirect("/02-login/main");
		} else {
			//resp.getWriter().write("Login Fail");
			//使用request对象实现不同servlet的数据流转
			req.setAttribute("str", "用户名或密码错误");
			//使用请求转发,要转发的地址是相对路径，直接书写Servlet的别名,一次请求地址栏信息不变
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}
	}
}
