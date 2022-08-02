<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인메인 loginMain</title>
</head>
<body>

	<script type="text/javascript">
	
		//로그아웃으로 이동
		function logoutPro(){
			location.href = "member/pro/logoutPro.jsp";
		}
	
	</script>

	<h2>메인화면입니다.</h2>

	<%
	
		//로그인 안됐을때
		if(session.getAttribute("sessionID") ==  null){
			out.println("로그인이 정상적으로 완료되지 않았습니다.");
			response.sendRedirect("WEB-INF/jsp/login/loginForm.jsp");	//로그인화면으로
		
		//로그인 됐을때	
		} else{
			
	%>
	
	<h3><%=session.getAttribute("sessionID") %>님 정상적으로 로그인 되었습니다.</h3>		
	
	<br><br>
	<input type="button" value="로그아웃" onclick="logoutPro()">
		
	<% } %>	
</body>
</html>