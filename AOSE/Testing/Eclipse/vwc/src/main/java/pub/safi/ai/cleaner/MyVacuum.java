package ai.cleaner;

public class MyVacuum extends VacuumAgent {

	public int getAction() {		
		if(bumped()) 
			return this.LEFT;
		else if(seesDirt())
			return this.SUCK;
		
		return this.FORWARD;
	}
}
