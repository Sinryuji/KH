package org.kh.member.model.service;

import java.util.ArrayList;

import org.kh.member.model.vo.CheckVo;
import org.kh.member.model.vo.MemberVo;
import org.kh.member.model.vo.SearchVo;

public interface MemberService {
	public MemberVo selectOneMember(MemberVo member);
	public ArrayList<MemberVo> selectListMember();
	public int insertMember(MemberVo member);
	public int updateMember(MemberVo member);
	public int deleteMember(MemberVo member);
	public ArrayList<MemberVo> chkMemberList(CheckVo vo);
	public ArrayList<MemberVo> searchMember(SearchVo searchVo);
	public ArrayList<MemberVo> searchMember(MemberVo member);
	public ArrayList<MemberVo> searchMember(String[] data);
}
 

