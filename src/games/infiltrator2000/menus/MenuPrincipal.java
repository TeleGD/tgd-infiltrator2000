package games.infiltrator2000.menus;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuPrincipal extends Menu {

	private int ID;

	public MenuPrincipal(int ID) {
		super(3);
		this.ID = ID;
		items[0] = "Infiltrator2000";
		items[1] = "Scores";
		items[2] = "Retour";
		nom = "Menu Principal";
	}

	public int getID() {
		return this.ID;
	}

	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ESCAPE){
			game.enterState(0 /* Welcome */, new FadeOutTransition(), new FadeInTransition());
		}
		super.keyPressed(key, c);
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) {
		super.render(arg0, arg1, g);
	}

	@Override
	public void execOption(){
		switch (selection) {
		case 0:
			game.enterState(3 /* World */, new FadeOutTransition(), new FadeInTransition());
			break;
		case 1:
			game.enterState(5 /* MenuScores */, new FadeOutTransition(), new FadeInTransition());
			break;

		case 2:
			game.enterState(0 /* Welcome */, new FadeOutTransition(), new FadeInTransition());
			break;
		default:
			break;
		}
	}

}
