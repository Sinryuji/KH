<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form id="insertScoreForm" action="insertScoreProc.jsp">
		<h3>학생 성적 등록</h3>
		<table border="1">
			<tr>
				<th>학생번호 :</th>
				<td><input type="text" id="stuno" name="stuno"></td>
			</tr>
			<tr>
				<th>시험명 :</th>
				<td><select id="exam" name="exam">
					<option value="">=시험명=</option>
					<option value="중간고사">중간고사</option>
					<option value="기말고사">기말고사</option>
				</select></td>
			</tr>
			<tr>
				<th>국어점수 :</th>
				<td><input type="text" id="korean" name="korean"></td>
			</tr>
			<tr>
				<th>영어점수 :</th>
				<td><input type="text" id="english" name="english" ></td>
			</tr>
			<tr>
				<th>수학점수 :</th>
				<td><input type="text" id="math" name="math" ></td>
			</tr>
		</table>
		<input type="button" id="insert" onclick="insertSco()" value="등록">&nbsp;<input type="button" id="list" onclick="listStu()" value="조회">
	</form>
</section>
<footer>
	HRDKOREA Copyrightⓒ2020 All right reserved. Human Resources Development Service of Korea.
</footer>
<script>
	function insertSco(){
		var stuno = document.getElementById("stuno");
		var exam = document.getElementById("exam");
		var korean = document.getElementById("korean");
		var english = document.getElementById("english");
		var math = document.getElementById("math");
		if(stuno.value == ""){
			alert("학생번호를 입력하세요!");
			stuno.focus();
			return;
		}
		if(exam.value == ""){
			alert("시험명을 선택하세요!");
			exam.focus();
			return;
		}
		if(korean.value == ""){
			alert("국어 점수를 입력하세요!");
			korean.focus();
			return;
		}
		if(english.value == ""){
			alert("영어 점수를 입력하세요!");
			english.focus();
			return;
		}
		if(math.value == ""){
			alert("수학 점수를 입력하세요!");
			math.focus();
			return;
		}
		var insertSocreForm = document.getElementById("insertScoreForm");
		alert("학생성적정보 등록이 완료되었습니다!")
		insertScoreForm.submit();
	}
	
	function listStu(){
		location.href="list.jsp";
	}
</script>
</body>
</html>