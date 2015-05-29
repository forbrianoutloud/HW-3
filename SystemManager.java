/* 
 * Josh Richmond
 * Brian Lee
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class SystemManager {
	
	Map<String,Port> airports;
	Map<String,Port> seaports;
	Map<String, Company> airlines;
	Map<String, Company> cruiselines;
	Map<String, Ship> ships;
	
	public SystemManager(){
		airports = new HashMap<String,Port>();
		seaports = new HashMap<String,Port>();
		airlines = new HashMap<String,Company>();
		cruiselines = new HashMap<String,Company>();
		ships = new HashMap<String,Ship>();
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
	
	public void createSeaport(String n){
		if(!seaports.containsKey(n)){
			Port seaport = null;
			try {
			    seaport = new Port(n);
				seaports.put(n,seaport);
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
				airline = new Airline(n);
				airlines.put(n,airline);
			
		}else{
			System.err.println("Error: Airline " + n + " already exist");
		}
	}
	
	public void createCruiseline(String n){
		if(!cruiselines.containsKey(n)){
			CruiseLine cruiseline = null;
				cruiseline = new CruiseLine(n);
				cruiselines.put(n,cruiseline);
			
		}else{
			System.err.println("Error: cruiselines " + n + " already exist");
		}
	}
	
	/*Create Flight:
	 * 		Creates a new flight object and adds it to the corresponding airlines flight map.
	 * 		An error is handled if the airline does not exist.
	 */
	public void createFlight(String airlineName, String[] sequence, int[] startDate, int[] endDate, String flID){
		if(airlines.containsKey(airlineName)){
			Trip flight = new Flight(airlineName,sequence, startDate, endDate, flID);
			 airlines.get(airlineName).addTrip(flight);
		}else{
			System.err.println("Error: Cannot create Flight ID:" + flID + " Airline:" + airlineName + " does not exist");
			
		}
	}
	
	public void createCruise(String cruiseName, String[] sequence, int[] startDate, int[] endDate, String ID,String ship){
		Ship tempShip = ships.get(ship).clone();
		if(cruiselines.containsKey(cruiseName)){
			Trip cruise = new CruiseTrip(cruiseName,sequence, startDate, endDate, ID, (Ship) tempShip);
			 cruiselines.get(cruiseName).addTrip(cruise);
		}else{
			System.err.println("Error: Cannot create cruise ID:" + ID + " cruiseline:" + cruiseName + " does not exist");
		}
	}
	
	public void createShip(String shipID){
		if(ships.containsKey(shipID)){
			System.err.println("Error: ship already exists");
		}else{
			Ship ship = new Ship(shipID);
			ships.put(shipID, ship);
		}
	}
	

	
	public void createShipSection(String companyName, String shipID, int rows, int cols, Class cabinClass){
		if(cruiselines.containsKey(companyName)){
			Section shipSection = new CabinSection(companyName,shipID, rows, cols,cabinClass);
			ships.get(shipID).addSection(shipSection);
		}else{
			System.err.println("Error company does not exist");
		}
	}
	
	public void createFlightSection(String companyName, String flightID, int rows, int cols, Class seatClass){
		if(airlines.containsKey(companyName)){
			Section flightSection = new FlightSection(companyName,flightID, rows, cols,seatClass);
			((Flight) airlines.get(companyName).getTrip(flightID)).addSection(flightSection);
		}else{
			System.err.println("Error company does not exist");
		}
	}
	
	public void bookSeat(String company, String flID, Class s, int row, char col) throws IOException{
		if(airlines.containsKey(company)){
			Accommodation seat = new Seat(row,col);
			airlines.get(company).getTrip(flID).getSection(s).bookAccomodation(seat);
		}else{
			System.err.println("error: company does not exist");
		}
	}
	
	public void bookCabin(String company, String tripID, Class c, int row, char col){
		if(cruiselines.containsKey(company)){
			Accommodation cabin = new Cabin(row,col);
			((CruiseTrip) cruiselines.get(company).getTrip(tripID)).getShip().getSection(c).bookAccomodation(cabin);
		}
	}
	
	public void airlineState(){
		System.out.println("Airline Subsystem Information");
		for(Company airline : airlines.values()){
			airline.displayDetails();
		}
	}
	
	public void cruiselineState(){
		System.out.println("Cruisline Substystem Information");
		for (Company cruiseline : cruiselines.values()){
			cruiseline.displayDetails();
		}
	}
	
	public void getAvailableCabins(){
		for(Company c : cruiselines.values()){
			for(Trip t : c.getTrips().values()){
				((CruiseTrip) t).getShip().displayAvailable();
			}
		}
	}
	
			
	/*Create Section:SeatClass
	 * 		Creates a new flightsection object and adds section to a specific flight
	 * 		An error is handled if the flight/airline given does not exist or the section is invalid
	 */
	
