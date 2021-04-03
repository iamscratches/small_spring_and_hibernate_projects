package training.oracle.business.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LoggingAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object result, Method methodName, Object[] argList, Object target) throws Throwable {
		System.out.println("Logging after advice is called... ");
		System.out.println("Business method on which the service is applied " + methodName.getName());
		System.out.println("Parameters passed to the business method is " + argList[0]);
		System.out.println("Result from the business method call: " + (String)result);
	}

}
