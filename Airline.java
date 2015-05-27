/* 
 * Josh Richmond
 * Brian Lee
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Airline {
	private String airlineName;
	private Map<String,Flight> flights = new HashMap<String,Flight>();
	
	/* Throws exception if airline length is invalid */
	public Airline(String name) throws IOException{
		if(name.length() < 6){
			airlineName = name;
		}else{
			throw new IOException();
		}
	}
	
	/* adds flight to map of flights
	 * throws exception if flight already exist within this airline
	 */
	public void addFlight(Flight flight){
		String flightID = flight.getID();
		if(!flights.containsKey(flightID)){
			flights.put(flightID, flight);
		}else{
			System.err.println("Error: Airline " + airlineName + " already contains flight id " + flightID);
		}
	}
	
	/* returns flight object with corresponding ID
	 * throws exception if id does not exist
	 */
	public Flight getFlight(String ID) throws IOException{
		if(flights.containsKey(ID)){
			return flights.get(ID);
		}else{
			throw new IOException();
		}
	}

	public void getDetails() {
		System.out.println("  Flights:");
		for (Map.Entry<String, Flight> entry : flights.entrySet()){
			entry.getValue().getDetails();
		}
	}
	
	public Map<String,Flight> getFlights(){
		return flights;
	}
	

	
	
}
