package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.MemberVo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//인코딩 지정
		req.setCharacterEncoding("utf-8");

		//파라미터 값 가져오기
		MemberVo memberParam = new MemberVo();
		memberParam.setUserId(req.getParameter("userId"));
		memberParam.setUserPw(req.getParameter("userPw"));

		//비즈니스 로직
		MemberVo member = memberService.selectOneMember(memberParam);
		
		//결과 응답
		resp.setContentType("text/html; charset=utf-8");
		if(member != null) {
			resp.getWriter().println("로그인 성공");
		}else {
			resp.getWriter().println("로그인 실패");
		}
	}
}
 



