package games.guardSlalom.menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import app.AppFont;
import app.AppLoader;

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
	public void init(GameContainer container, StateBasedGame game) {
		this.container = container;
		this.game = game;
		font1 = AppLoader.loadFont("Kalinga", AppFont.BOLD, 12); // TODO: trouver une fonte équivalente

		nbrOptions = items.length;
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) {

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) {
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
		case Input.KEY_DOWN:
			if (selection < nbrOptions - 1)
				selection++;
			else
				selection = 0;
			break;
		case Input.KEY_UP:
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
