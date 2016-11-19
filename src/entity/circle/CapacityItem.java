package entity.circle;

public class CapacityItem extends Item {

	protected Capacity capacityGranted;

	public CapacityItem(double x, double y) {
		super(x, y);
	}

	//-------------------------Get-----------------
	public Capacity getCapacityGranted() {
		return capacityGranted;
	}

	//-------------------------Set------------------
	public void setCapacityGranted(Capacity capacityGranted) {
		this.capacityGranted = capacityGranted;
	}
	
	
	
}
