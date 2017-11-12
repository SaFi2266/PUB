public class VacuumWorld {
	public int worldRow;
	public int worldColumn;
	public int[][] world; //world in matrix form
	public int performance; //award one point for each clean square at each time step
	
	
	public VacuumWorld(int row, int column){
		worldRow = row;
		worldColumn = column;
		world = new int[row][column];
		
		//randomize dirt placement and update current performance
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				if(Math.random() > 0.5){
					world[i][j] = 1;
				}
				else{
					world[i][j] = 0;
					performance++;
				}
			}
		}
	}
	
	public int[][] getWorld(){
		return world;
	}
	
	public int getRow(){
		return worldRow;
	}
	
	public int getColumn(){
		return worldColumn;
	}
	
	public void printWorld(){
		for (int i = 0; i < worldRow; i++) {
		    for (int j = 0; j < worldColumn; j++) {
		        System.out.print(world[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
	
	/*
	 * Clean the location given
	 * 
	 * @param location in the matrix
	 * @return void
	 */
	public void clean(int i, int j){
		world[i][j] = 0;
		performance++;
	}
	
	/*
	 * Check if the tile is clean (0 = clean and 1 = dirty)
	 * 
	 * @oaram location in the matrix
	 * @return true if the tile is clean and false if the tile is dirty
	 */
	public boolean isClean(int i, int j){
		if(world[i][j] == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void placeObstacle(int i, int j){
		world[i][j] = 2;
	}
	
	public int getPerformance(){
		return performance;
	}
}
