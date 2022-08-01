package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.log.MemberLoginControl;
import com.dev.log.MemberLoginFormControl;

public class FrontController extends HttpServlet {

	String enc;
	Map<String, Controller> mappings;

	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("charset");
		mappings = new HashMap<>();
		mappings.put("/minihomepee.do", new MiniHomepeeController());
		mappings.put("/profile.do", new ProfileController());
		
		//logIn
		mappings.put("/memberLoginForm.do", new MemberLoginFormControl()); //로그인 화면
		mappings.put("/memberLogin.do", new MemberLoginControl()); //로그인 처리
	
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = uri.substring(contextPath.length());
		System.out.println(path);
		mappings.get(path).execute(req, resp);

	}
}
