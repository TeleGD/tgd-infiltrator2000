package fr.vision;

import java.awt.Point;
import java.util.ArrayList;

import entity.movable.Circle.Character;
import entity.movable.Circle.Player;
import entity.rectangle.Wall;

public class Area {
	
	private Character character;
	private ArrayList<Point> wallCorners;
	private ArrayList<Point> poly;
	private int size;
	
	public Area(Character character, int size){
		this.character = character;
		this.size = size;
		wallCorners = new ArrayList<Integer>();
		poly = new ArrayList<Integer>();
		poly.add( new Point(4,4) );
	}

	
	/*
	 * 1----2 >
	 * |	|
	 * 3----4
	 * v
	 */
	public void updateViewField(){
			for( Wall wall : character.getWorld().getWalls()){
				double tmpX = character.getX();
				double tmpY = character.getY();
				if( norm(wall.getX(), tmpX, wall.getY(), tmpY ) <= size ){
					wallCorners.add(new Point( (int)wall.getX(), (wall.getY() ) );
				}
				if( norm(wall.getX() + wall.getWidth(), tmpX, wall.getY(), tmpY ) <= size ){

				}
				if( norm(wall.getX(), tmpX, wall.getY() + wall.getHeight(), tmpY ) <= size ){

				}
				if( norm(wall.getX() + wall.getWidth(), tmpX, wall.getY() + wall.getHeight(), tmpY ) <= size ){

				}
			}
	}
	
	public void drawViewField(){
		
	}
	
	private double norm(double xA, double xB, double yA, double yB){
		return Math.sqrt( Math.pow(xA-xB,2) + Math.pow(yA-yB,2) );
		
	}

	
}
