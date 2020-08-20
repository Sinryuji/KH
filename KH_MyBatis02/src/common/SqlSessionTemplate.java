package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		String config = "mybatis-config.xml";
		SqlSession session = null;
		try {
			//전달된 이름의 파일을 대상으로 입력 스트림 생성
			InputStream is = Resources.getResourceAsStream(config);
			//SqlSessionFactory를 생성할 수 있는 빌더 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//빌더로부터 SqlSessionFactory생성
			SqlSessionFactory factory = builder.build(is);
			//SqlSessionFactory로부터 SqlSession을 열기(false인자는 AutoCommit 플래그)
			session = factory.openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}


