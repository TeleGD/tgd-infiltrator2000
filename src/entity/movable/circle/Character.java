package entity.movable.circle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.movable.Movable;
import fr.basic.World;
import fr.interfaces.Circle;
import fr.vision.Areabis;

public abstract class Character extends MovableCircle{

	protected Image img;
	protected World world; 
	protected double view;
	//-------------------------
	protected Areabis area;
	
	
	public Character(double x, double y, double sx, double sy, double radius, double view,Image im,World world) {
		super(x, y, sx, sy);
		this.img=im;
		this.world=world;
		this.radius = radius;
		this.view = view;
		this.radius = radius;
		area= new Areabis(this);
	}


	//-----------------------------Get----------------
	
	public Image getImg() {
		return img;
	}

	//-----------------------------Set----------------
	
	public void setImg(Image img) {
		this.img = img;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		area.update(arg1, arg2, arg3);
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		area.render(arg1, arg2, arg3);
	}
	
	public World getWorld(){
		return this.world;
	}
	
	public double getFieldOfView(){
		return this.view;
	}
	
	public double getOrientation(){
		return 0;
	}

	//-------------------------test de nuit. Nico------------
	public int getDirection(){
		if ((this.speedX>0)&&(this.speedY==0)){
			return 0;
		}
		if  ((this.speedX>0)&&(this.speedY>0)){
			return 1;
		}
		if  ((this.speedX==0)&&(this.speedY>0)){
			return 2;
		}
		if  ((this.speedX<0)&&(this.speedY>0)){
			return 3;
		}
		if  ((this.speedX<0)&&(this.speedY==0)){
			return 4;
		}
		if  ((this.speedX<0)&&(this.speedY<0)){
			return 5;
		}
		if  ((this.speedX==0)&&(this.speedY<0)){
			return 6;
		}
		if  ((this.speedX>0)&&(this.speedY<0)){
			return 7;
		}else { return -1;}
	}
	
	
}
