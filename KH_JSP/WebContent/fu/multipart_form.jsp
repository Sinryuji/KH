<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>multipart Test</title>
</head>
<body>
<section>
<article>
	<form action="/KH_JSP/upload" method="post" enctype="multipart/form-data">
		text1: <input type="text" name="text1"/><br>
		file1: <input type="file" name="file1"/><br>
		file2: <input type="file" name="file1"/><br>
		
		<input type="submit" value="전송"/>
	</form>
</article>
</section>
</body>
</html>