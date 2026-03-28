
import java.io.*;
import java.util.Scanner;

public class LibraryManagementSystem {
	// Declare and initialize instance variables
	private static final int MAX_MEDIAITEMS = 100;
	// Store mediaItem objects
	private static MediaItem[] mediaItems = new MediaItem[MAX_MEDIAITEMS];
	private static int mediaItemCount = 0;

	// Main Method
	public static void main(String[] args) {
		// Create scanner object
		Scanner scn = new Scanner(System.in);
		// Welcome message to user
		System.out.println("Welcome to the Library Management System!\n");

		// Prompt user for input
		System.out.println("Ex: inventory.txt");
		System.out.println("Enter the file path: ");
		// Get input from user
		String filePath = scn.nextLine();
		System.out.println();

		// Create a file from the user's input
		File myFile = new File(filePath);

		// Load media items from the file
		if (myFile.exists()) {
			loadMediaItemsfile(filePath);

			// Declare the option variable
			String option;

			// Do while loop that continues until user exits
			do {
				// Display menu to user
				System.out.println("\nMENU:");
				System.out.println("1. Search");
				System.out.println("2. Delete");
				System.out.println("3. Sort");
				System.out.println("4. Check out item");
				System.out.println("5. Check in item");
				System.out.println("0. Exit");
				// Prompt user for input
				System.out.println("Choose and option: ");
				option = scn.nextLine();

				// Take the user's menu option and excecute the action
				switch (option) {
				// Search funtionality for (title/author/publication year
				case "1":
					// Prompt user for input
					System.out.println("Do you want to search by title/author/pubyear: ");
					String input = scn.nextLine();
					if (input.equalsIgnoreCase("title")) {
						System.out.println("\nUser selected: title");
						System.out.println("Please enter the title of the item: ");
						String title = scn.nextLine();
						// Method call to search by title
						searchByTitle(title);
					} else if (input.equalsIgnoreCase("author")) {
						System.out.println("\nUser selected: author");
						System.out.println("Please enter the author of the item: ");
						String author = scn.nextLine();
						// Method call to search by author
						searchByAuthor(author);
					} else if (input.equalsIgnoreCase("pubyear")) {
						System.out.println("\nUser selected: pubyear");
						System.out.println("Please enter the publication year of the item: ");
						try {
							int year = scn.nextInt();
							// Method call to search by publication year
							searchByPublicationYear(year);
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							System.out.println("Invalid input. Enter a valid number for year");
						}
					} else {
						System.out.println("Cannot search for: " + input);
					}

					break;
				// Delete the item of users choice
				case "2":
					// Prompt user for input
					System.out.println("Enter Item ID to delete");
					String deleteItemID = scn.nextLine();
					deleteByItemID(deleteItemID);
					break;
				// Sort the list by Item ID and give and option to save
				case "3":
					// Method call to sort items by item ID
					sortByItemID();
					System.out.println("Items have been sorted according to ItemID: \n");
					// Method call to display array of sorted items
					displaySortedMediaItems();
					System.out.println("\nWould you like to save the sorted list to file? 'Yes' or 'No': ");
					String response = scn.nextLine();
					// based on user input the sorted array will be saved to a file
					if (response.equalsIgnoreCase("Yes")) {
						// Prompt user for input
						System.out.println("\nEnter the file path to save to: ");
						String saveFile = scn.nextLine();
						// Method call that saves to a file of the users choice
						saveToFile(saveFile);
					} else {
						System.out.println("Returning to main menu");
					}
					break;
				// Check item out by item ID
				case "4": 
					System.out.println("Enter Item ID to check out: ");
					String checkOut = scn.nextLine();
					checkOutItem(checkOut);
					break;
				// Check item in by item ID
				case "5":
					System.out.println("Enter Item ID to check in: ");
					String checkIn = scn.nextLine();
					checkInItem(checkIn);
					break;
				// Exit program
				case "0":
					// Give greeting and exit program
					System.out.println("Goodbye");
					System.out.println("Thanks for using the Library Management System");
					break;
				default:
					System.out.println("Invalid option. Please try again. ");

				}// END of Switch statement

			} while (!option.equals("0"));
		} // END of if file exists
		else {
			System.out.println("Invalid file path. Program will now exit");
		}
		// Close scanner
		scn.close();
	}// END of main method

