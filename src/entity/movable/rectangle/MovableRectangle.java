package entity.movable.rectangle;

import java.util.ArrayList;

import entity.movable.Movable;
import fr.interfaces.Rectangle;

public class MovableRectangle extends Movable implements Rectangle{

	public MovableRectangle(double x, double y, double sx, double sy) {
		super(x, y, sx, sy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ArrayList<Double>> pixelBordeer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<Double>> pixelBordeerWithSpeed() {
		// TODO Auto-generated method stub
		return null;
	}

}
