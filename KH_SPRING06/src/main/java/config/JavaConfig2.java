package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.CacheAspect2;
import aspect.ExeTimeAspect2;
import calculator.Calculator;
import calculator.ImplCalculator;
import calculator.RecCalculator;

//aop를 사용할때 aop는 proxy객체를 자동으로 생성 하는데 pointcut에 등록된 클래스들이 만약 어떠한 인터페이스를 상속받는다면 스프링은 자동으로 그 상속받는 인터페이스 타입으로 프록시를 생성한다 
//그래서 만약 main에서 bean객체를 인터페이스가 아니라 클래스 타입으로 사용 하고 싶다면 별도의 설정이 필요하다.
//Aspect 방식일때 java config는
//@EnableAspectJAutoProxy(proxyTargetClass=true) 로 설정해주면 된다.
@Configuration
@EnableAspectJAutoProxy
public class JavaConfig2 {
	
	@Bean
	public ExeTimeAspect2 exeTimeAspect() {
		return new ExeTimeAspect2();
	}
	
	@Bean
	public CacheAspect2 cacheAspect2() {
		return new CacheAspect2();
	}
	
	@Bean
	public Calculator implCal() {
		return new ImplCalculator();
	}
	
	@Bean
	public Calculator recCal() {
		return new RecCalculator();
	}
}
