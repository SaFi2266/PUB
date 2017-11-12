package ai;
/**
 * A generic agent.
 * All agents must implement determineAction and takeAction methods
 */

public abstract class Agent {
	public  AgentBody body;		//The body of the agent
	public  int score;			//The current score
	public  Object percept;		//The current percept 
	public  String action;		//The current action

	public Agent()
	{
		body = new AgentBody();
		score = 0;
	}

	/**
	 * Determines the next action to be taken by the agent.
	 * The action is stored as a string in the field 'action'.
	 */
	public abstract void determineAction();
	/**
	 * Perfom the current action.
	 * @param e is the environment the agent is within
	 */
	public abstract void takeAction(Environment e);

}
