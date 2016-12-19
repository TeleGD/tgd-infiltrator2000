package fr.circles;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.StateBasedGame;

import fr.capacity.Capacity2;
import fr.rectangles.Wall;

public class Player extends Character {

	protected ArrayList<Capacity2> capacities;
	protected ArrayList<Wall> walls;
	protected double speed = 0.25;
	private Image inventory;
	private boolean upPress, downPress, rightPress, leftPress, droitegauche, hautbas;
	private int a;
	private Player circleTest;
	
	public Player(float centerPointX, float centerPointY, float radius) throws SlickException {
		super(centerPointX, centerPointY, radius);
		this.capacities=new ArrayList<Capacity2>();
		inventory = new Image("images/inventory.png");
	}

	//--------------------------Get-------------------
	
	public ArrayList<Capacity2> getcapacities() {
		return capacities;
	}

	//-------------------------Set--------------------
	
	public void setcapacities(ArrayList<Capacity2> capacities) {
		this.capacities = capacities;
	}
	
	public void addCapacity(Capacity2 capacity){
		if ( capacities.size() < 6 ){
			capacities.add(capacity);
		} else {
			System.out.println("Desole mais la 7eme capacite est pour T7 !");
		}
	}
	
	public  void deleteCapacity(Capacity2 capacity){
		int i = 0;
		boolean done = false;
		while (i < capacities.size() || !done ){
			if ( capacities.get(i).equals(capacity) ) {
				capacities.remove(i);
				done = true;
			} else {
				i++;
			}
		}
	}
		
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		arg2.setColor(Color.red);
		arg2.fill(new Circle(x + radius, y + radius, radius));
		arg2.drawString("x= " + x, 500, 500);
		arg2.drawString("y= " + y, 500, 550);
		arg2.drawString("a= "+a, 500, 600);
		arg2.drawImage(inventory, 0, 100);
		for (int i=0;i<capacities.size();i++){
			arg2.drawImage(capacities.get(i).getImage().getScaledCopy(2), 10, 110+50*i);
		}
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		move(arg2);
	}
	
	
	// Deplacements *****************************************************

		private void move(int delta) throws SlickException {
			horizontalMove();
			verticalMove();
			this.newX=x+speedX*delta;
			this.newY=y+speedY*delta;
			moveX(delta);
			moveY(delta);
			//circleTest=new Player(newX,newY,radius);
			for (Wall w : fr.basic.World.getWalls()) {
				a=fr.util.Collisions.col(this, w);
				switch (a) {
				case 1:
					this.x=w.getMinX()-this.getWidth();
					speedX=0;
					break;
				case 2:
					this.y=w.getMinY()-this.getHeight();
					this.speedY=0;
					break;
				case 3:
					this.x=w.getMaxX();
					this.speedX=0;
					break;
				case 4:
					this.speedY=0;
					this.y=w.getMaxY();
					break;
				}
				
				
			}
			
		}

		private void horizontalMove() {
			speedX = 0;
			if ((leftPress && !rightPress) || (leftPress && rightPress && !droitegauche)) {
				speedX = (float) -0.2;

			}
			if ((!leftPress && rightPress) || (leftPress && rightPress && droitegauche)) {
				speedX = (float) 0.2;
			}
		}

		private void verticalMove() {
			speedY = 0;
			if ((upPress && !downPress) || (upPress && downPress && !hautbas)) {
				speedY = (float) -0.2;

			}
			if ((!upPress && downPress) || (upPress && downPress && hautbas)) {
				speedY = (float) 0.2;
			}
		}
	
	
	public void keyReleased(int key, char c) {
		switch (key) {
		case Input.KEY_NUMPAD1:
			leftPress = false;
			downPress = false;
			break;
		case Input.KEY_NUMPAD2:
			downPress = false;
			break;
		case Input.KEY_NUMPAD3:
			rightPress = false;
			downPress = false;
			break;
		case Input.KEY_NUMPAD4:
			leftPress = false;
			break;
		case Input.KEY_NUMPAD6:
			rightPress = false;
			break;
		case Input.KEY_NUMPAD7:
			leftPress = false;
			upPress = false;
			break;
		case Input.KEY_NUMPAD8:
			upPress = false;
			break;
		case Input.KEY_NUMPAD9:
			upPress = false;
			rightPress = false;
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
			leftPress = true;
			downPress = true;
			droitegauche = true;
			hautbas = true;
			break;
		case Input.KEY_NUMPAD2:
			downPress = true;
			hautbas = true;
			break;
		case Input.KEY_NUMPAD3:
			rightPress = true;
			downPress = true;
			droitegauche = true;
			hautbas = true;
			break;
		case Input.KEY_NUMPAD4:
			leftPress = true;
			droitegauche = true;
			break;
		case Input.KEY_NUMPAD6:
			rightPress = true;
			droitegauche = true;
			break;
		case Input.KEY_NUMPAD7:
			upPress = true;
			leftPress = true;
			droitegauche = true;
			hautbas = true;
			break;
		case Input.KEY_NUMPAD8:
			upPress = true;
			hautbas = true;
			break;
		case Input.KEY_NUMPAD9:
			rightPress = true;
			upPress = true;
			droitegauche = true;
			hautbas = true;
			break;
		}
	}
	


}
