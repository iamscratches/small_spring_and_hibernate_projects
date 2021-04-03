package training.oracle.entry;

import training.oracle.business.impl.CurrencyConverterImpl;
import training.oracle.business.impl.Customer;

public class DriverApp {
	
	public static void main(String args[]) {
		
		CurrencyConverterImpl ccRef = new CurrencyConverterImpl();
		
		// Dependent object is getting created
		Customer customerRef1 = new Customer(1001, "Rahul", "Bangalore", "8617463248");
		
		// Now we will inject the dependent object to be Target
		ccRef.setCustomerRef(customerRef1);
		
		// Now we can invoke the business operations
		System.out.println(ccRef.dollarsToRupees(1000));
	}

}
