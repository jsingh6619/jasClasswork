package arrays;

public class Person {
	//first part would be like jas
	//second would be like mit
	public static final String[] FIRST_START = {"Ge", "Jos", "Gur", "Stor" };
	public static final String[] FIRST_MIDDLE = {"a", "e", "i", "o", "u"};
	public static final String[] FIRST_END = {"let", "rge", "rian", "lius", "lion"};
	// Could just be singh and kaur
	public static final String[] LAST_START = {"Bl", "Gr", "Ph", "M", "Thr", "Sh", "Sin"};
	public static final String[] LAST_MIDDLE = {"an", "g", "ast", "own", "il"};
	public static final String[] LAST_END = {"strom", "h", "rack", "son"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	private String nickname;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
		nickname = createNickname(firstName);
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * PASS BY VALUE
	 * the parameters of a method contain only values, not references, therefore when they are changed, the REFERENCE to the ORIGINAL object does not change
	 *  
	 * returns a String equal to name up to the index of (but not including) the second vowel
	 * createNickname("Jonathan") -> "Jon"
	 * @param name
	 * @return
	 */
	public static String createNickname(String name) {
		String nickname = "";
		int count = 0;
		for(int i = 0; i < name.length(); i++) {
			String letter = name.substring(i, i+1);
			if(isVowel(letter)) {
				count++;
				if(count != 2) {
					nickname += letter;
				}
				else {
					return nickname;
				}
			}
			else {
				// add the letter when not a vowel
				nickname += letter;
			}
		}
		return nickname;
	}
		
	public static boolean isVowel(String letter) {
		letter = letter.toLowerCase();
		return letter.equals("a")||letter.equals("e")||letter.equals("i")||letter.equals("o")||letter.equals("u");
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
		return "My name is " + firstName + " " + lastName + ". Call me " + nickname + " and I am from " + home + ".";
	}
}
