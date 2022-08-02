<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃폼 logoutPro</title>
</head>
<body>

	<%
	
		session.invalidate();	//모든 세션 삭제
		response.sendRedirect("../login/loginForm.jsp");
	
	%>

</body>
</html>