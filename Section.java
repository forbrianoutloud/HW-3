
import java.util.ArrayList;
import java.util.List;


public abstract class Section {
	private String companyName, ID;
	private int rows, cols;
	private int[][] seats;
	private List<Accommodation> booked = new ArrayList<Accommodation>();
    private Class c;
	public Section (String companyName, String ID, int rows, int cols, Class c){
		this.companyName = companyName;
		this.ID = ID;
		this.rows = rows;
		this.cols = cols;
		seats = new int[rows][cols];
		this.c = c;
	}
	
	public void bookAccomodation(Accommodation a){
		int row = a.getRow()-1;
		int col = Character.getNumericValue(a.getCol()-17);
		if(seats[row][col] == 0){
			seats[row][col] = 1;
			booked.add(a);
			System.out.println("Accomodation Booked!");
		}else{
			System.err.println("Error: accomodation already booked");
		}
	}
	
	public void diplayDetails(){
		System.out.println("        Booked Accomodations:");
		for(Accommodation a : booked){
			System.out.println("         row-" + a.getRow() + " col-" + a.getCol());
		}
		
	}
	public String getCompanyName(){
		return companyName;
	}
	public String getID(){
		return ID;
	}
	public int getRows(){
		return rows;
	}
	public int getCols(){
		return cols;
	}
	public Class getclass(){
		return c;
	}
	
	public void findAvailable(){
		int i;
		for(i = 0; i < rows; i++){
			for(int j = 0; j < cols;j++){
				if(seats[i][j] == 0){
					System.out.println("         row-" + (i+1) + "  col-" + Character.toChars(j+65)[0]);
				}
			}
		}
	}

	
	
}
