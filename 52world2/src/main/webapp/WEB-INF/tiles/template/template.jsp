<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>2022 MINI HOMEPAGE</title>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet" />

<link rel="stylesheet" href="52world/css/main.css" />
</head>
<body>
	<div class="bookcover">
		<div class="bookdot">
			<div class="page">
				<!-- 왼쪽 화면 시작 -->
				<div class="left-container">
					<!-- 방문자수 -->
					<tiles:insertAttribute name="visiter"></tiles:insertAttribute>
					<!-- 프로필 -->
					<tiles:insertAttribute name="profile"></tiles:insertAttribute>
				</div>
				<!-- 왼쪽 화면 끝 -->

				<!-- 가운데화면 시작 -->
				<div class="middle-container">
					<!-- 미니홈피 제목 -->
					<tiles:insertAttribute name="title"></tiles:insertAttribute>
					<!-- 메인페이지 -->
					<tiles:insertAttribute name="middle"></tiles:insertAttribute>
				</div>
				<!-- 가운데 화면 끝 -->

				<!-- 오른쪽 탭 화면 시작 -->
				<tiles:insertAttribute name="tab"></tiles:insertAttribute>
				<!-- 오른쪽 탭화면 끝 -->
			</div>
		</div>
	</div>
	<script>
		function editProfile() {
			let src = document.querySelector(".profile-img").src;
			window.open("52world/editProfile.html?src=" + src, "프로필 수정",
					"width= 450px, height= 650px");
		}
	</script>

</body>
</html>