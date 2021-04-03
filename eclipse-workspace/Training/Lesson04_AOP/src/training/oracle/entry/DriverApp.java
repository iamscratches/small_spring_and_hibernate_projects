package training.oracle.entry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.oracle.business.CurrencyConverter;

public class DriverApp {
	
	public static void main(String args[]) {
		
		//IOC container gets started...
		ApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");		
		
		// Looking up for the Business On the IOC[ Internally IOC will procure bean ]
		CurrencyConverter ccRef = (CurrencyConverter)context.getBean("ccBean");
		
		// Now we can invoke the business operations
		System.out.println(ccRef.dollarsToRupees(1000));
	}

}
