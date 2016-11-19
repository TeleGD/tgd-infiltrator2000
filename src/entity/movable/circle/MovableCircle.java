package entity.movable.circle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

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
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}



}
