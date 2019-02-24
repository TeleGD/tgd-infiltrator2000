package fr.circles;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.World;

public class GuardSquare extends Guard {

	private boolean done;

	public GuardSquare(float x, float y, float radius) {
		super(x, y, radius);
		this.xOrigin=this.x+150;
		this.yOrigin=this.y+150;
		this.speedX = (float)0.4;
		this.speedY=0;
	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException {
		super.update(arg1, arg2, arg3);
		move();
		moveX(arg3);
		moveY(arg3);
	}

	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException {
		super.render(arg1, arg2, arg3);
		arg3.drawString("speedX= "+speedX+"\n speedY= "+speedY, 800, 600);
	}

	public void move() {
		if ((this.x>this.xOrigin+100) && (this.y>this.yOrigin+100)){
			this.speedX=(float)-0.4;
			this.speedY=0;
		}

		if ((this.x>this.xOrigin+100) && (this.y<this.yOrigin-100)){
			this.speedX=(float)-0;
			this.speedY=(float)0.4;
		}

		if ((this.x<this.xOrigin-100) && (this.y>this.yOrigin+100)){
			this.speedX=(float)-0;
			this.speedY=(float)-0.4;
		}
		if ((this.x<this.xOrigin-100) && (this.y<this.yOrigin-100)){
			this.speedX=(float)0.4;
			this.speedY=0;
		}
	}


}
