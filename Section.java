
import java.util.ArrayList;
import java.util.List;


public abstract class Section {
	private SeatClass s;
	private String companyName, ID;
	private int rows, cols;
	private int[][] seats;
	private List<Seat> bookedSeats = new ArrayList<Seat>();
	
	public Section (String companyName, String ID, int rows, int cols, SeatClass s){
		this.companyName = companyName;
		this.ID = ID;
		this.rows = rows;
		this.cols = cols;
		this.s = s;
		seats = new int[rows][cols];
	}
	
	public SeatClass getSeatClass(){
		return s;
	}
	
	
}
