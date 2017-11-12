
public class SimpleReflexAgent {
	public int myRow;
	public int myColumn;
	public int myWorldRow;
	public int myWorldColumn;
	
	public SimpleReflexAgent(int row, int column, int worldRow, int worldColumn){
		myRow = row;
		myColumn = column;
		myWorldRow = worldRow;
		myWorldColumn = worldColumn;
	}
	
	public int getRow(){
		return myRow;
	}
	
	public int getColumn(){
		return myColumn;
	}
	
	/*
	 * move the agent to the right one tile
	 * @param
	 * @return void
	 */
	public void moveRight(){
		if((myColumn + 1) < myWorldColumn){
			myColumn++;
		}
	}
	
	/*
	 * move the agent to the left one tile
	 * @param
	 * @return void
	 */
	public void moveLeft(){
		if(myColumn > 0){
			myColumn--;
		}
	}
	
	/*
	 * move the agent down one tile
	 * @param
	 * @return void
	 */
	public void moveDown(){
		if((myRow + 1) < myWorldRow){
			myRow++;
		}
	}
	
	/*
	 * move the agent up one tile
	 * @param
	 * @return void
	 */
	public void moveUp(){
		if(myRow > 0){
			myRow--;
		}
	}
}
