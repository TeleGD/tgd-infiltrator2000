package entity.movable.circle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.movable.Movable;
import fr.basic.World;
import fr.interfaces.Circle;

public abstract class Character extends MovableCircle{

	protected Image img;
	protected World world; 
	protected double radius;
	protected double view;
	
	public Character(double x, double y, double sx, double sy, double radius, double view,Image im,World world) {
		super(x, y, sx, sy);
		this.img=im;
		this.world=world;
		this.radius = radius;
		this.view = view;
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
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
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
	
}
