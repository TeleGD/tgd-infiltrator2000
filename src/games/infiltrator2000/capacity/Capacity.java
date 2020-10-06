package games.infiltrator2000.capacity;

import org.newdawn.slick.Image;

public interface Capacity {
	public void action(); //Peut prendre en compte les x et y du perso et une direction
	public Image getImage();
	public String getName();
	public String getDescription();
	public double getRemainingTime();

}
