package entity.wall;

import org.newdawn.slick.Image;

import entity.Entity;
import fr.interfaces.Rectangle;

public class Wall extends Entity implements Rectangle {

	protected Image img;

	public Wall(double x, double y, Image img) {
		super(x, y);
		this.img = img;
	}

	//----------------------------Get---------------
	
	public Image getImg() {
		return img;
	}

	//----------------------------Set---------------
	
	public void setImg(Image img) {
		this.img = img;
	}

	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
