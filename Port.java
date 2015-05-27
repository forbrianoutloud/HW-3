import java.io.IOException;
public class Port {

	private String portName;
	
	/* Throws exception if airport name is not 3 characters */
	public Port(String name) throws IOException{
		if(name.length() == 3){
			this.portName = name;
		}else{
			throw new IOException();
		}
	}
	
	public String getName(){
		return this.portName;
	}

}
