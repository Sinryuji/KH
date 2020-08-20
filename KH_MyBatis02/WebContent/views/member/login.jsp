<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<fieldset>
	<legend>로그인</legend>
	<form action="<%=request.getContextPath()%>/login" method="post">
	ID : <input type="text" name="userId"/><br>
	PW : <input type="password" name="userPw"/><br>
	<input type="submit" value="로그인"/>
	<input type="reset" value="취소"/>
	</form>
</fieldset>
</body>
</html>


