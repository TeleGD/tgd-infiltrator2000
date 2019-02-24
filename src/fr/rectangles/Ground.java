package fr.rectangles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Ground extends Rectangle{
	protected Image img;

	public Ground(float x, float y, int width, int height) throws SlickException {
		super(x, y, 32*width, 32*height);
		this.img = new Image("images/floor.png");
	}


	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		for(int i=0;i< this.height/32; i++){
			for (int j = 0;j< this.width/32;j++){
				arg3.drawImage(img,x+ j*32,y+32*i);
			}
		}

	}
}
