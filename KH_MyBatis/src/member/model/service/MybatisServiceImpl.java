package member.model.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.model.dao.MybatisDaoImpl;
import member.model.vo.Student;

public class MybatisServiceImpl 
					implements MybatisService{
	
	private SqlSession getSqlSession() {
		SqlSession session = null;
		String resources = "/resources/mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(resources);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false);	//auto commit 여부 전달(기본값 true)
			
			//위 코드는 한 줄로 사용 가능
			//session = new SqlSessionFactoryBuilder().build(is).openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	@Override
	public Student selectStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudent() {
		SqlSession session = getSqlSession();
		int result = new MybatisDaoImpl().insertStudent(session);
		
		if(result > 0) { 
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}
	
	@Override
	public int insertStudent(String name) {
		SqlSession session = getSqlSession();
		int result = new MybatisDaoImpl().insertStudent(session, name); //DB세션과 이름을 전달
		
		if(result > 0) { 
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}
}

 
