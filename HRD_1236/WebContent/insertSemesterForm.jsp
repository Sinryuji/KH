<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1236.*, java.util.*"%>
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
	<h3>강의 등록 화면</h3>
	<form id="insertSemesterForm" action="insertSemesterProc.jsp">
	<table border="1">
		<tr>
			<th>과목 명</th>
			<td><input type="text" id="name" name="name"></td>
		</tr>
		<tr>
			<th>담당 강사</th>
			<td>
				<select id="lecturer" name="lecturer">
					<% 
						DAO dao = new DAO();
						LectureVO lec = null;
						List<LectureVO> list = new ArrayList<LectureVO>();
						list = dao.lectureList();
						for(int i = 0 ; i < list.size() ; i++){
							lec = list.get(i);
					%>
						<option value=<%= lec.getIdx() %>><%= lec.getName() %> : <%= lec.getMajor() %></option>
					<%
						}
					%>		
				</select>
			</td>
		</tr>
		<tr>
			<th>학점</th>
			<td><input type="text" id="point" name="point"></td>
		</tr>
		<tr>
			<th>요일</th>
			<td>
				<input type="radio" name="week" value="1">월
				<input type="radio" name="week" value="2">화
				<input type="radio" name="week" value="3">수
				<input type="radio" name="week" value="4">목
				<input type="radio" name="week" value="5">금
				<input type="radio" name="week" value="6">토
			</td>
		</tr>
		<tr>
			<th>시작</th>
			<td><input type="text" id="start_hour" name="start_hour" placeholder="HHMM"></td>
		</tr>
		<tr>
			<th>종료</th>
			<td><input type="text" id="end_hour" name="end_hour" placeholder="HHMM"></td>
		</tr>
	</table>
	<input type="button" value="등록" onclick="insertLecture();">&nbsp;<input type="button" value="조회">
	</form>
</section>
<footer>
	HRDKOREA Copyrightⓒ2020 All right reserved. Human Resources Development Service of Korea.
</footer>
<script>
	function insertLecture(){
		var name = document.getElementById("name");
		var lecturer = document.getElementById("lecturer");
		var point = document.getElementById("point");
		var week = document.getElementsByName("week");
		var start_hour = document.getElementById("start_hour");
		var end_hour = document.getElementById("end_hour");
		
		if(name.value == ""){
			alert("과목 명을 입력하세요!");
			name.focus();
			return;
		}
		if(lecturer.value == ""){
			alert("담당 강사를 선택하세요!");
			lecturer.focus();
			return;
		}
		if(point.value == ""){
			alert("학점을 입력하세요!");
			point.focus();
			return;
		}
		var bool = false;
		for(var i = 0 ; i < week.length ; i++){
			if(week[i].value != "") {
				bool = true;
			}
		}
		if(bool == false){
			alert("요일은 선택하세요!");
			week.get(0).focus();
			return;
		}
		if(start_hour.value == ""){
			alert("시작시간을 입력하세요!");
			start_hour.focus();
			return;
		}
		if(end_hour.value == ""){
			alert("종료시간을 입력하세요!");
			end_hour.focus();
			return;
		}
		
		var insertSemesterForm = document.getElementById("insertSemesterForm");
		alert("강의 등록이 완료되었습니다!");
		insertSemesterForm.submit();
	}
</script>
</body>
</html>