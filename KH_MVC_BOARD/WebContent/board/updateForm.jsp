<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<script src="${pageContext.request.contextPath }/board/script.js"></script>
<link href="${pageContext.request.contextPath }/board/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/board/css/writeFormstyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<b>글수정</b>
<section>
	<form method="post" name="writeForm" action="${pageContext.request.contextPath }/board/updatePro.do?pageNum=${pageNum}" onsubmit="return wrtieSave()">
		<table class="board">
			<tr>
				<td class="attr">이 름</td>
				<td>${article.writer }
				<input type="hidden" name="num" value="${article.num }">
				<input type="hidden" name="writer" value="${article.writer }">
				</td>
			</tr>
			<tr>
				<td class="attr">E-mail</td>
				<td>
				<input type="text" name="email" value="${article.email }">
				</td>
			</tr>
			<tr>
				<td class="attr">제 목</td>
				<td>
				<input class="input" type="text" name="subject" value="${article.subject }">
				</td>
			</tr>
			<tr>
				<td class="attr">내 용</td>
				<td>
				<textarea name="content" rows="13" cols="50">${article.content }</textarea>
				</td>
			</tr>
			<tr>
				<td class="attr">비밀번호</td>
				<td>
				<input type="password" name="pass">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="attr">
					<input type="submit" value="글수정">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="window.location='${pageContext.request.contextPath}/board/list.do?pageNum=${pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</section>
</body>
</html>