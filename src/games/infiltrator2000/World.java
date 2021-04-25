package games.infiltrator2000;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import app.AppLoader;

import games.infiltrator2000.capacity.Capacity2;
import games.infiltrator2000.circles.EndLevel;
import games.infiltrator2000.circles.Guard;
import games.infiltrator2000.circles.GuardHor;
import games.infiltrator2000.circles.GuardSquare;
import games.infiltrator2000.circles.GuardVer;
import games.infiltrator2000.circles.Item;
import games.infiltrator2000.circles.Player;
import games.infiltrator2000.circles.Projectile;
import games.infiltrator2000.menus.MenuFin;
import games.infiltrator2000.menus.MenuScores;
import games.infiltrator2000.rectangles.FrontalWall;
import games.infiltrator2000.rectangles.Ground;
import games.infiltrator2000.rectangles.LateralWall;
import games.infiltrator2000.rectangles.Wall;
import games.infiltrator2000.util.Chrono;

public class World extends BasicGameState{

	private int ID;
	private int state;

	private Chrono chrono;
	private Player player;
	private ArrayList<Wall> walls;
	private ArrayList<Guard> guards;
	private ArrayList<Guard> deadGuards;
	private ArrayList<Item> items;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Ground> ground;
	private EndLevel finish;

	public static int getWidth() {
		return 1280;
	}

	public static int getHeight() {
		return 720;
	}

	public World(int ID) {
		this.ID = ID;
		this.state = 0;
	}

	@Override
	public int getID() {
		return this.ID;
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) {
		/* Méthode exécutée une unique fois au chargement du programme */
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée à l'apparition de la page */
		if (this.state == 0) {
			this.play(container, game);
		} else if (this.state == 2) {
			this.resume(container, game);
		}
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée à la disparition de la page */
		if (this.state == 1) {
			this.pause(container, game);
		} else if (this.state == 3) {
			this.stop(container, game);
			this.state = 0; // TODO: remove
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) {
		/* Méthode exécutée environ 60 fois par seconde */
		for (Ground g : ground) g.render(arg0, arg1, arg2);

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
		this.finish.render(arg0, arg1, arg2);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) {
		/* Méthode exécutée environ 60 fois par seconde */
		Input input = arg0.getInput();
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			this.setState(1);
			arg1.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		if (input.isKeyDown(Input.KEY_ENTER)) {
			this.setState(3);
			long score = chrono.getTime();
			((MenuScores) arg1.getState(5 /* MenuScores */)).addScore(score);
			((MenuFin) arg1.getState(4 /* MenuFin */)).setScore(score);
			arg1.enterState(4 /* MenuFin */, new FadeOutTransition(),	new FadeInTransition());
		}
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
		this.finish.update(arg0, arg1, arg2);
	}

	public void play(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois au début du jeu */
		guards = new ArrayList<Guard>();
		walls = new ArrayList<Wall>();
		items = new ArrayList<Item>();
		projectiles = new ArrayList<Projectile>();
		deadGuards = new ArrayList<Guard>();
		ground = new ArrayList<Ground>();

		chrono = new Chrono();
		chrono.start();

		//walls.add(new LateralWall(700,200,15,AppLoader.loadPicture("/images/infiltrator2000/walls/lateralwall1up.png"),AppLoader.loadPicture("/images/infiltrator2000/walls/wall1side.png")));
		//walls.add(new FrontalWall(668,200,5,AppLoader.loadPicture("/images/infiltrator2000/walls/wall1up.png"),AppLoader.loadPicture("/images/infiltrator2000/walls/wall1front.png")));
		walls.add(new LateralWall(0,-64,40,AppLoader.loadPicture("/images/infiltrator2000/walls/lateralwall1up.png"),AppLoader.loadPicture("/images/infiltrator2000/walls/wall1side.png")));
		walls.add(new LateralWall(0,720-32,40,AppLoader.loadPicture("/images/infiltrator2000/walls/lateralwall1up.png"),AppLoader.loadPicture("/images/infiltrator2000/walls/wall1side.png")));
		walls.add(new FrontalWall(0,0,23,AppLoader.loadPicture("/images/infiltrator2000/walls/wall1up.png"),AppLoader.loadPicture("/images/infiltrator2000/walls/wall1front.png")));
		walls.add(new FrontalWall(1280-32,0,23,AppLoader.loadPicture("/images/infiltrator2000/walls/wall1up.png"),AppLoader.loadPicture("/images/infiltrator2000/walls/wall1front.png")));

		guards.add(new GuardSquare(this, 600,400,50));
		guards.add(new GuardVer(this, 300,400,50));
		guards.add(new GuardHor(this, 650,100,40));
		player = new Player(this, 500, 300, 35);

		player.addCapacity(new Capacity2("couteau"));
		player.addCapacity(new Capacity2("pistolet"));
		player.addCapacity(new Capacity2("radar"));
		ground.add(new Ground(32,32,5,5));
		this.finish=new EndLevel(800,400,3);
	}

	public void pause(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la mise en pause du jeu */
		chrono.pause();
	}

	public void resume(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée lors de la reprise du jeu */
		chrono.resume();
	}

	public void stop(GameContainer container, StateBasedGame game) {
		/* Méthode exécutée une unique fois à la fin du jeu */
		chrono.stop();
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return this.state;
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


	public ArrayList<Wall> getWalls(){
		return walls;
	}

	public ArrayList<Guard> getGuards(){
		return guards;
	}

	public ArrayList<Item> getItems(){
		return items;
	}


	public ArrayList<Projectile> getProjectiles(){
		return projectiles;
	}

	public Player getPlayer(){
		return player;
	}

}