//	public void createSection(String air, String flID, int rows, int cols, SeatClass s){
//		if(airlines.containsKey(air)){
//			FlightSection section;
//			try {
//				section = new FlightSection(air,flID,rows,cols,s);
//
//					airlines.get(air).getTrip(flID).addSection(section);
//
//			} catch (IOException e1) {
//				System.err.println("Error: Cannot add Section to Flight:" + flID + " on Airline:" + air + "Invalid section size.");
//			}
//		}else{
//			System.err.println("Error: Cannot add section to Flight, Airline " + air + " does not exist");
//		}
//	}
//	
	/*find available flights
	 * 		Loops through all flights of each airline, if they match the 
	 * 		orig and dest and they have available seats, they are added to a
	 * 		list of available flights.
	 * 		
	 * 		The method then prints out the available flights
	 */
//	public void findAvailableFlights(String orig, String dest){
//		List<Flight> availableFlights = new ArrayList<Flight>();
//		for(Airline airL : airlines.values()){
//			Map<String,Flight> flights = airL.getFlights();
//			for(Flight f : flights.values()){
//				if((f.getOrig() == orig) && (f.getDest() == dest)){
//					Map<SeatClass,FlightSection> section = f.getSections();
//					sectionLoop:
//					for(FlightSection sec : section.values()){
//						if(sec.hasAvailableSeats()){
//							availableFlights.add(f);
//							break sectionLoop;
//						}
//					}
//				}
//			}
//		}
//		
//		System.out.println();
//		if(!availableFlights.isEmpty()){
//			System.out.println("The following flights from " + orig + " to " + dest + " are available:");
//			for(Flight af : availableFlights){
//				System.out.println("     Airline:" + af.getAirline() + "  " +  "Flight ID:" + af.getID());
//			}
//		}else{
//			System.out.println("No Available flights from " + orig + " to " + dest);
//		}
//	}
//	
	
	/*Book seat:
	 * 		books a seat in a specific section on a specific flight
	 * 		An error is handled if the airline/flight/section does not exist or if the seat is already booked.
	 */
//	public void bookSeat(String air,String fl, SeatClass s, int row, char col){
//		if (airlines.containsKey(air)){
//			try {
//				Flight flight = airlines.get(air).getFlight(fl);
//				try{
//					FlightSection section = flight.getSection(s);
//					Seat seat = new Seat(row, col);
//					try{
//						section.bookSeat(seat);
//					} catch (IOException e3){
//						System.err.println("Error: Cannot book seat for Flight:" + fl + " on Airline:" + air + " Seat is already booked");
//					}
//				} catch (IOException e2) {
//					System.err.println("Error: Cannot book seat for Flight:" + fl + " on Airline:" + air + " Section:" + s.toString() + " doesn't exist");
//				}
//			} catch (IOException e) {
//				System.err.println("Error: Cannot book seat for Flight:" + fl + " on Airline:" + air + " Flight does not exist");
//			}
//		}else{
//			System.err.println("Error: Cannot book seat for Airline:" + air + " on Flight:" + fl + " , airline does not exist");
//		}
//	
//	}
//	
	/*display system details:
	 * 		Prints out all airports and class getDetails() on each airline, which will
	 * 		display in depth information on flights for each airline.
	 */
//	public void displaySystemDetails(){
//		System.out.println();
//		System.out.println("Airports:");
//		for (Map.Entry<String, Port> entry : airports.entrySet()) {
//			System.out.println(" " + entry.getKey());
//		}
//		System.out.println();
//		System.out.println("Airlines:");
//		for (Map.Entry<String, Airline> entry : airlines.entrySet()) {
//			System.out.println(" " + entry.getKey() + ":");
//			entry.getValue().getDetails();
//		}
//	}
	
	
}
