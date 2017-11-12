package agent_driven_table;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	private Perception perception;
	private List<Action> actions;
	
	public Agent(Perception perception, List<Action> actions) {
		super();
		this.perception = perception;
		this.actions = actions;
	}
	public Agent() {
		this.actions = new ArrayList<Action>();
	}
	public Perception getPerception() {
		return perception;
	}
	public void setPerception(Perception perception) {
		this.perception = perception;
	}
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	public Perception perceive(Environment e) {
		Perception per = new Perception();
		
		if(e.isDirtyA() == true && e.isAgentLocation() == true) {
			per.setDirty(true);
			per.setLocation(true);
		} else if(e.isDirtyA() == false && e.isAgentLocation() == true) {
			per.setDirty(false);
			per.setLocation(true);
		} else if(e.isDirtyB() == true && e.isAgentLocation() == false) {
			per.setDirty(true);
			per.setLocation(false);
		} else if(e.isDirtyB() == false && e.isAgentLocation() == false) {
			per.setDirty(false);
			per.setLocation(false);
		}
		
		return per;

	}
	@Override
	public String toString() {
		return "Agent [perception=" + perception + "]";
	}
	
	
}
