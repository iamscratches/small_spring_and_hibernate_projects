package training.oracle.containerevents;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DriverApp {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("/beans.xml");
		
		ConfigurableApplicationContext configAppContext = (ConfigurableApplicationContext)beanFactory;
		
		configAppContext.start();
		
		configAppContext.stop();
		
		configAppContext.close();

	}

}
