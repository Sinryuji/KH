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

@WebServlet("/deleteMember")
public class DeleteServlet extends HttpServlet{
	
	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		MemberVo temp = new MemberVo();
		temp.setUserId(req.getParameter("userId"));
		
		int ret = memberService.deleteMember(temp);
		
		resp.setContentType("text/html; charset=utf-8");
		if(ret == 1) {
			resp.getWriter().println("탈퇴 성공");
		}else {
			resp.getWriter().println("탈퇴 실패");
		}
	}
}


