<%@page import="co.edu.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	
	<c:choose>
		<c:when test="${!empty member }">
			<h3><c:out value="${member.name }"></c:out>님으로 로그인했습니다.</h3>
		</c:when>
		<c:otherwise><h3>손님입니다.</h3></c:otherwise>
	</c:choose>
	
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>방문횟수</th>
			</tr>
		</thead>
		<tbody>
			<%
				BoardDAO dao = new BoardDAO();
				List<BoardVO> list = dao.boardList();
			%>
			<c:set var="boards" value="<%=list %>" />
			<c:forEach var="vo" items="${boards }">
			
				<tr>
					<td>${vo.seq }</td>
					<td>${vo.title }</td>
					<td>${vo.writer }</td>
					<td>${vo.writeDate }</td>
					<td>${vo.visitCnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>