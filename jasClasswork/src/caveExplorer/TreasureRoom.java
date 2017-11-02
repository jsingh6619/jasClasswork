package caveExplorer;

public class TreasureRoom extends NPC {

	private boolean first;
	private String activeDescription;
	private String inactiveDescription;
	
	public TreasureRoom() {
		activeDescription = "There is a tribe of people staring at you. Type 'e' to interact";
		inactiveDescription = "Don't be greedy. You've already taken the money.";
		first = true;
	}
	
	public boolean firstTime() {
		return first;
	}

	public void interact() {
		CaveExplorer.print("This is your first time here. Enjoy a gift of $1000. Type 'bye' to leave.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("We want you to leave. Say 'bye'!");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("Later, guy!");
		first = false;
	}

	public String getDescription() {
		return activeDescription;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}
}
