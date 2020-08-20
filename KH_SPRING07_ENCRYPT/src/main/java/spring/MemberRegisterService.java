package spring;

import java.util.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MemberRegisterService {
	private MemberDao memberDao;
	public MemberRegisterService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
//	public void regist(RegisterRequest req){
//		Member member = memberDao.selectByEmail(req.getEmail());
//		if(member != null){
//			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
//		}
//		//비밀번호 암호화 적용
//		StringBuffer encryptPassword = new StringBuffer();
//		
//		String password = req.getPassword();
//		String salt = Sha256Util.genSalt();
//		
//		encryptPassword.append(Sha256Util.getEncrypt(password, salt).toString());
//		encryptPassword.append("\\$").append(salt);
//
//		req.setPassword(encryptPassword.toString());
//		//비밀번호 암호화 처리 완료
//		
//		Member newMember = new Member(
//				req.getEmail(),
//				req.getPassword(),
//				req.getName(),
//				new Date()
//				);
//		memberDao.insert(newMember);		
//	}
	
	private PasswordEncoder encoder;
	
	public void setPasswordEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	
	
	public void regist(RegisterRequest req){
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null){
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		
//		StringBuffer encryptPassword = new StringBuffer();
//		
//		String Password = req.getPassword();
//		String salt = Sha256Util.genSalt();
//		
//		encryptPassword.append(Sha256Util.getEncrypt(Password, salt));
//		encryptPassword.append("\\$").append(salt);
//		
//		System.out.println(encryptPassword.toString());
//		
//		req.setPassword(encryptPassword.toString());
		
		String password = req.getPassword();
		password = encoder.encode(password);
		req.setPassword(password);
		
		Member newMember = new Member(
				req.getEmail(),
				req.getPassword(),
				req.getName(),
				new Date()
				);
		memberDao.insert(newMember);		
	}
}
