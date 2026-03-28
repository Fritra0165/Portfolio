
public class Book extends MediaItem implements Loanable {
	// Declare instance variables
	String genre;
	String IBSN;

	// Book constructor method
	public Book(String itemID, String title, String authorOrDirector, int publicationYear, boolean isAvailable,
			String genre, String IBSN) {
		super(itemID, title, authorOrDirector, publicationYear, isAvailable);
		this.genre = genre;
		this.IBSN = IBSN;

	}// END of Book constructor method

	// Method to get book details
	public String toString() {
		return getItemDetails();
	}// END of toString method

	// Method to get book details
	public String getItemDetails() {
		return "Book, " + itemID + ", " + title + ", " + authorOrDirector + ", " + publicationYear + ", " + genre + ", "
				+ IBSN;
	}// END of getItemDetails method

	@Override
	// Method to show the book is loaned
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
		return daysLate * .50;
	}// END of calcLateFees method

}// END of Book class
