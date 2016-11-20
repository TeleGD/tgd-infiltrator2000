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
import entity.movable.Projectile;
import entity.rectangle.LateralWall;
import entity.rectangle.Wall;
import fr.util.Chrono;
import fr.vision.Area;
import fr.capacity.Capacity;

public class World extends BasicGameState{

	public static int ID = 0;
	private Chrono chrono;
	private Player player;
	private StateBasedGame game;
	private ArrayList<Wall> walls;
	private ArrayList<Guard> guards;
	private ArrayList<Item> items;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Area> areas;
	
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
		guards.add(new Guard(500,100,0.5,0,15,50,null,this));
		player = new Player(500., 300., 0., 0.,30,60, null, new ArrayList<Capacity>(),this);
		areas.add(new Area(player, 100));
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
			g.render(arg0, arg1, arg2);
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
			g.update(arg0, arg1, arg2);
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
	
	public void addWall(Wall w){
		walls.add(w);
	}
	
	public void addGuard(Guard g){
		guards.add(g);
	}
	
	public void addItem(Item i){
		items.add(i);
	}
	
	public void addProjectiles(Projectile p){
		projectiles.add(p);
	}
	
	public void addArea(Area a) {
		areas.add(a);
	}
	
	public ArrayList<Wall> getWalls(){
		return walls;
	}
	
	public ArrayList<Guard> getGuards(){
		return guards;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	public ArrayList<Area> getAreas() {
		return areas;
	}
	
	public ArrayList<Entity> getEntities(){
		ArrayList<Entity> tmp = new ArrayList<Entity>();
		tmp.addAll(walls);
		tmp.addAll(guards);
		tmp.addAll(items);
		tmp.addAll(projectiles);
		return tmp;
	}
	
	public static void reset(){
		
	}

}
