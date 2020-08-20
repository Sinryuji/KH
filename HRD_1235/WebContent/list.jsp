<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1235.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertStudent</title>
</head>
<body>
<header>
	<h1>학생 성적 관리 ver 1.0</h1>
</header>
<nav>
	<a href="insertStudent.jsp">학생 등록</a>
	<a href="list.jsp">학생 목록 조회/수정</a>
	<a href="insertScore.jsp">학생 성적 등록</a>
	<a href="listScore.jsp">학생 성적 조회</a>
</nav>
<section>
	<h3>학생 목록 조회/수정</h3>
	<table border="1">
		<tr>
			<th>학생번호</th>
			<th>학년</th>
			<th>반</th>
			<th>학생명</th>
			<th>전화번호</th>
		</tr>
		<% 
			Dao dao = new Dao();
			List<StudentVo> list = new ArrayList<StudentVo>();
			list = dao.list();
			StudentVo vo = null;
			for(int i = 0 ; i < list.size() ; i++){
				vo = list.get(i);
		%>
		<tr>
			<td><a href="updateStudent.jsp?stuno=<%=vo.getStuno() %>"><%= vo.getStuno() %></a></td>
			<td><%= vo.getStugrade() %></td>
			<td><%= vo.getStuclass() %></td>
			<td><%= vo.getStuname() %></td>
			<td><%= vo.getPhone() %></td>
		</tr>
		<%
			}
		%>
	</table>
</section>
<footer>
	HRDKOREA Copyrightⓒ2020 All right reserved. Human Resources Development Service of Korea.
</footer>
</body>
</html>