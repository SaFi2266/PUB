package agent_driven_table;

public class Perception {
	private boolean location;
	private boolean isDirty; //state
	
	
	public Perception(boolean location, boolean isDirty) {
		super();
		this.location = location;
		this.isDirty = isDirty;
	}
	
	public Perception() {
	}
	
	public boolean isLocation() {
		return location;
	}
	public void setLocation(boolean location) {
		this.location = location;
	}
	public boolean isDirty() {
		return isDirty;
	}
	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}
	
	
}
