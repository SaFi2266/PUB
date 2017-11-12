package main;

import java.util.Random;

public class Room {

	private int[][] room;	// The room's matrix
	private int size;		// The size of the room
	private Random rand;	// Helper for random number generation
	
	private int remainingObjects;					// Counter which counts how many objects are left for the agent to clear
	private final int OBJECT_PLACE_PERCENT = 40;	// The frequency of placing an object during filling the room
	private final int OBSTACLE_PLACE_PERCENT = 40;	// the frequency of placing an obstacle during filling the room
	
	// Initializing the size, the room matrix and the random helper.
	public Room(int size) {
		this.size = size;
		room = new int[size][size];
		rand = new Random();
	}
	
	// void fillRoomRandomly() - fills the room matrix with random values based on the following rules:
	// room[x][y] = 0  -> free position
	// room[x][y] = 1  -> position with an object
	// room[x][y] = 2  -> position with an obstacle
	
	public void fillRoomRandomly() {
		// Setting initial position as free position
		room[0][0] = 0;
		remainingObjects = 0;
		
		// Looping through the whole room matrix
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				// If we're not on the initial position
				if (x != 0 || y != 0) {
					// 40% of the times we'll put an object in the current position, then increment the object count.
					if (rand.nextInt(100) < OBJECT_PLACE_PERCENT) {	
						room[x][y] = 1;
						remainingObjects++;
					// If we didn't put an object, 40% of the times we'll put an obstacle in the current position.
					} else if (rand.nextInt(100) <= OBSTACLE_PLACE_PERCENT) {
						boolean hasObstacleInNeighborhood = false;
						
						// Since there cannot be two obstacles as neighbors, we have to check if there's already
						// an obstacle in the current position's neighborhood.
						for (int i = x - 1; i <= x + 1; i++) {
							for (int j = y - 1; j <= y + 1; j++) {
								if (i >= 0 && j >= 0 && i < size && j < size) {
									if (room[i][j] == 2) {
										hasObstacleInNeighborhood = true;
										break;
									}
								}
							}
						}
						
						// If we didin't find any obstacles, we can put one in the current position.
						if (!hasObstacleInNeighborhood) {
							room[x][y] = 2;
						// Otherwise put a free space in the current position.
						} else {
							room[x][y] = 0;
						}
					// If we didn't put an obstacle either, the current position will be free space.
					} else {
						room[x][y] = 0;
					}
				}
			}
		}
		
		// Print out the generated room.
		System.out.println("Starting state of room:");
		printRoom(0, 0);
	}
	
	// Function, that prints out the matrix with an 'A' character at the agent's [x, y] position.
	public void printRoom(int x, int y) {
		System.out.println();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == x && j == y) {
					System.out.print("A ");
				} else {
					System.out.print(room[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Function, that sets an object in the [x, y] position free and updates the remaining object count.
	public void setObjectFree(int x, int y) {
		room[x][y] = 0;
		remainingObjects--;
	}
	
	// Returns the remaining object count.
	public int getRemainingObjects() {
		return remainingObjects;
	}
	
	// Returns true, if there's an object in [x, y] position, returns false otherwise.
	public boolean isObject(int x, int y) {
		return room[x][y] == 1;
	}
	
	// Returns true, if there's an obstacle in [x, y] position, returns false otherwise.
	public boolean isObstacle(int x, int y) {
		return room[x][y] == 2;
	}
	
	// Returns true, if [x, y] coordinate is out of the room, returns false otherwise.
	public boolean isPositionInside(int x, int y) {
		return (x >= 0 && x < size && y >= 0 && y < size);
	}
	
	// Returns the size of the room.
	public int getSize() {
		return size;
	}
	
}
