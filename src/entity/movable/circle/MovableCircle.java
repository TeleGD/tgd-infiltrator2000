package entity.movable.circle;

import entity.movable.Movable;
import fr.interfaces.Circle;

public class MovableCircle extends Movable implements Circle{

	public MovableCircle(double x, double y, double sx, double sy) {
		super(x, y, sx, sy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPositionX() {
		return x;
	}

	@Override
	public double getPositionY() {
		return y;
	}

}
