package games.infiltrator2000.circles;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class EndLevel extends Item {

	protected int levelSuivant;

	public EndLevel(float x, float y,int lvlSuiv) {
		super(x, y,30);
		this.levelSuivant=lvlSuiv;
	}

	//-------------------------Get------------------
	public int getLevelSuivant() {
		return levelSuivant;
	}

	//------------------------Set-------------------
	public void setLevelSuivant(int levelSuivant) {
		this.levelSuivant = levelSuivant;
	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3)  {

	}

	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3){
		arg3.setColor(Color.orange);
		arg3.draw(this);
		arg3.drawString("lvl suivant", this.getCenterX(),this.getCenterY()-radius-15);
	}

}
