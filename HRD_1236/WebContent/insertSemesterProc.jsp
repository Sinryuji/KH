<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1236.*" %>
<%

	DAO dao = new DAO();
	SemesterVO sem = new SemesterVO();
	sem.setName(request.getParameter("name"));
	sem.setPoint(Integer.parseInt(request.getParameter("point")));
	sem.setLecturer(Integer.parseInt(request.getParameter("lecturer")));
	sem.setWeek(Integer.parseInt(request.getParameter("week")));
	sem.setStart_hour(request.getParameter("start_hour"));
	sem.setEnd_hour(request.getParameter("end_hour"));
	dao.insertSemester(sem);
	response.sendRedirect("index.jsp");
%>
