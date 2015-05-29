
public class CruiseTrip extends Trip{
	private Ship ship;
	public CruiseTrip(String companyName, String[] sequence, int[] startDate, int[] endDate, String tripID, Ship ship) {
		super(companyName, sequence, startDate, endDate, tripID);
		addShip(ship);
	}
	
	public void addShip(Ship ship){
		this.ship = ship;
	}
	
	public Ship getShip(){
		return ship;
	}
	
}
