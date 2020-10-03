package games.guardSlalom.rectangles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class Door extends Wall {

	protected boolean open;

	public Door(float x, float y, boolean open) {
		super(x, y, (float) 0.0, (float) 0.0);
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

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3)  {

	}

	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3){

	}
}
