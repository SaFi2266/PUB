package main;

import java.util.Random;

public class Agent {

	private int x; 						// Agent's current X coordinate.
	private int y;						// Agent's current Y coordinate.
	private int nextX; 					// Agent's next step's X coordinate.
	private int nextY; 					// Agent's next step's Y coordinate.
	private int points;					// Collected points by the agent.
	private boolean movingToStart;		// True, if the agent found every objects and should move back to it's initial position.

	private Room room;		// The initialized room object from the Main.
	private Random rand;	// Helper object for random number generation.

	// Directions order:
	// {-1,  0} -> Going UP
	// { 0,  1} -> Going RIGHT
	// { 1,  0} -> Going DOWN
	// { 0, -1} -> Going LEFT

	private final int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	private int currentDirectionIndex;	// Integer that represents the current direction of the agent.

	// Initializing variables.
	public Agent(Room room) {
		x = y = 0;
		points = 0;
		this.room = room;
		rand = new Random();
	}

	public void start() {
		movingToStart = false;		// Since the agent firstly wants to collect every objects, we set this to false.
		currentDirectionIndex = 1;	// By default, the agent is looking to the right in it's initial position.
		
		// Setting start time in milliseconds, so at the end we can calculate the execution time of the algorithm.
		long startTime = System.currentTimeMillis();

		// Repeat the searching algorithm until there are no objects left in the room.
		while (room.getRemainingObjects() > 0) {
			startSearching();
		}

		// At this point the agent collected every object, now it needs to go back to it's initial position, [0, 0].
		movingToStart = true;
		
		// We repeat the searching algorithm until the agent arrives to it's starting position, but now it won't look for objects.
		while (x != 0 || y != 0) {
			startSearching();
		}
		
		// Printing out execution time and earned points.
		System.out.println("Execution time: " + (System.currentTimeMillis() - startTime) + " milliseconds.");
		System.out.println("Points earned: " + points);
	}
	
	private void startSearching() {
		// Set 'next' coordinates to the next step's coordinate in the current direction.
		nextX = x + directions[currentDirectionIndex][0];
		nextY = y + directions[currentDirectionIndex][1];

		// If there is no obstacle in the agent's way and it's still inside the room, we take a step forward.
		while (room.isPositionInside(nextX, nextY) && !room.isObstacle(nextX, nextY)) {
			// Since moving forward is an action, reduce points by 1.
			points--;

			System.out.println("The agent moved from [" + x + ", " + y + "] to [" + nextX + ", " + nextY + "] and lost -1 point.");
			// Updating agent's current position to the next one.
			x = nextX;
			y = nextY;

			// If the agent should check for objects and there is an object in the current (new) position, pick it up.
			if (!movingToStart && room.isObject(x, y)) {
				points += 100; 				// Agent gets 100 points for picking up an object.
				room.setObjectFree(x, y); 	// Remove the object from the room, replace it with free space.
				System.out.println("The agent picked up an object at [" + x + ", " + y + "] and got +100 points!");
			}
			
			// I had to add the following piece of code, because there were some cases when the program got into an 
			// infinite loop, simply because of the nature of the rotations (those are implemented below this while loop).
			// What it does is basically 40% of the times after stepping forward, the agent will rotate randomly left or right.
			
			if (rand.nextInt(100) < 40) {
				if (rand.nextInt(2) > 0) {
					turnLeft();
				} else {
					turnRight();
				}
			}

			// Set 'next' coordinates to the next step's coordinate in the current direction.
			nextX = x + directions[currentDirectionIndex][0];
			nextY = y + directions[currentDirectionIndex][1];
			
			// Print the current state of the room. Comment that line, if you want the program to run as fast as possible.
			room.printRoom(x, y);
			
			// Sleep for x milliseconds, making it easier to read the output.
			sleep(1000);
		}

		// At this point the agent is stuck either because of an obstacle or the walls of the room => it has to turn left or right.
		
		// Check, if the agent is moving by a wall and got stuck because of an obstacle.
		if (!turnByObstacle()) {
			/* 
			 * The program can only get here, if the agent is not moving 
			 * BY (!) the wall and is stuck because of an obstacle or a wall.
			 * In this case, since the agent doesn't know anything about 
			 * it's corresponding positions  (is it object?, is it free?), 
			 * it can turn both directions. 
			 * So, 50% of the times it will turn to the left, 50% of the times to the right.
			 * */
			
			if (rand.nextInt(2) > 0) {
				turnLeft();
			} else {
				turnRight();
			}
		}
	}
	
	private boolean turnByObstacle() {
		/* 
		 * If the agent is moving back to it's initial position, 
		 * this function will get called even if the agent reaches [0, 0], 
		 * since it will "collide" with another wall, 
		 * no matter which position it comes from. 
		 * In this case the agent doesn't need to turn, 
		 * so we simply return from the function with true 
		 * (so there will not be random turn either, and the algorithm is over).
		 * */
		
		if (movingToStart && x == 0 && y == 0) {
			return true;
		}
		
		/* 
		 * If the agent is not in it's initial position, we check if it has to turn.
		 * 
		 * The following 4 conditions take care of the proper turning of the agent 
		 * when it's moving by the wall and meets an obstacle/another wall.
		 * For example, let's look at the 1st if condition: 
		 * if the agent is moving to the right (direction = 1) by the top wall (where x = 0),
		 * or it is moving to the left (direction = 3) by the bottom wall (x = room.getSize() - 1), 
		 * it has to turn right, because turning left wouldn't make sense.
		 * The same idea works for the remaining 3 if conditions.
		 * */
		
		if ((x == 0 && currentDirectionIndex == 1) || (x == room.getSize() - 1 && currentDirectionIndex == 3)) {
			turnRight();
			return true;
		}
		
		if ((x == 0 && currentDirectionIndex == 3) || (x == room.getSize() - 1 && currentDirectionIndex == 1)) {
			turnLeft();
			return true;
		}
		
		if ((y == 0 && currentDirectionIndex == 0) || (y == room.getSize() - 1 && currentDirectionIndex == 2)) {
			turnRight();
			return true;
		}
		
		if ((y == 0 && currentDirectionIndex == 2) || (y == room.getSize() - 1 && currentDirectionIndex == 0)) {
			turnLeft();
			return true;
		}
		
		return false;
	}
	
	// Function that performs a turn to the left.
	private void turnLeft() {
		// Decreasing points, since turning left is an action.
		points--;
		
		// By the order of the directions array, decreasing the current direction's index by 1 will solve the turn to the left
		// (except when the index is 0, because then we don't have a -1 index, so we take the last index instead, which is 3).
		
		if (currentDirectionIndex == 0) {
			currentDirectionIndex = 3;
		} else {
			currentDirectionIndex--;
		}
		
		System.out.println("The agent turned left and lost -1 point.");
	}
	
	// Function that performs a turn to the right.
	private void turnRight() {
		// Decreasing points, since turning right is an action.
		points--;
		
		// By the order of the directions array, increasing the current direction's index by 1 will solve the turn to the right
		// (except when the index is 3, because then we don't have a 4th index, so we take the first index instead, which is 0).
		
		if (currentDirectionIndex == 3) {
			currentDirectionIndex = 0;
		} else {
			currentDirectionIndex++;
		}
		
		System.out.println("The agent turned right and lost -1 point.");
	}
	
	private void sleep(int timeInMS) {
		try {
			Thread.sleep(timeInMS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
