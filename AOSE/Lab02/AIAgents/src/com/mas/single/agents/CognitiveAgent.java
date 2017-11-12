package com.mas.single.agents;

import static com.mas.common.constants.CellStatus.EOL;
import static com.mas.common.constants.CellStatus.OBSTACLE;
import static com.mas.common.constants.CellStatus.OPEN;

import java.text.DecimalFormat;

import com.mas.common.constants.CellStatus;
import com.mas.common.constants.Direction;
import com.mas.common.exception.MasException;

/*
 * The Cognitive Agent stores the information on the squares
 * it has already visited and uses that information to 
 * explore square that it has not visited.  Hence improving the 
 * performance.
 */
public class CognitiveAgent extends Agent {
	private int[][] squareVisitedStatus;

	public CognitiveAgent(){
		super();
	}
	

	@Override
	public void initializeAgent(){
		squareVisitedStatus = new int[environment.getHeight()][environment.getWidth()];
	}

	@Override
	public void checkAndMove() throws MasException {
		if(!checkAndMoveToOpenSquare(OPEN)){
			checkAndMoveToVisistedSquare();
		}
		moves++;
	}
	
	private void subtractInt(){
		DecimalFormat df = new DecimalFormat("###.##");
		points = Double.valueOf(df.format(points - 0.1));
	}


	private boolean checkAndMoveToVisistedSquare() throws MasException{
		int attempts = 0;
		while(true){
			toggleDirectionRandom(direction);
			if(!checkNextSquareStatus(direction).equals(OBSTACLE) && !checkNextSquareStatus(direction).equals(EOL)){
				move(direction);
				return true;
			}
			attempts++;
			if(attempts > 10000){
				throw new MasException("Obstacles have enclosed the agent");
			}

		}
	}

	private boolean checkAndMoveToOpenSquare(CellStatus status) {
		if(checkNextSquareStatus(direction).equals(status) && !isAlreadyVisited(direction)){
			subtractInt();
			move(direction);
			return true;
		}else{
			toggleDirection(direction);
			if(checkNextSquareStatus(direction).equals(status) && !isAlreadyVisited(direction)){
				subtractInt();
				move(direction);
				return true;
			}else{
				toggleDirection(direction);
				if(checkNextSquareStatus(direction).equals(status) && !isAlreadyVisited(direction)){
					subtractInt();
					move(direction);
					return true;
				}else{
					toggleDirection(direction);
					if(checkNextSquareStatus(direction).equals(status) && !isAlreadyVisited(direction)){
						subtractInt();
						move(direction);
						return true;
					}
				}
			}
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
