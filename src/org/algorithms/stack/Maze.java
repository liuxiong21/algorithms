package org.algorithms.stack;

import java.awt.Container;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Maze extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -518239672963721702L;
	
	private MazeGrid grid;
	
	private MazePathPanel pathPanel;
	
	private Stack<GridUnit> pathStack = new Stack<GridUnit>();
	
	private GridUnit curUnit;
	
	private int speed = 500;
	
	public Maze(String title){
		super(title);
	}
	
	public void initMaze(int size,int gridOffset){
		grid = new MazeGrid(size);
		pathPanel = new MazePathPanel(size,500,gridOffset);
		pathPanel.setBounds(gridOffset, gridOffset, 25, 25);
		Container container = this.getContentPane();
		container.add(pathPanel);
		container.setComponentZOrder(pathPanel, 0);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Maze maze = new Maze("Maze Path");
		maze.setSize(new Dimension(550, 580));
		maze.setLocationByPlatform(true);
		JLayeredPane layerPane = new JLayeredPane();
		maze.setContentPane(layerPane);
		int gridsize = 20;
		int gridOffset = 10;
		maze.initMaze(gridsize,gridOffset);
		MazeGridPanel gridPanel = new MazeGridPanel(gridsize,500);
		gridPanel.setBounds(gridOffset, gridOffset, 500, 500);
		layerPane.add(gridPanel);
		gridPanel.setMazeGrid(maze.getGrid());
		gridPanel.repaint();
		maze.setDefaultCloseOperation(EXIT_ON_CLOSE);
		maze.setVisible(true);
		maze.startGame();
	}
	
	public MazeGrid getGrid(){
		return grid;
	}
	
	public void startGame(){
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				curUnit = grid.getEntry();
				curUnit.setPass(true);
				pathStack.push(curUnit);
				while(true){
					GridUnit next = getNextUnit();
					if(next==null||next.isObstacle()||next.isPass()){
						if(curUnit.getDirection()<4)
							curUnit.setDirection(curUnit.getDirection()+1);
						else{
							curUnit = pathStack.pop();
							if(curUnit==null){
								System.out.println("failed");
								return;
							}
							paintCurGrid();
						}
						continue;
					}
					curUnit.setDirection(curUnit.getDirection()+1);
					pathStack.push(curUnit);
					curUnit = next;
					paintCurGrid();
					if(curUnit.isOutlet()){
						System.out.println("successed!!");
						return;
					}
						
				}
				
			}
			
		});
		t.start();
	}
	
	public void paintCurGrid(){
		try {
			TimeUnit.MILLISECONDS.sleep(speed);
			pathPanel.changeBounds(curUnit.getX(), curUnit.getY());
			curUnit.setPass(true);
			pathPanel.repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public GridUnit getNextUnit(){
		int direction = curUnit.getDirection();
		if(direction==1)
			return grid.getUnit(curUnit.getX()+1, curUnit.getY());
		else if(direction==2)
			return grid.getUnit(curUnit.getX(), curUnit.getY()+1);
		else if(direction==3)
			return grid.getUnit(curUnit.getX()-1, curUnit.getY());
		else
			return grid.getUnit(curUnit.getX(), curUnit.getY()-1);
	}
	
}
