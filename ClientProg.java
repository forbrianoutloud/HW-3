import java.io.IOException;
import java.util.Scanner;

/* 
 * Josh Richmond
 * Brian Lee
 */
public class ClientProg {
	public enum User{
		Guest,Admin;
	}

	public static void main(String[] args) {
		
		String[] tempSeq;
		int[] startDate;
		int[] endDate;
		User user;
		Scanner sc = new Scanner(System.in);
		SystemManager res = new SystemManager();
		
		System.out.println("Please enter username (Admin/Guest): ");
		
		login: while(true){
			String userName = sc.nextLine();
			if(userName.equals("Admin")){
				System.out.println("Please enter password:");
				while(true){
					String password = sc.nextLine();
					if(password.equals("password")){
						System.out.println("Welcome administrator, Please us the 'help' command for assistance");
						user = User.Admin;
						break login;
					}else{
						System.out.println("Invalid password, please try again");
					}
				}
			}else if(userName.equals("Guest")){
				System.out.println("Welcome guest, Please use the 'help' command for assistance");
				user = User.Guest;
				break;
			}else{
				System.out.println("Invalid Username, please try again: ");
				
			}
		}
		

		
		
		/*The following code is taken from the Assignment description */ 
		

		
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
		res.createCruiseline("cruisline");
		
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
		
		
		res.createCruise("Carnival", tempSeq, startDate, endDate, "124","testShip");
		tempSeq = new String[]{"ss1","ss2"};
		startDate = new int[]{6,16,2015};
		endDate = new int[]{6,20,2015};
		res.createCruise("Carnival", tempSeq, startDate, endDate, "125", "testShip");
		



		res.createFlightSection("DELTA", "123"	, 2, 2, Class.business);
		
//		try {
//			res.bookSeat("DELTA", "123",SeatClass.business,1,'A');
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Error should happen here");
//		res.bookCabin("Carnival", "testShip",CabinClass.couples,1,'A');
	

		
		res.airlineState();
		res.cruiselineState();
		res.getAvailableCabins();
		
		if(user.equals(User.Guest)){
			String company;
			String ID;
			String c;
			Class cabin = null;
			Class seat = null;
			int row;
			String col;
			
			test : while(true){
				System.out.println("Please enter command:");
				String cmd = sc.nextLine();
				
				switch(cmd){
				case "help":
					System.out.println("Here is a list of commands:");
					System.out.println(" 'Find Seat'   Finds all available seats on a flight.");
					System.out.println(" 'Book Seat'   Books an available seat on a flight.");
					System.out.println(" 'Find Cabin'  Finds all available cabins on a cruise.");
					System.out.println(" 'Book Cabin'  Books an available cabin on a cruise.");
					break;
				case "Find Seat":
					res.getAvailableSeats();
					break;
				case "Book Seat":
					System.out.println("Please enter name of airline:");
					company = sc.next();
					System.out.println("Please enter flight id:");
					ID = sc.next();
					System.out.println("Please enter seat class (Economy,Business,First)");
					c = sc .next();
					switch(c){
					case "Economy":
						seat = Class.economy;
						break;
					case "Business":
						seat = Class.business;
						break;
					case "First":
						seat = Class.first;
						break;
					default:
						System.err.println("Invalid seat class");
						break;
					}
					System.out.println("Please enter row");
					row = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter col");
					col = sc.nextLine();
					try {
						res.bookSeat(company, ID, seat, row, col.charAt(0));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "Find Cabin":
					res.getAvailableCabins();
					break;
				case "Book Cabin":
					System.out.println("Please enter name of cruiseline: ");
					company = sc.nextLine();
					System.out.println("Please enter trip id: ");
					ID = sc.nextLine();
					System.out.println("Please enter cabin class (Family/Deluxe Family/Couples/Deluxe Couples)");
					c = sc.nextLine();
					switch(c){
					case "Family":
						cabin = Class.family;
						break;
					case "Deluxe Family":
						cabin = Class.deluxeFamily;
						break;
					case "Couples":
						cabin = Class.couples;
					case "Deluxe Couples":
						break;
					default:
						System.err.println("Invalid entry");
					}
					System.out.println("Please enter row");
					row = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter col");
					col = sc.nextLine();
					res.bookCabin(company,ID,cabin,row,col.charAt(0));
					break;
				default:
					System.out.println("no such command");
					break;
				}
			}
		}
		
		
		
		
		
		
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
