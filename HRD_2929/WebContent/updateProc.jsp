<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "HRD_2929.MemberDao, HRD_2929.MemberVo, java.text.*, java.sql.*, java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");

	int custno = Integer.parseInt(request.getParameter("custno"));
	String custname = request.getParameter("custname");
	String joindate = request.getParameter("joindate");
	MemberVo vo = new MemberVo();
	vo.setCustno(custno);
	vo.setCustname(custname);
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	java.sql.Date date = new java.sql.Date(format.parse(joindate).getTime());
	vo.setJoindate(date);
	MemberDao dao = new MemberDao();
	dao.updateMember(custno, vo);
	response.sendRedirect("index.jsp");
%>
