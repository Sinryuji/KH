<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<fieldset>
	<legend>회원 정보</legend>
	<form action="<%=request.getContextPath()%>/update" method="post">
	ID : <input type="text" name="userId" value="${member.userId}" readonly/><br>
	PW : <input type="password" name="userPw" value="${member.userPw}" /><br>
	NAME : <input type="text" name="userName" value="${member.userName}" readonly /><br>
	ADDR : <input type="text" name="userAddr" value="${member.userAddr}" /><br>
	<input type="submit" value="정보수정"/>
	</form>
</fieldset>
</body>
</html>


