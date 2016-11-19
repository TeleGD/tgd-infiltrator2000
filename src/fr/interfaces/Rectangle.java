package fr.interfaces;

import java.util.ArrayList;

public interface Rectangle {
	public double getHeight();
	public double getWidth();
	public void setHeight(double height);
	public void setWidth(double width);
	public ArrayList<ArrayList<Double>> pixelBordeer();
	public ArrayList<ArrayList<Double>> pixelBordeerWithSpeed();
}
