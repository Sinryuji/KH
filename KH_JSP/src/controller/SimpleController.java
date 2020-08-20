package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet{

	//1단계 - HTTP 요청아르 받음(GET/POST)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//2단계 요청 분석
		String type = req.getParameter("type");
		
		//3단계 모델을 사용하여 분석된 요청을 처리
		Object resultObject = null;
		if( type == null || type.equals("greeting")) {
			resultObject = "안녕하세요.";
		} else if(type.equals("date")) {
			resultObject = new java.util.Date();
		} else {
			resultObject = "Invalid Type!";
		}
		
		//4단계 request나 session에 처리된 결과를 저장
		req.setAttribute("result", resultObject);
		
		//5단계 RequestDispatcher를 사용하여 알맞은 뷰로 포워딩 | 라다이렉트
		RequestDispatcher dispatcher = req.getRequestDispatcher("/simpleView.jsp");
		dispatcher.forward(req, resp);
	}
}
