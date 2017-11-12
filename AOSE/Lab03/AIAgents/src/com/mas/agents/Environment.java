package com.mas.agents;

import java.util.Random;

// Put room dimensions  
public class Environment {
	
	private String [][]square;
	private int height;		
	private int width;

	// named square status
	private boolean started = false;
	private boolean complete = false;

	// make the room as string object	
	public Environment(int height, int width){
		this.height = height;
		this.width = width;
		square = new String[height][width];
		initializeSquares();
	}
	// Fill with nothing
	private void initializeSquares(){
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				square[i][j] = "";
			}
		}
	}
	
	// to get room's square value
	public String getSquareValue(int x, int y){
		return square[x][y];
	}
	// to set room's square value
	public void setSquareValue(int x, int y, String value){
		square[x][y] = value;
	}
	// to check room's square value was cleaned 
	public boolean isComplete() {
		return complete;
	}
	// to set room's square value is complete
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	// to get room's square 
	public String[][] getSquare() {
		return square;
	}
	// to set room's square
	public void setSquare(String[][] square) {
		this.square = square;
	}
	// to get the height
	public int getHeight() {
		return height;
	}
	// to set the height
	public void setHeight(int height) {
		this.height = height;
	}
	//  to get the width
	public int getWidth() {
		return width;
	}
	// to set the width
	public void setWidth(int width) {
		this.width = width;
	}
	// to check all squares are clean
	public boolean isAllObjectsPicked(){
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				if(square[i][j].trim().equals("i"))
					return false;
			}
		}
		return true;
	}
	// fill room's squares randomly with objects will be green
	public void placeObjectsRandom() {
		int objectsSet = 0;
		while (true){
			Random r = new Random();
			int i = Math.abs(r.nextInt() % height);
			int j = Math.abs(r.nextInt() % width);
			
			if(square[i][j] == null || square[i][j].trim().equals("")){
				square[i][j]="i";
				//square[i][j].setBackground(Color.GREEN);
				objectsSet++;
			}
			
			if(objectsSet == height){
				break;
			}
		}		
	}

	// fill room's squares randomly with obstacles will be red
	public void placeObstaclesRandom() {
		int obstaclesSet = 0;
		while (true){
			Random r = new Random();
			int i = Math.abs(r.nextInt() % height);
			int j = Math.abs(r.nextInt() % width);
			
			if(square[i][j] == null || square[i][j].trim().equals("")){
				square[i][j]="o";
				//square[i][j].setBackground(Color.RED);
				obstaclesSet++;
			}
			
			if(obstaclesSet == height){
				break;
			}
		}
	}
	
	// to check the starting
	public boolean isStarted() {
		return started;
	}
	// to set the starting
	public void setStarted(boolean started) {
		this.started = started;
	}
}
