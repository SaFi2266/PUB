package main;
//import main.Room.*;
//import main.Agent.*;

public class Main {
	
	public Room room;
	public Agent agent;
	//private Room room;
	//private Agent agent;
	
	public Main() {
		
		// Firstly, create new instance from the Room class with the size of the room as a parameter (n).
		room = new Room(5);
		
		// Fill the room randomly.
		room.fillRoomRandomly();
		
		// Create new instance from the Agent class.
		agent = new Agent(room);
		
		// Start the agent's searching algorithm.
		agent.start();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
