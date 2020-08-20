package spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	//@Resource(name="memberDao") xml 파일에서 설정한 id 값을 name으로 지정해준다 같은 타입의 객체가 여러개일 경우 @Qualifier 역할을 함, @Resource는 생성자에는 사용 불가, 필드, setter에만 사용 가능
	//생성자와 setter는 어노테이션 마다 적용 여부가 갈리기에 어떤 어노테이션이든 그냥 필드에 적용 하자고 생각하는게 편해 보임
	private MemberDao memberDao;
	
	public MemberRegisterService() {}
	
	@Autowired
	public MemberRegisterService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null){
			throw new AlreadyExistingMemberException(
						"dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(),
				req.getPassword(),
				req.getName(),
				new Date()
				);
		memberDao.insert(newMember);		
	}
}
