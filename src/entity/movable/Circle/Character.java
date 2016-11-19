package entity.movable.Circle;

import org.newdawn.slick.Image;

import entity.movable.Movable;
import fr.interfaces.Circle;

public abstract class Character extends MovableCircle{

	protected Image img;
	
	public Character(double x, double y, double sx, double sy,Image im) {
		super(x, y, sx, sy);
		this.img=im;
	}


	//-----------------------------Get----------------
	
	public Image getImg() {
		return img;
	}

	//-----------------------------Set----------------
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	
	
}
