import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UI {

	
	public enum User{
		Guest,Admin;
	}
	
	private static void testStuff(SystemManager res){
		ClientProg cp = new ClientProg();
		cp.createStuff(res);
		return;
	}
	
	public static void main(String[] args){
		User user;
		Scanner sc = new Scanner(System.in);
		SystemManager res = new SystemManager();
		
		testStuff(res); // add a bunch of data for testing
		
		System.out.println("Please enter username (Admin/Guest): ");
		
		login: while(true){
			String userName = sc.nextLine().toLowerCase();
			if(userName.equals("admin")){
				System.out.println("Please enter password:");
				while(true){
					String password = sc.nextLine();
					if(password.equals("password")){
						System.out.println("Welcome administrator, Please use the 'help' command for assistance");
						user = User.Admin;
						break login;
					}else{
						System.out.println("Invalid password, please try again");
					}
				}
			}else if(userName.equals("guest")){
				System.out.println("Welcome guest, Please use the 'help' command for assistance");
				user = User.Guest;
				break;
			}else{
				System.out.println("Invalid Username, please try again: ");
				
			}
		}
		
		if(user.equals(User.Guest)){ // Guest interface
			String companyName;
			String ID;
			String c;
			Class cabin = null;
			Class seat = null;
			Company company;
			int row;
			String col;
			
			cmd: while(true){
				System.out.println("Please enter command:");
				String cmd = sc.nextLine().toLowerCase();
				switch(cmd){
				case "help":
					System.out.println("Here is a list of commands:");
					System.out.println(" (1) 'Find Seat'\tFinds all available seats on a flight.");
					System.out.println(" (2) 'Book Seat'\tBooks an available seat on a flight.");
					System.out.println(" (3) 'Find Cabin'\tFinds all available cabins on a cruise.");
					System.out.println(" (4) 'Book Cabin'\tBooks an available cabin on a cruise.");
					continue cmd;
				case "1":
				case "find seat":
					res.getAvailableSeats();
					continue cmd;
				case "2":
				case "book seat":
					System.out.println("Please enter name of airline:");
					companyName = sc.next();
					company = res.getAirline(companyName);
					if (company == null){
						System.err.println("Airline " + companyName + " does not exist");
						System.err.flush();
						sc.nextLine(); // because java is frustrating
						continue cmd;
					}
					System.out.println("Please enter flight id:");
					ID = sc.next();
					if (!res.doesTripExist(company, ID)){
						System.err.println("Trip " + ID + " does not exist");
						System.err.flush();
						sc.nextLine(); // because java is frustrating
						continue cmd;
					}
					System.out.println("Please enter seat class \n\t(1) Economy\n\t(2) Business\n\t(3) First");
					c = sc.next().toLowerCase();
					switch(c){
					case "1":
					case "economy":
						seat = Class.economy;
						break;
					case "2":
					case "business":
						seat = Class.business;
						break;
					case "3":
					case "first":
						seat = Class.first;
						break;
					default:
						System.err.println("Invalid seat class");
						continue cmd;
					}
					System.out.println("Please enter row");
					row = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter col");
					col = sc.nextLine();
					try {
						res.bookSeat(companyName, ID, seat, row, col.charAt(0));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue cmd;
				case "3":
				case "find cabin":
					res.getAvailableCabins();
					continue cmd;
				case "4":
				case "book cabin":
					System.out.println("Please enter name of cruiseline: ");
					companyName = sc.nextLine();
					company = res.getCruiseline(companyName);
					if (company == null){
						System.err.println("Cruiseline " + companyName + " does not exist");
						System.err.flush();
						sc.nextLine(); // because java is frustrating
						continue cmd;
					}
					System.out.println("Please enter trip id: ");
					ID = sc.nextLine();
					if (!res.doesTripExist(company, ID)){
						System.err.println("Trip " + ID + " does not exist");
						System.err.flush();
						sc.nextLine(); // because java is frustrating
						continue cmd;
					}
					System.out.println("Please enter cabin class \n\t(1) Family\n\t(2) Deluxe Family\n\t(3) Couples\n\t(4) Deluxe Couples)");
					c = sc.nextLine().toLowerCase();
					switch(c){
					case "1":
					case "family":
						cabin = Class.family;
						break;
					case "2":
					case "deluxe family":
						cabin = Class.deluxeFamily;
						break;
					case "3":
					case "couples":
						cabin = Class.couples;
					case "4":
					case "deluxe couples":
						cabin = Class.deluxeCouples;
						break;
					default:
						System.err.println("Invalid entry");
						continue cmd;
					}
					System.out.println("Please enter row");
					row = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter col");
					col = sc.nextLine();
					res.bookCabin(companyName,ID,cabin,row,col.charAt(0));
					continue cmd;
				default:
					System.out.println("no such command");
					continue cmd;
				}
			}
		}
		
		if(user.equals(User.Admin)){ // Guest interface
			cmd: while(true){
				System.out.println("Please enter command:");
				String cmd = sc.nextLine().toLowerCase();
				switch(cmd){
				case "help":
					System.out.println("Here is a list of commands:");
					System.out.println(" (1) 'Create'\tCreate airports, ports, airlines, cruises, flights, trips, ships, flight sections, or cabin sections.");
					System.out.println(" (2) 'Display Details'\tPrint the current state of the airline subsystem or cruise subsystem.");
					continue cmd;
				case "1":
				case "create":
					System.out.println("Which subsystem?");
					System.out.println("\t(1) Airline");
					System.out.println("\t(2) Cruise");
					cmd = sc.nextLine().toLowerCase();
					switch(cmd){
						case "1":
						case "airline":
							System.out.println("What would you like to create?");
							System.out.println("\t(1) Airport");
							System.out.println("\t(2) Airline");
							System.out.println("\t(3) Flight");
							System.out.println("\t(4) Flight Section");
							cmd = sc.nextLine().toLowerCase();
							switch(cmd){
								case "1":
								case "airport":
									String airport = sc.nextLine();
									res.createAirport(airport);
									continue cmd;
								case "2":
								case "airline":
									String airline = sc.nextLine();
									res.createAirline(airline);
									continue cmd;
								case "3":
								case "flight":
									String airlineName;
									String[] airports = new String[2]; // start and end
									int[] startDate = new int[3];
									int[] endDate = new int[3];
									String flID;
									System.out.println("Airline for flight:");
									airlineName = sc.nextLine();
									if (res.getAirline(airlineName) == null){
										System.err.println("Airline doesn't exist");
										System.err.flush();
										continue cmd;
									}
									System.out.println("Start airport:");
									airports[0] = sc.nextLine();
									if (!res.doesAirportExist(airports[0])){
										System.err.println("Airport doesn't exist.");
										System.err.flush();
										continue cmd;
									}
									System.out.println("End airport:");
									airports[1] = sc.nextLine();
									if (!res.doesAirportExist(airports[1])){
										System.err.println("Airport doesn't exist.");
										System.err.flush();
										continue cmd;
									}
									System.out.println("Start date");
									System.out.println("\tMonth:");
									startDate[0] = Integer.parseInt(sc.nextLine());
									if (startDate[0] > 12 || startDate[0] < 1){
										System.err.println("Invalid month");
										System.err.flush();
										continue cmd;
									}
									System.out.println("\tDay:");
									startDate[1] = Integer.parseInt(sc.nextLine());
									if (startDate[1] > 31 || startDate[1] < 1){
										System.err.println("Invalid day");
										System.err.flush();
										continue cmd;
									}
									System.out.println("\tYear:");
									startDate[2] = Integer.parseInt(sc.nextLine());
									System.out.println("End date");
									System.out.println("\tMonth:");
									endDate[0] = Integer.parseInt(sc.nextLine());
									if (endDate[0] > 12 || endDate[0] < 1){
										System.err.println("Invalid month");
										System.err.flush();
										continue cmd;
									}
									System.out.println("\tDay:");
									endDate[1] = Integer.parseInt(sc.nextLine());
									if (endDate[1] > 31 || endDate[1] < 1){
										System.err.println("Invalid day");
										System.err.flush();
										continue cmd;
									}
									System.out.println("\tYear:");
									endDate[2] = Integer.parseInt(sc.nextLine());
									System.out.println("Flight ID:");
									flID = sc.nextLine();
									res.createFlight(airlineName, airports, startDate, endDate, flID);
									continue cmd;
								case "4":
								case "flight Section":
									String companyName;
									String flightID;
									int rows; 
									int cols;
									Class seatClass;
									System.out.println("Enter Airline Name:");
									companyName = sc.nextLine();
									Company c = res.getAirline(companyName);
									if (c == null){
										System.err.println("Airline "+ companyName +" does not exist");
										System.err.flush();
										continue cmd;
									}
									System.out.println("Flight ID:");
									flightID = sc.nextLine();
									if (!res.doesTripExist(c, flightID)){
										System.err.println("Flight "+ flightID +" does not exist");
										System.err.flush();
										continue cmd;
									}
									System.out.println("Number of rows:");
									rows = Integer.parseInt(sc.nextLine());
									System.out.println("Number of cols:");
									cols = Integer.parseInt(sc.nextLine());
									System.out.println("Seat Class:");
									System.out.println("\t(1) First");
									System.out.println("\t(2) Economy");
									System.out.println("\t(3) Business");
									String sclass = sc.nextLine().toLowerCase();
									switch(sclass){
										case "1":
										case "first":
											seatClass = Class.first;
											break;
										case "2":
										case "economy":
											seatClass = Class.economy;
											break;
										case "3":
										case "business":
											seatClass = Class.business;
											break;
										default:
											System.err.println("Invalid entry");
											System.err.flush();
											continue cmd;
									}
									res.createFlightSection(companyName, flightID, rows, cols, seatClass);
									continue cmd;
								default:
									System.err.println("Invalid entry");
									System.err.flush();
									continue cmd;
							}
						case "2":
						case "cruise":
							System.out.println("What would you like to create?");
							System.out.println("\t(1) Port");
							System.out.println("\t(2) Cruise");
							System.out.println("\t(3) Trip");
							System.out.println("\t(4) Ship");
							System.out.println("\t(5) Cabin Section");
							cmd = sc.nextLine().toLowerCase();
							switch(cmd){
								case "1":
								case "port":
									String port = sc.nextLine();
									res.createSeaport(port);
									continue cmd;
								case "2":
								case "cruise":
									String cruise = sc.nextLine();
									res.createCruiseline(cruise);
									continue cmd;
								case "3":
								case "trip":
									String cruiselineName;
									List<String> ports = new ArrayList<String>();
									int[] startDate = new int[3];
									int[] endDate = new int[3];
									String tripID;
									String ship;
									System.out.println("Cruise for trip:");
									cruiselineName = sc.nextLine();
									if (res.getCruiseline(cruiselineName) == null){
										System.err.println("Cruise "+ cruiselineName + " doesn't exist");
										System.err.flush();
										continue cmd;
									}
									System.out.println("Ship for this trip:");
									ship = sc.nextLine();
									if (!res.doesShipExist(ship)){
										System.err.println("Ship " + ship + " doesn't exist");
										System.err.flush();
										continue cmd;
									}
									System.out.println("Enter sequence of ports for trip: (enter 'end' after last port)");
									String portName = sc.nextLine();
									while (portName != "end"){
										if (!res.doesSeaportExist(portName)){
											System.err.println("Port "+portName+" doesn't exist");
											System.err.flush();
											continue cmd;
										}
										ports.add(portName);
										portName = sc.nextLine();
									}
									System.out.println("Start date");
									System.out.println("\tMonth:");
									startDate[0] = Integer.parseInt(sc.nextLine());
									if (startDate[0] > 12 || startDate[0] < 1){
										System.err.println("Invalid month");
										System.err.flush();
										continue cmd;
									}
									System.out.println("\tDay:");
									startDate[1] = Integer.parseInt(sc.nextLine());
									if (startDate[1] > 31 || startDate[1] < 1){
										System.err.println("Invalid day");
										System.err.flush();
										continue cmd;
									}
									System.out.println("\tYear:");
									startDate[2] = Integer.parseInt(sc.nextLine());
									System.out.println("End date");
									System.out.println("\tMonth:");
									endDate[0] = Integer.parseInt(sc.nextLine());
									if (endDate[0] > 12 || endDate[0] < 1){
										System.err.println("Invalid month");
										System.err.flush();
										continue cmd;
									}
									System.out.println("\tDay:");
									endDate[1] = Integer.parseInt(sc.nextLine());
									if (endDate[1] > 31 || endDate[1] < 1){
										System.err.println("Invalid day");
										System.err.flush();
										continue cmd;
									}
									System.out.println("\tYear:");
									endDate[2] = Integer.parseInt(sc.nextLine());
									System.out.println("Trip ID:");
									tripID = sc.nextLine();
									res.createCruiseTrip(cruiselineName, ports.toArray(new String[ports.size()]), startDate, endDate, tripID, ship);
									continue cmd;
								case "4":
								case "ship":
									System.out.println("Enter ship id:");
									String shipName = sc.nextLine();
									res.createShip(shipName);
									continue cmd;
								case "5":
								case "cabin Section":
									String companyName;
									String shipID;
									int rows; 
									int cols;
									Class cabinClass;
									System.out.println("Enter Cruise Name:");
									companyName = sc.nextLine();
									if (res.getCruiseline(companyName) == null){
										System.err.println("Cruise "+ companyName +" does not exist");
										System.err.flush();
										continue cmd;
									}
									System.out.println("Ship ID:");
									shipID = sc.nextLine();
									if (!res.doesShipExist(shipID)){
										System.err.println("Ship "+ shipID +" does not exist");
										System.err.flush();
										continue cmd;
									}
									System.out.println("Number of rows:");
									rows = Integer.parseInt(sc.nextLine());
									System.out.println("Number of cols:");
									cols = Integer.parseInt(sc.nextLine());
									System.out.println("Cabin Class:");
									System.out.println("\t(1) Family");
									System.out.println("\t(2) Deluxe Family");
									System.out.println("\t(3) Couples");
									System.out.println("\t(4) Deluxe Couples");
									String sclass = sc.nextLine().toLowerCase();
									switch(sclass){
										case "1":
										case "family":
											cabinClass = Class.family;
											break;
										case "2":
										case "deluxe family":
											cabinClass = Class.deluxeFamily;
											break;
										case "3":
										case "couples":
											cabinClass = Class.couples;
											break;
										case "4":
										case "deluxe couples":
											cabinClass = Class.deluxeCouples;
											break;
										default:
											System.err.println("Invalid entry");
											System.err.flush();
											continue cmd;
									}
									res.createShipSection(companyName, shipID, rows, cols, cabinClass);
									continue cmd;
								default:
									System.out.println("Invalid entry");
									continue cmd;
							}
						default:
							System.out.println("Invalid entry");
							continue cmd;
					}
				case "2":
				case "display details":
					System.out.println("Which subsystem?");
					System.out.println("\t(1) Airline");
					System.out.println("\t(2) Cruise");
					cmd = sc.nextLine().toLowerCase();
					switch(cmd){
						case "1":
						case "airline":
							res.airlineState();
							continue cmd;
						case "2":
						case "cruise":
							res.cruiselineState();
							continue cmd;
					}
				default:
					System.out.println("no such command");
					continue cmd;
				}
			}
		}
		
	}
	
}
