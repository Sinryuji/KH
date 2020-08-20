<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 
	try{
		Thread.sleep(3000);
	}catch(Exception e){}
	out.println("안녕하세요. " + request.getParameter("name") + "님!");
%>
