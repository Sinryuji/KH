<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "HRD_2929.*, java.util.*" %>
<%
	MemberDao dao = new MemberDao();
	List<MemberVo> ls = dao.getMemberList();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<h1>회원관리 ver 1.0</h1>
</header>

<nav>
<ul>
	<li><a href="regForm.jsp">회원등록</a></li>
	<li><a href="list.jsp">회원목록조회/수정</a></li>
	<li><a href="index.jsp">홈으로</a></li>
</ul>
</nav>

<h1>회원록록 조회/수정</h1>
<table border="1">
<tr><td>회원번호</td><td>회원성명</td><td>가입일자</td></tr>
<%
	for(int i = 0; i < ls.size(); i++){
		MemberVo vo = ls.get(i);
		%>
		<tr><td>
		<a href="updateForm.jsp?custno=<%= vo.getCustno() %>"><%= vo.getCustno() %></a></td><td><%= vo.getCustname() %></td><td><%= vo.getJoindate() %></td></tr>
		<%
	}
%>
</table>
<footer>
HRDKOREA Copyrightⓒ2016 All rights reserved. Human Resources Development Service of Korea
</footer>
</body>
</html>