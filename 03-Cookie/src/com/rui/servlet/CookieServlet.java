package com.rui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//创建Cookie对象
		Cookie c = new Cookie("key", "thinkpad");
		//设置Cookie存储时间
		c.setMaxAge(3*24*3600);
		//设置Cookie有效路径,只有该路径才会附带Cookie
		c.setPath("/cookie/gc");
		//响应Cookie信息
		resp.addCookie(c);
	}
}
