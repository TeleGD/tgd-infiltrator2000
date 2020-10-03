package games.guardSlalom.circles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.geom.Circle;

public abstract class Movable extends Circle{

	protected float speedX,speedY;
	protected float newX,newY;


	public  Movable(float centerPointX, float centerPointY, float radius) {
		super(centerPointX, centerPointY, radius);
	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3)  {

	}

	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3){

	}

	public void moveX(int delta){
		this.x+=speedX*delta;
	}

	public void moveY(int delta){
		this.y+=speedY*delta;
	}

}
