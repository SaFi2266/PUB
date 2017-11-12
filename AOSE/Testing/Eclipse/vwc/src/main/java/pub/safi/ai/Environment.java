package ai;
/**
 * A generic environment.
 * All environments must implement getPercept, performanceMeasure, 
 * snapshot, termination, and legalAction methods
 *
 */

public abstract class Environment implements Runnable
{
	
	public Agent[] agents = new Agent[0];				// The agents within the environment.
	public int step = 0;								// The current step number.	 
	public int maxSteps = 1000;							// The maximum number of steps.	    
	public boolean display = true;						// Flag to indicate whether to display   
	public Thread runner;    
	/** 
	 * @param a Agent in the environment
	 */
	public abstract Object getPercept(Agent a);			// Get the current percept.
	/** 
	 * @param a Agent in the environment
	 */
	public abstract int performanceMeasure(Agent a);	// Score the performance of the agent.	
	public abstract void snapshot();					// A snapshot of the environment.
	public abstract boolean termination();				// Determine if all agents have terminated.
	/** 
	 * @param a Possible action.
	 */
	public abstract boolean legalAction(String a);		// Determine if action is legal.
	public void start()
	{
	    runner = new Thread(this);
	    runner.start();
	}
	
	public void stop()
	{
	    runner = null;
	}

	public void run()		// Run the environment until maximum steps or termination criteria are met.
	{
		Simulator mySim = new Simulator();
		mySim.start();
	}

	public void takeStep()	// Each agent determines and performs one action.
	{
	    if (step < maxSteps && !termination()) {
			step++;
			// update the percept and action of each agent
			for (int j=0; j<agents.length; j++)
			{
				Agent a = agents[j];
				a.percept= getPercept(a);
				a.determineAction();
			}
			// update the environment
			updateEnv();
			// set the scores of the agents
			for (int j=0; j<agents.length; j++)
				agents[j].score=performanceMeasure(agents[j]);
			displayEnv();
		}
	}

	public void displayEnv()	// Perform one animation step if the display flag is set.
	{
		if (display) {
		   snapshot();
		   try { Thread.sleep(300); }
		   catch(Exception e) {}
		}
	}

	public void updateEnv()	// Update the environment after each step.
	{
	    executeAgentActions();
	}

	public void executeAgentActions() // Each agent executes its current action.
	{
	    // each agent takes an action if legal
	    for (int i=0; i<agents.length; i++) {
		String act = agents[i].action;
		if (legalAction(act))
		    agents[i].takeAction(this);
	    }
	}
	protected class Simulator extends Thread {
		public void run() {
			displayEnv();
			while (step < maxSteps && !termination()) {
				takeStep();
			}
		}
	}
}
