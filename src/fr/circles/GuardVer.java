package fr.circles;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.World;

public class GuardVer extends Guard{
	public GuardVer(float x, float y, float radius) {
		super(x, y, radius);
		this.speedX=0;
		//this.visualField=visuFie;
	}
	public void verticalMove(){
		if (this.y<=100){
			this.speedY=(float) 0.4;
		}
		if (this.y>=200){
			this.speedY=(float) -0.4;
		}
	}
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		super.update(arg1, arg2, arg3);
		verticalMove();
		moveY(arg3);
	}
	
	/*public Areabis getVisualField() {
		return visualField;
	}

	//------------------------------Set--------------
	
	public void setVisualField(Areabis visualField) {
		this.visualField = visualField;
	}*/
	
	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		super.render(arg1, arg2, arg3);
		arg3.setColor(Color.magenta);
		arg3.fill(this);
	}
}