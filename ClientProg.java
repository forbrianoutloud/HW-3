import java.util.Scanner;

/* 
 * Josh Richmond
 * Brian Lee
 */
public class ClientProg {

	public static void main(String[] args) {
		String[] tempSeq;
		int[] startDate;
		int[] endDate;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter username (Admin/Guest): ");
		
		login: while(true){
			String userName = sc.nextLine();
			if(userName.equals("Admin")){
				System.out.println("Please enter password:");
				while(true){
					String password = sc.nextLine();
					if(password.equals("password")){
						System.out.println("Welcome administrator, Please us the 'help' command for assistance");
						break login;
					}else{
						System.out.println("Invalid password, please try again");
					}
				}
			}else if(userName.equals("Guest")){
				System.out.println("Welcome guest, Please use the 'help' command for assistance");
				break;
			}else{
				System.out.println("Invalid Username, please try again: ");
				
			}
		}
		
		
		/*The following code is taken from the Assignment description */ 
		
		SystemManager res = new SystemManager();
		
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
		
		res.createCruise("Carnival", tempSeq, startDate, endDate, "124");
		
		
		
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
