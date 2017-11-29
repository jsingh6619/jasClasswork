package search;

public class Pokemon {

	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public Pokemon(String name, int level){
		this.level = level;
		this.name = name;
		hp = 100;
		this.poisoned = false;
	}
	
	public void iChooseYou(){
		System.out.println(name + ", " + name + "!" );
	}

	public int getHP() {
		return hp;
	}

	public String getName() {
		return name;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}
	
	public void lapse() {
		if(poisoned) {
			hp = hp - 15;
		}
	}
	
	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		
		squirtle.iChooseYou();
		bulbasaur.iChooseYou();
		
		System.out.println("Squirtle is preparing to attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.getHP();
				target.setHP(hp/2);
			}
		});
		
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {
			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}
		});
		
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
		
		System.out.println("Squirtle is attacking again");
		squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.getHP();
				target.setHP(hp - 100);
			}
		});
		
		squirtle.levelUp(new Effect() {
			public void happen() {
				squirtle.setHP(100);
			}
		});
	}

	private static void printScore(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getName() + ", HP = " + p1.getHP());
		System.out.println(p2.getName() + ", HP = " + p2.getHP());
	}

	public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit");
		}
		else{
			System.out.println("The attack missed");
		}
	}
	
	public void levelUp(Effect e) {
		level++;
		e.happen();
	}
}
