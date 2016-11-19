package entity.rectangle;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import fr.interfaces.Rectangle;

public class EntityRectangle extends Entity implements Rectangle {

	protected double height;
	protected double width;
	
	public EntityRectangle(double x, double y,double width,double height) {
		super(x, y);
		this.height=height;
		this.width=width;
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

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}
}
