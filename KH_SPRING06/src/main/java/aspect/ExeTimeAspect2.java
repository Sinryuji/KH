package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect2 {
	
	@Pointcut("execution(public * calculator..*(..))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		System.out.println("time 1 before");
		try {
			Object result = joinPoint.proceed();
			System.out.println("time 2 after");
			return result;
		}
		finally {
			System.out.println("time 3 after");

			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s, %s(%s) 실행 시간 : %d ns\n", joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish - start));
		}
	}
}
