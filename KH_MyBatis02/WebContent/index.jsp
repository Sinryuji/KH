<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
<h1>MyBatis를 이용하여 기본 CRUD테스트 하기</h1>
<a href="<%=request.getContextPath()%>/views/member/login.jsp">1.로그인</a><br>
<a href="<%=request.getContextPath()%>/allMember">2.모든 회원 정보</a><br>
<a href="<%=request.getContextPath()%>/views/member/regist.jsp">3.회원가입</a><br>
<a href="<%=request.getContextPath()%>/modifyMember">4.정보수정</a><br>
<a href="<%=request.getContextPath()%>/deleteMember?userId=test1">5.회원탈퇴</a><br>
<a href="<%=request.getContextPath()%>/views/member/dynaQ-if.jsp">6.동적쿼리(if)</a><br>
<a href="<%=request.getContextPath()%>/views/member/dynaQ-choose.jsp">7.동적쿼리(choose)</a><br>
<a href="<%=request.getContextPath()%>/views/member/dynaQ-trim.jsp">8.동적쿼리(trim)</a><br>
<a href="<%=request.getContextPath()%>/views/member/dynaQ-foreach.jsp">9.동적쿼리(foreach)</a><br>
</body>
</html>



