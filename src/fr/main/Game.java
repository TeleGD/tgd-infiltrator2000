package fr.main;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.menu.*;
import fr.basic.World;

public class Game extends StateBasedGame {
	
	public Game(String name) {
		super(name);
	}

	public Game() {
		super("1NF1|TR470R 2000");
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game(),1280,720,false);
		//app.setTargetFrameRate(120);
		app.setVSync(true);
		app.setShowFPS(true);
		app.start();
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
 		addState(new MenuPrincipal());
		addState(new World());
		addState(new MenuFin());
		addState(new MenuScores());
	}

}