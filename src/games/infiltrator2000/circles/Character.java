package games.infiltrator2000.circles;

public abstract class Character extends Movable{

	public Character(float centerPointX, float centerPointY, float radius) {
		super(centerPointX, centerPointY, radius);
	}

	public int getDirection(){
		if ((this.speedX>0)&&(this.speedY==0)){
			return 0;
		}
		if  ((this.speedX>0)&&(this.speedY>0)){
			return 1;
		}
		if  ((this.speedX==0)&&(this.speedY>0)){
			return 2;
		}
		if  ((this.speedX<0)&&(this.speedY>0)){
			return 3;
		}
		if  ((this.speedX<0)&&(this.speedY==0)){
			return 4;
		}
		if  ((this.speedX<0)&&(this.speedY<0)){
			return 5;
		}
		if  ((this.speedX==0)&&(this.speedY<0)){
			return 6;
		}
		if  ((this.speedX>0)&&(this.speedY<0)){
			return 7;
		}else { return -1;}
	}

}
