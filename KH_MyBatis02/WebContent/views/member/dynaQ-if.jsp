<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적쿼리</title>
</head>
<body>
	<h1>if구문</h1>
	<form action="<%=request.getContextPath()%>/memberList" method="POST">
		<input type="checkbox" name="chId"/>아이디
		<input type="checkbox" name="chPw"/>비밀번호
		<input type="checkbox" name="chName"/>이름
		<input type="checkbox" name="chAddr"/>주소
		<input type="submit" value="정보요청"/>
	</form>
</body>
</html>


