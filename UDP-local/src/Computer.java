
public class Computer {

	private int delay;
	private double heatPercentage;
	private double heatProduced;
	private double coolingEquipment;
	private boolean solidState;
	private boolean on;
	private String ip;
	private String location;
	
	public Computer(){
		delay = 100;
		heatProduced = 8.8;
		coolingEquipment = 7.9;
		solidState = false;
		on = true;
		ip = generateRandomIP();
		location = Location.getLocation();
		
	}
	
	public static String generateRandomIP(){
		int f = (int) ((256-100)*Math.random() + 100);
		int s = (int) ((256-100)*Math.random() + 100);
		int t = (int) (10 * Math.random());
		int fo = (int) (256 * Math.random());
		
		return String.format("%d.%d.%d.%d", f, s, t, fo);
	}
	
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public double getHeatPercentage() {
		return heatPercentage;
	}
	public void setHeatPercentage(double heatPercentage) {
		this.heatPercentage = heatPercentage;
	}
	public double getHeatProduced() {
		return heatProduced;
	}
	public void setHeatProduced(int heatProduced) {
		this.heatProduced = heatProduced;
	}
	public double getCoolingEquipment() {
		return coolingEquipment;
	}
	public void setCoolingEquipment(int coolingEqupment) {
		this.coolingEquipment = coolingEqupment;
	}
	public boolean isSolidState() {
		return solidState;
	}
	public void setSolidState(boolean solidState) {
		this.solidState = solidState;
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
}
