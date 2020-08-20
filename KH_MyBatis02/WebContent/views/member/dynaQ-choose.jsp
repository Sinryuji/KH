<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적쿼리</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/search">
	<input type="radio" name="select" checked value="name"/>이름으로 검색
	<input type="radio" name="select" value="id"/>아이디로 검색
	입력: <input type="text" name="keyword"/>
	<input type="submit" value="검색"/>
</form>
</body>
</html>


