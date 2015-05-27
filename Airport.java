/* 
 * Josh Richmond
 * Brian Lee
 */
import java.io.IOException;


public class Airport {
	private String airportName;
	
	/* Throws exception if airport name is not 3 characters */
	public Airport(String name) throws IOException{
		if(name.length() == 3){
			this.airportName = name;
		}else{
			throw new IOException();
		}
	}
	
	public String getName(){
		return this.airportName;
	}
}