	// Method to load media item from a file
	public static void loadMediaItemsfile(String filePath) {
		// Create a Buffered reader object to read the input file line by line
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			// Declare variable line
			String line;
			String delimiter = ",";
			// Read each line of the file until you reach the end
			while ((line = reader.readLine()) != null) {
				// Store lines in an array
				String[] parts = line.split(delimiter);

				// Declare and Initialize variables with split parts
				String type = parts[0].trim();
				String itemID = parts[1].trim();
				String title = parts[2].trim();
				String authorOrDirector = parts[3].trim();
				int publicationYear = Integer.parseInt(parts[4].trim());

				// try to see if numbers are formatted correctly
				try {
					// Check if type is a book
					if (type.equalsIgnoreCase("book")) {
						// Declare and initialize variables with split parts
						String genre = parts[5].trim();
						String IBSN = parts[6].trim();
						// create new Book object and store it in mediaItems array
						mediaItems[mediaItemCount++] = new Book(itemID, title, authorOrDirector, publicationYear, true,
								genre, IBSN);
					}
					// Check if type is a magazine
					else if (type.equalsIgnoreCase("magazine")) {
						String issueNumber = parts[5].trim();
						String month = parts[6].trim();
						// Create new Magazine object and store it in mediaItems array
						mediaItems[mediaItemCount++] = new Magazine(itemID, title, authorOrDirector, publicationYear,
								true, issueNumber, month);
					}
					// Check if type is a dvd
					else if (type.equalsIgnoreCase("dvd")) {
						// Declare and initialize variables with split parts
						int duration = Integer.parseInt(parts[5].trim());
						String rating = parts[6];
						// Create new DVD object and store it in mediaItems array
						mediaItems[mediaItemCount++] = new DVD(itemID, title, authorOrDirector, publicationYear, true,
								duration, rating);

					} else {
						// Error message to user
						System.out.println("Unknown media item " + type);
					} // END of if/else statements
				} // END of Try statement
					// throw an exception w/ message
				catch (NumberFormatException e) {
					System.out.println("Invalid number format in record: " + line);
				} // END of catch statment

			} // END of while block
		} // END of try block
			// Catch FileNotFound, IO and Array Index out of Bounds errors.
		catch (FileNotFoundException e) {
			// Error message to user
			System.out.println("File not found: " + filePath);
		} catch (IOException e) {
			// Error message to user
			System.out.println("\nError reading file: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			// Error message to user
			System.out.println("\nRecord not complete: " + e.getMessage());
		}
	}// END of loadMediaItemsfile method
	
	private static void checkInItem(String checkInID) {
		boolean found = false;
		// Iterate through all media items
		for (int i = 0; i < mediaItemCount; i++){
			// Check if the items ID mataches user input
			if (mediaItems[i].itemID.equalsIgnoreCase(checkInID)) {
				// Check if the items not available
				if (!mediaItems[i].isAvailable) {
					// Mark the item as returned
					((Loanable) mediaItems[i]).markAsReturned();
					// Message to user that the check in was a success
					System.out.println("\nYou have successfully checked in an item");
				}
				else {
					// Message to user that the check in was a success
					System.out.println("\nItem is checked out, sorry");
				}
				found = true;
			}
		}
		// If the item ID is not valid 
		if (!found) {
			//Message to let user know item ID is invlaid
			System.out.println("No item found with ID: " + checkInID);
		}
	}// END of checkInItem method


	// Method to check out Item
	private static void checkOutItem(String checkoutID) {
		boolean found = false;
		// Iterate through all media items
		for (int i = 0; i < mediaItemCount; i++){
			// Check if the items ID mataches user input
			if (mediaItems[i].itemID.equalsIgnoreCase(checkoutID)) {
				// Check if the items available
				if (mediaItems[i].isAvailable) {
					// Mark the item as loaned
					((Loanable) mediaItems[i]).markAsLoaned();
					// Message to user that the check out was a success
					System.out.println("\nYou have successfully checked out an item");
				}
				else {
					// Message letting user know the item is being loaned
					System.out.println("\nItem is checked out, sorry");
				}
				found = true;
			}
		}
		// If the item ID is not valid 
		if (!found) {
			//Message to let user know item ID is invlaid
			System.out.println("No item found with ID: " + checkoutID);
		}
	}//END of checkOutItem method

