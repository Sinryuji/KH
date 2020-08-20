package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Member;
import spring.MemberDao;

public class MainForMemberDao {
	
	private static MemberDao memberDao;

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("appCtx.xml");
		memberDao = ctx.getBean("memberDao", MemberDao.class);
		
		selectAll();
		updateMember();
		insertMember();
		selectAll();
		
		ctx.close();
	}
	
	public static void selectAll() {
		System.out.println("--------selectAll");
		int total = memberDao.count();
		System.out.println("전체 데이터: " + total);
		List<Member> members = memberDao.selectAll();
		for (Member m : members) {
			System.out.println(m.getId() + ":" + m.getEmail() + ":" + m.getName());
		}
	}
	
	public static void updateMember() {
		System.out.println("-------updateMember");
		Member member = memberDao.selectByEmail("garnet2929@naver.com");
		String oldPw = member.getPassword();
		String newPw = Double.toHexString(Math.random());
		member.changePassword(oldPw, newPw);
		
		memberDao.update(member);
		System.out.println("암호 변경: " + oldPw + " > " + newPw);
	}
	
	public static void insertMember() {
		System.out.println("------insertMember");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		String prefix = dateFormat.format(new Date());
		Member member = 
				new Member(prefix + "@test.com", prefix, prefix, new Date());
		memberDao.insert(member);
		System.out.println(member.getId() + " 데이터 추가");
	}

}
