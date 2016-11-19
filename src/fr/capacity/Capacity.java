package fr.capacity;

import org.newdawn.slick.Image;

public class Capacity {
	
	private long duration;
	private Image img;
	private String name;
	private String effectDescription;
	private boolean second;    // true si la capacite est limitee en temps  false si la capacite est limitée en nombre

	public Capacity(String typeCapacity){
		if (typeCapacity=="couteau"){
			this.duration=5;
			//this.image=...;
			this.name="couteau";
			this.effectDescription="s'arme d'un couteau et peut tuer les gardes";
			this.second=false;
		}
		if (typeCapacity=="pistolet"){
			this.duration=5;
			//this.image=...;
			this.name="pistolet";
			this.effectDescription="s'arme d'un pistolet et peut lancé des projectiles";
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
			//this.image=...;
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
	
}
