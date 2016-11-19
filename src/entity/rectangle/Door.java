package entity.rectangle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Door extends Wall {

	protected boolean open;

	public Door(double x, double y, Image img, boolean open) {
		super(x, y, img);
		this.open = open;
	}

	//-----------------------------Get--------------
	public boolean isOpen() {
		return open;
	}

	//----------------------------Set---------------
	public void setOpen(boolean open) {
		this.open = open;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}
}
