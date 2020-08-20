package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberPrinter;

@Configuration
public class ConfigPart2 {
	
	@Autowired
	private MemberDao memberDao;
	//main에서 설정파일을 두개를 설정 할 건데 거기서 다른 설정 파일의 MemberDao 객체를 이 객체로 자동주입 한다는 의미 인 것 같다. 그 자동 주입을 위해서 @Autowired 어노테이션을 사용 했다. 그러면 main에서 설정 파일 두개를 설정할때 part1이 part2보다 먼저 와야할까?
	//하는 궁금증이 생겼다. MemberDao객체는 prat1에서 생기니까 part1의 설정 파일이 먼저 로드 되고 그 다음 part2가 로드 되어야 순서가 맞으니까. 하지만 순서를 바꿔도 아무 문제 없이 동작했다. 아마도 순서랑 상관없이 로드한 뒤 @Autowired 어노테이션을 통해
	//자동 주입할 같은 타입의 객체가 있는지 알아서 찾는 방식으로 동작 하는 것 같다.
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberDao(memberDao);
		infoPrinter.setMemberPrinter(printer());
		return infoPrinter;
	}
}
