package com.mas.multicontest.agents;

import static com.mas.common.constants.CellStatus.EOL;
import static com.mas.common.constants.CellStatus.OBSTACLE;

import com.mas.common.constants.Direction;
import com.mas.common.exception.MasException;
import com.mas.single.agents.Agent;

/**
 * @author JS
 * 
 * The Reactive Agent does not store any information on the squares,
 * But it will be able to sense the information present on its neighboring
 * squares and act accordingly. 
 *
 */
public class MultiReactiveAgent extends Agent {
	
	public MultiReactiveAgent(){
		super();
	}
	
	public MultiReactiveAgent(String agentName){
		super(agentName);
	}

	@Override
	public void checkAndMove() throws MasException {
		
		if(reachedHome)return;
		
		if(environment.isAllObjectsCollected() && x == home_x && y == home_y){
			reachedHome = true;
			return;
		}

		
		if(environment.isAllObjectsCollected()){
		
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
		}

		if(!environment.isAllObjectsCollected()){
			Direction agentDirection = isAgentPresent(CA);
			
			if(agentDirection != null){
				direction = agentDirection;
				move(direction);
				return;
			}
		}
		
		int attempts = 0;
		while(true){
			if(moves%5==0 && !environment.isAllObjectsCollected())toggleDirectionRandom(direction);
			
			if(!checkNextSquareStatus(direction).equals(OBSTACLE) && !checkNextSquareStatus(direction).equals(EOL)){
				move(direction);
				return;
			}else{
				toggleDirectionRandom(direction);
			}
			attempts++;
			
			if(attempts > 10000){
				throw new MasException("Obstacles have enclosed the agent");
			}
		}
	}
	
	protected Direction isAgentPresent(String agentType) {
		String boxContent = "";
		
		if(x+1 < environment.getHeight()){
			boxContent = environment.getSquareValue(x+1,y);
			if(boxContent.contains(agentType)) return Direction.NORTH;
		}
		if(x-1 >= 0){
			boxContent = environment.getSquareValue(x-1,y);
			if(boxContent.contains(agentType)) return Direction.SOUTH;
		}
		if(y-1 >= 0){
			boxContent = environment.getSquareValue(x,y-1);
			if(boxContent.contains(agentType)) return Direction.WEST;
		}
		if(y+1 < environment.getWidth()){
			boxContent = environment.getSquareValue(x,y+1);
			if(boxContent.contains(agentType)) return Direction.EAST;
		}
		return null;
	}
}
