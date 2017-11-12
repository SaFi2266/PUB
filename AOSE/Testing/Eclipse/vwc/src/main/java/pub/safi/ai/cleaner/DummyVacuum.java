package ai.cleaner;

public class DummyVacuum extends VacuumAgent {

	public int getAction() {		
		if(bumped()) 
			return this.LEFT;
		
		return this.FORWARD;
	}

}

