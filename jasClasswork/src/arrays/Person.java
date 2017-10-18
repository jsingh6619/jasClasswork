package arrays;

public class Person {
	//first part would be like jas
	//second would be like mit
	public static final String[] FIRST_START = {"Jas", "Har", "Gur", "Aman", "Harsh"};
	public static final String[] FIRST_MIDDLE = {"ala", "ima", "e", "o", "anna", "mi", "ola"};
	public static final String[] FIRST_END = {"meet", "preet", "deep", "winder", "rian", "lius", "lion"};
	// Could just be singh and kaur
	public static final String[] LAST_START = {"Bl", "Gr", "Ph", "M", "Thr", "Sh", "Sin"};
	public static final String[] LAST_MIDDLE = {"an", "g", "ast", "own", "il"};
	public static final String[] LAST_END = {"strom", "h", "rack", "son"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I am from " + home + ".";
	}
}
