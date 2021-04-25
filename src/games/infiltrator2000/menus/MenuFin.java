package games.infiltrator2000.menus;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuFin extends Menu {

	private int ID;

	public MenuFin(int ID) {
		super(3);
		this.ID = ID;
		selection = 1;
		items[0] = "Merci d'avoir joue! Score final : 0";
		items[1] = "Scores";
		items[2] = "Quitter";
		nom = "Menu de Fin";
	}

	public int getID() {
		return this.ID;
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) {
		g.drawString(this.nom, 550, 320);

		g.setColor(Color.white);
		g.drawString(this.items[0], 400, 360);

		for (int i = 1; i < nbrOptions; i++) {
			g.drawString(this.items[i], 560, 360 + 30 * i);
		}
		g.drawString(">>", 540, 360 + 30 * selection);

	}

	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ESCAPE){
			game.enterState(1 /* MenuPrincipal */, new FadeOutTransition(), new FadeInTransition());
		}
		super.keyPressed(key, c);
	}

	@Override
	public void execOption(){
		switch (selection) {
		case 0:
			break;
		case 1:
			game.enterState(5 /* MenuScores */, new FadeOutTransition(),	new FadeInTransition());
			break;
		case 2:
			game.enterState(1 /* MenuPrincipal */, new FadeOutTransition(),	new FadeInTransition());
			break;
		default:
			break;
		}
	}

	public void setScore(long score) {
		items[0] = "Merci d'avoir joue! Score final : " + score;
	}

}
