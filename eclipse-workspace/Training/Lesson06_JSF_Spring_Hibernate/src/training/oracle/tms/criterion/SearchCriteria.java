package training.oracle.tms.criterion;

public class SearchCriteria {
	private String attributeName;
	private String attributeValue;
	private String attributeCondition;
	
	public SearchCriteria(){
		
	}

	public SearchCriteria(String attributeName, String attributeValue, String attributeCondition) {
		super();
		this.attributeName = attributeName;
		this.attributeValue = attributeValue;
		this.attributeCondition = attributeCondition;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public String getAttributeCondition() {
		return attributeCondition;
	}

	public void setAttributeCondition(String attributeCondition) {
		this.attributeCondition = attributeCondition;
	}

	@Override
	public String toString() {
		return "SearchCriteria [attributeName=" + attributeName + ", attributeValue=" + attributeValue
				+ ", attributeCondition=" + attributeCondition + "]";
	}
	
}
