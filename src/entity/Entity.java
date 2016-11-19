package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Entity {
	
	protected double x;
	protected double y;
	protected boolean visible;
	
	
	
	public Entity(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		this.visible=false;
	}

	//-------------------Get-----------------------
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public boolean getVisible(){
		return visible;
	}
	
	//--------------------Set-----------------------
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setVisible(boolean visib){
		this.visible=visib;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}

}
