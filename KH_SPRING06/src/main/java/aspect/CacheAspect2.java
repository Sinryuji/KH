package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class CacheAspect2 {
	private Map<Long, Object> cache = new HashMap<>();
	
	@Pointcut("execution(public * calculator.*.*(..))")
	private void publicTarget2() {
		
	}
	
	@Around("publicTarget2()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("cache 1 before");

		Long num = (Long)joinPoint.getArgs()[0];
		if(cache.containsKey(num)) {
			System.out.println("cache 2-2 before");

			System.out.printf("CacheAspect : Cache에서 구함[%d]\n", num);
			return cache.get(num);
		}
		System.out.println("cache 2-1 before");

		System.out.println("cache에서 Target:" + joinPoint.getTarget());
		Object result = joinPoint.proceed();
		System.out.println("cache 3 after");

		cache.put(num, result);
		System.out.printf("CacheAspect : Cache에 추가[%d]\n", num);
		return result;
	}
}
