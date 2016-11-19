package entity.movable.circle;

import entity.movable.Movable;
import fr.interfaces.Circle;

public class MovableCircle extends Movable implements Circle{

	protected double radius;
	
	public MovableCircle(double x, double y, double sx, double sy) {
		super(x, y, sx, sy);
	}

	@Override
	public double getRadius() {
		return this.radius;
	}

	@Override
	public void setRadius(double radius) {
		this.radius=radius;
		
	}



}
