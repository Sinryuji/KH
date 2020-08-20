package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {
	
	//@Resource(name="memberDao")
	@Autowired
	private MemberDao memberDao;
	//@Resoruce(name="memberPrinter1")
	@Autowired
	@Qualifier("asdf")
	private MemberPrinter printer;
	
	public MemberListPrinter() {}
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer){
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll(){
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members){
			printer.print(m);
		}
	}
}
