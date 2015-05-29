
import java.util.ArrayList;
import java.util.List;


public abstract class Section {
	private SeatClass s;
	private String companyName, ID;
	private int rows, cols;
	private int[][] seats;
	private List<Accomodation> booked = new ArrayList<Accomodation>();
	
	public Section (String companyName, String ID, int rows, int cols){
		this.companyName = companyName;
		this.ID = ID;
		this.rows = rows;
		this.cols = cols;
		seats = new int[rows][cols];
	}
	

	
	
}
