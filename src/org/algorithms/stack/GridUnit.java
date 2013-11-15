package org.algorithms.stack;

public class GridUnit {

	private int x;
	
	private int y;
	
	private boolean obstacle;
	
	private boolean pass;
	
	private int direction;
	
	private boolean entry;
	
	private boolean outlet;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isObstacle() {
		return obstacle;
	}

	public void setObstacle(boolean obstacle) {
		this.obstacle = obstacle;
	}

	public boolean isEntry() {
		return entry;
	}

	public void setEntry(boolean entry) {
		this.entry = entry;
	}

	public boolean isOutlet() {
		return outlet;
	}

	public void setOutlet(boolean outlet) {
		this.outlet = outlet;
	}

	@Override
	public String toString() {
		return "GridUnit [x=" + x + ", y=" + y + ", obstacle=" + obstacle
				+ ", pass=" + pass + ", direction=" + direction + ", entry="
				+ entry + ", outlet=" + outlet + "]";
	}

	
}
