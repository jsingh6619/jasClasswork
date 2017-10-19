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
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	public void stateYourFriends() {
		String statement = "My friends are ";
		for(int i = 0; i < friends.length - 1; i++){
			statement += friends[i].firstName + ", ";
		}
		statement += "and " + friends[friends.length-1].firstName;
		System.out.println(statement);
	}
	
	public void mingle(Person[] peers) {
		for(Person p: peers) {
			//you cannot friend yourself
			if(p != this) {
				setInFirstPlace(p);
			}
		}
	}
	
	public void setInFirstPlace(Person f) {
		//go backward through an array
		for(int i = friends.length - 1; i > 0; i--) {
			//move the friend from in front, back
			friends[i] = friends[i - 1];//CHECK: Does not go AIOOBE
		}
		friends[0] = f;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I am from " + home + ".";
	}
}
