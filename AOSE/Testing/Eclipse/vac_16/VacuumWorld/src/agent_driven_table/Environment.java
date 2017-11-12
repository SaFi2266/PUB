package agent_driven_table;

public class Environment {
	private boolean isDirtyA;
	private boolean isDirtyB;
	private boolean agentLocation;
	
	public Environment(boolean isDirtyA, boolean isDirtyB, boolean agentLocation) {
		super();
		this.isDirtyA = isDirtyA;
		this.isDirtyB = isDirtyB;
		this.agentLocation = agentLocation;
	}
	
	public Environment() {
	}
	
	public boolean isDirtyA() {
		return isDirtyA;
	}
	public void setDirtyA(boolean isDirtyA) {
		this.isDirtyA = isDirtyA;
	}
	public boolean isDirtyB() {
		return isDirtyB;
	}
	public void setDirtyB(boolean isDirtyB) {
		this.isDirtyB = isDirtyB;
	}
	public boolean isAgentLocation() {
		return agentLocation;
	}
	public void setAgentLocation(boolean agentLocation) {
		this.agentLocation = agentLocation;
	}
	
	public void updateEnviroment(Action a) {
		if(a.getName() == "aspire" && this.isAgentLocation() == true) {
			this.isDirtyA = false;
		} else if(a.getName() == "aspire" && this.isAgentLocation() == false) {
			this.isDirtyB = false;
		} else if(a.getName() == "left" && this.isAgentLocation() == false) {
			this.setAgentLocation(true);
		} else if(a.getName() == "right" && this.isAgentLocation() == true) {
			this.setAgentLocation(false);
		}
	}
	@Override
	public String toString() {
		return "Sala A: " + isDirtyA() + " , Sala B: " + isDirtyB() + " , Sala atual:" + isAgentLocation();
	}
}
