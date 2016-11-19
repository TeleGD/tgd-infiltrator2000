package entity.wall;

import org.newdawn.slick.Image;

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
	
	
}
