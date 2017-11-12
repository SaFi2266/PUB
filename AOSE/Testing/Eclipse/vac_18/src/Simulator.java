
public class Simulator {
	public static void main (String[] args){
		int performanceScore = 0;
		VacuumWorld world = new VacuumWorld(1, 2);
		SimpleReflexAgent agent = new SimpleReflexAgent(0, 0, 1, 2);
		world.printWorld();
		
		for(int i = 0; i < 1000; i++){
			if(!world.isClean(agent.getRow(), agent.getColumn())){
				world.clean(agent.getRow(), agent.getColumn());
				performanceScore += world.getPerformance();
			}
			else if(agent.getColumn() == 0){
				agent.moveRight();
				performanceScore += world.getPerformance();
			}
			else{
				agent.moveLeft();
				performanceScore += world.getPerformance();
			}
		}
		
		System.out.println(performanceScore);
	}
}
