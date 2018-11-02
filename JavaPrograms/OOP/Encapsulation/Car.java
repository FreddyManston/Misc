public class Car {
	private String NAME;
	private int TOP_SPEED;

	public Car() {}
	
	public Car(String names, int top_speed) {
		this.NAME = name;
		this.TOP_SPEED = top_speed;
	}

	public String getMake() { return(NAME); }
	public void setMake(String name) { this.NAME = name; }

	public String getTopSpeed() { return(TOP_SPEED); }
	public void setTopSpeed(String speedKMPH) { TOP_SPEED = speedKMPH; }
}
