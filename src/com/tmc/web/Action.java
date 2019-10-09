package com.tmc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(path.equals("/register")) {
			String userName = request.getParameter("username");
			System.out.println("username:" + userName);
		}
	}
}
