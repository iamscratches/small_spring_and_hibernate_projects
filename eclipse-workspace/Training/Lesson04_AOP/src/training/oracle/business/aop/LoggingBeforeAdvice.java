package training.oracle.business.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class LoggingBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method methodName, Object[] argList, Object target) throws Throwable {
		 
		System.out.println("Logging before advice is called... ");
		System.out.println("Business method on which the service is applied " + methodName.getName());
		System.out.println("Parameters passed to the business method is " + argList[0]);
		
	}

}
