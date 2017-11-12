package agent_driven_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableDrivenAgent extends Agent {
	private Map<Perception, Action> table = new HashMap<Perception, Action>();
	private List<Perception> perceptions = new ArrayList<Perception>();
		
	public Map<Perception, Action> getTable() {
		return table;
	}

	public void setTable(Map<Perception, Action> table) {
		this.table = table;
	}

	public Map<Perception, Action> createTable(){
		this.table.put((new Perception(true,false)), new Action("right"));
		this.table.put((new Perception(true,true)), new Action("aspire"));
		this.table.put((new Perception(false,false)), new Action("left"));
		this.table.put((new Perception(false,true)), new Action("aspire"));
	
		return table;
	}

	public Action selectAction (Perception p) {
		perceptions.add(p);
		Action action = table.get(p);	
		
		return action;
	}
}
