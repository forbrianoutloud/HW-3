/* 
 * Josh Richmond
 * Brian Lee
 */
public class Seat {
	private boolean status = false;
	private int row;
	char col;
	public Seat(int row, char col){
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
