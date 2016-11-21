package fr.vision;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import fr.circles.Guard;
import fr.circles.Player;
import fr.rectangles.Wall;
import fr.util.Collisions;

public class EnemyVisualField extends Polygon{
	
	private int depth;
	private float centerX,centerY,x1,y1,x2,y2;
	private boolean stop;
	private double av;
	private float a,b;
	private float[] newPoint;
	protected Polygon poly;
	protected float[] center;
	
	public EnemyVisualField(float x,float y,float x1,float y1,float x2,float y2,int depth){
		super();
		this.depth=100;
		centerX=x;
		centerY=y;
		center= new float[2];
		center[0]=centerX;
		center[1]=centerY;
		newPoint= new float[2];
		newPoint[0]=centerX;
		newPoint[1]=centerY;
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.addPoint(x2, y);
		for (int i=0;i<16;i++){
			av=0;
			a=x1+i*(x2-x1)/15;
			b=y1+i*(y2-y1)/15;
			while (!stop && fr.util.Collisions.distance(newPoint,center )<depth){
				newPoint=fr.util.Collisions.prolongementDroite(centerX, centerY, a, b, av);
				av+=3;
				for (Wall w : fr.basic.World.getWalls()){
					if(w.contains(newPoint[0],newPoint[1])) stop = true;
				}
				this.addPoint(newPoint[0], newPoint[1]);
			}
		}
		
	}
	
	
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException {
	}

	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		arg3.draw(this);
	}
}


