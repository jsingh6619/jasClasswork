package attendance;

public class Student implements Attendee {
	private boolean isPresent = false;
	private String first;
	private String last;
	
	public Student(String first, String last){
		this.first = first;
		this.last = last;
	}
	public boolean isPresent() {
		if (isPresent = true) {
			return true;
		}
		else {
			return false;
		}
		// return isPresent; could also work
	}
	
	public void setPresent(boolean present) {
		isPresent = present;
	}
	
	public String getFirstName() {
		return first;
	}
	
	public String getLastName() {
		return last;
	}
	
	public boolean mathces(String first, String last) {
		return first.toLowerCase().equals(this.first.toLowerCase()) && last.toLowerCase().equals(this.last.toLowerCase());
		/*if(this.firstName == first && this.lastName == last) {
			return true;
		}
		else {
			return false;
		}
		
		never use == for Strings
		*/
	}
	
	public boolean matches(String last) {
		return last.toLowerCase().equals(this.last.toLowerCase());
		/*if(this.lastName == last) {
			return true;
		}
		else {
			return false;
		}
		*/
	}
	
	public String getReportString() {
		String report = last;
		while (report.length()<20) {
			report += " ";
		}
		report += first;
		while (report.length()<40) {
			report += " ";
		}
		if(isPresent) {
			report+="PRESENT/n";
		}
		else {
			report+="ABSENT/n";
		}
		return report;
		/*String end = this.lastName;
		while(abc.length < 20) {
			String end += " ";
		}
		String end += this.firstName;
		return end;
		*/
	}
}
