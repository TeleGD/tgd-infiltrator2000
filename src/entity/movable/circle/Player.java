package entity.movable.circle;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.rectangle.EntityRectangle;
import entity.rectangle.Wall;
import fr.basic.World;
import fr.capacity.Capacity;
import fr.util.Collisions;

public class Player extends Character {

	protected ArrayList<Capacity> inventaire;
	protected ArrayList<Wall> walls;
	protected double speed = 0.25;
	protected boolean left,right,up,down,collision;
	protected double newX,newY;
	
	public Player(double x, double y, double sx, double sy, double radius,double view, Image im, ArrayList<Capacity> inv, World world) {
		super(x, y, sx, sy, radius,view, im,world);
		this.inventaire=inv;
	}

	//--------------------------Get-------------------
	
	public ArrayList<Capacity> getInventaire() {
		return inventaire;
	}

	//-------------------------Set--------------------
	
	public void setInventaire(ArrayList<Capacity> inventaire) {
		this.inventaire = inventaire;
	}
	
	public void addCapacity(Capacity capacity){
		if ( inventaire.size() < 6 ){
			inventaire.add(capacity);
		} else {
			System.out.println("Desole mais la 7eme capacite est pour T7 !");
		}
	}
	
	@Override
	public double getOrientation(){
		if ( left ) return 180;
		if ( right ) return 0;
		if ( up ) return 90;
		if ( down ) return 270;
		return 0;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		super.update(arg1, arg2, arg3);
		this.walls = this.getWorld().getWalls();
		for ( Wall w : walls ){
			collision = Collisions.isCollision((MovableCircle)this,(EntityRectangle)w);
		}
		if ( !collision ){
			this.moveX(arg3);
			this.moveY(arg3);
		} else {
			if ( up ){
				this.setSpeedY(speed);
				this.moveY(arg3);
				this.setSpeedY(0);
			}
			if ( down ){
				this.setSpeedY(-speed);
				this.moveY(arg3);
				this.setSpeedY(0);
			}
			if ( left ){
				this.setSpeedX(speed);
				this.moveX(arg3);
				this.setSpeedX(0);
			}
			if ( right ){
				this.setSpeedX(-speed);
				this.moveX(arg3);
				this.setSpeedX(0);
			}
			collision = false;
		}
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		
		arg3.setColor(Color.cyan);
		arg3.fillOval((float)(this.x-radius), (float)(this.y-radius), (float)(2*radius), (float)(2*radius));
		super.render(arg1, arg2, arg3);
	}
	
	public void keyReleased(int key, char c) {
		switch (key) {
		case Input.KEY_NUMPAD1:
			this.setSpeedX(0);
			this.setSpeedY(0);
			break;
		case Input.KEY_NUMPAD2:
			this.setSpeedY(0);
			break;
		case Input.KEY_NUMPAD3:
			this.setSpeedX(0);
			this.setSpeedY(0);
			break;
		case Input.KEY_NUMPAD4:
			this.setSpeedX(0);
			break;
		case Input.KEY_NUMPAD6:
			this.setSpeedX(0);
			break;
		case Input.KEY_NUMPAD7:
			this.setSpeedX(0);
			this.setSpeedY(0);
			break;
		case Input.KEY_NUMPAD8:
			this.setSpeedY(0);
			break;
		case Input.KEY_NUMPAD9:
			this.setSpeedX(0);
			this.setSpeedY(0);
			break;
		case Input.KEY_DOWN:
			this.setSpeedY(0);
			break;
		case Input.KEY_UP:
			this.setSpeedY(0);
			break;
		case Input.KEY_LEFT:
			this.setSpeedX(0);
			break;
		case Input.KEY_RIGHT:
			this.setSpeedX(0);
			break;
		}
		
	}
	
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_A:
			if ( inventaire.size() > 0 ){
				inventaire.get(0).action();
			}
			break;
		case Input.KEY_Z:
			if ( inventaire.size() > 1 ){
				inventaire.get(1).action();
			}
			break;
		case Input.KEY_E:
			if ( inventaire.size() > 2 ){
				inventaire.get(2).action();
			}
			break;
		case Input.KEY_Q:
			if ( inventaire.size() > 3 ){
				inventaire.get(3).action();
			}
			break;
		case Input.KEY_S:
			if ( inventaire.size() > 4 ){
				inventaire.get(4).action();
			}
			break;
		case Input.KEY_D:
			if ( inventaire.size() > 5 ){
				inventaire.get(5).action();
			}
			break;
		case Input.KEY_NUMPAD1:
			this.setSpeedX(-speed);
			this.setSpeedY(speed);
			break;
		case Input.KEY_NUMPAD2:
			this.setSpeedY(speed);
			break;
		case Input.KEY_NUMPAD3:
			this.setSpeedX(speed);
			this.setSpeedY(speed);
			break;
		case Input.KEY_NUMPAD4:
			this.setSpeedX(-speed);
			break;
		case Input.KEY_NUMPAD6:
			this.setSpeedX(speed);
			break;
		case Input.KEY_NUMPAD7:
			this.setSpeedX(-speed);
			this.setSpeedY(-speed);
			break;
		case Input.KEY_NUMPAD8:
			this.setSpeedY(-speed);
			break;
		case Input.KEY_NUMPAD9:
			this.setSpeedX(speed);
			this.setSpeedY(-speed);
			break;
		case Input.KEY_DOWN:
			this.setSpeedY(speed);
			down = true;
			left = false;
			up = false;
			right = false;
			break;
		case Input.KEY_UP:
			this.setSpeedY(-speed);
			up = true;
			down = false;
			right = false;
			left = false;
			break;
		case Input.KEY_LEFT:
			this.setSpeedX(-speed);
			left = true;
			right = false;
			down = false;
			up =false;
			break;
		case Input.KEY_RIGHT:
			this.setSpeedX(speed);
			right = true;
			left = false;
			up = false;
			down = false;
			break;
		}
	}
	


}
