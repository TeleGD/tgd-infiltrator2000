package fr.circles;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.World;
import fr.rectangles.Wall;

public class Guard extends Character {
	protected boolean destructed;
	protected double a1, a2, b1, b2,av; // used to generate visual field
	protected Polygon visualField;
	protected float[] newPoint;
	protected boolean stop;
	protected float a,b;
	protected float xOrigin,yOrigin;
	
	public Guard(float centerX, float centerY, float radius) {
		super(centerX, centerY, radius);
		this.xOrigin=centerX;
		this.yOrigin=centerY;
		this.destructed = false;
		this.visualField=new Polygon();
		visualField.addPoint(centerX, centerY);
		visualField.addPoint(centerX+5,centerY+5);
	}

	// ------------------------------Get--------------

	public boolean isDestructed() {
		return destructed;
	}


	public void setDestructed(boolean enVie) {
		this.destructed = !enVie;
	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException {
		this.updateVisualField();
	}

	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		arg3.setColor(Color.magenta);
		arg3.fillOval(x,y,2*radius,2*radius);
		arg3.setColor(Color.white);
		arg3.draw(visualField);
	}

	public void horizontalMove() {
		if (this.x <= 100) {
			this.speedX = (float) 0.4;
		}
		if (this.x >= 1000) {
			this.speedX = (float) -0.4;
		}
	}

	public void chooseDirVisualField() {
		switch (getDirection()) {
		case 0:
			a1 = radius;
			a2 = a1;
			b1 = -Math.tan(Math.PI / 6) * radius;
			b2 = Math.tan(Math.PI / 6) * radius;
			break;
		case 1:
			a1 = radius * Math.cos(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			b1 = radius * Math.sin(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			a2 = radius * Math.cos(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			b2 = radius * Math.sin(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			break;
		case 2:
			a1 = Math.tan(Math.PI / 6) * radius;
			b1 = radius;
			a2 = -Math.tan(Math.PI / 6) * radius;
			b2 = radius;
			break;
		case 3:
			a1 = -radius * Math.cos(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			b1 = radius * Math.sin(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			a2 = -radius * Math.cos(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			b2 = radius * Math.sin(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			break;
		case 4:
			a1 = -radius;
			a2 = a1;
			b1 = Math.tan(Math.PI / 6) * radius;
			b2 = -Math.tan(Math.PI / 6) * radius;
			break;
		case 5:
			a1 = -radius * Math.cos(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			b1 = -radius * Math.sin(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			a2 = -radius * Math.cos(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			b2 = -radius * Math.sin(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			break;
		case 6:
			a1 = -Math.tan(Math.PI / 6) * radius;
			b1 = -radius;
			a2 = Math.tan(Math.PI / 6) * radius;
			b2 = -radius;
			break;
		case 7:
			a1 = radius * Math.cos(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			b1 = -radius * Math.sin(Math.PI / 4 - Math.PI / 6) / Math.cos(Math.PI / 6);
			a2 = radius * Math.cos(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			b2 = -radius * Math.sin(Math.PI / 4 + Math.PI / 6) / Math.cos(Math.PI / 6);
			break;
		}
	}
	
	public void updateVisualField(){
		this.visualField= new Polygon();
		visualField.addPoint(this.getCenterX(),this.getCenterY());
		chooseDirVisualField();
		this.a1=a1+this.getCenterX();
		this.a2=a2+this.getCenterX();
		this.b1=b1+this.getCenterY();
		this.b2=b2+this.getCenterY();
		newPoint=new float[2];
		newPoint= this.getCenter();
		
		for(int i =0;i<40;i++){
			stop = false;
			a=(float) (a1+i*(a2-a1)/39);
			b=(float) (b1+i*(b2-b1)/39);
			while(!(stop || fr.util.Collisions.distance(newPoint, this.getCenter())>300)){
				newPoint=fr.util.Collisions.prolongementDroite(this.getCenterX(), this.getCenterY(), a, b, av);
				av+=3;
				for (Wall w : fr.basic.World.getWalls()){
					if(w.contains(newPoint[0],newPoint[1])) {
						stop = true;
					}
				}
			}
			av=0;
			visualField.addPoint(newPoint[0], newPoint[1]);
			newPoint=this.getCenter();
		}
		
		
	}
}
