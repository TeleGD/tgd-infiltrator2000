package entity.movable.circle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.World;
import fr.vision.Area;
import fr.vision.Areabis;

public class Guard extends Character {
	protected Areabis visualField;
	protected boolean enVie;
	
	public Guard(double x, double y, double sx, double sy, double radius, double view, /*Image im,*/ Areabis visuFie, World world) {
		super(x, y, sx, sy,radius,view, null);
		this.visualField=visuFie;
		this.enVie=true;
	}

	
	//------------------------------Get--------------
	
	public boolean isEnVie() {
		return enVie;
	}

	public Areabis getVisualField() {
		return visualField;
	}

	//------------------------------Set--------------
	
	public void setVisualField(Areabis visualField) {
		this.visualField = visualField;
	}
	
	public void setEnVie(boolean enVie) {
		this.enVie = enVie;
	}
	
	
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		super.update(arg1, arg2, arg3);
		horizontalMove();
		moveX(arg3);
	}
	
	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		super.render(arg1, arg2, arg3);
		arg3.setColor(Color.magenta);
		arg3.fillOval((float)(this.x-radius), (float)(y-radius), (float)(2*radius), (float)(2*radius));
	}
	
	public void horizontalMove(){
		if (this.x<=100){
			this.speedX=0.4;
		}
		if (this.x>=1000){
			this.speedX=-0.4;
		}
	}
	
	
	

	
}
