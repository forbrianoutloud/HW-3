/* 
 * Josh Richmond
 * Brian Lee
 */
public enum SeatClass {
	economy,first,business;
	
	/* Used when displaying system details */
	public String toString() {
	    switch(this) {
	      case economy: return "Economy";
	      case first: return "First";
	      case business: return "Business";
	      default:       return "Unspecified";
	    }
	  }
}
