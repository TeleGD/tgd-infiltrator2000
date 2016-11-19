package entity.movable.circle;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import fr.capacity.Capacity;

public class Player extends Character {

	protected ArrayList<Capacity> inventaire;
	private boolean upPress, leftPress, rightPress, droitegauche, downPress;
	private boolean capa1Press, capa2Press, capa3Press, capa4Press, capa5Press, capa6Press;
	
	public Player(double x, double y, double sx, double sy, Image im, ArrayList<Capacity> inv) {
		super(x, y, sx, sy, im);
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
			System.out.println("Désolé mais la 7ème capacité est pour T7 !");
		}
	}
	
	public void keyReleased(int key, char c) {
		switch (key) {
		case Input.KEY_A:
			capa1Press = false;
			break;
		case Input.KEY_Z:
			capa2Press = false;
			break;
		case Input.KEY_E:
			capa3Press = false;
			break;
		case Input.KEY_Q:
			capa4Press = false;
			break;
		case Input.KEY_S:
			capa5Press = false;
			break;
		case Input.KEY_D:
			capa6Press = false;
			break;
		}
		
	}
	
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_A:
			capa1Press = true;
			if ( inventaire.size() > 0 ){
				inventaire.get(0).action();
			}
			break;
		case Input.KEY_Z:
			capa2Press = true;
			if ( inventaire.size() > 1 ){
				inventaire.get(1).action();
			}
			break;
		case Input.KEY_E:
			capa3Press = true;
			if ( inventaire.size() > 2 ){
				inventaire.get(2).action();
			}
			break;
		case Input.KEY_Q:
			capa4Press = true;
			if ( inventaire.size() > 3 ){
				inventaire.get(3).action();
			}
			break;
		case Input.KEY_S:
			capa5Press = true;
			if ( inventaire.size() > 4 ){
				inventaire.get(4).action();
			}
			break;
		case Input.KEY_D:
			capa6Press = true;
			if ( inventaire.size() > 5 ){
				inventaire.get(5).action();
			}
			break;
		}
	}
	


}
