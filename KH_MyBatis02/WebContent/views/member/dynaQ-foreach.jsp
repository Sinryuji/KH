<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적쿼리</title>
</head>
<body>
	<h1>foreach구문</h1>
	<form action="<%=request.getContextPath()%>/search3" method="get">
		<input type="checkbox" name="addr" value="서울시"/>서울
		<input type="checkbox" name="addr" value="경기도"/>경기
		<input type="checkbox" name="addr" value="전라도"/>전라
		<input type="checkbox" name="addr" value="강원도"/>강원
		<br>
		<input type="submit" value="검색"/>
	</form>
</body>
</html>


