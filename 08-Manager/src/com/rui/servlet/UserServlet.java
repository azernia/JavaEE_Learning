package com.rui.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.rui.pojo.User;
import com.rui.service.UserService;
import com.rui.service.impl.UserServiceImpl;
/**
 * Servlet重定向路径总结：
 * 	相对路径：从当前请求的路径查找资源的路径
 * 		相对路径如果servlet的别名中包含目录，会造成重定向资源查找失败。
 * 	绝对路径：第一个/表示服务器根目录
 * 		/虚拟项目名/资源路径
 * 
 * Servlet请求转发：
 * 		/表示项目根目录。
 * 		req.getRequestDispatcher("/资源路径").forward(req, resp);
 * @author Rui
 * Date 2021年1月21日 下午5:52:01
 */
public class UserServlet extends HttpServlet {
	Logger logger = Logger.getLogger(UserServlet.class);
	private UserService us = new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String oper = req.getParameter("oper");
		switch(oper) {
		case "login":
			checkUserLogin(req, resp);
			break;
		case "reg":
			userReg(req, resp);
			break;
		case "out":
			userOut(req, resp);
			break;
		case "pwd":
			modifyPwd(req, resp);
			break;
		case "show":
			showUser(req, resp);
			break;
			default:
				logger.debug("This opration is not found:" + oper );
		}
//		if("login".equals(oper)) {
//			checkUserLogin(req, resp);
//		} else if("reg".equals("reg")) {
//			
//		} else if("out".equals("out")) {
//			userOut(req, resp);
//		} else if("pwd".equals("pwd")) {
//			modifyPwd(req, resp);
//		}else {
//			logger.debug("This opration is not found:" + oper );
//		}
	}
	
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		String sex=req.getParameter("sex");
		int age=req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
		String birthday=req.getParameter("birthday");
		String[] bs = null;
		if(birthday != null) {
			bs = birthday.split("/");
			birthday = bs[2]+"-"+bs[0]+"-"+bs[1];
		}
//		StringBuffer sb = new StringBuffer();
//		for(int i = 2; i >= 0; i--) {
//			if(i > 0) {
//				sb.append(bs[i]);
//				sb.append("-");
//			}else {
//				sb.append(bs[i]);
//			}
//		}
		User u = new User(uname, pwd, sex, age, birthday);
		int index = us.userRegService(u);
		if(index>0){
			//获取session
			HttpSession hs=req.getSession();
			hs.setAttribute("reg", "true");
			//重定向
			resp.sendRedirect("/mg/login.jsp");
		}
	}

	private void showUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = us.userShowService();
		req.setAttribute("lu", list);
		req.getRequestDispatcher("/user/showUser.jsp").forward(req, resp);
		return;
	}

	private void modifyPwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String newPwd = req.getParameter("newPwd");
		User u = (User)req.getSession().getAttribute("user");
		int uid = u.getUid();
		int index = us.userChangePwdService(newPwd, uid);
		if(index > 0) {
			HttpSession hs = req.getSession();
			hs.setAttribute("pwd", "true");
			resp.sendRedirect("/mg/login.jsp");
		}
	}

	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession hs = req.getSession();
		hs.invalidate();
		resp.sendRedirect("/mg/login.jsp");
	}

	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		User u = us.checkUserLoginService(uname, pwd);
		if(u != null) {
			HttpSession hs = req.getSession();
			hs.setAttribute("user", u);
			resp.sendRedirect("/mg/main/main.jsp");
			return;
		} else {
			req.setAttribute("flag", 0);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
