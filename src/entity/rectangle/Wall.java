package entity.rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import fr.interfaces.Rectangle;

public class Wall extends EntityRectangle {

	protected Image img,img2;

	/*public Wall(double x, double y, Image img) {
		super(x, y);
		this.img = img;
	}*/
	
	public Wall (double x, double y,int nbrTuilesX, int nbrTuilesY, Image tuileTop, Image tuile){
		super(x,y,(double)32*nbrTuilesX,(double)32*nbrTuilesY);
		this.img = tuileTop;
		this.img2=tuile;
	}

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
		/*arg3.setColor(Color.red);
		arg3.fillRect((float)x, (float)y, (float)width, (float)height);*/
		
		for(int i=0;i<width/32;i++){arg3.drawImage(img2, (float)x, (float)(y+height-32));}
		for (int i = 1;i<height/32-1;i++){arg3.drawImage(img2, (float)x, (float)(y+height-32));}
		
	}
}
