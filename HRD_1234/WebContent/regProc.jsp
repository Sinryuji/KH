<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1234.*, java.text.*, java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");

	int custno = Integer.parseInt(request.getParameter("custno"));
	String custname = request.getParameter("custname");
	String phone = request.getParameter("phone");
	String joindate = request.getParameter("joindate");
	String grade = request.getParameter("grade");
	String city = request.getParameter("city");
	String address = request.getParameter("address");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	Date date = new Date(sdf.parse(joindate).getTime());
	Vo vo = new Vo();
	vo.setCustno(custno);
	vo.setCustname(custname);
	vo.setPhone(phone);
	vo.setJoindate(date);
	vo.setGrade(grade);
	vo.setCity(city);
	vo.setAddress(address);
	Dao dao = new Dao();
	dao.insert(vo);
	response.sendRedirect("index.jsp");
%>