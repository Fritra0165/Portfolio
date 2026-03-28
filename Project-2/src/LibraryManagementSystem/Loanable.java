
// Defines the behavior for items that are checked out or late
public interface Loanable {
	// Method to show that the item is being loaned
	public void markAsLoaned();
	
	// Method to show that the item is being returned
	public void markAsReturned();

	// Calc fees based on how many days its late
	double calcLateFees(int daysLate);
}// END of Loanable interface
