package org.kh.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.CheckVo;
import org.kh.member.model.vo.MemberVo;
import org.kh.member.model.vo.SearchVo;

public class MemberDaoImpl implements MemberDao{
	
	@Override
	public MemberVo selectOneMember(SqlSession session, MemberVo vo) {
		MemberVo member = session.selectOne("mybatis.selectOneMember", vo);
		return member;
	}
	
	@Override
	public ArrayList<MemberVo> selectListMember(SqlSession session) {
		List<MemberVo> list = session.selectList("mybatis.selectAllMember");
		return (ArrayList<MemberVo>)list;
	}

	@Override
	public int insertMember(SqlSession session, MemberVo vo) {
		int ret = session.insert("mybatis.insertMember", vo);
		return ret;
	}

	@Override
	public int updateMember(SqlSession session, MemberVo vo) {
		int ret = session.update("mybatis.updateMember", vo);
		return ret;
	}

	@Override
	public int deleteMember(SqlSession session, MemberVo vo) {
		int ret = session.delete("mybatis.deleteMember", vo);
		return ret;
	}

	@Override
	public ArrayList<MemberVo> chkMemberList(SqlSession session, CheckVo vo) {
		List<MemberVo> list = session.selectList("mybatis.checkMember", vo);
		return (ArrayList<MemberVo>)list;
	}
	
	@Override
	public ArrayList<MemberVo> searchMember(SqlSession session, SearchVo vo) {
		List<MemberVo> list = session.selectList("mybatis.searchMember", vo);
		return (ArrayList<MemberVo>)list;
	}
	
	@Override
	public ArrayList<MemberVo> searchMember(SqlSession session, MemberVo vo) {
		List<MemberVo> list = session.selectList("mybatis.searchMember2", vo);
		return (ArrayList<MemberVo>)list;
	}
	
	@Override
	public ArrayList<MemberVo> searchMember(SqlSession session, String[] data) {
		List<MemberVo> list = session.selectList("mybatis.searchMember3", data);
		return (ArrayList<MemberVo>)list;
	}
} 


