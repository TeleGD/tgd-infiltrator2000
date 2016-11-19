package fr.util;

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
	
	public void render(){
		System.out.println("Temps ecoule = " + chrono + " ms") ;
	}
	
	public void update(){
		if (go && !pause) chrono = System.currentTimeMillis()-time;
	}
}
