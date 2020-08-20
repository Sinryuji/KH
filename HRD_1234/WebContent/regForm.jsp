<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1234.*" %>
<%
	Dao dao = new Dao();
	int result = dao.getLastNumber();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regForm</title>
<script>
	function insert(){
		var custname = document.getElementById("custname");
		var phone = document.getElementById("phone");
		var address = document.getElementById("address");
		var joindate = document.getElementById("joindate");
		var grade = document.getElementById("grade");
		var city = document.getElementById("city");
		if(custname.value == "") {
			alert("회원성명을 입력하세요!");
			custname.focus();
			return;
		}
		if(phone.value == "") {
			alert("회원전화를 입력하세요!");
			pohne.focus();
			return;
		}
		if(address.value == "") {
			alert("회원주소를 입력하세요!");
			address.focus();
			return;
		}
		if(joindate.value == "") {
			alert("가입일자를 입력하세요!");
			joindate.focus();
			return;
		}
		if(grade.value == "") {
			alert("고객등급을 입력하세요!");
			grade.focus();
			return;
		}
		if(city.value == "") {
			alert("도시코드를 입력하세요!");
			city.focus();
			return;
		}
		var regForm = document.getElementById("regForm");
		alert("회원등록이 완료 되었습니다!");
		regForm.submit();
	};
	
	function selectt() {
		location.href="list.jsp";
	};
</script>
</head>
<body>
<header>
	쇼핑몰 회원관리 ver 1.0
</header>
<menu>
	<a href="regForm.jsp">회원등록</a>
	<a href="list.jsp">회원목록조회/수정</a>
	<a href="salesList.jsp">회원매출조회</a>
	<a href="index.jsp">홈으로</a>
</menu>
<section>
	<h2>홈쇼핑 회원 등록</h2>
		<form id="regForm" action="regProc.jsp" method="post">
			<table border="1">
				<tr>
					<td><b>회원번호(자동발생)</b></td>
					<td><input type="text" id="custno" name="custno" value="<%= result %>" readonly></td>
				</tr>
				<tr>
					<td><b>회원성명</b></td>
					<td><input type="text" id="custname" name="custname"></td>
				</tr>
				<tr>
					<td><b>회원전화</b></td>
					<td><input type="text" id="phone" name="phone"></td>
				</tr>
				<tr>
					<td><b>회원주소</b></td>
					<td><input type="text" id="address" name="address"></td>
				</tr>
				<tr>
					<td><b>가입일자</b></td>
					<td><input type="text" id="joindate" name="joindate"></td>
				</tr>
				<tr>
					<td><b>고객등급[A:VIP,B:일반,C:직원]</b></td>
					<td><input type="text" id="grade" name="grade"></td>
				</tr>
				<tr>
					<td><b>도시코드</b></td>
					<td><input type="text" id="city" name="city"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="등록" onclick="insert();">&nbsp;<input type="button" id="select" value="조회" onclick="selectt();"></td>
				</tr>
			</table>
		</form>
</section>
<footer>
	HRDKOREA Copyrightⓒ2016 All rights reserved Human Resources Development Service of Korea.
</footer>
</body>
</html>