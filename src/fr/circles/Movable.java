package fr.circles;

import org.newdawn.slick.geom.Circle;

public abstract class Movable extends Circle{

	protected float speedX,speedY;
	protected float newX,newY;


	public  Movable(float centerPointX, float centerPointY, float radius) {
		super(centerPointX, centerPointY, radius);
	}





	public void moveX(int delta){
		this.x+=speedX*delta;
	}

	public void moveY(int delta){
		this.y+=speedY*delta;
	}

}
