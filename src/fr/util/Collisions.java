package fr.util;
import java.util.ArrayList;

import entity.circle.EntityCircle;
import entity.movable.circle.MovableCircle;
import entity.movable.rectangle.MovableRectangle;
import entity.rectangle.EntityRectangle;

public class Collisions {
	
	//Collisions rectangle avec rectangle
	public static boolean isCollision(MovableRectangle h1,MovableRectangle h2){
		return ((h1.getX()+h1.getWidth()>h2.getX() && h1.getX()<h2.getX()+h2.getWidth())&&((h1.getY()+h1.getSpeedY()+h1.getHeight()>=h2.getY()+h2.getSpeedY()) && (h1.getY()+h1.getSpeedY()<=h2.getY()+h2.getSpeedY()+h2.getHeight())));
	}
	
	public static boolean isCollision(EntityRectangle h1, EntityRectangle h2){
		return ((h1.getX()+h1.getWidth()>h2.getX() && h1.getX()<h2.getX()+h2.getWidth())&&((h1.getY()+h1.getHeight()>=h2.getY()) && (h1.getY()<=h2.getY()+h2.getHeight())));
	}
	
	public static boolean isCollision(EntityRectangle h1, MovableRectangle h2){
		return ((h1.getX()+h1.getWidth()>h2.getX() && h1.getX()<h2.getX()+h2.getWidth())&&((h1.getY()+h1.getHeight()>=h2.getY()+h2.getSpeedY()) && (h1.getY()<=h2.getY()+h2.getSpeedY()+h2.getHeight())));
	}
	
	public static boolean isCollision(MovableRectangle h1, EntityRectangle h2){
		return isCollision(h2, h1);
	}
	
	//collisions cercle et cercle
	//TODO la collision cercle/cercle qui bougent est simplifie, si ca bouge trop vite, ca va bugger
	
	public static boolean isCollision(EntityCircle h1, EntityCircle h2){
		double dx=h1.getX()-h2.getX();
		double dy=h1.getY()-h2.getY();
		return dx*dx+dy*dy<((h1.getRadius()+h2.getRadius())*(h1.getRadius()+h2.getRadius()));
	}
	
	public static boolean isCollision(EntityCircle h1, MovableCircle h2){
		double dx=h1.getX()-h2.getX()+h2.getSpeedX();
		double dy=h1.getY()-h2.getY()+h2.getSpeedY();
		return dx*dx+dy*dy<((h1.getRadius()+h2.getRadius())*(h1.getRadius()+h2.getRadius()));
	}
	
	public static boolean isCollision(MovableCircle h1, EntityCircle h2){
		return isCollision(h2,h1);
	}
	
	public static boolean isCollision(MovableCircle h1, MovableCircle h2){
		double dx=h1.getX()+h1.getSpeedX()-h2.getX()+h2.getSpeedX();
		double dy=h1.getY()+h1.getSpeedY()-h2.getY()+h2.getSpeedY();
		return dx*dx+dy*dy<((h1.getRadius()+h2.getRadius())*(h1.getRadius()+h2.getRadius()));
	}
	
	//collisions cercle et rectangle
	
	public static boolean isCollision(EntityCircle h1, EntityRectangle h2){
		ArrayList<ArrayList<Double>> points=h2.pixelBordeer();
		boolean  res=true;
		for (int i = 0; i < points.size(); i++) {
			double dx=h1.getX()-points.get(i).get(0);
			double dy=h1.getY()-points.get(i).get(1);
			res=res&&!(dx*dx+dy*dy<((h1.getRadius()))*(h1.getRadius()));
		}
		return !res;
	}
	
	public static boolean isCollision(EntityRectangle h1, EntityCircle h2){
		return isCollision(h2,h1);
	}
	
	public static boolean isCollision(EntityCircle h1, MovableRectangle h2){
		ArrayList<ArrayList<Double>> points=h2.pixelBordeerWithSpeed();
		boolean  res=true;
		for (int i = 0; i < points.size(); i++) {
			double dx=h1.getX()-points.get(i).get(0);
			double dy=h1.getY()-points.get(i).get(1);
			res=res&&!(dx*dx+dy*dy<((h1.getRadius()))*(h1.getRadius()));
		}
		return !res;
	}
	
	public static boolean isCollision(MovableRectangle h1, EntityCircle h2){
		return isCollision(h2,h1);
	}
	
	public static boolean isCollision(MovableCircle h1, EntityRectangle h2){
		ArrayList<ArrayList<Double>> points=h2.pixelBordeer();
		boolean  res=true;
		for (int i = 0; i < points.size(); i++) {
			double dx=h1.getX()+h1.getSpeedX()-points.get(i).get(0);
			double dy=h1.getY()+h1.getSpeedY()-points.get(i).get(1);
			res=res&&!(dx*dx+dy*dy<((h1.getRadius()))*(h1.getRadius()));
		}
		return !res;
	}
	
	public static boolean isCollision(EntityRectangle h1, MovableCircle h2){
		return isCollision(h2, h1);
	}
	
	public static boolean isCollision(MovableCircle h1, MovableRectangle h2){
		ArrayList<ArrayList<Double>> points=h2.pixelBordeerWithSpeed();
		boolean  res=true;
		for (int i = 0; i < points.size(); i++) {
			double dx=h1.getX()+h1.getSpeedX()-points.get(i).get(0);
			double dy=h1.getY()+h1.getSpeedY()-points.get(i).get(1);
			res=res&&!(dx*dx+dy*dy<((h1.getRadius()))*(h1.getRadius()));
		}
		return !res;
	}
	
	public static boolean isCollision(MovableRectangle h1, MovableCircle h2){
		return isCollision(h2, h1);
	}
	
}