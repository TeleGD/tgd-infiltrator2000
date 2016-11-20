package fr.vision;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.StateBasedGame;
import entity.movable.circle.Character;

public class Areabis extends Polygon{

	private double a1,b1,a2,b2;
	private Character character;
	private double x,y;
	
	
	public Areabis(Character character){
		this.character=character;
		this.addPoint((float)character.getX(), (float)character.getY());
		this.addPoint((float)(character.getX()+character.getRadius()*Math.cos(Math.PI/3)), (float) ((float) (character.getY())+character.getRadius()*Math.sin(Math.PI/3)));
		this.addPoint((float)(character.getX()+character.getRadius()*Math.cos(Math.PI/3)), (float) ((float) (character.getY())+character.getRadius()*Math.sin(-Math.PI/3)));
		
		
	}
	
	public Areabis(double x,double y,Character character){
		this.character=character;
		this.x=x;
		this.y=y;
		this.a1=character.getRadius()*Math.cos(Math.PI/6);
		this.a2=a1;
		this.b1=character.getRadius()*Math.sin(Math.PI/6);
		this.b2=-character.getRadius()*Math.sin(Math.PI/6);
	}
	
	
	public void render( GameContainer arg1, StateBasedGame arg2, Graphics arg3) throws SlickException{
		arg3.setColor(Color.red);
		arg3.drawLine((float)character.getX(), (float)character.getY(), (float)(character.getX()+a1), (float)(character.getY()+b1));
		arg3.drawLine((float)character.getX(), (float)character.getY(), (float)(character.getX()+a2), (float)(character.getY()+b2));
	}
	
	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) throws SlickException  {
		switch ( this.character.getDirection()){
		case 0:
			a1=100;
			a2=a1;
			b1=-Math.tan(Math.PI/6)*100;
			b2=Math.tan(Math.PI/6)*100;
		break;
		case 1:
			a1=100*Math.cos(Math.PI/4-Math.PI/6)/Math.cos(Math.PI/6);
			b1=100*Math.sin(Math.PI/4-Math.PI/6)/Math.cos(Math.PI/6);
			a2=100*Math.cos(Math.PI/4+Math.PI/6)/Math.cos(Math.PI/6);
			b2=100*Math.sin(Math.PI/4+Math.PI/6)/Math.cos(Math.PI/6);
			break;
		case 2:
			a1=Math.tan(Math.PI/6)*100;
			b1=100;
			a2=-Math.tan(Math.PI/6)*100;
			b2=100;
			break;
		case 3:
			a1=-100*Math.cos(Math.PI/4-Math.PI/6)/Math.cos(Math.PI/6);
			b1=100*Math.sin(Math.PI/4-Math.PI/6)/Math.cos(Math.PI/6);
			a2=-100*Math.cos(Math.PI/4+Math.PI/6)/Math.cos(Math.PI/6);
			b2=100*Math.sin(Math.PI/4+Math.PI/6)/Math.cos(Math.PI/6);
			break;
		case 4:
			a1=-100;
			a2=a1;
			b1=Math.tan(Math.PI/6)*100;
			b2=-Math.tan(Math.PI/6)*100;
			break;
		case 5:
			a1=-100*Math.cos(Math.PI/4-Math.PI/6)/Math.cos(Math.PI/6);
			b1=-100*Math.sin(Math.PI/4-Math.PI/6)/Math.cos(Math.PI/6);
			a2=-100*Math.cos(Math.PI/4+Math.PI/6)/Math.cos(Math.PI/6);
			b2=-100*Math.sin(Math.PI/4+Math.PI/6)/Math.cos(Math.PI/6);
			break;
		case 6:
			a1=-Math.tan(Math.PI/6)*100;
			b1=-100;
			a2=Math.tan(Math.PI/6)*100;
			b2=-100;
			break;
		case 7:
			a1=100*Math.cos(Math.PI/4-Math.PI/6)/Math.cos(Math.PI/6);
			b1=-100*Math.sin(Math.PI/4-Math.PI/6)/Math.cos(Math.PI/6);
			a2=100*Math.cos(Math.PI/4+Math.PI/6)/Math.cos(Math.PI/6);
			b2=-100*Math.sin(Math.PI/4+Math.PI/6)/Math.cos(Math.PI/6);
			break;
		}
		
	}
}
