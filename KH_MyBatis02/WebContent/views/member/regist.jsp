<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<fieldset>
	<legend>회원가입</legend>
	<form action="<%=request.getContextPath()%>/regist" method="post">
	ID : <input type="text" name="userId" value="test1"/><br>
	PW : <input type="password" name="userPw" value="1234"/><br>
	NAME : <input type="text" name="userName" value="lee"/><br>
	ADDR : <input type="text" name="userAddr" value="seoul"/><br>
	<input type="submit" value="회원가입"/>
	<input type="reset" value="다시입력"/>
	</form>
</fieldset>
</body>
</html>


