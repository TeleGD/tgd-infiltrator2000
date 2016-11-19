package entity.circle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

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
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}


}
