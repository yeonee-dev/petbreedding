package kh.com.petbreedding.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class LogAdvice {

	@Pointcut("execution(* kh.com.petbreedding..*Dao.*(..))")
	public void commonDaoPointcut() {
	}

	@Around("commonDaoPointcut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		if(args == null)
			System.out.println("[LOG] Parameter is NULL");
		else {
			for(int i = 0; i < args.length; i++) {
				System.out.println("[LOG] [around-before] " + methodName + "() args: " + args[i].toString());
			}

		}
		StopWatch stopwatch = new StopWatch(); // target Object 부분 실행에 소요되는 시간 확인
		stopwatch.start();
		Object returnObj = pjp.proceed(); // target Object 부분 실행
		stopwatch.stop();
		System.out.println("[LOG] [around-proceed] " + methodName + "() 소요시간: " + stopwatch.getTotalTimeMillis() + "ms");
		
		if(returnObj == null)
			System.out.println("[LOG] returnObj is NULL");
		else
			System.out.println("[LOG] [around-after] " + methodName + "() returnValue: " + returnObj.toString());
		return returnObj;
	}
}
