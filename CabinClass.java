
public enum CabinClass {
	family,deluxeFamily,couples,deluxeCouples;
	
	public String toString(){
		switch(this){
			case family: return "Family";
			case deluxeFamily: return "Deluxe Family";
			case couples: return "Couples";
			case deluxeCouples: return "Deluxe Couples";
			default: return "Unspecified";
		}
	}
}
