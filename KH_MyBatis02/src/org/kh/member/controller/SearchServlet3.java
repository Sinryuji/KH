package org.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.MemberVo;
import org.kh.member.model.vo.SearchVo;

@WebServlet("/search3")
public class SearchServlet3 extends HttpServlet {
	
	MemberService memberService = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String[] data = req.getParameterValues("addr");
		
		ArrayList<MemberVo> list = memberService.searchMember(data);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		if(!list.isEmpty()) {
			out.append("검색 성공<br>");
			for( MemberVo tmp : list) {
				out.append("ID:" + tmp.getUserId() + "<br>");
				out.append("PW:" + tmp.getUserPw() + "<br>"); 
				out.append("NAME:" + tmp.getUserName() + "<br>");
				out.append("ADDR:" + tmp.getUserAddr() + "<br><hr>");
			}
		}else {
			out.append("검색 실패");
		}
		out.close();
	}
}
