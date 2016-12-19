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
	// private boolean upPress, downPress, rightPress, leftPress, droitegauche,
	// hautbas;
	private boolean pad1, pad2, pad3, pad4, pad6, pad7, pad8, pad9,leftright,downup;
	private int a;
	private Player circleTest;
	private double vitTot;

	public Player(float centerPointX, float centerPointY, float radius) throws SlickException {
		super(centerPointX, centerPointY, radius);
		this.capacities = new ArrayList<Capacity2>();
		inventory = new Image("images/inventory.png");
	}

	// --------------------------Get-------------------

	public ArrayList<Capacity2> getcapacities() {
		return capacities;
	}

	// -------------------------Set--------------------

	public void setcapacities(ArrayList<Capacity2> capacities) {
		this.capacities = capacities;
	}

	public void addCapacity(Capacity2 capacity) {
		if (capacities.size() < 6) {
			capacities.add(capacity);
		} else {
			System.out.println("Desole mais la 7eme capacite est pour T7 !");
		}
	}

	public void deleteCapacity(Capacity2 capacity) {
		int i = 0;
		boolean done = false;
		while (i < capacities.size() || !done) {
			if (capacities.get(i).equals(capacity)) {
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
		arg2.drawString("a= " + a, 500, 600);
		arg2.drawImage(inventory, 0, 100);
		for (int i = 0; i < capacities.size(); i++) {
			arg2.drawImage(capacities.get(i).getImage().getScaledCopy(2), 10, 110 + 50 * i);
		}
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		move(arg2);
	}

	// Deplacements *****************************************************

	private void move(int delta) throws SlickException {
		horizontalMove();
		verticalMove();
		this.vitTot = Math.sqrt(speedX * speedX + speedY * speedY);
		if (vitTot > 0) {
			speedX = (float) (speedX / vitTot * 0.4);
			speedY = (float) (speedY / vitTot * 0.4);
		}

		this.newX = x + speedX * delta;
		this.newY = y + speedY * delta;
		moveX(delta);
		moveY(delta);
		// circleTest=new Player(newX,newY,radius);
		for (Wall w : fr.basic.World.getWalls()) {
			a = fr.util.Collisions.col(this, w);
			switch (a) {
			case 1:
				this.x = w.getMinX() - this.getWidth();
				speedX = 0;
				break;
			case 2:
				this.y = w.getMinY() - this.getHeight();
				this.speedY = 0;
				break;
			case 3:
				this.x = w.getMaxX();
				this.speedX = 0;
				break;
			case 4:
				this.speedY = 0;
				this.y = w.getMaxY();
				break;
			}

		}

	}

	private void horizontalMove() {
		speedX = 0;
		if (((pad1 || pad4 || pad7) && !(pad3 || pad9 || pad6))||((pad1 || pad4 || pad7) && (pad3 || pad9 || pad6)) && !leftright) {
			speedX = (float) -0.4;

		}
		if(((pad3 || pad9 || pad6) &&!(pad1 || pad4 || pad7)) || ((pad1 || pad4 || pad7) && (pad3 || pad9 || pad6)) && leftright){
			speedX = (float) 0.4;
		}
	}

	private void verticalMove() {
		speedY = 0;
		if (((pad7 || pad8 || pad9) && !((pad1 || pad2 || pad3)))||((pad7 || pad8 || pad9) && (pad1 || pad2 || pad3)) && !downup) {
			speedY = (float) -0.4;

		}
		if ((!(pad7 || pad8 || pad9) &&(pad1 || pad2 || pad3))||((pad7 || pad8 || pad9) && (pad1 || pad2 || pad3)) && downup) {
			speedY = (float) 0.4;
		}
	}

	public void keyReleased(int key, char c) {
		switch (key) {
		case Input.KEY_NUMPAD1:
			pad1 = false;
			downup=true;
			leftright=false;
			break;
		case Input.KEY_NUMPAD2:
			pad2 = false;
			downup=true;
			break;
		case Input.KEY_NUMPAD3:
			pad3 = false;
			downup=true;
			leftright=true;
			break;
		case Input.KEY_NUMPAD4:
			pad4 = false;
			leftright=false;
			break;
		case Input.KEY_NUMPAD6:
			pad6 = false;
			leftright=true;
			break;
		case Input.KEY_NUMPAD7:
			leftright=false;
			downup=false;
			pad7 = false;
			break;
		case Input.KEY_NUMPAD8:
			downup=false;
			pad8 = false;
			break;
		case Input.KEY_NUMPAD9:
			pad9 = false;
			downup=false;
			leftright=true;
			break;

		}

	}

	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_A:
			if (capacities.size() > 0) {
				capacities.get(0).action();
			}
			break;
		case Input.KEY_Z:
			if (capacities.size() > 1) {
				capacities.get(1).action();
			}
			break;
		case Input.KEY_E:
			if (capacities.size() > 2) {
				capacities.get(2).action();
			}
			break;
		case Input.KEY_Q:
			if (capacities.size() > 3) {
				capacities.get(3).action();
			}
			break;
		case Input.KEY_S:
			if (capacities.size() > 4) {
				capacities.get(4).action();
			}
			break;
		case Input.KEY_D:
			if (capacities.size() > 5) {
				capacities.get(5).action();
			}
			break;
		case Input.KEY_NUMPAD1:
			pad1 = true;
			break;
		case Input.KEY_NUMPAD2:
			pad2 = true;
			break;
		case Input.KEY_NUMPAD3:
			pad3 = true;
			break;
		case Input.KEY_NUMPAD4:
			pad4 = true;
			break;
		case Input.KEY_NUMPAD6:
			pad6 = true;
			break;
		case Input.KEY_NUMPAD7:
			pad7 = true;
			break;
		case Input.KEY_NUMPAD8:
			pad8 = true;
			break;
		case Input.KEY_NUMPAD9:
			pad9 = true;
			break;
		}
	}

}
