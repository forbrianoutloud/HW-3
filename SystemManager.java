/* 
 * Josh Richmond
 * Brian Lee
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SystemManager {
	
	Map<String,Port> airports;
	Map<String,Port> seaports;
	Map<String,Airline> airlines;
	
	public SystemManager(){
		airports = new HashMap<String,Port>();
		seaports = new HashMap<String,Port>();
		airlines = new HashMap<String,Airline>();
	}
	
	/*Create Airport:
	 * 		Takes in a name of an airport and checks to see if that Airport already exists,
	 * 	    If it doesn't a new airport object is created and added to airports map.
	 * 		An error is thrown if the airport name is not 3 characters or already exists.
	 */
	public void createAirport(String n){
		if(!airports.containsKey(n)){
			Port airport = null;
			try {
				airport = new Port(n);
				airports.put(n,airport);
			} catch (IOException e) {
				System.err.println("Error: Failed to Create Airport " + n + ", Incorrect length");
			}
			
		}else{
			System.err.println("Error: Airport " + n + " already exist");
		}
	}
	
	/*Create Airline:
	 * 	  	Takes in a name of an airline.
	 * 		An error is handled if the name is over 7 characters or already exists
	 * 		If there are no errors, an airline is created and added to the airlines map
	 */
	public void createAirline(String n){
		if(!airlines.containsKey(n)){
			Airline airline = null;
			try {
				airline = new Airline(n);
				airlines.put(n,airline);
			} catch (IOException e) {
				System.err.println("Error: Failed to Create Airline " + n + ", Incorrect length");
			}
			
		}else{
			System.err.println("Error: Airline " + n + " already exist");
		}
	}
	
	/*Create Flight:
	 * 		Creates a new flight object and adds it to the corresponding airlines flight map.
	 * 		An error is handled if the airline does not exist.
	 */
	public void createFlight(String airlineName, String orig, String dest, int year, int month, int day, String id){
		if(airlines.containsKey(airlineName)){
			Flight flight = new Flight(airlineName, orig, dest, year, month, day, id);
			airlines.get(airlineName).addFlight(flight);
		}else{
			System.err.println("Error: Cannot create Flight ID:" + id + " Airline:" + airlineName + " does not exist");
			
		}
	}
	
	/*Create Section:
	 * 		Creates a new flightsection object and adds section to a specific flight
	 * 		An error is handled if the flight/airline given does not exist or the section is invalid
	 */
	public void createSection(String air, String flID, int rows, int cols, SeatClass s){
		if(airlines.containsKey(air)){
			FlightSection section;
			try {
				section = new FlightSection(air,flID,rows,cols,s);
				try {
					airlines.get(air).getFlight(flID).addSection(section);
				} catch (IOException e) {
					System.err.println("Error: Cannot add Section to Flight:" + flID + " on Airline:" + air + " Flight does not exist");
				}
			} catch (IOException e1) {
				System.err.println("Error: Cannot add Section to Flight:" + flID + " on Airline:" + air + "Invalid section size.");
			}
		}else{
			System.err.println("Error: Cannot add section to Flight, Airline " + air + " does not exist");
		}
	}
	
	/*find available flights
	 * 		Loops through all flights of each airline, if they match the 
	 * 		orig and dest and they have available seats, they are added to a
	 * 		list of available flights.
	 * 		
	 * 		The method then prints out the available flights
	 */
	public void findAvailableFlights(String orig, String dest){
		List<Flight> availableFlights = new ArrayList<Flight>();
		for(Airline airL : airlines.values()){
			Map<String,Flight> flights = airL.getFlights();
			for(Flight f : flights.values()){
				if((f.getOrig() == orig) && (f.getDest() == dest)){
					Map<SeatClass,FlightSection> section = f.getSections();
					sectionLoop:
					for(FlightSection sec : section.values()){
						if(sec.hasAvailableSeats()){
							availableFlights.add(f);
							break sectionLoop;
						}
					}
				}
			}
		}
		
		System.out.println();
		if(!availableFlights.isEmpty()){
			System.out.println("The following flights from " + orig + " to " + dest + " are available:");
			for(Flight af : availableFlights){
				System.out.println("     Airline:" + af.getAirline() + "  " +  "Flight ID:" + af.getID());
			}
		}else{
			System.out.println("No Available flights from " + orig + " to " + dest);
		}
	}
	
	
	/*Book seat:
	 * 		books a seat in a specific section on a specific flight
	 * 		An error is handled if the airline/flight/section does not exist or if the seat is already booked.
	 */
	public void bookSeat(String air,String fl, SeatClass s, int row, char col){
		if (airlines.containsKey(air)){
			try {
				Flight flight = airlines.get(air).getFlight(fl);
				try{
					FlightSection section = flight.getSection(s);
					Seat seat = new Seat(row, col);
					try{
						section.book(seat);
					} catch (IOException e3){
						System.err.println("Error: Cannot book seat for Flight:" + fl + " on Airline:" + air + " Seat is already booked");
					}
				} catch (IOException e2) {
					System.err.println("Error: Cannot book seat for Flight:" + fl + " on Airline:" + air + " Section:" + s.toString() + " doesn't exist");
				}
			} catch (IOException e) {
				System.err.println("Error: Cannot book seat for Flight:" + fl + " on Airline:" + air + " Flight does not exist");
			}
		}else{
			System.err.println("Error: Cannot book seat for Airline:" + air + " on Flight:" + fl + " , airline does not exist");
		}
	
	}
	
	/*display system details:
	 * 		Prints out all airports and class getDetails() on each airline, which will
	 * 		display in depth information on flights for each airline.
	 */
	public void displaySystemDetails(){
		System.out.println();
		System.out.println("Airports:");
		for (Map.Entry<String, Port> entry : airports.entrySet()) {
			System.out.println(" " + entry.getKey());
		}
		System.out.println();
		System.out.println("Airlines:");
		for (Map.Entry<String, Airline> entry : airlines.entrySet()) {
			System.out.println(" " + entry.getKey() + ":");
			entry.getValue().getDetails();
		}
	}
	
	
}
