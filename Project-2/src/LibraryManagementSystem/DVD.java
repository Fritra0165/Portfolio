
public class DVD extends MediaItem implements Loanable {
	// Declare instance variables
	int duration;
	String rating;
	
	// DVD constructor method
	public DVD(String itemID, String title, String authorOrDirector, int publicationYear, boolean isAvailable,
			int duration, String rating) {
		super(itemID, title, authorOrDirector, publicationYear, isAvailable);
		this.duration = duration;
		this.rating = rating;
	}//END of DVD constructor
	
	// Method to get DVD details
	public String toString() {
		 return getItemDetails();
	}//END of toString method
	
	// Method to get DVD details
	public String getItemDetails() {
			 return "DVD, " + itemID + ", " + title + ", " + authorOrDirector + ", " + publicationYear + ", " + duration 
					 + ", " + rating;
	}// END of getItemDetails method
	
	@Override
	// Method to show the DVD is loaned
	public void markAsLoaned() {
		checkOut();
	}// END of markAsLoaned method
	
	@Override
	// Method to show the item has been returned
	public void markAsReturned() {
		returnItem();
	}// END of markAsReturned method

	@Override
	// Method to calculate Late fees
	public double calcLateFees(int daysLate) {
		// TODO Auto-generated method stub
		return daysLate * 1.00;
	}// END of calcLateFees method

}// END of DVD class
