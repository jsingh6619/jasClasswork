package caveExplorer;

public class NPCRoom extends CaveRoom {

	private NPC npc;
	
	public NPCRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public boolean canEnter() {
		return npc == null;
	}
	
	public void enterNPC(NPC n) {
		this.npc = n;
	}
	
	public void leaveNPC() {
		this.npc = null;
	}
	
	public boolean containsNPC() {
		return npc != null;
	}
	
	/**
	 * Everything above is a NEW function of a CaveRoom, the methods below REPLACE original CaveRoom methods
	 */
	
	/**
	 * Override to change description of possible moves
	 */
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move or you can press 'e' to interact.");
	}
	
	/**
	 * override to add more moves
	 * @return
	 */
	public String validMoves() {
		return "wdsae";
	}

	/**
	 * override to create response to keys other than wdsa
	 * @param direction
	 */
	public void performAction(int direction) {
		CaveExplorer.print("That key does nothing.");
	}
}
