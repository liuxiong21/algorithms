package org.algorithms.stack;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MazeGridPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9042808571998199098L;
	
	private int unitLen;
	
	private MazeGrid grid;
	
	public MazeGridPanel(int size,int width){
		unitLen = width/size;
	}
	
	public void setMazeGrid(MazeGrid grid){
		this.grid = grid;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(grid==null)
			return;
		for(GridUnit[] units:grid.getGrid()){
			for(GridUnit unit:units){
				if(unit.isObstacle())
					g.setColor(Color.BLACK);
				else if(unit.isEntry()||unit.isOutlet())
					g.setColor(Color.GREEN);
				else
					g.setColor(Color.WHITE);
				g.fillRect(unit.getX()*unitLen,unit.getY()*unitLen, unitLen, unitLen);
			}
		}
	}

}
