package entity.rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class LateralWall extends Wall{

	private int nbreTile;
		public LateralWall(double x,double y,int nbrTileLong, Image imgTop, Image imgLat){
		super(x,y,32*nbrTileLong,3*32);
		this.img=imgTop;
		this.img2=imgLat;
		this.nbreTile=nbrTileLong;
	}
		
		public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
			
		}
		
		public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
			arg3.setColor(Color.red);
			arg3.fillRect((float)x, (float)y, (float)width, (float)height);
			
			for (int i=0;i<nbreTile;i++){
				arg3.drawImage(img2,(float) (x+i*32), (float)(y+64));
				arg3.drawImage(img2,(float) (x+i*32), (float)(y+32));
				arg3.drawImage(img,(float) (x+i*32), (float)(y));
			}
			
		}

}
