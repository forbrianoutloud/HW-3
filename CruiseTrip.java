
public class CruiseTrip extends Trip{
	Ship ship;
	public CruiseTrip(String companyName, String[] sequence, int[] startDate, int[] endDate, String tripID, Ship ship) {
		super(companyName, sequence, startDate, endDate, tripID);
		addShip(ship);
	}
	
	public void addShip(Ship ship){
		this.ship = ship;
		for(Section s : ship.getSections().values()){
			Section temp = new CabinSection(s.getCompanyName(),s.getID(),s.getRows(),s.getCols(),  s.getclass());
			sections.put( s.getclass(), temp);
		}
	}
	
	public Ship getShip(){
		return ship;
	}
	
}
