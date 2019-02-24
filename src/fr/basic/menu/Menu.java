package fr.basic.menu;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import fr.basic.World;

public abstract class Menu extends BasicGameState {
	public static int ID ;
	protected int selection;
	static TrueTypeFont font1;
	protected int nbrOptions;
	protected GameContainer container;
	protected StateBasedGame game;
	protected String nom;
	protected String[] items;
	private int renderX, renderY;

	public Menu(){
		//Ne pas utiliser si possible. Utilisez ceux d'en dessous.
		selection = 0;
		items = new String[1];
		items[0] = "Menu de base.";
		renderX = 550;
		renderY = 320;
	}

	public Menu(int itemCount){
		selection = 0;
		items = new String[itemCount];
		nbrOptions = itemCount;
		renderX = 550;
		renderY = 320;
	}

	public Menu(int itemCount,int startingX, int startingY){
		selection = 0;
		items = new String[itemCount];
		nbrOptions = itemCount;
		renderX = startingX;
		renderY = startingY;
	}

	public String[] getItems() {
		return this.items;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)throws SlickException {
		this.container = container;
		container.setShowFPS(true);
		this.game = game;
		Font titre1Font = new Font("Kalinga", Font.BOLD, 12);
		font1 = new TrueTypeFont(titre1Font, false);

		nbrOptions = items.length;
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.drawString(this.nom, renderX, renderY);

		g.setColor(Color.white);

		for (int i = 0; i < nbrOptions; i++) {
			g.drawString(this.items[i], renderX+10, renderY+40 + 30 * i);
		}
		g.drawString(">>", renderX - 10, renderY+40 + 30 * selection);

	}

	@Override
	public void keyPressed(int key, char c) {
		switch (key) {
		case Input.KEY_NUMPAD2:
			if (selection < nbrOptions - 1)
				selection++;
			else
				selection = 0;
			break;
		case Input.KEY_NUMPAD8:
			if (selection > 0)
				selection--;
			else
				selection = nbrOptions - 1;
			break;
		case Input.KEY_ENTER:
			execOption();
			break;
		default :
			break;
		}
	}

	public void execOption() {
		switch (selection) {
		default:
			break;
		}
	}

	@Override
	public abstract int getID();
}
