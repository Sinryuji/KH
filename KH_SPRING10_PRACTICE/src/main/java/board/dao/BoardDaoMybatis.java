package board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import board.domain.BoardVO;

@Repository
public class BoardDaoMybatis implements BoardDao{

	private SqlSessionTemplate sqlSessionTemplate;

	public BoardDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<BoardVO> list() {
		return sqlSessionTemplate.selectList("listBoard");
	}
	
	@Override
	public int delete(BoardVO boardVO) {
		return sqlSessionTemplate.delete("deleteBoard", boardVO);
	}
	
	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("deleteAllBoard");
	}
	
	@Override
	public int update(BoardVO boardVO) {
		return sqlSessionTemplate.update("updateBoard", boardVO);
	}
	
	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("insertBoard", boardVO);
	}
	
	@Override
	public BoardVO select(int seq) {
		BoardVO vo = (BoardVO) sqlSessionTemplate.selectOne("selectBoard", seq);
		return vo;
	}
	
	@Override
	public int updateReadCount(int seq) {
		return sqlSessionTemplate.update("updateCount", seq);
	}
	
}
