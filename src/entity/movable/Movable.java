package entity.movable;

import entity.Entity;

public abstract class Movable extends Entity {

	protected double speedX;
	protected double speedY;
	
	
	public Movable(double x, double y, double sx, double sy) {
		super(x, y);
		this.speedX=sx;
		this.speedY=sy;
	}


	//-------------------------Get-----------------
	
	public double getSpeedX() {
		return speedX;
	}


	public double getSpeedY() {
		return speedY;
	}

	//-----------------------Set--------------------
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}


	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
	
	public void moveX(int delta){
		this.x += speedX*delta;
	}
	
	public void moveY(int delta){
		this.y += speedY*delta;
	}
	
	

	
	
}
