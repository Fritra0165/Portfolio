
public class Magazine extends MediaItem implements Loanable {
	// Declare instance variables
	String issueNumber;
	String month;

	// Magazine constructor method
	public Magazine(String itemID, String title, String authorOrDirector, int publicationYear, boolean isAvailable,
			String issueNumber, String month) {
		super(itemID, title, authorOrDirector, publicationYear, isAvailable);
		this.issueNumber = issueNumber;
		this.month = month;
	}// END of Magazine constructor

	// Method to get magazine details
	public String toString() {
		return getItemDetails();
	}// END of toString method

	// Method to get magazine details
	public String getItemDetails() {
		return "Magazine, " + itemID + ", " + title + ", " + authorOrDirector + ", " + publicationYear + ", "
				+ issueNumber + ", " + month;
	}// END of getItemDetails method

	@Override
	// Method to show the Magazine is loaned
	public void markAsLoaned() {
		checkOut();
	}// END of markAsLoaned method
	
	@Override
	// Method to show the item has been returned
	public void markAsReturned() {
		returnItem();
	}// END of markAsReturned method

	@Override
	// Method to calculate late fees
	public double calcLateFees(int daysLate) {
		return daysLate * .20;
	}// END of calcLateFees method

}// END of Magazine class
