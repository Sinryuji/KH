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
	<form id="insertStudentForm" action="insertStudentProc.jsp">
		<h3>학생 정보 등록</h3>
		<table border="1">
			<tr>
				<th>학년 :</th>
				<td><input type="text" id="stugrade" name="stugrade"></td>
			</tr>
			<tr>
				<th>반 :</th>
				<td><input type="text" id="stuclass" name="stuclass"></td>
			</tr>
			<tr>
				<th>학생명 :</th>
				<td><input type="text" id="stuname" name="stuname"></td>
			</tr>
			<tr>
				<th>전화번호 :</th>
				<td><input type="text" id="phone" name="phone" placeholder="-제외"></td>
			</tr>
		</table>
		<input type="button" id="insert" onclick="insertStu()" value="등록">&nbsp;<input type="button" id="list" onclick="listStu()" value="조회">
	</form>
</section>
<footer>
	HRDKOREA Copyrightⓒ2020 All right reserved. Human Resources Development Service of Korea.
</footer>
<script>
	function insertStu(){
		var stugarde = document.getElementById("stugrade");
		var stuclass = document.getElementById("stuclass");
		var stuname = document.getElementById("stuname");
		var phone = document.getElementById("phone");
		if(stugarde.value == ""){
			alert("학년을 입력하세요!");
			stugarde.focus();
			return;
		}
		if(stuclass.value == ""){
			alert("반을 입력하세요!");
			stuclass.focus();
			return;
		}
		if(stuname.value == ""){
			alert("학생명을 입력하세요!");
			stuname.focus();
			return;
		}
		if(phone.value == ""){
			alert("전화번호를 입력하세요!");
			phone.focus();
			return;
		}
		var insertStudentForm = document.getElementById("insertStudentForm");
		alert("학생등록이 완료되었습니다!")
		insertStudentForm.submit();
	}
	
	function listStu(){
		location.href="list.jsp";
	}
</script>
</body>
</html>