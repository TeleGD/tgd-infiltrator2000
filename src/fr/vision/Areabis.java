package fr.vision;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.StateBasedGame;
import entity.movable.circle.Character;
import entity.rectangle.Wall;

public class Areabis extends Polygon {

	private double a1, b1, a2, b2; // sens trigo a1,b1 en avance sur a2,b2
	private Character character;
	private double x, y, x1, x2;
	private double c;
	private ArrayList<Double> l;
	private boolean pris, stop;

	public Areabis(Character character) {
		this.character = character;
		this.a1=Math.cos(Math.PI/3);
		this.a2=Math.cos(Math.PI/3);
		this.b1=Math.sin(Math.PI/3);
		this.b2=-Math.sin(Math.PI/3);
		
		this.x = character.getX();
		this.y = character.getY();
		chooseDir();
		normalize(a1, b1);
		normalize(a2, b2);

		
		this.addPoint((float)x,(float)y);
		for (int j = 0; j < 2; j++) {
			this.x = character.getX();
			this.y = character.getY();

			stop = false;
			while (!stop) {
				this.x += a1 + (a2 - a1)/2 * j;
				this.y += b1 + (b2 - b1)/2 * j;
				l = new ArrayList<Double>();
				l.add(x);
				l.add(y);
				stop=true;
				/*for (Wall w : fr.basic.World.getWalls()) {
					stop=w.isInside(x,y);
				}*/
			}
			pris = true;
			for (int i = 0; i < this.getPoints().length - 1; i++) {
				if ((float) x == this.getPoints()[i]) {
					if ((float) y == this.getPoints()[i + 1]) {
						pris = false;
					}
				}
				if (pris) {
					this.addPoint((float) x, (float) y);
				}
			}
		}
	}

	public Areabis(double x, double y, Character character) {
		this.character = character;
		this.x = x;
		this.y = y;
		this.a1 = character.getRadius() * Math.cos(Math.PI / 6);
		this.a2 = a1;
		this.b1 = character.getRadius() * Math.sin(Math.PI / 6);
		this.b2 = -character.getRadius() * Math.sin(Math.PI / 6);
	}

	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		arg3.setColor(Color.red);
		arg3.drawLine((float) character.getX(), (float) character.getY(), (float) (character.getX() + a1),
				(float) (character.getY() + b1));
		arg3.drawLine((float) character.getX(), (float) character.getY(), (float) (character.getX() + a2),
				(float) (character.getY() + b2));
	}

	public void chooseDir() {
		switch (this.character.getDirection()) {
		case 0:
			a1 = 100;
			a2 = a1;
			b1 = -Math.tan(Math.PI / 6) * 100;
			b2 = Math.tan(Math.PI / 6) * 100;
			break;
		case 1:
			a1 = 100 * Math.cos(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			b1 = 100 * Math.sin(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			a2 = 100 * Math.cos(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			b2 = 100 * Math.sin(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			break;
		case 2:
			a1 = Math.tan(Math.PI / 6) * 100;
			b1 = 100;
			a2 = -Math.tan(Math.PI / 6) * 100;
			b2 = 100;
			break;
		case 3:
			a1 = -100 * Math.cos(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			b1 = 100 * Math.sin(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			a2 = -100 * Math.cos(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			b2 = 100 * Math.sin(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			break;
		case 4:
			a1 = -100;
			a2 = a1;
			b1 = Math.tan(Math.PI / 6) * 100;
			b2 = -Math.tan(Math.PI / 6) * 100;
			break;
		case 5:
			a1 = -100 * Math.cos(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			b1 = -100 * Math.sin(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			a2 = -100 * Math.cos(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			b2 = -100 * Math.sin(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			break;
		case 6:
			a1 = -Math.tan(Math.PI / 6) * 100;
			b1 = -100;
			a2 = Math.tan(Math.PI / 6) * 100;
			b2 = -100;
			break;
		case 7:
			a1 = 100 * Math.cos(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			b1 = -100 * Math.sin(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			a2 = 100 * Math.cos(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			b2 = -100 * Math.sin(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			break;
		}

	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException {

		
	}

	public void normalize(double a, double b) {
		c = Math.sqrt(a * a + b * b);
		a = a / c;
		b = b / c;
	}
}
