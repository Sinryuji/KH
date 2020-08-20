<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Ajax</title>
</head>
<body>
<form method="post" action="hello.jsp">
이름:
<input type="text" name="name" size="15"/>
<input type="submit" name="submit" value="전송"/>
</form>
<%
	if(request.getParameter("name") != null ) {
		try{
			Thread.sleep(3000);
		}catch(Exception e){}
		out.println("안녕하세요. " + request.getParameter("name") + "님!");
	}
%>
</body>
</html>