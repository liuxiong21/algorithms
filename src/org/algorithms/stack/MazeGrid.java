package org.algorithms.stack;

import java.util.Random;

public class MazeGrid {
	
	private GridUnit[][] grid = null;
	
	private int size;
	
	public MazeGrid(int size){
		this.size = size;
		grid = new GridUnit[size][size];
		init();
	}
	
	public void init(){
		Random rand = new Random();
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				GridUnit unit = new GridUnit();
				unit.setX(i);
				unit.setY(j);
				if(i==0&&j==0)
					unit.setEntry(true);
				else if(i==size-1&&j==size-1)
					unit.setOutlet(true);
				else if(rand.nextInt(3)==1)
					unit.setObstacle(true);
				unit.setDirection(1);
				grid[i][j] = unit;
			}
		}
	}
	
	public GridUnit[][] getGrid(){
		return grid;
	}
	
	public GridUnit getUnit(int x,int y){
		if(x>=size||x<0||y>=size||y<0)
			return null;
		return grid[x][y];
	}

	public GridUnit getEntry() {
		return grid[0][0];
	}

	public GridUnit getOutlet() {
		return grid[size-1][size-1];
	}

}
