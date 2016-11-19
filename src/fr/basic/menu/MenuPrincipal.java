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
	
	public MenuPrincipal(){
		super(2);
		ID = 1;
		
		items[0] = "Jouer";
		items[1] = "Quitter";
		nom = "Menu Principal";
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
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.drawString(this.nom, 550, 320);

		g.setColor(Color.white);

		for (int i = 0; i < nbrOptions; i++) {
			g.drawString(this.items[i], 560, 360 + 30 * i);
		}
		g.drawString(">>", 540, 360 + 30 * selection);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
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

		case Input.KEY_ESCAPE:
			this.container.exit();
			break;
		/*case Input.KEY_C:
			game.enterState(CreditsMenu.ID, new FadeOutTransition(),
					new FadeInTransition());
			break;
		case Input.KEY_M:
			game.enterState(MissionMenu.ID, new FadeOutTransition(),
					new FadeInTransition());
			break;*/
		}
	}

	public void execOption() {
		switch (selection) {
		case 0:
			World.reset();
			game.enterState(World.ID, new FadeOutTransition(),
					new FadeInTransition());
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
		return ID;
	}
}
