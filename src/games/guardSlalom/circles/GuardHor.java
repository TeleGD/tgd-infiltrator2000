package games.guardSlalom.circles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GuardHor extends Guard{




	public GuardHor(float x, float y, float radius) {
		super(x, y,radius);
		this.speedX=(float)0.4;
	}
	public void horizontalMove(){
		if (this.x<=xOrigin-500){
			this.speedX=(float) 0.4;
		}
		if (this.x>=xOrigin+500){
			this.speedX=(float) -0.4;
		}
	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) {
		horizontalMove();
		moveX(arg3);
		super.update(arg1, arg2, arg3);
	}

	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) {
		super.render(arg1, arg2, arg3);
	}
}
