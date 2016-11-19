package entity.movable.Circle;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Guard extends Character {
	private double radius; 
	protected Area visualField;
	
	public Guard(double x, double y, double sx, double sy, Image im, Area visuFie) {
		super(x, y, sx, sy, im);
		this.visualField=visuFie;
	}

	//------------------------------Get--------------
	
	public Area getVisualField() {
		return visualField;
	}

	//------------------------------Set--------------
	
	public void setVisualField(Area visualField) {
		this.visualField = visualField;
	}
	
	public void update(BasicGameState arg1, StateBasedGame arg2, int arg3)  {
		
	}
	
	public void render(BasicGameState arg1, StateBasedGame arg2, Graphics arg3){
		arg3.fillOval((float)x, (float)y, (float)2*radius, (float)2*radius);
	}
	
	public void movX(double x, double sx, double count, double bool, int delta){
		if (bool == 1){
			while (x<count){
				moveX(delta);
			}
			bool=-1;
		}
		else{
			while (x>-count){
				moveX(delta);
			}
			bool=1;
		}
	}

	@Override
	public int getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}