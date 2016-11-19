package entity;

public abstract class Entity {
	
	protected double x;
	protected double y;
	
	
	
	public Entity(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	//-------------------Get-----------------------
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	//--------------------Set-----------------------
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}

}
