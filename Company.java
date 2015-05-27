import java.util.HashMap;


public abstract class Company {
	private String companyName;
	private HashMap<String,Trip> trips = new HashMap<String,Trip>();
	
	public Company(String name){
		companyName = name;
	}
	

	public void addTrip(Trip trip){
		String tripID = trip.getID();
		if(!trips.containsKey(tripID)){
			trips.put(tripID, trip);
		}else{
			System.err.println("Error: tripID already exist");
		}
	}
	
	public Trip getTrip(String ID){
		if(trips.containsKey(ID)){
			return trips.get(ID);
		}else{
			return null;
		}
	}
	

}
