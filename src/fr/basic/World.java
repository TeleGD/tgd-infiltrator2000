package fr.basic;


import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import entity.Entity;
import entity.circle.Item;
import entity.movable.circle.Guard;
import entity.movable.circle.GuardHor;
import entity.movable.circle.GuardSquare;
import entity.movable.circle.GuardVer;
import entity.movable.circle.Player;
import entity.movable.circle.Projectile;
import entity.rectangle.FrontalWall;
import entity.rectangle.LateralWall;
import entity.rectangle.Wall;
import fr.util.Chrono;
import fr.vision.Area;
import fr.basic.menu.MenuFin;
import fr.basic.menu.MenuScores;
import fr.capacity.Capacity;

public class World extends BasicGameState{

	public static int ID = 0;
	
	private static Chrono chrono = new Chrono();
	private static Player player;
	private StateBasedGame game;
	private static ArrayList<Wall> walls;
	private static ArrayList<Guard> guards;
	private ArrayList<Guard> deadGuards;
	private static ArrayList<Item> items;
	private static ArrayList<Projectile> projectiles;
	private static ArrayList<Area> areas;
	private Polygon poly;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		areas = new ArrayList<Area>();
		guards = new ArrayList<Guard>();
		walls = new ArrayList<Wall>();
		items = new ArrayList<Item>();
		projectiles = new ArrayList<Projectile>();
		deadGuards = new ArrayList<Guard>();
		poly = new Polygon();
		poly.addPoint(0,0);
		poly.addPoint(0, 10);
		poly.addPoint(10, 0);
		chrono = new Chrono();
		chrono.start();
		game = arg1;
		
		walls.add(new LateralWall(700,200,15,new Image("images/walls/lateralwall1up.png"),new Image("images/walls/wall1side.png")));
		walls.add(new FrontalWall(668,200,5,new Image("images/walls/wall1up.png"),new Image("images/walls/wall1front.png")));
		walls.add(new LateralWall(0,0,40,new Image("images/walls/lateralwall1up.png"),new Image("images/walls/wall1side.png")));
		walls.add(new LateralWall(0,720-32,40,new Image("images/walls/lateralwall1up.png"),new Image("images/walls/wall1side.png")));
		walls.add(new FrontalWall(0,0,23,new Image("images/walls/wall1up.png"),new Image("images/walls/wall1front.png")));
		walls.add(new FrontalWall(1280-32,0,23,new Image("images/walls/wall1up.png"),new Image("images/walls/wall1front.png")));
		
		guards.add(new Guard(500,100,0.5,0,15,50,null,this));
		guards.add(new GuardSquare(800,100,0.5,0,15,50,null,this));
		guards.add(new GuardVer(900,100,0.5,0,15,50,null,this));
		guards.add(new GuardHor(1000,100,0.5,0,15,50,null,this));
		
		player = new Player(500., 300., 0., 0.,30,60, this);
		areas.add(new Area(player, 100));
		
		player.addCapacity(new Capacity("couteau"));
		player.addCapacity(new Capacity("pistolet"));
		player.addCapacity(new Capacity("radar"));
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		
		for(Wall w : walls){
			w.render(arg0, arg1, arg2);
		}
		
		for(Item i : items){
			i.render(arg0, arg1, arg2);
		}
		
		for(Guard g : guards){
			//NE PAS RENDER LES GARDES MORTS
			if(g.isEnVie()) g.render(arg0, arg1, arg2);
		}
		
		player.render(arg0, arg1, arg2);	
		
		for(Area a : areas){
			a.render(arg0, arg1, arg2);
		}
		
		for(Projectile p : projectiles){
			p.render(arg0, arg1, arg2);
		}
		chrono.render(arg0, arg1, arg2);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
		for(Projectile p : projectiles){
			p.update(arg0, arg1, arg2);
		}
		
		for(Wall w : walls){
			w.update(arg0, arg1, arg2);
		}
		
		for(Guard g : guards){
			//NE PAS UPDATE LES GARDES MORTS
			if(g.isEnVie()) g.update(arg0, arg1, arg2);
			else deadGuards.add(g);
		}
		
		for(Item i : items){
			i.update(arg0, arg1, arg2);
		}
		
		for(Guard g : deadGuards) {
			guards.remove(g);
		}

		deadGuards.removeAll(deadGuards);
		
		player.update(arg0, arg1, arg2);
		chrono.update(arg0, arg1, arg2);
	}

	@Override
	public int getID() {
		return ID;
	}
	
	public static long getScore(){
		return chrono.getTime();
	}
	
	public void keyPressed(int key, char c){
		switch(key){
		case Input.KEY_ESCAPE:
			game.enterState(MenuFin.ID, new FadeOutTransition(), new FadeInTransition());
			break;
		default:
			player.keyPressed(key,c);
			break;
		}
	}
	
	public void keyReleased(int key, char c){
		player.keyReleased(key,c);
	}
	
	public static void addWall(Wall w){
		walls.add(w);
	}
	
	public static void addGuard(Guard g){
		guards.add(g);
	}
	
	public static void addItem(Item i){
		items.add(i);
	}
	
	public static void addProjectiles(Projectile p){
		projectiles.add(p);
	}
	
	public static void addArea(Area a) {
		areas.add(a);
	}
	
	public static ArrayList<Wall> getWalls(){
		return walls;
	}
	
	public static ArrayList<Guard> getGuards(){
		return guards;
	}
	
	public static ArrayList<Item> getItems(){
		return items;
	}
	
	public static ArrayList<Area> getAreas() {
		return areas;
	}
	
	public static ArrayList<Projectile> getProjectiles(){
		return projectiles;
	}
	
	public static ArrayList<Entity> getEntities(){
		ArrayList<Entity> tmp = new ArrayList<Entity>();
		tmp.addAll(walls);
		tmp.addAll(guards);
		tmp.addAll(items);
		tmp.addAll(projectiles);
		return tmp;
	}
	
	public static Player getPlayer(){
		return player;
	}
	
	public static void reset(){
		chrono.start();
	}

}
