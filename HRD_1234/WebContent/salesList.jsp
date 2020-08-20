<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "hrd_1234.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	쇼핑몰 회원관리 ver 1.0
</header>
<menu>
	<a href="regForm.jsp">회원등록</a>
	<a href="list.jsp">회원목록조회/수정</a>
	<a href="salesList.jsp">회원매출조회</a>
	<a href="index.jsp">홈으로</a>
</menu>
<section>
		<h2>회원목록조회/수정</h2>
		<table border="1">
			<tr>
				<th>
					<b>회원번호</b>
				</th>
				<th>
					<b>회원성명</b>
				</th>
				<th>
					<b>고객등급</b>
				</th>
				<th>
					<b>매출</b>
				</th>
			</tr>
				<%
					Dao dao = new Dao();
					List<Vo> list = new ArrayList<Vo>();
					list = dao.salesList();
					for(int i = 0 ; i < list.size() ; i++) {
						Vo vo = list.get(i);
				%>
					<tr>
					<td>
						<%= vo.getCustno() %>
					</td>
					<td>
						<%= vo.getCustname() %>
					</td>
					<td>
						<% if(vo.getGrade().equals("A")){ %>
						VIP
						<% } %>
						<% if(vo.getGrade().equals("B")){ %>
						일반
						<% } %>
						<% if(vo.getGrade().equals("C")){ %>
						직원
						<% } %>
					</td>
					<td>
						<%= vo.getSales() %>
					</td>
					</tr>
					<%	} %>
					
			
			
		</table>
</section>
<footer>
	HRDKOREA Copyrightⓒ2016 All rights reserved Human Resources Development Service of Korea.
</footer>
</body>
</html>