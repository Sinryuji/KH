<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "hrd_1234.*, java.util.*" %>
<%
	Dao dao = new Dao();
	int custno = Integer.parseInt(request.getParameter("custno"));
	Vo vo = dao.select(custno);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<h2>홈쇼핑 회원 정보 수정</h2>
			<form id="updateForm" action="updateProc.jsp" method="post">
				<table border="1">
					<tr>
						<td><b>회원번호(자동발생)</b></td>
						<td><input type="text" id="custno" name="custno" value="<%= vo.getCustno() %>" readonly></td>
					</tr>
					<tr>
						<td><b>회원성명</b></td>
						<td><input type="text" id="custname" name="custname" value="<%= vo.getCustname() %>"></td>
					</tr>
					<tr>
						<td><b>회원전화</b></td>
						<td><input type="text" id="phone" name="phone" value="<%= vo.getPhone() %>"></td>
					</tr>
					<tr>
						<td><b>회원주소</b></td>
						<td><input type="text" id="address" name="address" value="<%= vo.getAddress() %>"></td>
					</tr>
					<tr>
						<td><b>가입일자</b></td>
						<td><input type="text" id="joindate" name="joindate" value="<%= vo.getJoindate() %>"></td>
					</tr>
					<tr>
						<td><b>고객등급[A:VIP,B:일반,C:직원]</b></td>
						<td><input type="text" id="grade" name="grade" value="<%= vo.getGrade() %>"></td>
					</tr>
					<tr>
						<td><b>도시코드</b></td>
						<td><input type="text" id="city" name="city" value="<%= vo.getCity() %>"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="button" value="수정" onclick="update();">&nbsp;<input type="button" id="select" value="조회" onclick="selectt();"></td>
					</tr>
				</table>
			</form>
</section>
<footer>
	HRDKOREA Copyrightⓒ2016 All rights reserved Human Resources Development Service of Korea.
</footer>
<script>
	function update() {
		
	}
</script>
</body>
</html>