
import java.io.*;
import java.util.regex.*;

public class ShelterManager {
	//Declare and initialize instance variables 
	private static final int MAX_ANIMALS = 100;
	private Object[] animals = new Object[MAX_ANIMALS]; // Will store Dog and Cat objects
	private int animalCount = 0;

	//Regex patterns for validation
	private static final String PHONE_REGEX = "^\\(\\d{3}\\)\\d{3}-\\d{3}$";
	private static final String DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";

	public void readAnimalsFromFile(String filename) {
		//Create a Buffered reader object to read the input file line by line
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			//Declare string variable line
			String line;
			//Read every line in the file
			//and store it in the line variable
			while ((line = br.readLine()) != null) {

				//Store parsed lines of code in an array
				String[] parts = parseRecord(line);

				//Declare and intitalize variables with the parts
				String type = parts[0].trim();
				int registrationNumber = Integer.parseInt(parts[1].trim());
				String name = parts[2].trim();
				String dateOfBirth = parts[3].trim();
				String ownerPhoneNumber = parts[4].trim();
				String ownerName = parts[5].trim();
				String lastVaccinations = parts[6].trim();

				//Check if phone owners number matches the regex
				if (!ownerPhoneNumber.matches(PHONE_REGEX)) {
					System.out.println("Invalid phone number format: " + line);
					//skip the record
					continue;
				}

				//Check if date of birth matchs the regex
				dateOfBirth.matches(DATE_REGEX);
				if (!dateOfBirth.matches(DATE_REGEX)) {
					System.out.println("Invalid date format: " + line);
					//skip the record
					continue;
				}

				//If type is "dog" or "cat", create a new object
				try {
					//Check if animal is of type cat
					if (type.equalsIgnoreCase("cat")) {
						//Create a new cat object
						animals[animalCount++] = new Cat(registrationNumber, name, dateOfBirth, ownerPhoneNumber,
								ownerName, lastVaccinations);
					}
					//Check if animal is of type dog
					else if (type.equalsIgnoreCase("dog")) {
						//Create a new dog object
						animals[animalCount++] = new Dog(registrationNumber, name, dateOfBirth, ownerPhoneNumber,
								ownerName, lastVaccinations);
					} else {
						System.out.println("Unknown animal type: " + type);
					}
				//Catch NumberFormatException error
				} catch (NumberFormatException e) {
					System.out.println("Invalid number format in record: " + line);
				}

			} //END of while loop
		} //END of Try block
		//Catch FileNotFound, IO and Array Index out of Bounds errors.
		catch (FileNotFoundException e) {
			System.out.println("\nFile not found: " + filename);
		} catch (IOException e) {
			System.out.println("\nError reading file: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\nRecord not complete: " + e.getMessage());
		}

	}//END of readAnimalsFromFile method
	
	//Splits the line into parts based on seperator
	private String[] parseRecord(String line) {
		if (line.contains(",")) {
			return line.split(",");
		} else if (line.contains("|")) {
			return line.split("\\|");
		} else if (line.contains(";")) {
			return line.split(";");
		} else {
			return new String[] {};
		}
	}//END of parseRecord method
	
	//Print out the details of all the animals records
	public void displayAllAnimals() {
		//For loop to iterate through the animals array printing out each line
		for (int i = 0; i < animalCount; i++) {
			System.out.println(animals[i].toString());
		} //END of displayAllAnimals method
	}
}//END of ShelterManager class