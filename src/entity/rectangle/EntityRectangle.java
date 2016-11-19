package entity.rectangle;

import java.util.ArrayList;

import entity.Entity;
import fr.interfaces.Rectangle;

public class EntityRectangle extends Entity implements Rectangle {

	public EntityRectangle(double x, double y) {
		super(x, y);
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
