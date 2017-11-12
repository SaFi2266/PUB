package agent_driven_table;

public class Main {

	public static void main(String[] args) {
		Environment environment = new Environment(true, true, true); 
		int n = 10;
		
		SimpleReflexAgent agent = new SimpleReflexAgent();
		agent.setPerception(agent.perceive(environment));
		
		for(int i=0; i < n;i++) {	
			System.out.println("\nA situação do ambiente é: " + environment.toString()); 
			agent.setPerception(agent.perceive(environment));//agente perceive the enviroment
			environment.updateEnviroment(agent.selectAction(agent.getPerception()));
		}

	}

}
