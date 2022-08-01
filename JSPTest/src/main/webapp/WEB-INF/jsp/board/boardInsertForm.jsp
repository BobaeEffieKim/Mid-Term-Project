<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "co.edu.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
<%
	MemberVO vo = (MemberVO) session.getAttribute("member");
	
	if(vo == null) {
%>
<script>
	alert('로그인을 먼저 하세요.');
</script>
<div align="center">
	<div>
		<h1>게시글 등록</h1>
	</div>
	<div>
		<form id="frm" name="frm" action="insertBoard.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">제목</th>
						<td width="300"><input type="text" id="title" name="title" readonly></td>
					</tr>
					<tr>
						<th width="150">작성자</th>
						<td width="300"><input type="text" id="writer" name="writer" readonly></td>
					</tr>
					<tr>
						<th width="150">내용</th>
						<td width="300"><textarea id="content" name="content" readonly></textarea></td>
					</tr>
				</table>
			</div><br />
			<div>
				<button type="submit">작성</button>&nbsp;&nbsp;&nbsp;
				<button type="reset">취 소</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='main.do'">홈</button>
			</div>
		</form>
	</div>
</div>
<% } else { %>

<div align="center">
	<div>
		<h1>게시글 등록</h1>
	</div>
	<div>
		<form id="frm" name="frm" action="insertBoard.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">제목</th>
						<td width="300"><input type="text" id="title" name="title"></td>
					</tr>
					<tr>
						<th width="150">작성자</th>
						<td width="300"><input type="text" id="writer" name="writer" value=${member.id } readonly></td>
					</tr>
					<tr>
						<th width="150">내용</th>
						<td width="300"><textarea id="content" name="content"></textarea></td>
					</tr>
				</table>
			</div><br />
			<div>
				<button type="submit">작성</button>&nbsp;&nbsp;&nbsp;
				<button type="reset">취 소</button>&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='main.do'">홈</button>
			</div>
		</form>
	</div>
</div>
<% } %>
</body>
</html>