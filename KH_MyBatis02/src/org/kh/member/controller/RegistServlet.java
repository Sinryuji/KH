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

@WebServlet("/regist")
public class RegistServlet extends HttpServlet{
	
	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		MemberVo temp = new MemberVo();
		temp.setUserId(req.getParameter("userId"));
		temp.setUserPw(req.getParameter("userPw"));
		temp.setUserName(req.getParameter("userName"));
		temp.setUserAddr(req.getParameter("userAddr"));
		
		int ret = memberService.insertMember(temp);
		
		resp.setContentType("text/html; charset=utf-8");
		if(ret == 1) {
			resp.getWriter().println("회원가입 성공");
		}else {
			resp.getWriter().println("회원가입 실패");
		}
	}
}
