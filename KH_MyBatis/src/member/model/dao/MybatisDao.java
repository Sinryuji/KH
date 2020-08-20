package member.model.dao;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Student;

public interface MybatisDao {
	public Student selectStudent(
			SqlSession session, 
			String userId, 
			String userPw);
	
	public int insertStudent(SqlSession session);
	
	public int insertStudent(SqlSession session, String name);
}


