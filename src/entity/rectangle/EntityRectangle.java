package entity.rectangle;

import java.util.ArrayList;

import entity.Entity;
import fr.interfaces.Rectangle;

public class EntityRectangle extends Entity implements Rectangle {

	protected double height;
	protected double width;
	
	public EntityRectangle(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getHeight() {
		return this.height;
	}

	@Override
	public double getWidth() {
		return this.width;
	}

	@Override
	public ArrayList<ArrayList<Double>> pixelBordeer() {
		ArrayList<ArrayList<Double>> res=new ArrayList<ArrayList<Double>>();
		for (int i = (int) this.x; i < this.x+this.width ; i++) {
			ArrayList<Double> a=new ArrayList<Double>();
			a.add((double)i);
			a.add(this.y);
			res.add(a);
			ArrayList<Double> b=new ArrayList<Double>();
			b.add((double)i);
			b.add(this.y+this.height);
			res.add(b);
		}
		for (int j = (int) this.y; j <this.y+this.height ; j++) {
			ArrayList<Double> a=new ArrayList<Double>();
			a.add(this.x);
			a.add((double) j);
			res.add(a);
			ArrayList<Double> b=new ArrayList<Double>();
			b.add(this.x+this.width);
			b.add((double) j);
			res.add(b);
		}
		return res;
	}
	
	@Override
	public void setHeight(double height) {
		this.height=height;
		
	}

	@Override
	public void setWidth(double width) {
		this.width=width;
		
	}

	@Override
	public ArrayList<ArrayList<Double>> pixelBordeerWithSpeed() {
		return null;
	}

}
