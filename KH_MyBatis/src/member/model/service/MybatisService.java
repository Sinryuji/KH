package member.model.service;

import member.model.vo.Student;

public interface MybatisService {
	public Student selectStudent();
	public int insertStudent();	
	public int insertStudent(String name);
}