	// Method to display the sorted Media items
	public static void displaySortedMediaItems() {
		for (int i = 0; i < mediaItemCount; i++) {
			System.out.println(mediaItems[i].toString());
		}
	}// END of displaySortedMediaItems method

	// Method to search for a title
	public static void searchByTitle(String title) {
		boolean found = false;
		System.out.println("\nSearch results for title: " + title);
		// Iterate through all media items
		for (int i = 0; i < mediaItemCount; i++) {
			if (mediaItems[i].title.equalsIgnoreCase(title)) {
				System.out.println(mediaItems[i]);
				found = true;
			}
		}
		// if title not found warn user
		if (!found) {
			System.out.println("title not found \n");
		}
	}// END of searchByTitle method

	// Method to search for an author
	public static void searchByAuthor(String author) {
		boolean found = false;
		System.out.println("\nSearch results for author: " + author);
		// Iterate through all media items
		for (int i = 0; i < mediaItemCount; i++) {
			if (mediaItems[i].authorOrDirector.equalsIgnoreCase(author)) {
				System.out.println(mediaItems[i]);
				found = true;
			}
		}
		// if author not found warn user
		if (!found) {
			System.out.println("author not found \n");
		}
	}// END of searchByAuthor method

	// Method to search for an year
	public static void searchByPublicationYear(int year) {
		boolean found = false;
		System.out.println("\nSearch results for publication year: " + year);
		// Iterate through all media items
		for (int i = 0; i < mediaItemCount; i++) {
			if (mediaItems[i].publicationYear == year) {
				System.out.println(mediaItems[i]);
				found = true;
			}
		}
		// if author not found warn user
		if (!found) {
			System.out.println("publication year not found\n");
		}
	}// END of searchByPublicationYear method

	// Method to Delete a media item by its item ID
	public static void deleteByItemID(String deleteItemID) {
		boolean deleted = false;
		// iterate through all media items
		for (int i = 0; i < mediaItemCount; i++) {
			// If item has not yet been deleted continue
			if (!deleted && mediaItems[i].itemID.equalsIgnoreCase(deleteItemID)) {
				// Message to user
				System.out.println("Deleted: " + mediaItems[i]);
				// Shift all items to the left one
				for (int j = 0; j < mediaItemCount; j++) {
					mediaItems[j] = mediaItems[j + 1];
				}
				// get rid of the item / decrease count
				mediaItems[mediaItemCount--] = null;
				deleted = true;
			}
		}
		// If itemID not found warn user
		if (!deleted) {
			System.out.println("Item not found." + deleteItemID);
		}
	}// END of deleteByItemID method

	// Method to sort media items in alphabetical order using selection sort
	public static void sortByItemID() {
		// Outter loop to iterate over array
		for (int i = 0; i < mediaItemCount - 1; i++) {
			// Declare mininmum index
			int minIndex = i;
			// Inner loop for comparing and swapping
			for (int j = 0; j < mediaItemCount - 1 - i; j++) {
				// compare itemIDs alphabetically
				if (mediaItems[j].itemID.compareToIgnoreCase(mediaItems[minIndex].itemID) < 0) {
					// update index of the smallest item
					minIndex = j;
				}

			}
			// Swap the smallest item with the current item
			MediaItem temp = mediaItems[i];
			mediaItems[i] = mediaItems[minIndex];
			mediaItems[minIndex] = temp;
		}
	}// END of sortByItemID method

	// Method to save mediaItems array to a file
	public static void saveToFile(String filePath) {
		try (FileWriter writer = new FileWriter(filePath)) {
			for (int i = 0; i < mediaItemCount; i++) {
				// Write all lines from mediaItems to new file
				writer.write(mediaItems[i].toString() + "\n");
			}
			// Message to user if successful
			System.out.println("Save sucessful!");
		} catch (IOException e) {
			// Error message to user
			System.out.println("Error saving to the file:" + e.getMessage());
		}
	}
}// END of LibraryManagementSystem class
