package fr.capacity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Capacity2 {

	private long duration;
	private String name;
	private String effectDescription;
	private boolean second;    // true si la capacite est limitee en temps  false si la capacite est limit�e en nombre
	private Image image;

	public Capacity2(String typeCapacity) throws SlickException{
		if (typeCapacity=="couteau"){
			this.duration=5;
			this.image=new Image("images/bonuses/knife.png");
			this.name="couteau";
			this.effectDescription="s'arme d'un couteau et peut tuer les gardes";
			this.second=false;
		}
		if (typeCapacity=="pistolet"){
			this.duration=5;
			this.image=new Image("images/bonuses/gun.png");
			this.name="pistolet";
			this.effectDescription="s'arme d'un pistolet et peut lancer des projectiles";
			this.second=false;
		}
		if (typeCapacity=="clef"){
			this.duration=5;
			//this.image=...;
			this.name="clef";
			this.effectDescription="s'equipe d'une clef, peut ouvrir une porte";
			this.second=false;
		}
		if (typeCapacity=="caillou"){
			this.duration=5;
			//this.image=...;
			this.name="caillou";
			this.effectDescription="s'arme d'un caillou et peut provoquer du bruit en le lancant";
			this.second=false;
		}
		if (typeCapacity=="radar"){
			this.duration=5;
			this.image=new Image("images/bonuses/radar.png");
			this.name="couteau";
			this.effectDescription="s'equipe d'un radar qui detecte tout les characters pendant un certain temps";
			this.second=true;
		}
		else {
			this.duration=5;
			//this.image=...;
			this.name="";
			this.effectDescription="";
			this.second=false;
		}
	}

	public void action(){

	}

	public Image getImage() {
		return image;
	}

}
