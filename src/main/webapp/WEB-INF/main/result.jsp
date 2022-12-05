<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Result</title>
</head>

<body>
	<h1>스프링에서 응답된 뷰</h1>
	<hr />
	<h2>jsp코드로 출력하기: <%=request.getAttribute("msg")%></h2>
	<!-- expression language -->
	<h2>EL로 출력하기: ${msg}</h2>
</body>

</html>