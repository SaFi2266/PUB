package com.mas.single.main;

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
import com.mas.single.agents.Agent;
import com.mas.single.agents.CognitiveAgent;

/**
 * @author JS
 * 
 * Main class for the Single Cognitive Agent
 *
 */
public class MasSingleAgentMain  extends JFrame implements ActionListener {
	private JTextField[][]cell;
	private JButton[][] buttons = new JButton[1][2];
	private JButton runButton;
	private JButton stepButton;
	private JPanel panel = new JPanel();

	private Environment e;
	private Agent agent;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MasSingleAgentMain(){
		super("MAS Agent");
	}

	public static void main(String[] args)  {
		MasSingleAgentMain main = new MasSingleAgentMain();
		main.initializeUI();
		main.renderUI();
		main.setVisible(true);

	}
	
	private void initializeUI(){
		//Input the height and width of the squares.
		int height = 10;
		int width = 10;
		
		cell = new JTextField[height][width];
		e = new Environment(height, width);
		
		/*
		 * Choose the type of agent that is needed.
		 */
		agent = new CognitiveAgent();
		//agent = new ReactiveAgents();
		agent.setEnvironment(e);
		agent.initializeAgent();
		

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
		
		this.setSize((int)(height*36), (int)(width*36 +40));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getActionCommand().equals(runButton.getText())){
			init();
			while(!e.isAllObjectsPicked()){
				moveAgent();
			}
		}else if(event.getActionCommand().equals(stepButton.getText())){
			init();
			if(!e.isAllObjectsPicked()){
				moveAgent();
			}
		}
	}
	
	private void init() {
		if(!e.isStarted()){
			e.setStarted(true);
			agent.placeAgent();
		}
	}
	
	private void moveAgent(){
		try {
			agent.moveAgent();
			renderUI();
			//if(e.isComplete()){
			if(e.isAllObjectsCollected()){
				JOptionPane.showMessageDialog(this, "Complete.\nMoves: "+agent.getMoves()+"\nPoints: "+agent.getPoints());
			}
		} catch (MasException e1) {
			JOptionPane.showMessageDialog(this, "ERROR: "+e1.getMessage());
			e1.printStackTrace();
			System.exit(0);
		}
	}
	
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
