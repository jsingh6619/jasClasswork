package attendance;

public class Student implements Attendee {
	private boolean isPresent = false;
	private String first;
	private String last;
	
	public boolean isPresent() {
		if (isPresent = true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setPresent(boolean present) {
		isPresent = true;
	}
	
	public String getFirstName() {
		return first;
	}
	
	public String getLastName() {
		return last;
	}
	
	public boolean mathces(String first, String last) {
		if(this.first == first && this.last == last) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean matches(String last) {
		
	}
	
	public String getReportString() {
		
	}
}
