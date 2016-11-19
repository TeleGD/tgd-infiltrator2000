package entity.circle;

import entity.Entity;
import fr.interfaces.Circle;

public class EntityCircle extends Entity implements Circle {

	protected double radius;
	
	public EntityCircle(double x, double y) {
		super(x, y);
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
