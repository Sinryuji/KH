<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적쿼리</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/search2" method="get">
	이름: <input type="text" name="userName"/><br>
	주소: <input type="text" name="userAddr"/><br>
	<input type="submit" value="검색"/>
</form>
</body>
</html>


