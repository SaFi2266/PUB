package com.mas.single.agents;

import static com.mas.common.constants.CellStatus.EOL;
import static com.mas.common.constants.CellStatus.OBSTACLE;
import static com.mas.common.constants.CellStatus.OPEN;

import java.util.Random;

import com.mas.common.constants.CellStatus;
import com.mas.common.constants.Direction;
import com.mas.common.env.Environment;
import com.mas.common.exception.MasException;

/**
 * @author JS
 *
 */
public abstract class Agent {
	protected Direction direction;
	protected int x;
	protected int y;
	protected int home_x;
	protected int home_y;
	protected int moves = 0;
	protected double points = 0;
	protected Environment environment;
	protected String agentName;
	
	protected boolean reachedHome;

	public static final String CA = "CA";
	public static final String RA = "RA";
	
	public Agent(){
		this("A");
	}
	
	public Agent(String agentName){
		this.agentName = agentName;
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
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setHomeLocation(int x, int y){
		this.home_x = x;
		this.home_y = y;
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
	
	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public boolean isReachedHome() {
		return reachedHome;
	}

	public void setReachedHome(boolean reachedHome) {
		this.reachedHome = reachedHome;
	}

	public void initializeAgent(){
	}
	
	public void moveAgent() throws MasException{
		checkAndMove();
		if(environment.isAllObjectsPicked()){
			//environment.setComplete(true);
			environment.setAllObjectsCollected(true);
		}
	}
	
	/*
	 * Needs to be implemented by the Specific type of agents.
	 */
	public abstract void checkAndMove()  throws MasException;

	public void placeAgent() {
		for(int i=0;i<environment.getHeight();i++){
			for(int j=0;j<environment.getWidth();j++){
				if(environment.getSquare()[i][j].trim().equals("")){
					environment.getSquare()[i][j]=agentName;
					this.x = i;
					this.y = j;
					return;
				}
			}
		}
	}
	
	
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
		points --;
	}
	
	protected void checkForObject(String field){
		if(field.equals("i")){
			//Object Found
			points = points+10;
		}
	}




	protected void moveNorth() {
		checkForObject(environment.getSquareValue(x+1,y));
		environment.setSquareValue(x+1,y,agentName);
		environment.setSquareValue(x,y,"v");
		x = x + 1;
		
		moves = moves+1;
	}


	protected void moveSouth() {
		checkForObject(environment.getSquareValue(x-1,y));
		environment.setSquareValue(x-1,y,agentName);
		environment.setSquareValue(x,y,"v");
		x = x - 1;
		
		moves = moves+1;
		
	}


	protected void moveWest() {
		checkForObject(environment.getSquareValue(x,y-1));
		environment.setSquareValue(x,y-1,agentName);
		environment.setSquareValue(x,y,"v");
		y = y - 1;
		
		moves = moves+1;
		
	}

	protected void moveEast() {
		checkForObject(environment.getSquareValue(x,y+1));
		environment.setSquareValue(x,y+1,agentName);
		environment.setSquareValue(x,y,"v");
		y = y + 1;
		
		moves = moves+1;
		
	}


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
	
	public boolean locationEquals(Agent a1){
		return (this.x == a1.x && this.y == a1.y);
	}


	
	
	
}
