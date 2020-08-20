package member.model.dao;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.Student; 

public class MybatisDaoImpl implements MybatisDao{

	@Override
	public Student selectStudent(SqlSession session, String userId, String userPw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudent(SqlSession session) {
		int result = session.insert("student.insert1");
		System.out.println("result@MybatisDao=" + result);
		return result;
	}
	
	@Override
	public int insertStudent(SqlSession session, String name) {
		int result = session.insert("student.insert2", name);
		System.out.println("result@MybatisDao=" + result);
		return result;
	}

} 


