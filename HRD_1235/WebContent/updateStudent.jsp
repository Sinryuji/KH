<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1235.*" %>
<%
	StudentVo vo = new StudentVo();
	Dao dao = new Dao();
	int stuno = Integer.parseInt(request.getParameter("stuno"));
	vo = dao.select(stuno);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<form id="updateStudentForm" action="updateStudentProc.jsp">
		<h3>학생 정보 수정</h3>
		<table border="1">
			<tr>
				<th>학생번호:</th>
				<td><%= vo.getStuno() %>
				<input type="hidden" id="stuno" name="stuno" value="<%= vo.getStuno() %>"></td>
			</tr>
			<tr>
				<th>학년 :</th>
				<td><input type="text" id="stugrade" name="stugrade" value="<%= vo.getStugrade() %>"></td>
			</tr>
			<tr>
				<th>반 :</th>
				<td><input type="text" id="stuclass" name="stuclass" value="<%= vo.getStuclass() %>"></td>
			</tr>
			<tr>
				<th>학생명 :</th>
				<td><input type="text" id="stuname" name="stuname" value="<%= vo.getStuname() %>"></td>
			</tr>
			<tr>
				<th>전화번호 :</th>
				<td><input type="text" id="phone" name="phone" value="<%= vo.getPhone() %>"></td>
			</tr>
		</table>
		<input type="button" id="update" onclick="updateInfo();" value="수정">&nbsp;<input type="button" id="list" onclick="listStu();" value="조회">
	</form>
</section>
<footer>
	HRDKOREA Copyrightⓒ2020 All right reserved. Human Resources Development Service of Korea.
</footer>
<script>
	function updateInfo(){
		var updateStudentForm = document.getElementById("updateStudentForm");
		alert("학생정보수정이 완료되었습니다!")
		updateStudentForm.submit();
	}
	
	function listStu(){
		location.href="list.jsp";
	}
</script>
</body>
</html>