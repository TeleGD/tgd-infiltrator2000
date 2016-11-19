package entity.circle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class EndLevel extends Item {
	
	protected String levelSuivant;

	public EndLevel(double x, double y, String lvlSuiv) {
		super(x, y);
		this.levelSuivant=lvlSuiv;
	}

	//-------------------------Get------------------
	public String getLevelSuivant() {
		return levelSuivant;
	}

	//------------------------Set-------------------
	public void setLevelSuivant(String levelSuivant) {
		this.levelSuivant = levelSuivant;
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		
	}
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
	
	}

}
