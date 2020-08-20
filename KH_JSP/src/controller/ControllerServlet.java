package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet{

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
		//request 객체레부터 사용자의 요철을 분석하는 코드 작성
		
		//3단계 모델을 사용하여 분석된 요청을 처리
		
		//4단계 request나 session에 처리된 결과를 저장
		
		//5단계 RequestDispatcher를 사용하여 알맞은 뷰로 포워딩 | 라다이렉트
	}
}
