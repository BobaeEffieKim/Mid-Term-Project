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
<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
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
			<c:forEach var="vo" items="${boardList }">
			
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
	
  <div class="center">
  <div class="pagination">
  
  <c:if test="${pageInfo.prev }">
  	<a href="boardListPaging.do?pageNum=${pageInfo.startPage -1 }&amount=${pageInfo.cri.amount}">prev</a>
  </c:if>
  
  <c:forEach var="num" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
  	<a href="boardListPaging.do?pageNum=${num }&amount=${pageInfo.cri.amount}" class="${pageInfo.cri.pageNum == num?'active':'' }">${num }</a>
  </c:forEach>
  
  <!-- class="${pageInfo.cri.pageNum == num?'active':'' }"는 3항연산자로 선택페이지 색깔 주게 -->
  
  <c:if test="${pageInfo.next }">
  	<a href="boardListPaging.do?pageNum=${pageInfo.endPage +1 }&amount=${pageInfo.cri.amount}">next</a>
  </c:if>
  
  </div>
</div>
</body>
</html>