package entity.movable;

import org.newdawn.slick.Image;

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
	
	

}
