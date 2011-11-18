package DatapowerSource;

public class Expression {
    String filterValue;
    String userValue;
    
    public Expression(String filtervalue, String uservalue){
    	this.filterValue = filtervalue;
    	this.userValue = uservalue;
    }
    
	public String getFilterValue() {
		return filterValue;
	}
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}
	public String getUserValue() {
		return userValue;
	}
	public void setUserValue(String userValue) {
		this.userValue = userValue;
	}
    
    
    
    
	
}
