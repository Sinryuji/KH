package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {
	
	//@Resource(name="memberDao")
	@Autowired
	private MemberDao memDao;
	//@Resource(name="memberPrinter1")
	private MemberPrinter printer;
	
	public void setMemberDao(MemberDao memberDao){
		this.memDao = memberDao;
	}
	
	@Autowired
	@Qualifier("asdf")
	public void setMemberPrinter(MemberPrinter printer){
		this.printer = printer;
	}
	
	public void printMemberInfo(String email){
		Member member = memDao.selectByEmail(email);
		if(member == null){
			System.out.println("정보 없음!\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}
