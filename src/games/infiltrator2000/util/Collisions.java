package games.infiltrator2000.util;

import java.util.ArrayList;

import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

import games.infiltrator2000.circles.Player;
import games.infiltrator2000.rectangles.Wall;

public class Collisions {

	private static float x1;//ceux de s2
	private static float x2;
	private static float y1;
	private static float y2;
	private static float x3,x4,y3,y4;//ceux du prolongemement de s2
	private static float x,y;//centre s2
	private static float[] f,g;
	private static ArrayList<Polygon> polys;

	// mur: droite = 3,gauche =1, haut = 2, bas= 4, no col=0
	public static int col(Player s1, Wall s2) {
		if (s1.intersects(s2)) {//&& !s1.contains(s2)) return 0;
		ArrayList<Polygon> shisme = shisme(s2);
		if(shisme.get(1).contains(new Point(s1.getCenterX(),s1.getCenterY()))) return 2;
		else if(shisme.get(2).contains(new Point(s1.getCenterX(),s1.getCenterY()))) return 3;
		else if(shisme.get(3).contains(new Point(s1.getCenterX(),s1.getCenterY()))) return 4;
		else if(shisme.get(0).contains(new Point(s1.getCenterX(),s1.getCenterY()))) return 1;
		else return 0;
		}
		return 0;
	}


	//prolonge derriere le point 2 en partant du 1 (de 5001321648778 en x)
	public static float[] prolongementDroite(float x1,float y1,float x2,float y2, double wow){
		float a=(float) (x2+wow*Math.abs(x2-x1)/(x2-x1));
		float b= (float) (y1+(x2+wow*Math.abs(x2-x1)/(x2-x1)-x1)*(y2-y1)/(x2-x1));
		f = new float[]{a,b};
		return f;
	}

	//pour s�parer les rec et leur prolongement en 4 zones
	public static ArrayList<Polygon>  shisme(Rectangle rec){
		x1=rec.getMinX();
		y1=rec.getMinY();
		x2=rec.getMaxX();
		y2=rec.getMaxY();
		x=rec.getCenterX();
		y=rec.getCenterY();
		polys=new ArrayList<Polygon>();
		//1
		g=new float[]{x,y,prolongementDroite(x,y,x1,y1,600)[0],prolongementDroite(x,y,x1,y1,600)[1],prolongementDroite(x,y,x1,y2,600)[0],prolongementDroite(x,y,x1,y2,600)[1]};
		polys.add(new Polygon(g));

		//2
		g=new float[]{x,y,prolongementDroite(x,y,x1,y1,600)[0],prolongementDroite(x,y,x1,y1,600)[1],prolongementDroite(x,y,x2,y1,600)[0],prolongementDroite(x,y,x2,y1,600)[1]};
		polys.add(new Polygon(g));

		//3
		g=new float[]{x,y,prolongementDroite(x,y,x2,y1,600)[0],prolongementDroite(x,y,x2,y1,600)[1],prolongementDroite(x,y,x2,y2,600)[0],prolongementDroite(x,y,x2,y2,600)[1]};
		polys.add(new Polygon(g));

		//4
		g=new float[]{x,y,prolongementDroite(x,y,x2,y2,600)[0],prolongementDroite(x,y,x2,y2,600)[1],prolongementDroite(x,y,x1,y2,600)[0],prolongementDroite(x,y,x1,y2,600)[1]};
		polys.add(new Polygon(g));

		return polys;
	}







	public static float distance(float[] f1, float[] f2) {
		return (float) Math.sqrt((f1[0] - f2[0]) * (f1[0] - f2[0]) + (f1[1] - f2[1]) * (f1[1] - f2[1]));
	}
}
