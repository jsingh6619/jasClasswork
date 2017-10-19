package arrays;

public class Hobby extends Thing {

	public Hobby(String description) {
		super(description);
		
	}

	public static Hobby randomHobby() {
		Hobby[] h = {new Hobby("Playing video games"), new Hobby("Dancing"), new Hobby("Going For Long Walks")};
		return h[(int)(Math.random() * h.length)];
	}

}
