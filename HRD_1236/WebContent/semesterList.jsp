<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1236.*, java.util.*" %>
<%
	DAO dao = new DAO();
	List<SemesterVO> list = new ArrayList<SemesterVO>();
	list = dao.semesterList();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<h1>강의 등록 프로그램  ver 1.0</h1>
</header>
<section>
	<h3>강의 목록 화면</h3>
	총 <%= list.size() %>개의 교과목이 있습니다.
	<table border="1">
		<tr>
			<th>ID</th>
			<th>과목명</th>
			<th>학점</th>
			<th>담당강사</th>
			<th>요일</th>
			<th>시작시간</th>
			<th>종료시간</th>
			<th>관리</th>
		</tr>
		<%
			SemesterVO sem = null;
			LectureVO lec = null;
			String week = null;
			for(int i = 0 ; i < list.size() ; i++) {
				sem = list.get(i);
				lec = dao.selectLecture(list.get(i).getLecturer());
				if(sem.getWeek() == 1){
					week = "월";
				}
				if(sem.getWeek() == 2){
					week = "화";
				}
				if(sem.getWeek() == 3){
					week = "수";
				}
				if(sem.getWeek() == 4){
					week = "목";
				}
				if(sem.getWeek() == 5){
					week = "금";
				}
				if(sem.getWeek() == 6){
					week = "토";
				}
		%>
			<tr>
				<td><%= sem.getId() %></td>
				<td><%= sem.getName() %></td>
				<td><%= sem.getPoint() %></td>
				<td><%= lec.getName() %></td>
				<td><%= week %></td>
				<td><%= sem.getStart_hour() %></td>
				<td><%= sem.getEnd_hour() %></td>
				<td><a href="updateSemesterForm.jsp?id=<%= sem.getId() %>">수정</a> / <a href="deleteSemesterPrco.jsp?id=<%= sem.getId() %>">삭제</a></td>
			</tr>
		<%
			}
		%>
	</table>
	<input type="button" value="작성" onclick="moveToInsertSemesterForm()">
</section>
<footer>
	HRDKOREA Copyrightⓒ2020 All right reserved. Human Resources Development Service of Korea.
</footer>
<script>
	function moveToInsertSemesterForm(){
		location.href="insertSemesterForm.jsp";
	}
</script>
</body>
</html>