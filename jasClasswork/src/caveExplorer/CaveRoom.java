package caveExplorer;

public class CaveRoom {

	private String description;
	private String directions;//tells you which door can be used
	private String contents;//a symbol showing you what is in the room('X' when you are in the room)
	private String defaultContents;//what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		
		setDefaultContents(" ");
		contents = defaultContents;
		
		//NOTE: Arrays are instantiated with 'null' values
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		
		setDirections();
	}

	/**
	 * for every Door in doors[] that is not null, this method appends a String to "directions" describing the door and where it is
	 * 	There is a (passage) to (the North)
	 * 	There is a (passage) to (the East)
	 * If there are no doors that are not  null, this sets directions to "There is no way out. You are trapped in this room."
	 */
	public void setDirections() {
		//hint: to check if a door is null, use: doors[0] == null OR USE doors[0] != null
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a " + doors[i].getDescription() + " to the " + toDirection(i) + ". " + doors[i].getDetails();
			}
		}
		if(!doorFound) {
			directions = "There is no way out. You are trapped in this room.";
		}
	}
	
	/**
	 * converts an int to a direction
	 * 	0 -> "the North"
	 * 	1 -> "the East"
	 * hint: complete this method without using an if statement
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] directions = {"North", "East", "South", "West"};
		//NOTE: when I say "no long if-else statements", this is how you should be thinking
		return directions[dir];
	}

	public void enter() {
		contents = "X";
	}
	
	public void leave() {
		contents = defaultContents;
	}
	
	/**
	 * This is how we join rooms together. It gives this room access to anotherRoom and vice-versa. It also puts the door between both rooms
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w', 'a', 's', 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		int direction = "wdsa".indexOf(input);
		goToRoom(direction);
	}
	
	/**
	 * returns true is w,a,s, or d is the input (NO IF STATEMENT)
	 * @param input
	 * @return
	 */
	private boolean isValid(String input) {
		return "wdsa".indexOf(input) != -1 && input.length() == 1;
	}
	
	/**
	 * THIS IS WHERE CAVE GETS EDITED
	 */
	public static void setUpCaves() {
		
	}
	
	public void goToRoom(int direction) {
		//make sure there is a room to go to:
		if(borderingRooms[direction] != null && doors[direction] != null && doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
		else {
			//print red text
			System.err.println("You can't do that!");
		}
	}
	
	/**
	 * returns the OPPOSITE direction
	 * 0 -> 2
	 * 1 -> 3
	 * 2 -> 0
	 * 3 -> 1
	 * @param dir
	 * @return
	 */
	public static int oppositeDirection(int dir) {
		return (dir + 2) % 4;
	}
	
	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections(); //updates the directions
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
