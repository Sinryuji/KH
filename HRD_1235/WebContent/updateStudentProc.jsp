<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1235.*" %>
<!DOCTYPE html>
<%
	Dao dao = new Dao();
	int stuno = Integer.parseInt(request.getParameter("stuno"));
	int stugrade = Integer.parseInt(request.getParameter("stugrade"));
	int stuclass = Integer.parseInt(request.getParameter("stuclass"));
	String stuname = request.getParameter("stuname");
	String phone = request.getParameter("phone");
	StudentVo vo = new StudentVo();
	vo.setStuno(stuno);
	vo.setStugrade(stugrade);
	vo.setStuclass(stuclass);
	vo.setStuname(stuname);
	vo.setPhone(phone);
	dao.update(vo);	
	response.sendRedirect("updateStudent.jsp?stuno=" + stuno);
%>