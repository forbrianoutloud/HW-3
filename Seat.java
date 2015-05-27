/* 
 * Josh Richmond
 * Brian Lee
 */
public class Seat extends Accommodation{
	private int row;
	char col;
	public Seat(int row, char col){
		super();
		this.row = row;
		this.col = col;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public char getCol(){
		return this.col;
	}
	
}
