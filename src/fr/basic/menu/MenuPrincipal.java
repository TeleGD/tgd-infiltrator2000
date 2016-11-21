package fr.basic.menu;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import fr.basic.World;

public class MenuPrincipal extends Menu {
	public static int ID = 1;
	
	public MenuPrincipal(){
		super(2);
		items[0] = "Jouer";
		items[1] = "Quitter";
		nom = "Menu Principal";
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ESCAPE){
			game.enterState(MenuFin.ID, new FadeOutTransition(), new FadeInTransition());
		}
		super.keyPressed(key, c);
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		super.render(arg0, arg1, g);
	}
	
	@Override
	public void execOption(){
		switch (selection) {
		case 0:
			World.reset();
			game.enterState(World.ID, new FadeOutTransition(), new FadeInTransition());
			break;

		case 1:
			this.container.exit();
			break;
		default:
			break;
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
}
