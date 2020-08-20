package org.kh.member.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.CheckVo;
import org.kh.member.model.vo.MemberVo;

import javax.servlet.annotation.*;

@WebServlet("/memberList")
public class MemberChkListServlet extends HttpServlet{
	MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String chId = req.getParameter("chId");
		String chPw = req.getParameter("chPw");
		String chName = req.getParameter("chName");
		String chAddr = req.getParameter("chAddr");
		
		CheckVo chvo = new CheckVo(chId, chPw, chName, chAddr);
		
		ArrayList<MemberVo> list = memberService.chkMemberList(chvo);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		if(!list.isEmpty()) {
			out.append("요청 결과");
			for( MemberVo tmp : list) {
				out.append("NO:" + tmp.getUserNo() + "<br>");
				if(tmp.getUserId() != null)
					out.append("ID:" + tmp.getUserId() + "<br>");
				if(tmp.getUserPw() != null)
					out.append("PW:" + tmp.getUserPw() + "<br>");
				if(tmp.getUserName() != null)
					out.append("NAME:" + tmp.getUserName() + "<br>");
				if(tmp.getUserAddr() != null)
					out.append("ADDR:" + tmp.getUserAddr() + "<br>");
				out.append("RegDate:" + tmp.getReg_date() + "<br><hr>");
			}
		}else {
			out.append("요청 실패");
		}
		out.close();
		
		
		
	}
}
