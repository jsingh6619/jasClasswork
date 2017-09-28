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
		if (report.length() < 20) {
			while (report.length() < 20) {
				report += " ";
			}
		}
		else{
			report = changeName(report, 20);
		}
		report += first;
		if (report.length() < 40) {
			while (report.length() < 40) {
				report += " ";
			}
		}
		else{
			report = changeName(report, 40);
		}
		if(isPresent) {
			report+="PRESENT";
		}
		else {
			report+="ABSENT";
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
	public String changeName(String name ,int ind) {
		String nme = "";
		if(name.length() > ind) {
			nme = name.substring(0, ind - 3);
		}
		while (nme.length() < ind) {
			nme += ".";
		}
		return nme;
	}
}
