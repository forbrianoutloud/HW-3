
public class Accommodation {
	private boolean status = false;
	private int row;
	private char col;
	
	public Accommodation(int row, char col){
		this.row = row;
		this.col = col;
		status = true;
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public char getCol(){
		return this.col;
	}
}
