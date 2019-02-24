package fr.circles;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import fr.basic.World;
import fr.util.Collisions;

public class Projectile extends MovableCircle {

	protected boolean enVie;

	public Projectile(double x, double y, double sx, double sy) {
		super(x, y, sx, sy);
		this.enVie=true;
	}

	//get
	public boolean isEnVie() {
		return enVie;
	}

	//set
	public void setEnVie(boolean enVie) {
		this.enVie = enVie;
	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		moveX(1);
		moveY(1);
		for (int i = 0; i < World.getGuards().size(); i++) {
			if (Collisions.isCollision(this, World.getGuards().get(i))){
				World.getGuards().get(i).setEnVie(false);
				for (int j = 0; j < World.getProjectiles().size(); j++) {
					this.equals(World.getProjectiles().get(i));
				}
			}
		}
	}

	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		float radius=1;
		super.render(arg1, arg2, arg3);
		arg3.setColor(Color.yellow);
		arg3.fillOval((float)(this.x-radius), (float)(y-radius), (float)(2*radius), (float)(2*radius));
	}



}
