
public enum Class {
	family,deluxeFamily,couples,deluxeCouples,first,economy,business;
	
	public String toString(){
		switch(this){
			case family: return "Family";
			case deluxeFamily: return "Deluxe Family";
			case couples: return "Couples";
			case deluxeCouples: return "Deluxe Couples";
		    case economy: return "Economy";
		    case first: return "First";
		    case business: return "Business";
			default: return "Unspecified";
		}
	}


}
