package org.kh.member.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.dao.MemberDao;
import org.kh.member.model.dao.MemberDaoImpl;
import org.kh.member.model.vo.CheckVo;
import org.kh.member.model.vo.MemberVo;
import org.kh.member.model.vo.SearchVo;

import common.SqlSessionTemplate;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public MemberVo selectOneMember(MemberVo member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		MemberVo ret = memberDao.selectOneMember(session, member);
		session.close();
		return ret;
	}
	
 	@Override
	public ArrayList<MemberVo> selectListMember() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<MemberVo> list = memberDao.selectListMember(session);
		session.close();
		return list;
	}

	@Override
	public int insertMember(MemberVo member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int ret = memberDao.insertMember(session, member);
		if(ret == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return ret;
	}

	@Override
	public int updateMember(MemberVo member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int ret = memberDao.updateMember(session, member);
		if(ret == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return ret;
	}

	@Override
	public int deleteMember(MemberVo member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int ret = memberDao.deleteMember(session, member);
		if(ret == 1) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return ret;
	}

	@Override
	public ArrayList<MemberVo> chkMemberList(CheckVo vo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<MemberVo> list = memberDao.chkMemberList(session, vo);
		session.close();
		return list;
	}

	@Override
	public ArrayList<MemberVo> searchMember(SearchVo searchVo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<MemberVo> list = memberDao.searchMember(session, searchVo);
		session.close();
		return list;
	}
	
	@Override
	public ArrayList<MemberVo> searchMember(MemberVo member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<MemberVo> list = memberDao.searchMember(session, member);
		session.close();
		return list;
	}
	
	@Override
	public ArrayList<MemberVo> searchMember(String[] data) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		ArrayList<MemberVo> list = memberDao.searchMember(session, data);
		session.close();
		return list;
	}
}
 
 