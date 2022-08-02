<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login/loginForm</title>
</head>
<body>
	<script type="text/javascript">
	
		function formCheck(){
			if(frm.id.value == ""){
				alert("아이디를 입력하세요.");
				frm.id.focus();
				return false;
			}
			
			if(frm.password.value == ""){
				alert("패스워드를 입력하세요.");
				frm.password.focus();
				return false;
			}
			frm.submit();
		}
	
	</script>
	
<div align="center">
	<div>
		<h1>로그인</h1>
	</div>
	<div>
		<form id="frm" name="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="300"><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<th width="150">패스워드</th>
						<td width="300"><input type="password" id="password" name="password"></td>
					</tr>
				</table>
			</div><br />
			<div>
				<button type="button" onclick="formCheck()">로그인</button>&nbsp;&nbsp;&nbsp;
				<button type="reset">취 소</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='memberJoinForm.jsp'">회원가입</button>
			</div>
			
			<div class="forgot">
				<a href="idFind.jsp" class="idFind"><span>아이디 찾기</span></a>
				<a href="passwordFind.jsp" class="passwordFind"><span>비밀번호 찾기</span></a>
			</div>
			
		</form>
	</div>
</div>
	
</body>
</html>