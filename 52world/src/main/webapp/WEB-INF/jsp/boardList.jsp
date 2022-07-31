<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
</head>
<body>

	<c:choose>
		<c:when test="${!empty loginId}">
			<h3><c:out value="${loginId}"></c:out>님으로 로그인했습니다.</h3>
	         <a href="logout.jsp"><input type="button" value="로그아웃"></a>
		</c:when>
		<c:otherwise>
			<h3>손님입니다.</h3>
         	<a href="login.jsp"><input type="button" value="로그인"></a>
		</c:otherwise>
	</c:choose>

</body>
</html>