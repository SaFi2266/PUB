package agent_driven_table;

import java.util.List;

public class SimpleReflexAgent extends Agent{
	
	
	public SimpleReflexAgent() {
	}
	public SimpleReflexAgent(Perception perception, List<Action> actions) {
		super(perception, actions);
	}
	
	
	public Action selectAction(Perception p) {
		Action action = new Action();
		
		if(p.isDirty() == true) {
			action.setName("aspire");
		} else if(p.isLocation() == true && p.isDirty() == false) {
			action.setName("right");
		} else if(p.isLocation() == false && p.isDirty() == false) {
			action.setName("left");
		} 
		
		return action;
	}
}
