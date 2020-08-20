package org.kh.member.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.CheckVo;
import org.kh.member.model.vo.MemberVo;
import org.kh.member.model.vo.SearchVo;

public interface MemberDao {
	public MemberVo selectOneMember(SqlSession session, MemberVo vo);
	public ArrayList<MemberVo> selectListMember(SqlSession session);
	public int insertMember(SqlSession session, MemberVo vo);
	public int updateMember(SqlSession session, MemberVo vo);
	public int deleteMember(SqlSession session, MemberVo vo);
	public ArrayList<MemberVo> chkMemberList(SqlSession session, CheckVo vo);
	public ArrayList<MemberVo> searchMember(SqlSession session, SearchVo vo);
	public ArrayList<MemberVo> searchMember(SqlSession session, MemberVo vo);
	public ArrayList<MemberVo> searchMember(SqlSession session, String[] data);
}


 