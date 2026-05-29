package app.product.hackathon.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;

@Aspect
@Slf4j
public class LoggingAspect {
	@Pointcut("execution(* app.product.hackathon.service.impl.CarServiceImpl.*(..))")
	public void serviceLayerPointcut() {}
	
	@Before("serviceLayerPointcut()")
	public void logBeforeServiceCall(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		log.info("Calling method: {}", methodName);
	}
}
