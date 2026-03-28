
public abstract class MediaItem {
	// Declare variables 
	String itemID;
	String title;
	String authorOrDirector;
	int publicationYear;
	boolean isAvailable = true;
	
	// MediaItem constructor method
	public MediaItem(String itemID, String title, String authorOrDirector, 
			int publicationYear, boolean isAvailable){
		this.itemID = itemID;
		this.title = title;
		this.authorOrDirector = authorOrDirector;
		this.publicationYear = publicationYear;
		this.isAvailable = isAvailable;
	}// END of MediaItem constructor
	
	// Method to manage item availability
	public void checkOut() {
		if (isAvailable) {
			isAvailable = false;
		}
	}// END of checkOut method
	
	// Method to manage item availability
	public void returnItem() {
		isAvailable = true;
	}//END of returnItem method
	
	// Abstract method to print out the media items details
	public abstract String getItemDetails();//END of getItemDetails method
}// END of MediaItem class
