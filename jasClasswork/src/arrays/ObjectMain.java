/*
package arrays;

public class ObjectMain {

	public ObjectMain() {
		o[] people = new Person[12];
		populate(people);
		for(Person p: people) {
			System.out.println(p);
		}
		people[0] = new Thing("toaster oven");
	}

	private void populate(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough home = randomBorough();
			//BIG IDEA:
			//In an Object array, you can have multiple data types!
			//(This is unlike a primitive array, like int[], boolean[], etc.
			if(Math.random() < .6) {
				//60% of the time
				int money = (int)(Math.random() * 20 + 1) * 100000;
				people[i] = new Athlete(firstName, lastName, home, money);
			}
			else {
				//40& of the time
				people[i] = new Person(firstName, lastName,home);

			}
		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random() * Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a) + get(b) + get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();
	}
}
*/
package arrays;

public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[34];
		populate(people);
//		people[0] = new Thing("toaster oven");
		Person[] group = selectGroup(people, 34);
		/*for(Object p: group) {
			System.out.println(p);
		}*/
//		analyzeCommonalities(people, group);
		for(Person p: people) {
			p.mingle(people);
			System.out.println(p);
			p.stateYourFriends();
		}
	}
	
	private void analyzeCommonalities(Person[] people, Person[] group) {
		double averageCommonality = 0;
		double trials = 500;
		double count = 0;
		for(int i = 0; i < trials; i++) {
			group = selectGroup(people, people.length);
			count += countCommonalities(people, group);
		}
		averageCommonality = count / trials;
		System.out.println("After " + trials + " trials, shuffling " + people.length + " people, on average, " + averageCommonality + " people end up in the same position where they started.");
	}
	
	//returns the number of items that are the same in both arrays and in the same location (index) too
	//PRECONDITION: The arrays have the same length
	private int countCommonalities(Object[] arr1, Object[] arr2) {
		int count = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}

	private void populate(Object[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough home = randomBorough();
			//BIG IDEA:
			//In an Object array, you can have multiple data types!
			//(This is unlike a primitive array, like int[], boolean[], etc.
			if(Math.random() < .6) {
				//60% of the time
				int money = (int)(Math.random() * 20 + 1) * 100000;
				people[i] = new Athlete(firstName, lastName, home, money);
			}
			else {
				//40& of the time
				people[i] = new Person(firstName, lastName,home);

			}
		}
	}

	/**
	 * returns a new Person[] 'group'
	 * selected from population without repeats
	 * @param population
	 * @param length
	 * @return
	 */
	private Person[] selectGroup(Person[] population, int length) {
		Person[] group = new Person[length];
		for(int i = 0; i < length; i++) {
			Person toAdd = randomPerson(population);
			while(alreadyContains(group, toAdd)) {
				toAdd = randomPerson(population);
			}
			group[i] = toAdd;
		}
		return group;
	}
	
	//returns a randomly selected Person from population
	private Person randomPerson(Person[] population) {
		return population[(int)(Math.random() * population.length)]; 
	}
	
	//returns true if population already has p in it
	private boolean alreadyContains(Person[] population, Person p) {
		for(int i = 0; i < population.length; i++) {
			if(population[i] == p) {
				return true;
			}
		}
		return false;
	}
	
	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random() * Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a) + get(b) + get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();
	}
}

