<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색</title>
</head>

<body>
	<div align="left">
		<form method="post" action="/springmvc/emp/search.do">
			<input type="hidden" name="test" value="paramtest">
			<h1>회원 검색</h1>
			<h3>
				<select name="search">
					<option value="name">사원명</option>
					<option value="grade">등급</option>
					<option value="addr">주소</option>
				</select> 
				<input type="text" name="addr" /> 
				<input type="submit" value="검색">
			</h3>
		</form>
	</div>
</body>
</html>