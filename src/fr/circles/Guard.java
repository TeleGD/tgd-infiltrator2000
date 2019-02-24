package fr.circles;

import java.util.ArrayList;

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
import fr.main.Game;
import fr.rectangles.Wall;

public class Guard extends Character {
	protected boolean destructed;
	protected double a1, a2, b1, b2,av; // used to generate visual field
	protected Polygon visualField;
	protected float[] newPoint;
	protected boolean stop, alerted;
	protected float a,b;
	protected float xOrigin,yOrigin;
	protected ArrayList<Integer> toFollow;
	protected int currentDst;
	protected int currentDir;

	public Guard(float centerX, float centerY, float radius) {
		super(centerX, centerY, radius);
		this.xOrigin=centerX;
		this.yOrigin=centerY;
		this.destructed = false;
		this.visualField=new Polygon();
		visualField.addPoint(centerX, centerY);
		visualField.addPoint(centerX+5,centerY+5);
		toFollow = new ArrayList<Integer>();
		currentDst = -1;
		currentDir = -1;
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

	public void horizontalMove(float dir){
		while(this.x != dir){
			if(this.x < dir){
				this.speedX = (float) 0.4;
			}
			else{
				this.speedX = (float) -0.4;
			}
		}
	}

	public void verticalMove(float dir){
		while(this.y != dir){
			if(this.y < dir){
				this.speedY = (float) 0.4;
			}
			else{
				this.speedY = (float) -0.4;
			}
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

	public int summitToID(float x, float y){
		// Returns the ID associated with the summit (x;y) in the graph.
		float gWidth = Math.floorDiv(Game.getWidth(), 32);
		return (int)(x+gWidth*y);
	}

	public int[] IDToSummit(int id){
		int[] summit = {0,0};
		float gWidth = Math.floorDiv(Game.getWidth(), 32);
		summit[0] = (int) (32 * (id % gWidth)) ;
		summit[1] = (int) (32 * Math.floorDiv(id, (int) gWidth));
		return summit;
	}

	public float d(float x0, float y0, float xf, float yf){
		// Returns the distance from (x0,y0) to (xf,yf)
		return (float) Math.sqrt((xf-x0)*(xf-x0) + (yf-y0)*(yf-y0));
	}

	public float d(int ID,float xf, float yf){
		float x0,y0,gWidth;
		gWidth = Math.floorDiv(Game.getWidth(), 32);
		x0 = ID%gWidth;
		y0 = (float) Math.floorDiv(ID, (int) gWidth);
		return d(x0,y0,xf,yf);
	}

	public float d(int ID0, int IDf){
		float x0,y0,gWidth,xf,yf;
		gWidth = Math.floorDiv(Game.getWidth(), 32);
		x0 = ID0%gWidth;
		y0 = (float) Math.floorDiv(ID0, (int) gWidth);
		xf = IDf%gWidth;
		yf = (float) Math.floorDiv(IDf, (int) gWidth);
		return d(x0,y0,xf,yf);
	}

	public boolean aStar(float x0, float y0, float xf, float yf){
		//A* pathfinding, in 8-neighboring;
		//	Returns whether a path was found or not.
		//	If a path is found, the guard follows it.
		boolean path = true;

		// First step : getting grid coordinates from (x0;y0) and (xf;yf)
		float gx0,gy0,gxf,gyf;
		gx0 = Math.floorDiv((int) x0, 32);
		gxf = Math.floorDiv((int) xf, 32);
		gy0 = Math.floorDiv((int) y0, 32);
		gyf = Math.floorDiv((int) yf, 32);

		// Then we initialize S and notS
		ArrayList<Float> F,L,D;
		ArrayList<Integer> S,notS,directions;
		int current, dest;
		final float gWidth = Math.floorDiv(Game.getWidth(), 32);

		S = new ArrayList<Integer>();
		notS = new ArrayList<Integer>();
		directions = new ArrayList<Integer>();
		F = new ArrayList<Float>();
		L = new ArrayList<Float>();
		D = new ArrayList<Float>();
		current = summitToID(gx0,gy0);
		dest = summitToID(gxf,gyf);

		F.add(current, (float) 0);
		L.add(current, d(gx0,gy0,gxf,gyf));
		D.add(current, d(gx0,gy0,gxf,gyf)); //D(x) = F(x)+L(x)
		S.add(current);

		ArrayList<Wall> walls = World.getWalls();

		// Now, we begin the pathfinding :
		float minD;
		int succ;
		//Looping through the successors :
		while(current != dest){
			for(int i = -1; i < 2; i++){
				for(int j = -1; j < 2; j++){
					succ = (int) (current + i * gWidth + j);
					if(succ % 2 != 0){
						if(!S.contains(succ) && !notS.contains(succ) && !wallAtCoords(succ,walls)){
							S.add(succ);
							directions.add(succ, j+1 + i*3);
						}
						else if(D.get(succ) > (F.get(current)+1)+d(succ,gxf,gyf)){
							D.set(succ, (F.get(current)+1)+d(succ,gxf,gyf));
							if(notS.contains(succ)){
								notS.remove(succ);
								S.add(succ);
							}
						}
					}

				}
			}

			minD = -1;
			if(S.size() > 0){
				for(Integer ID : S){
					if(D.get(ID) < minD || minD < 0){
						current = ID;
						minD = D.get(ID);
						toFollow.add(directions.get(current));
					}
				}
			}
			else{
				path = false;
				break;
			}
		}

		return path;
	}

	protected void moveAlerted(){
		float gWidth = Math.floorDiv(Game.getWidth(), 32);
		if(!toFollow.isEmpty()){
			if(currentDir == -1 || summitToID(this.x,this.y) == currentDst ){
				currentDir = toFollow.get(0);
				toFollow.remove(0);
				currentDst = (int) ((currentDir / Math.abs(currentDir))*((currentDir%3)+gWidth*(1-(currentDir%3))));
			}
			switch (currentDir){
			// Basically, we update the speed according to the destination.
			case 0:// Impossible
				break;
			case 1:
				speedX = 0;
				speedY = -0.4f;
				break;
			case 2 :// Impossible
				break;
			case 3 :
				speedX = -0.4f;
				speedY = 0;
				break;
			case 5 :
				speedX = 0.4f;
				speedY = 0;
				break;
			case 6 :// Impossible
				break;
			case 7 :
				speedX = 0;
				speedY = 0.4f;
				break;
			case 8 :// Impossible
				break;
			default : break;
			}
		}
	}

	private boolean wallAtCoords(int succ, ArrayList<Wall> walls) {
		int j = succ % Math.floorDiv(Game.getWidth(), 32);
		int i = Math.floorDiv(succ, Math.floorDiv(Game.getWidth(), 32));

		for(Wall w : walls){
			if(w.getX() == j*32 && w.getY() == i*32){
				return true;
			}
		}

		return false;
	}

}
