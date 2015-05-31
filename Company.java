import java.util.HashMap;
import java.util.Map;


public abstract class Company {
	private String companyName;
	private Map<String,Trip> trips = new HashMap<String,Trip>();
	
	public Company(String name){
		companyName = name;
	}
	
	public String getCompany(){
		return companyName;
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
	
	public Map<String,Trip> getTrips(){
		return trips;
	}
	
	public void displayDetails(){
		System.out.println("  " + companyName + ":");
		for(Trip trip: trips.values()){
			trip.diplayDetails();
		}
	}
	
	public void findAvailable(){
		System.out.println("  " + companyName + ":");
		if (trips.isEmpty()){
			System.out.println("\tnone");
		}else{
			for(Trip trip: trips.values()){
				trip.findAvailable();
			}
		}
	}
	

}
