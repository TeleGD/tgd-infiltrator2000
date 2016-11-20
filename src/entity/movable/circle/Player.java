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

	protected ArrayList<Capacity> capacities;
	protected ArrayList<Wall> walls;
	protected double speed = 0.25;
	protected boolean left,right,up,down,collision;
	protected double newX,newY;
	private Image inventory;
	
	public Player(double x, double y, double sx, double sy, double radius,double view, World world) throws SlickException {
		super(x, y, sx, sy, radius,view,world);
		this.capacities=new ArrayList<Capacity>();
		inventory = new Image("images/inventory.png");
	}

	//--------------------------Get-------------------
	
	public ArrayList<Capacity> getcapacities() {
		return capacities;
	}

	//-------------------------Set--------------------
	
	public void setcapacities(ArrayList<Capacity> capacities) {
		this.capacities = capacities;
	}
	
	public void addCapacity(Capacity capacity){
		if ( capacities.size() < 6 ){
			capacities.add(capacity);
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
			if ( this.getSpeedX() != 0 && this.getSpeedY() == 0 ){
				this.setX(this.getX()+this.getSpeedX());
				collision = collision || Collisions.isCollision((MovableCircle)this,(EntityRectangle)w);
			} else if ( this.getSpeedX() == 0 && this.getSpeedY() != 0 ){
				this.setY(this.getY()+this.getSpeedY());
				collision = collision || Collisions.isCollision((MovableCircle)this,(EntityRectangle)w);
			} else if ( this.getSpeedX() != 0 && this.getSpeedY() != 0 ){
				this.setY(this.getY()+this.getSpeedY());
				this.setX(this.getX()+this.getSpeedX());
				collision = collision || Collisions.isCollision((MovableCircle)this,(EntityRectangle)w);
			} 
		}
		if ( !collision ){
			this.moveX(arg3);
			this.moveY(arg3);
		} else {
			if ( this.getSpeedX() != 0 && this.getSpeedY() == 0 ){
				while ( collision ){
					collision = false;
					this.setX(this.getX()-this.getSpeedX());
					for ( Wall w : walls ){
						collision =collision || Collisions.isCollision((MovableCircle)this,(EntityRectangle)w);
					}
				}
			} else if ( this.getSpeedX() == 0 && this.getSpeedY() != 0 ){
				while ( collision ){
					collision = false;
					this.setY(this.getY()-this.getSpeedY());
					for ( Wall w : walls ){
						collision =collision || Collisions.isCollision((MovableCircle)this,(EntityRectangle)w);
					}
				}
			} else if ( this.getSpeedX() != 0 && this.getSpeedY() != 0 ){
				while ( collision ){
					collision = false;
					this.setX(this.getX()-this.getSpeedX());
					this.setY(this.getY()-this.getSpeedY());
					for ( Wall w : walls ){
						collision =collision || Collisions.isCollision((MovableCircle)this,(EntityRectangle)w);
					}
				}
			}
		}
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		
		arg3.setColor(Color.cyan);
		arg3.fillOval((float)(this.x-radius), (float)(this.y-radius), (float)(2*radius), (float)(2*radius));
		super.render(arg1, arg2, arg3);
		arg3.drawImage(inventory, 0, 100);
		for (int i=0;i<capacities.size();i++){
			arg3.drawImage(capacities.get(i).getImage().getScaledCopy(2), 10, 110+50*i);
		}
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
			if ( capacities.size() > 0 ){
				capacities.get(0).action();
			}
			break;
		case Input.KEY_Z:
			if ( capacities.size() > 1 ){
				capacities.get(1).action();
			}
			break;
		case Input.KEY_E:
			if ( capacities.size() > 2 ){
				capacities.get(2).action();
			}
			break;
		case Input.KEY_Q:
			if ( capacities.size() > 3 ){
				capacities.get(3).action();
			}
			break;
		case Input.KEY_S:
			if ( capacities.size() > 4 ){
				capacities.get(4).action();
			}
			break;
		case Input.KEY_D:
			if ( capacities.size() > 5 ){
				capacities.get(5).action();
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
