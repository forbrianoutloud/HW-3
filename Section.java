import java.io.IOException;


public interface Section {
	
	public void book(Accommodation s) throws IOException;
	
	public boolean hasAvailableSeats();
	
}
