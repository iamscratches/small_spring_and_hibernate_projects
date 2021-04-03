package training.oracle.business.impl;

import training.oracle.business.CurrencyConverter;

public class CurrencyConverterImpl implements CurrencyConverter {
	
	private Customer customerRef;

	public Customer getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(Customer customerRef) {
		this.customerRef = customerRef;
	}

	@Override
	public String dollarsToRupees(double dollars) {
		double result = 71.98 * dollars;
		return "Hey, " + customerRef.getName() + " your currency converted value is " + 
				result;
	}

	@Override
	public String poundsToRupees(double pounds) {
		double result = 83.45 * pounds;
		return "Hey, " + customerRef.getName() + " your currency converted value is " + 
				result;
	}

	@Override
	public String eurosToRupees(double euros) {
		double result = 78.12 * euros;
		return "Hey, " + customerRef.getName() + " your currency converted value is " + 
				result;
	}

	@Override
	public String riyalsToRupees(double riyals) {
		double result = 17.65 * riyals;
		return "Hey, " + customerRef.getName() + " your currency converted value is " + 
				result;
	}

	@Override
	public String yensToRupees(double yens) {
		double result = 0.56 * yens;
		return "Hey, " + customerRef.getName() + " your currency converted value is " + 
				result;
	}

	@Override
	public String pesosToRupees(double pesos) {
		double result = 0.5 * pesos;
		return "Hey, " + customerRef.getName() + " your currency converted value is " + 
				result;
	}

}
