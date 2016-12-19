package fr.circles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.capacity.Capacity2;

public class CapacityItem extends Item {

	protected Capacity2 capacityGranted;

	public CapacityItem(float x, float y,float radius) {
		super(x, y,radius);
	}

	//-------------------------Get-----------------
	public Capacity2 getCapacityGranted() {
		return capacityGranted;
	}

	//-------------------------Set------------------
	public void setCapacityGranted(Capacity2 capacityGranted) {
		this.capacityGranted = capacityGranted;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}
	
}
