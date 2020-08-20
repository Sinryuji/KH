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

@WebServlet("/modifyMember")
public class ModifyServlet extends HttpServlet{
	
	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		MemberVo temp = new MemberVo();
		temp.setUserId("test1");
		temp.setUserPw("1234");
		
		MemberVo vo = memberService.selectOneMember(temp);
		
		resp.setContentType("text/html; charset=utf-8");
		if(vo != null) {
			req.setAttribute("member", vo);
			req.getRequestDispatcher("/views/member/update.jsp").forward(req, resp);
		}else {
			resp.getWriter().println("정보 확인 불가");
		}
	}
}


