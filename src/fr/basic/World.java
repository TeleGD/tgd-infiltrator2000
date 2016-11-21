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

import fr.util.Chrono;

import fr.basic.menu.MenuFin;
import fr.basic.menu.MenuScores;
import fr.capacity.Capacity;
import fr.circles.Guard;
import fr.circles.GuardHor;
import fr.circles.GuardSquare;
import fr.circles.GuardVer;
import fr.circles.Item;
import fr.circles.Player;
import fr.circles.Projectile;
import fr.rectangles.FrontalWall;
import fr.rectangles.LateralWall;
import fr.rectangles.Wall;

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
	private ArrayList<Integer> scores;

	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		guards = new ArrayList<Guard>();
		walls = new ArrayList<Wall>();
		items = new ArrayList<Item>();
		projectiles = new ArrayList<Projectile>();
		deadGuards = new ArrayList<Guard>();

		chrono = new Chrono();
		chrono.start();
		game = arg1;
		
		walls.add(new LateralWall(700,200,15,new Image("images/walls/lateralwall1up.png"),new Image("images/walls/wall1side.png")));
		walls.add(new FrontalWall(668,200,5,new Image("images/walls/wall1up.png"),new Image("images/walls/wall1front.png")));
		walls.add(new LateralWall(0,-64,40,new Image("images/walls/lateralwall1up.png"),new Image("images/walls/wall1side.png")));
		walls.add(new LateralWall(0,720-32,40,new Image("images/walls/lateralwall1up.png"),new Image("images/walls/wall1side.png")));
		walls.add(new FrontalWall(0,0,23,new Image("images/walls/wall1up.png"),new Image("images/walls/wall1front.png")));
		walls.add(new FrontalWall(1280-32,0,23,new Image("images/walls/wall1up.png"),new Image("images/walls/wall1front.png")));
		
		/*guards.add(new Guard(500,100,50));
		guards.add(new GuardSquare(800,100,50));
		guards.add(new GuardVer(900,100,50));*/
		guards.add(new GuardHor(1000,100,40));
		player = new Player(500, 300, 35);
		
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
			//g.render(arg0, arg1, arg2);
			//NE PAS RENDER LES GARDES MORTS
			if(!g.isDestructed()) g.render(arg0, arg1, arg2);
		}
		
		player.render(arg0, arg1, arg2);	
		
		//render par les guard
		/*for(EnemyVisualField a : areas){
			a.render(arg0, arg1, arg2);
		}*/
		
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
			//g.update(arg0, arg1, arg2);
			//NE PAS UPDATE LES GARDES MORTS
			if(!g.isDestructed()) g.update(arg0, arg1, arg2);
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
	
	
	public static ArrayList<Wall> getWalls(){
		return walls;
	}
	
	public static ArrayList<Guard> getGuards(){
		return guards;
	}
	
	public static ArrayList<Item> getItems(){
		return items;
	}
	
	
	public static ArrayList<Projectile> getProjectiles(){
		return projectiles;
	}
	
	public static Player getPlayer(){
		return player;
	}
	
	public static void reset(){
		chrono.start();
	}

}
