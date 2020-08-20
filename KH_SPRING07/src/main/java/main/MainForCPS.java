package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;

public class MainForCPS {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("appCtx.xml");
		
		ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			cps.changePassword("garnet2929@naver.com", "0.30118036003530535", "1111");
			System.out.println("암호를 변경하였습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("회원 정보가 존재하지 않습니다.");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("암호를 다시 확인 하세요.");
		}

	}

}
