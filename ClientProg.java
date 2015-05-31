import java.io.IOException;
import java.util.Scanner;

/* 
 * Josh Richmond
 * Brian Lee
 */
		
		
		/*The following code is taken from the Assignment description */ 
	public class ClientProg{
		
		public void createStuff(SystemManager res){
			String[] tempSeq;
			int[] startDate;
			int[] endDate;
			res.createAirport("DEN");
			res.createAirport("DFW");	
			res.createAirport("LON");
			res.createAirport("JPN");
			
			res.createSeaport("ss1");
			res.createSeaport("ss2");
			res.createSeaport("ss3");
			
			res.createAirline("DELTA");
			res.createAirline("AMER");
			res.createCruiseline("Carnival");
			res.createCruiseline("cruiseline");
			
			tempSeq = new String[]{"DEN","DFW"};
			startDate = new int[]{12,27,1993};
			endDate = new int[]{12,27,1993};
			
			res.createFlight("DELTA",tempSeq, startDate, endDate, "123");
			
			tempSeq = new String[]{"ss1","ss2","ss3"};
			startDate = new int[]{5,28,2015};
			endDate = new int[]{6,15,2015};		
			
			res.createShip("testShip");		
			res.createShipSection("Carnival", "testShip", 2, 2, Class.couples);
			res.createShipSection("Carnival", "testShip", 8, 2, Class.family);
			
			
			res.createCruiseTrip("Carnival", tempSeq, startDate, endDate, "124","testShip");
			tempSeq = new String[]{"ss1","ss2"};
			startDate = new int[]{6,16,2015};
			endDate = new int[]{6,20,2015};
			res.createCruiseTrip("Carnival", tempSeq, startDate, endDate, "125", "testShip");
			
	
	
	
			res.createFlightSection("DELTA", "123"	, 2, 2, Class.business);
			
	//		try {
	//			res.bookSeat("DELTA", "123",SeatClass.business,1,'A');
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		System.out.println("Error should happen here");
	//		res.bookCabin("Carnival", "testShip",CabinClass.couples,1,'A');

			
	//		res.createAirport("DE");
	//		res.createAirport("DEH");
	//		res.createAirport("DEN"); // Duplicate ID
	//		res.createAirport("NCE");
	//		res.createAirport("falsdkf"); //should raise exception, too long
	//		res.createAirport("DEN"); //Duplicate ID
	//		
	//	
	//		res.createAirline("JET");
	//		res.createCruiseline("carnival");
	//		res.createCruiseline("unsinkable");
	//		res.createAirline("DELTA");//Duplicate ID
	//		res.createAirline("SWEST");
	//		res.createAirline("AMER");//Duplicate ID
	//		res.createAirline("FRONT");
	//		res.createAirline("FRONTIER"); //should raise exception, too longk
			
	//		res.createFlight("DELTA", "DEN", "LON", 20015, 10, 10, "123");
	//		res.createFlight("DELTA", "DEN", "DEH", 2015, 8, 8, "567");
	//		res.createCruiseTrip("carnival", "ss1","ss2",2014,10,10,"123");
	//		res.createFlight("DELTA", "DEN", "NCE", 2015, 9, 8, "567"); // Duplicate ID
	//		res.createFlight("JET", "LON", "DEN", 2015, 5, 7, "123"); // Duplicate ID
	//		res.createFlight("AMER", "DEN", "LON", 2015, 10, 1, "123"); // Duplicate ID
	//		res.createFlight("JET", "DEN", "LON", 2015, 6, 10, "786");
	//		res.createFlight("JETS", "DEN", "LON", 2015, 1, 12, "909");
			
			
			
	//		res.createSection("JET", "123", 2, 2, SeatClass.economy);
	//		res.createSection("JET", "123", 1, 3, SeatClass.economy);
	//		res.createSection("JET", "123", 2, 3, SeatClass.first);
	//		res.createSection("DELTA", "123", 1, 1, SeatClass.business);
	//		res.createSection("DELTA", "123", 1, 2, SeatClass.economy);
	//		res.createSection("SWSERTT", "123", 1, 2, SeatClass.economy);
	//		
	//		res.displaySystemDetails();
	//		
	//		res.findAvailableFlights("DEN", "LON");
	//		res.bookSeat("DELTA", "123", SeatClass.business, 1, 'A');
	//		res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A');
	//		res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'B');
	//		res.bookSeat("DELTA", "123", SeatClass.business, 1, 'A');//Seat already booked
	//		
	//		res.displaySystemDetails();
	//
	//		res.findAvailableFlights("DEN", "LON");
	//
	//		
	//		
	//		
		
		}
	}
