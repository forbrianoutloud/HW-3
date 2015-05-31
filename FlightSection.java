/* 
 * Josh Richmond
 * Brian Lee
 */



public class FlightSection extends Section{
	
	public FlightSection(String companyName, String ID, int rows, int cols, Class s) {
		super(companyName, ID, rows, cols, s);
	}
	
	
	
//	private SeatClass s;
//	private String airlineName, flID;
//	private int rows, cols;
//	private int[][] seats;
//	private List<Seat> bookedSeats = new ArrayList<Seat>();
//	
//	public FlightSection(String air, String flID, int rows, int cols, SeatClass s) throws IOException{
//		if((rows > 100) || (cols > 10) || (rows < 1 && cols < 1)){
//			throw new IOException();
//		}
//		
//		this.airlineName = air;
//		this.flID = flID;
//		this.rows = rows;
//		this.cols = cols;
//		this.s = s;
//		seats = new int[rows][cols];
//		
//		
//	}
//	public SeatClass getSeatClass(){
//		return s;
//	}
//	
//	public String getAirlineName(){
//		return this.airlineName;
//	}
//	
//	public String getFlID(){
//		return this.flID;
//	}
//	
//	public int getRows(){
//		return this.rows;
//	}
//	
//	public int getCols(){
//		return this.cols;
//	}
//	
//	/* Used by getSystemDetails() in system manager
//	 * displays information about the section and seats in the section
//	 */
//	public void getDetails(){
//		System.out.println("     Section Type: " + this.getSeatClass().toString());
//		System.out.println("     Section Size: " + this.getRows() + "X" + this.getCols());
//		System.out.println("     Booked Seats:");
//		if (bookedSeats.size() == 0){
//			System.out.println("          none");
//		}
//		for (Seat bookedSeat : bookedSeats){
//			System.out.println("          Row:" + bookedSeat.getRow() + " Col:" + bookedSeat.getCol());
//		}
//	}
//	
//	/* Sets corresponding position in seats array to 1 (representing booked)
//	 * and adds seat to bookedSeats list
//	 * Throws exception if seat is already booked
//	 */
//	public void bookSeat(Seat s) throws IOException{
//		int row = s.getRow()-1;
//		int col = Character.getNumericValue(s.getCol()-17); // -17 will convert A to 0, B to 1,...etc
//		if (seats[row][col] == 0){
//			seats[row][col] = 1;
//			bookedSeats.add(s);
//		}else{
//			throw new IOException();
//		}
//	}
//	
//	/* checks to see if the number of booked seats is equal to the total number of seats */
//	public boolean hasAvailableSeats(){
//		if (bookedSeats.size() == (rows*cols)){
//			return false;
//		}else{
//			return true;
//		}
//	}

}
