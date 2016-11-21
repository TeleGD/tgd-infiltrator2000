package fr.basic.menu;

import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import fr.basic.World;

public class MenuFin extends Menu {
	public static int ID = 2;
	public MenuFin(){
		super(3);
		
		selection = 1;
		//items[0] = "Merci d'avoir joue! Score final : "+World.getScore();
		items[1] = "Scores";
		items[2] = "Quitter";
		nom = "Menu de Fin";
	}
	
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
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
		switch (key) {
		case Input.KEY_NUMPAD2:
			if (selection < nbrOptions - 1)
				selection++;
			else
				selection = 1;
			break;
		case Input.KEY_NUMPAD8:
			if (selection > 1)
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
	
	@Override
	public void execOption(){
		switch (selection) {
		case 0:
			break;
		case 1:
			/*try {
				MenuScores.addScore(World.getScore());
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			game.enterState(MenuScores.ID, new FadeOutTransition(),	new FadeInTransition());
			break;
		case 2:
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
