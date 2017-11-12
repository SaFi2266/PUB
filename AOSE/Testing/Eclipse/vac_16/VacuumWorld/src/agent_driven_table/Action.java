package agent_driven_table;

public class Action {
	private String name;
	
	public Action(String name) {
		super();
		this.name = name;
	}
	public Action() {
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "[" + name + "]";
	}
	
	
}
