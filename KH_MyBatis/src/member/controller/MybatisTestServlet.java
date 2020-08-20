package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MybatisService;
import member.model.service.MybatisServiceImpl;

@WebServlet("/MybatisTestServlet")
public class MybatisTestServlet extends HttpServlet {

	private MybatisService mybatisService = new MybatisServiceImpl();
    public MybatisTestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int result = mybatisService.insertStudent();
		String test = (result > 0) ? "Mybatis 테스트 성공!":"Mybatis 테스트 실패!";
		response.setContentType("text/html; charset=\"utf8\""); 
		response.getWriter()
		.append("Served at: ")
		.append(request.getContextPath())
		.append("<br>"+test);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int result = mybatisService.insertStudent(name);	//이름을 전달
		String test = (result > 0) ? "Mybatis 전송 성공!":"Mybatis 전송 실패!";
		response.setContentType("text/html; charset=\"utf8\""); 
		response.getWriter()
		.append("Served at: ")
		.append(request.getContextPath())
		.append("<br>"+test);
	}

}
