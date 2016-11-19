package entity.wall;

import org.newdawn.slick.Image;

import entity.Entity;

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
	
	
	
}
