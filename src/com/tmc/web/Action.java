package com.tmc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmc.DAO.UserDAO;
import com.tmc.DAOImpl.UserDAOImpl;

public class Action extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置request、response字符编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取请求完整路径
		String url = request.getRequestURI();
		// 截取请求
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		UserDAO userInfo = new UserDAOImpl();
		if(path.equals("/register")) {
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");
			String phone = request.getParameter("phone");
			userInfo.userAdd(userName, passWord, phone);
			response.sendRedirect("login.html");
		}else if (path.equals("/login")) {
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");
			int flag = userInfo.userLogin(userName, passWord);
			if(flag == 1) {
				response.sendRedirect("console1.html");
			}else {
				response.sendRedirect("system/userNotFound.html");
			}
		}
	}
}
