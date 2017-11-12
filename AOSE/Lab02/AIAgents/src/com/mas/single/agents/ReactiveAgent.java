package com.mas.single.agents;

import static com.mas.common.constants.CellStatus.EOL;
import static com.mas.common.constants.CellStatus.OBSTACLE;

import com.mas.common.exception.MasException;

/*
 * The Reactive Agent does not store any information on the squares,
 * it only visits the cells in a Random manner.
 */
public class ReactiveAgent extends Agent {

	@Override
	public void checkAndMove() throws MasException {
		int attempts = 0;
		while(true){
			if(moves%5==0)toggleDirectionRandom(direction);
			
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
}
