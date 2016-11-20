package fr.util;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Chrono {
	
	private long time;
	private long debutPause;
	private long chrono;
	private boolean go;
	private boolean pause;
	
	public Chrono(){
		start();
	}

	public void start(){
		time = System.currentTimeMillis();
		debutPause = 0;
		chrono = 0;
		go = true;
	}
	
	public void pause(){
		debutPause = System.currentTimeMillis();
		pause = true;
	}
	
	public void resume(){
		time = time +(System.currentTimeMillis()-debutPause);
		pause = false;
	}
	
	public void stop(){
		go = false;
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException{
		arg2.drawString(""+(chrono/60000)+":"+(chrono%60000)/1000+":"+(int)Math.floor((chrono%1000)/100), 600, 20);
		//System.out.println(""+(chrono/60000)+":"+(chrono%60000)/1000+":"+chrono%1000) ;
	}
	
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		if (go && !pause) chrono = System.currentTimeMillis()-time;
	}
	
	public long getTime(){
		return chrono;
	}
	
}
