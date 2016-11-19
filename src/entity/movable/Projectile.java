package entity.movable;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Projectile extends Movable {

	protected Image img;
	
	public Projectile(double x, double y, double sx, double sy, Image im) {
		super(x, y, sx, sy);
		this.img=im;
	}

	//--------------------------Get-----------------
	
	public Image getImg() {
		return img;
	}

	//--------------------------Set-----------------
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}
	
	

}
