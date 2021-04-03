package training.oracle.entry;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import training.oracle.business.RTOOperations;
import training.oracle.tms.entities.OffenceEO;

public class DriverApp {

	public static void main(String[] args) {
		 
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/beans.xml");

		// Get the bean
		RTOOperations rtoOperations = (RTOOperations)applicationContext.getBean("rtoBean");
		
		// Invoke the business methods
		List<OffenceEO> resultList = rtoOperations.listAllOffences();
		
		for (Iterator iterator = resultList.iterator(); iterator.hasNext();) {
			OffenceEO offenceEO = (OffenceEO) iterator.next();
			System.out.println(offenceEO);
		}

	}

}
