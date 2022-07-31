<%@page import="com.dev.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//로그인 시도 시 에러메세지 전달
	RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
	
	MemberDAO dao = new MemberDAO();
	if(dao.loginCheck(id, password) == null){
		
		request.setAttribute("msg", "아이디와 비밀번호가 올바른지 확인해주세요.");
		rd.forward(request, response);
		//response.sendRedirect("loginForm.jsp");	 
	} else{
		session.setAttribute("loginId",id);
		response.sendRedirect("boardList.jsp");
	}
	
%>