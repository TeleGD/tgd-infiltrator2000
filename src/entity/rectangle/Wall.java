package entity.rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import fr.interfaces.Rectangle;

public abstract class Wall extends EntityRectangle {

	public Wall(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	protected Image img,img2;

	
	
	

	//----------------------------Get---------------
	
	public Image getImg() {
		return img;
	}

	//----------------------------Set---------------
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		arg3.setColor(Color.red);
		arg3.fillRect((float)x, (float)y, (float)width, (float)height);
	}
	
	public boolean isInside(double x,double y){
		if(x>=this.x+this.width) return false;
		if(x<=this.x) return false;
		if(y>=this.y+this.height) return false;
		if(y<=this.y) return false;
		return true;
		
	}
}
