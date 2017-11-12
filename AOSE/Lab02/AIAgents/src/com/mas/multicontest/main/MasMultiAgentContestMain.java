package com.mas.multicontest.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mas.common.env.Environment;
import com.mas.common.exception.MasException;
import com.mas.multicontest.agents.MultiCognitiveAgent;
import com.mas.multicontest.agents.MultiReactiveAgent;
import com.mas.single.agents.Agent;

/**
 * 
 * Main class for Multi-Cognitive and Reactive Agents contest.
 *
 */
public class MasMultiAgentContestMain  extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	private JTextField[][]cell;
	private JButton[][] buttons = new JButton[1][2];
	private JButton runButton;
	private JButton stepButton;
	private JPanel panel = new JPanel();

	private Environment e;
	private Agent ca1;
	private Agent ca2;
	private Agent ra1;
	private Agent ra2;
	
	private int height;
	private int width;
	
	private int moves;
	private boolean objCollectedMsgDisplayed = false;

	
	private int agentNumber = 1;



	MasMultiAgentContestMain(){
		super("Multi Agent Contest");
	}

	public static void main(String[] args)  {
		MasMultiAgentContestMain main = new MasMultiAgentContestMain();
		main.initializeUI();
		main.renderUI();
		main.setVisible(true);

	}
	
	/**
	 * Initialize the Swing UI.
	 */
	private void initializeUI(){
		//Input the height and width of the squares.
		height = 10;
		width = 10;
		
		cell = new JTextField[height][width];
		e = new Environment(height, width);
		
		/*
		 * Choose the type of agent that is needed.
		 */
		ca1 = new MultiCognitiveAgent("CA1");
		ca2 = new MultiCognitiveAgent("CA2");
		ra1 = new MultiReactiveAgent("RA1");
		ra2 = new MultiReactiveAgent("RA2");
		
		//agent = new ReactiveAgents();
		ca1.setEnvironment(e);
		ca1.initializeAgent();
		
		ca2.setEnvironment(e);
		ca2.initializeAgent();

		ra1.setEnvironment(e);
		ra1.initializeAgent();

		ra2.setEnvironment(e);
		ra2.initializeAgent();

		runButton = new JButton("Run");
		stepButton = new JButton("Step");
		
		Container c = this.getContentPane();
		panel.setLayout(new GridLayout(height+1,width));
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				cell[i][j] = new JTextField();
				panel.add(cell[i][j], j);
			}
		}
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,2));
		buttons[0][0] = runButton;
		buttons[0][1] = stepButton;
		panel1.add(buttons[0][0], 0);
		panel1.add(buttons[0][1], 1);
		
		runButton.addActionListener(this);
		stepButton.addActionListener(this);
		
		c.add(panel);
		c.add(panel1, BorderLayout.PAGE_END);
		
		e.placeObstaclesRandom();
		e.placeObjectsRandom();
		placeAgents();
		renderUI();
		
		this.setSize((int)(height*36), (int)(width*36 +40));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getActionCommand().equals(runButton.getText())){
			init();
			while(!e.isComplete()){
				moveAgent();
			}
		}else if(event.getActionCommand().equals(stepButton.getText())){
			init();
			if(!e.isComplete()){
				moveAgent();
			}
		}
	}
	
	/* 
	 * start
	 */
	private void init() {
		if(!e.isStarted()){
			e.setStarted(true);
			//placeAgents();
		}
	}
	
	/* 
	 * put agents
	 */
	private void placeAgents() {
		placeAgentsX(0, ca1);
		placeAgentsX(height-1, ra1);
		
		placeAgentsY(width-1, ca2);
		placeAgentsY(0, ra2);

	}
	
	/*
	 * @param i
	 * @param agent
	 */
	private void placeAgentsX(int i, Agent agent){
		for(int j=0;j<width;j++){
			if(e.getSquareValue(i,j).equalsIgnoreCase("")){
				e.setSquareValue(i, j, agent.getAgentName());
				agent.setLocation(i, j);
				agent.setHomeLocation(i, j);
				return;
			}
		}
	}
	
	/*
	 * @param i
	 * @param agent
	 */
	private void placeAgentsY(int i, Agent agent){
		for(int j=width-1;j>0;j--){
			if(e.getSquareValue(i,j).equalsIgnoreCase("")){
				e.setSquareValue(i, j, agent.getAgentName());
				agent.setLocation(i, j);
				agent.setHomeLocation(i, j);
				return;
			}
		}
	}

	/*
	 * movements
	 */
	private void moveAgent(){
		try {
			while(!moveAgent(agentNumber)){
				incrementAgentNumber();
			}
			incrementAgentNumber();
			renderUI();
			
			if(e.isAllObjectsCollected()  && !objCollectedMsgDisplayed) {
				StringBuilder completionMessage = new StringBuilder();
				completionMessage.append("         All Objects Collected! \n");
				completionMessage.append("            Moves: "+moves+"\n");
				completionMessage.append("                Points\n");
				completionMessage.append("CA1: "+ca1.getPoints()+"   CA2: "+ca2.getPoints()+"\n");
				completionMessage.append("RA1: "+ra1.getPoints()+"   RA2: "+ra2.getPoints());
				objCollectedMsgDisplayed = true;
				JOptionPane.showMessageDialog(this, completionMessage.toString());
			}
			if(e.isComplete()){
				StringBuilder completionMessage = new StringBuilder();
				completionMessage.append("              Complete! \n");
				completionMessage.append("            Moves: "+moves+"\n");
				completionMessage.append("                Points\n");
				completionMessage.append("CA1: "+ca1.getPoints()+"   CA2: "+ca2.getPoints()+"\n");
				completionMessage.append("RA1: "+ra1.getPoints()+"   RA2: "+ra2.getPoints());
				JOptionPane.showMessageDialog(this, completionMessage.toString());
			}
		} catch (MasException e1) {
			JOptionPane.showMessageDialog(this, "ERROR: "+e1.getMessage());
			e1.printStackTrace();
			e.setComplete(true);
		}
	}
	
	/*
	 * directions
	 */
	private void incrementAgentNumber(){
		agentNumber++;
		if(agentNumber > 4)
			agentNumber = 1;
	}
	
	/*
	 * @param an
	 * @return
	 * @throws MasException
	 */
	private boolean moveAgent(int an) throws MasException{
		boolean moved = false;
		switch(an){
		case 1:
			if(!ca1.isReachedHome()){
				ca1.moveAgent();
				moved =  true;
			}
			break;
		case 2:
			if(!ca2.isReachedHome()){
				ca2.moveAgent();
				moved =  true;
			}
			break;
		case 3:
			if(!ra1.isReachedHome()){
				ra1.moveAgent();
				moved =  true;
			}
			break;
		case 4:
			if(!ra2.isReachedHome()){
				ra2.moveAgent();
				moved =  true;
			}
			break;
		}
		
		if(ca1.isReachedHome() && ca2.isReachedHome() && ra1.isReachedHome() && ra2.isReachedHome()){
			e.setComplete(true);
		}
		
		checkAndSetPoints();
		
		moves++;
		
		if(moves > 25000)
			throw new MasException("Obect surrounded by obstacles");
		
		return moved;
	}
	
	private void checkAndSetPoints(){
		if(ca1.locationEquals(ca2))distributePoints(ca1, ca2);
		if(ca1.locationEquals(ra1))distributePoints(ca1, ra1);
		if(ca1.locationEquals(ra2))distributePoints(ca1, ra2);
		if(ca2.locationEquals(ra1))distributePoints(ca2, ra1);
		if(ca2.locationEquals(ra2))distributePoints(ca2, ra2);
		if(ra1.locationEquals(ra2))distributePoints(ra1, ra2);
	}
	
	private void distributePoints(Agent  a1, Agent  a2){
		
		if((a1 instanceof MultiCognitiveAgent && a2 instanceof MultiCognitiveAgent) ||
			(a1 instanceof MultiReactiveAgent && a2 instanceof MultiReactiveAgent)){
			double totalPoints = a1.getPoints() + a2.getPoints();
			a1.setPoints(totalPoints/2);
			a2.setPoints(totalPoints/2);
		}else{
			// a1 will always be CA
			// a2 will always be RA
			if(a1.getPoints()>0){
				a2.setPoints(a1.getPoints()+a2.getPoints());
			}
			a1.setPoints(0);
		}
			
		
	}
	
	/*
	 * build interface
	 */
	private void renderUI(){
		for(int i=0;i<e.getHeight();i++){
			for(int j=0;j<e.getWidth();j++){
				String squareContent = e.getSquareValue(i,j);
				cell[i][j].setText(squareContent);
				if(squareContent!=null && squareContent.equals("o")){
					cell[i][j].setBackground(Color.RED);
				}else if(squareContent!=null && squareContent.equals("i")){
					cell[i][j].setBackground(Color.GREEN);
				}
			}
		}
	}

}
