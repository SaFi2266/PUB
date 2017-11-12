package com.mas.common.env;

import java.util.Random;

/**
 * @author JS
 *
 */
public class Environment {
	
	private String [][]square;
	private int height;
	private int width;

	private boolean started = false;
	private boolean complete = false;
	private boolean allObjectsCollected = false;

	public Environment(int height, int width){
		this.height = height;
		this.width = width;
		square = new String[height][width];
		initializeSquares();
	}
	
	private void initializeSquares(){
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				square[i][j] = "";
			}
		}
	}
	
	public String getSquareValue(int x, int y){
		return square[x][y];
	}
	
	public void setSquareValue(int x, int y, String value){
		square[x][y] = value;
	}
	
	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String[][] getSquare() {
		return square;
	}

	public void setSquare(String[][] square) {
		this.square = square;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public boolean isAllObjectsPicked(){
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				if(square[i][j].trim().equals("i"))
					return false;
			}
		}
		allObjectsCollected = true;
		return true;
	}
	
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
	

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isAllObjectsCollected() {
		return allObjectsCollected;
	}

	public void setAllObjectsCollected(boolean allObjectsCollected) {
		this.allObjectsCollected = allObjectsCollected;
	}

}
