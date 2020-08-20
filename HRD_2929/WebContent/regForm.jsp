<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "HRD_2929.MemberDao" %>
<%
	MemberDao dao = new MemberDao();
	int no = dao.getLastNumber();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function check(){
	custno = document.getElementById("custno");
	custname = document.getElementById("custname");
	joindate = document.getElementById("joindate");
	if(custno.value == ""){
		alert("회원번호가 입력되지 않았습니다.");
		custno.focus();
		return;
	}
	if(custname.value == ""){
		alert("회원성명이 입력되지 않았습니다.");
		custname.focus();
		return;
	}
	if(joindate.value == ""){
		alert("가입일자가 입력되지 않았습니다.");
		joindate.focus();
		return;
	}
	alert("회원등록이 완료되었습니다.");
	document.regForm.submit();
}
</script>
<body>
<header>
<h1>회원관리 ver 1.0</h1>
</header>

<nav>
<ul>
	<li><a href="regForm.jsp">회원등록</a></li>
	<li><a href="list.jsp">회원목록조회/수정</a></li>
	<li><a href="index.jsp">홈으로</a></li>
</ul>
</nav>

<section>
<h1>회원등록</h1>
<form method="post" action="regProc.jsp" name="regForm">
<table border="1">
	<tr>
		<td>회원번호(자동발생)</td><td><input type="text" name="custno" id="custno" value="<%= no %>"></td>
	</tr>
	<tr>
		<td>회원성명</td><td><input type="text" name="custname" id="custname"></td>
	</tr>
	<tr>
		<td>가입일자</td><td><input type="text" name="joindate" id="joindate"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="button" value="등록" onclick="check()"><input type="button" value="조회"></td>
	</tr>
</table>

</form>
</section>

<footer>
HRDKOREA Copyrightⓒ2016 All rights reserved. Human Resources Development Service of Korea
</footer>
</body>
</html>