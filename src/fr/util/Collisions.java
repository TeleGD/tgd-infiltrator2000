package fr.util;
import entity.Entity;
import entity.movable.Movable;
import entity.movable.rectangle.MovableRectangle;
import entity.rectangle.EntityRectangle;
import fr.interfaces.Rectangle;

public class Collisions {

	/**
	 * verifie qu'il existe une collision entre la Entity 1 et Entity2 sur l'axe Y
	 * @author PA
	 * @param h1 entity1
	 * @param h2 entity2
	 * @return -1 -> par le haut / 0 -> aucune  / 1 -> par le bas 
	 */
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
	
}