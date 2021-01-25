package com.rui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Response对象
 * 响应数据到浏览器的一个对象
 * 设置响应头
 * 设置响应实体
 * @author Rui
 * Date 2021年1月20日 上午11:20:18
 */
public class ResponseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求信息
		//获取请求头
		//获取请求行
		//获取用户数据
		//处理请求
		//响应处理结果
		//设置响应头
		resp.setHeader("mouse", "two fly birds");		//在响应头中添加响应信息，但是同键会覆盖
		resp.addHeader("key", "thinkpad");				//在响应头中添加响应信息，但是不会覆盖
		//设置响应码
		//resp.sendError(404, "Sorry");
		//设置响应编码格式
		//resp.setHeader("content-type", "text/html;charset=utf-8");
		//text/html,text/xml,text/plain
		resp.setContentType("text/html;charset=utf-8");
		//设置响应实体
		resp.getWriter().write("中文");
	}
}
