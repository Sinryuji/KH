<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hrd_1235.*"%>
<!DOCTYPE html>
<%
	Dao dao = new Dao();
	int stuno = Integer.parseInt(request.getParameter("stuno"));
	String exam = request.getParameter("exam");
	int korean = Integer.parseInt(request.getParameter("korean"));
	int english = Integer.parseInt(request.getParameter("english"));
	int math = Integer.parseInt(request.getParameter("math"));
	ScoreVo vo = new ScoreVo();
	vo.setStuno(stuno);
	vo.setExam(exam);
	vo.setKorean(korean);
	vo.setEnglish(english);
	vo.setMath(math);
	dao.insertSco(vo);
	response.sendRedirect("index.jsp");
%>
