package org.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.MemberVo;

@WebServlet("/allMember")
public class MemberListServlet extends HttpServlet{
	
	MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//비즈니스 로직
		ArrayList<MemberVo> list = memberService.selectListMember();
		
		resp.setContentType("text/html; charset=utf-8");
		if(!list.isEmpty()) {
			resp.getWriter().println("<hr><h6>목록 가져오기 성공<h6>");
			for(MemberVo vo : list) {
				resp.getWriter().println(vo.getUserId() + "<br>");
			}
			resp.getWriter().println("<hr>");
		}else {
			resp.getWriter().println("<h6>목록 가져오기 실패<h6>");
		}
	}
}



