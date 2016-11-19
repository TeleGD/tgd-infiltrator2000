package entity.circle;

public class EndLevel extends Item {
	
	protected String levelSuivant;

	public EndLevel(double x, double y, String lvlSuiv) {
		super(x, y);
		this.levelSuivant=lvlSuiv;
	}

	//-------------------------Get------------------
	public String getLevelSuivant() {
		return levelSuivant;
	}

	//------------------------Set-------------------
	public void setLevelSuivant(String levelSuivant) {
		this.levelSuivant = levelSuivant;
	}
	
	

}
