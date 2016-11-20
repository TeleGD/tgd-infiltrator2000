package fr.basic;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.circle.Item;
import entity.movable.circle.Guard;
import entity.movable.circle.Player;
import entity.movable.circle.Projectile;
import entity.rectangle.FrontalWall;
import entity.rectangle.LateralWall;
import entity.rectangle.Wall;
import fr.util.Chrono;
import fr.vision.Area;
import fr.capacity.Capacity;

public class World extends BasicGameState{

	public static int ID = 0;
	private Chrono chrono;
	private static Player player;
	private StateBasedGame game;
	private static ArrayList<Wall> walls;
	private static ArrayList<Guard> guards;
	private ArrayList<Integer> deadGuardsIndexes;
	private static ArrayList<Item> items;
	private static ArrayList<Projectile> projectiles;
	private static ArrayList<Area> areas;
	private ArrayList<Integer> scores;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		areas = new ArrayList<Area>();
		guards = new ArrayList<Guard>();
		walls = new ArrayList<Wall>();
		items = new ArrayList<Item>();
		projectiles = new ArrayList<Projectile>();
		chrono = new Chrono();
		chrono.start();
		walls.add(new LateralWall(700,200,15,new Image("images/walls/lateralwall1up.png"),new Image("images/walls/wall1side.png")));
		walls.add(new FrontalWall(668,200,5,new Image("images/walls/wall1up.png"),new Image("images/walls/wall1front.png")));
		guards.add(new Guard(500,100,0.5,0,15,50,null,this));
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
		if(chrono.getTime() > 2000) guards.get(0).setEnVie(false);
		
		for(Projectile p : projectiles){
			p.update(arg0, arg1, arg2);
		}
		
		for(Wall w : walls){
			w.update(arg0, arg1, arg2);
		}
		
		for(Guard g : guards){
			//NE PAS UPDATE LES GARDES MORTS
			if(g.isEnVie()) g.update(arg0, arg1, arg2);
		}
		
		for(Item i : items){
			i.update(arg0, arg1, arg2);
		}
		
		player.update(arg0, arg1, arg2);
		chrono.update(arg0, arg1, arg2);
	}

	@Override
	public int getID() {
		return ID;
	}
	
	public void keyPressed(int key, char c){
		player.keyPressed(key,c);
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
		
	}

}
