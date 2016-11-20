package entity.movable.circle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.World;
import fr.vision.Areabis;

public class GuardVer extends Guard{
	public GuardVer(double x, double y, double sx, double sy, double radius, double view, /*Image im,*/ Areabis visuFie, World world) {
		super(x, y, sx, sy,radius,view, null, world);
		this.speedX=0;
		this.visualField=visuFie;
	}
	public void verticalMove(){
		if (this.y<=100){
			this.speedY=0.4;
		}
		if (this.y>=200){
			this.speedY=-0.4;
		}
	}
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		super.update(arg1, arg2, arg3);
		verticalMove();
		moveY(arg3);
	}
	
	public Areabis getVisualField() {
		return visualField;
	}

	//------------------------------Set--------------
	
	public void setVisualField(Areabis visualField) {
		this.visualField = visualField;
	}
	
	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		super.render(arg1, arg2, arg3);
		arg3.setColor(Color.magenta);
		arg3.fillOval((float)(this.x-radius), (float)(y-radius), (float)(2*radius), (float)(2*radius));
	}
}