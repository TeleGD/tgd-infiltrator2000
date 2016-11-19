package entity.movable.circle;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.World;
import fr.capacity.Capacity;

public class Player extends Character {

	protected ArrayList<Capacity> inventaire;
	
	public Player(double x, double y, double sx, double sy, Image im, ArrayList<Capacity> inv, World world) {
		super(x, y, sx, sy, im,world);
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
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		this.moveX(arg3);
		this.moveY(arg3);
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		arg3.setColor(Color.cyan);
		arg3.fillRect((float)this.x, (float)this.y, 32, 32);
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
			this.setSpeedX(-0.5);
			this.setSpeedY(0.5);
			break;
		case Input.KEY_NUMPAD2:
			this.setSpeedY(0.5);
			break;
		case Input.KEY_NUMPAD3:
			this.setSpeedX(0.5);
			this.setSpeedY(0.5);
			break;
		case Input.KEY_NUMPAD4:
			this.setSpeedX(-0.5);
			break;
		case Input.KEY_NUMPAD6:
			this.setSpeedX(0.5);
			break;
		case Input.KEY_NUMPAD7:
			this.setSpeedX(-0.5);
			this.setSpeedY(-0.5);
			break;
		case Input.KEY_NUMPAD8:
			this.setSpeedY(-0.5);
			break;
		case Input.KEY_NUMPAD9:
			this.setSpeedX(0.5);
			this.setSpeedY(-0.5);
			break;
		}
	}
	


}
