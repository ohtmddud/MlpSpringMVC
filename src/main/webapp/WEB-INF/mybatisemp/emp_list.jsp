<%@page import="emp.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<%
ArrayList<EmpDTO> empList = (ArrayList<EmpDTO>) request.getAttribute("empList");
int size = empList.size();
%>

</head>
<body>
	<div>
	<jsp:include page="../emp/search.jsp"></jsp:include>
	</div>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th>사원코드</th>
					<th>사원명</th>
					<th>입사일</th>
					<th>등급</th>
					<th>주소</th>
					<th>부서코드</th>
					<th>삭제</th>
				</tr>
			</thead>			
			<tbody>
				<%
				for (int i = 0; i < size; i++) {
					EmpDTO emp = empList.get(i);
				%>
				<tr>
					<td><a href='/springmvc/emp/read.do?id=<%=emp.getId() %>'><%=emp.getId()%></a></td>
					<td><%=emp.getName()%></td>
					<td><%=emp.getDeptno()%></td>
					<td><%=emp.getGrade()%></td>
					<td><%=emp.getAddr()%></td>
					<td><%=emp.getPoint()%></td>
					<td><a href='/springmvc/emp/delete.do?id=<%=emp.getId() %>'>삭제</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>
