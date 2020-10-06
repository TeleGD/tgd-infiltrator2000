package games.infiltrator2000.nicotesting;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.state.StateBasedGame;

import games.infiltrator2000.World;
import games.infiltrator2000.circles.Guard;

@SuppressWarnings("serial")
public class GuardTest extends Guard{

	private Link link;
	private int alert;
	private Polygon area;

	public GuardTest(float centerX, float centerY, float radius) {
		super(centerX, centerY, radius);
		link=new Link(World.getPlayer(),this);
		this.area=new Polygon();
		this.area.addPoint(this.getCenterX(), getCenterY());

		float a1 =(float) -Math.tan(Math.PI / 6) ;
		float b1 = (float)-1;
		float a2 = (float)Math.tan(Math.PI / 6) ;
		float b2 = (float)-1;
		area.addPoint(this.getCenterX()+a1*1000, this.getCenterY()+b1*1000);
		area.addPoint(this.getCenterX()+a2*1000, this.getCenterY()+b2*1000);
	}

	public void update(GameContainer arg1, StateBasedGame arg2, int arg3) {
		link.update(arg1, arg2, arg3);
	}

	public void render(GameContainer arg1, StateBasedGame arg2, Graphics arg3) {
		arg3.setColor(Color.magenta);
		arg3.fillOval(x,y,2*radius,2*radius);
		arg3.setColor(Color.white);
		link.render(arg1,arg2,arg3);
		if (alert==1){
			arg3.drawString("attention tu es très proche", this.getX(), this.getY()-30);
		}
		arg3.setColor(Color.green);
		arg3.draw(area);
	}

	public void showAlert() {
		this.alert=1;
	}

	public void stopAlert() {
		this.alert=0;
	}

	public Polygon getArea(){
		return area;
	}
}
