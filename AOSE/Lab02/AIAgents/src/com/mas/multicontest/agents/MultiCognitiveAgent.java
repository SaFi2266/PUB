package com.mas.multicontest.agents;

import static com.mas.common.constants.CellStatus.OPEN;

import java.text.DecimalFormat;

import com.mas.common.constants.CellStatus;
import com.mas.common.constants.Direction;
import com.mas.common.exception.MasException;
import com.mas.single.agents.Agent;


/**
 * @author JS
 * 
 * The Multi Cognitive Agent stores the information on the squares
 * it has already visited and uses that information to 
 * explore square that it has not visited.  It also can sense other objects
 * 2 cells away and take decisions accordingly.

 */
public class MultiCognitiveAgent extends Agent {
	private int[][] squareVisitedStatus;

	public MultiCognitiveAgent(){
		super();
	}
	
	public MultiCognitiveAgent( String agentName){
		super(agentName);
	}
	

	@Override
	public void initializeAgent(){
		squareVisitedStatus = new int[environment.getHeight()][environment.getWidth()];
	}

	@Override
	public void checkAndMove() throws MasException {
		
		if(reachedHome)return;
		
		boolean checkIfVisited = true;
		boolean checkIfCaPresent = true;
		boolean checkIfRaPresent = true;
		int attempt = 1;

		
		if(environment.isAllObjectsCollected()){
			checkIfVisited = false;
			checkIfCaPresent = false;
			checkIfRaPresent = false;
			
			int xDiff = home_x - x;
			int yDiff = home_y - y;
			
			if(Math.abs(xDiff) > Math.abs(yDiff)){
				if(xDiff<0){
					direction = Direction.SOUTH;
				}else{
					direction = Direction.NORTH;
				}
			}else{
				if(yDiff < 0){
					direction = Direction.WEST;
				}else{
					direction = Direction.EAST;
				}
			}
			if(moves%10==0)toggleDirectionRandom(direction);
		}

		
		if(!checkAndMove(OPEN, checkIfRaPresent, checkIfCaPresent, checkIfVisited, attempt)){
			checkIfVisited = false;
			if(!checkAndMove(OPEN, checkIfRaPresent, checkIfCaPresent, checkIfVisited, attempt)){
				checkIfCaPresent = false;
				if(!checkAndMove(OPEN, checkIfRaPresent, checkIfCaPresent, checkIfVisited, attempt)){
					checkIfRaPresent = false;
					if(!checkAndMove(OPEN, checkIfRaPresent, checkIfCaPresent, checkIfVisited, attempt)){
						throw new MasException(agentName+" - Agent unable to move");
					}
					
				}
				
			}
			
		}
		
		if(environment.isAllObjectsCollected() && x == home_x && y == home_y){
			reachedHome = true;
		}
		
		
		moves++;
	}
	
	private void subtractInt(){
		DecimalFormat df = new DecimalFormat("###.##");
		points = Double.valueOf(df.format(points - 0.1));
	}

	private boolean checkAndMove(CellStatus status, boolean checkIfRaPresent, boolean checkIfCaPresent, boolean checkIfVisited, int attempt){
		//System.out.println("checkAndMove: status: "+status+"; checkIfRaPresent: "+checkIfRaPresent+"; checkIfCaPresent: "+checkIfCaPresent+"; checkIfVisited"+checkIfVisited+"; attempt: "+attempt);
		if(checkNextSquareStatus(direction).equals(status)){
			if(checkIfRaPresent){
				if(!isAgentPresent(RA)){
					if(checkIfCaPresent){
						if(!isAgentPresent(CA)){
							if(checkIfVisited){
								if(!isAlreadyVisited(direction)){
									subtractInt();
									move(direction);
									return true;
								}
								
							}else{
								move(direction);
								return true;
							}
						}
					}else{
						move(direction);
						return true;
					}
				}
			}else{
				move(direction);
				return true;
			}
		}
		
		if(attempt <= 4){
			attempt++;
			toggleDirection(direction);
			return checkAndMove(status, checkIfRaPresent, checkIfCaPresent, checkIfVisited, attempt);
		}
		
		return false;
	}
	
	
	protected boolean isAgentPresent(String agentType) {
		String boxContent = "";
		
		switch(direction){
		case NORTH:
			boxContent = environment.getSquareValue(x+1,y);
			if(boxContent.contains(agentType)) return true;
			if(x+2 < environment.getHeight()){
				boxContent = environment.getSquareValue(x+2,y);
				if(boxContent.contains(agentType)) return true;
			}
			break;
		case SOUTH:
			boxContent = environment.getSquareValue(x-1,y);
			if(boxContent.contains(agentType)) return true;
			if(x-2 >= 0){
				boxContent = environment.getSquareValue(x-2,y);
				if(boxContent.contains(agentType)) return true;
			}
			break;
		case WEST:
			boxContent = environment.getSquareValue(x,y-1);
			if(boxContent.contains(agentType)) return true;
			if(y-2 >= 0){
				boxContent = environment.getSquareValue(x,y-2);
				if(boxContent.contains(agentType)) return true;
			}
			break;
		case EAST:
			boxContent = environment.getSquareValue(x,y+1);
			if(boxContent.contains(agentType)) return true;
			if(y+2 < environment.getWidth()){
				boxContent = environment.getSquareValue(x,y+2);
				if(boxContent.contains(agentType)) return true;
			}
			break;
				
		}
		
		return false;
	}


	@Override
	protected void moveNorth() {
		squareVisitedStatus[x][y] = 1;
		super.moveNorth();
	}


	@Override
	protected void moveSouth() {
		squareVisitedStatus[x][y] = 1;
		super.moveSouth();
		
	}


	@Override
	protected void moveWest() {
		squareVisitedStatus[x][y] = 1;
		super.moveWest();
		
	}

	@Override
	protected void moveEast() {
		squareVisitedStatus[x][y] = 1;
		super.moveEast();
		
	}


	private boolean isAlreadyVisited(Direction currentDirection) {
		switch(currentDirection){
		case NORTH:
			if(squareVisitedStatus[x+1][y]==1) return true;
			break;
		case SOUTH:
			if(squareVisitedStatus[x-1][y]==1) return true;
			break;
		case WEST:
			if(squareVisitedStatus[x][y-1]==1) return true;
			break;
		case EAST:
			if(squareVisitedStatus[x][y+1]==1) return true;
			break;
				
		}
		
		return false;
	}
}
