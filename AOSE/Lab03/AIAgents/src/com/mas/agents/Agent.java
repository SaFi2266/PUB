package com.mas.agents;

import static com.mas.agents.CellStatus.EOL;
import static com.mas.agents.CellStatus.OBSTACLE;
import static com.mas.agents.CellStatus.OPEN;

import java.util.Random;

public abstract class Agent {
	protected Direction direction;
	protected int x;
	protected int y;
	protected int moves = 0;
	protected double points = 0;
	protected Environment environment;
	
	public Agent(){
		direction = Direction.EAST;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	public void initializeAgent(){
	}
	
	public void moveAgent() throws MasException{
		checkAndMove();
		if(environment.isAllObjectsPicked()){
			environment.setComplete(true);
		}
	}
	
	/*
	 * Needs to be implemented by the Specific type of agents.
	 */
	public abstract void checkAndMove() throws MasException;

	// put agent in the room
	public void placeAgent() {
		for(int i=0;i<environment.getHeight();i++){
			for(int j=0;j<environment.getWidth();j++){
				if(environment.getSquare()[i][j].trim().equals("")){
					environment.getSquare()[i][j]="A";
					this.x = i;
					this.y = j;
					return;
				}
			}
		}
	}
	
	// to change direction randomly 
	protected void toggleDirectionRandom(Direction currentDirection) {
		while(true){
			Random r = new Random();
			int randomDirection = r.nextInt(4);
			
			switch(randomDirection){
			case 0:
				if(currentDirection != Direction.NORTH){
					direction = Direction.NORTH;
					return;
				}
				break;
			case 1:
				if(currentDirection != Direction.SOUTH){
					direction = Direction.SOUTH;
					return;
				}
				break;
			case 2:
				if(currentDirection != Direction.WEST){
					direction = Direction.WEST;
					return;
				}
				break;
			case 3:
				if(currentDirection != Direction.EAST){
					direction = Direction.EAST;
					return;
				}
				break;
			}
		}
	}
	
	protected void move(Direction currentDirection) {
		switch(currentDirection){
		case NORTH:
			moveNorth();
			break;
		case SOUTH:
			moveSouth();
			break;
		case WEST:
			moveWest();
			break;
		case EAST:
			moveEast();
			break;
				
		}		
	}
	
	protected void checkForObject(String field){
		if(field.equals("i")){
			//increase points when object found
			points = points+10;
		}
	}
	// Up
	protected void moveNorth() {
		checkForObject(environment.getSquareValue(x+1,y));
		environment.setSquareValue(x+1,y,"A");
		environment.setSquareValue(x,y,"v");
		x = x + 1;
		// Calculate the moves
		moves = moves+1;
	}

	// Down
	protected void moveSouth() {
		checkForObject(environment.getSquareValue(x-1,y));
		environment.setSquareValue(x-1,y,"A");
		environment.setSquareValue(x,y,"v");
		x = x - 1;
		
		moves = moves+1;
		
	}

	// Left
	protected void moveWest() {
		checkForObject(environment.getSquareValue(x,y-1));
		environment.setSquareValue(x,y-1,"A");
		environment.setSquareValue(x,y,"v");
		y = y - 1;
		
		moves = moves+1;
		
	}
	// Right
	protected void moveEast() {
		checkForObject(environment.getSquareValue(x,y+1));
		environment.setSquareValue(x,y+1,"A");
		environment.setSquareValue(x,y,"v");
		y = y + 1;
		
		moves = moves+1;
		
	}


	// change the direction
	protected void toggleDirection(Direction currentDirection) {
		switch(currentDirection){
		case NORTH:
			direction = Direction.WEST;
			return;
		case SOUTH:
			direction = Direction.EAST;
			return;
		case WEST:
			direction = Direction.SOUTH;
			return;
		case EAST:
			direction = Direction.NORTH;
			return;
		}
	}


	// Stop the agent because it is reach end of life
	protected CellStatus checkNextSquareStatus(Direction currentDirection) {
		String boxContent = "";
		
		switch(currentDirection){
		case NORTH:
			if(x+1 >= environment.getHeight()) return EOL;
			boxContent = environment.getSquareValue(x+1,y);
			break;
		case SOUTH:
			if(x-1 < 0) return EOL;
			boxContent = environment.getSquareValue(x-1,y);
			break;
		case WEST:
			if(y-1 < 0) return EOL;
			boxContent = environment.getSquareValue(x,y-1);
			break;
		case EAST:
			if(y+1 >= environment.getWidth()) return EOL;
			boxContent = environment.getSquareValue(x,y+1);
			break;
				
		}
		
		if(boxContent != null && boxContent.equals("o")){
			return OBSTACLE;
		}
		
		
		return OPEN;
	}	
	
}
