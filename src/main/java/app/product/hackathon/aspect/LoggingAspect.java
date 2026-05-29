package app.product.hackathon.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;
@Aspect
@Slf4j
public class LoggingAspect {
	private final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());
	@Pointcut()
	public void makeAnAspect(){}
}
