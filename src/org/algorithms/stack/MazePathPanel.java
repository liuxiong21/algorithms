package org.algorithms.stack;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MazePathPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7271111477210846037L;
	
	private int unitLen;
	
	private int offset;
	
	public MazePathPanel(int size,int width,int offset){
		unitLen = width/size;
		this.offset = offset;
	}
	
	public void changeBounds(int x,int y){
		this.setBounds(offset+x*unitLen, offset+y*unitLen, unitLen, unitLen);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, unitLen, unitLen);
	}
	
}
