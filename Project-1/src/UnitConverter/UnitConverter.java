import java.util.Scanner;

public class UnitConverter {

	public static void main(String[] args) {
		//Message to the user
		System.out.println("The Unit Converter\n");

		//Initialize Scanner
		Scanner scn = new Scanner(System.in);

		//While loop to prompt the user for input 
		while (true) {
			//Prompt user for input
			System.out.println("\nEnter a conversion in this format:\n"
			+ "(convert <unit_from> <unit_to> <value>)");
			
			System.out.println("\ntype 'exit' to quit: ");
			
			//User input
			String input = scn.nextLine();
			
			//Exit look if user types exit
			if (input.equalsIgnoreCase("exit")) {
				System.out.println("\nThank you for choosing The Unit Converter.");
				break;
				
			}
			
			//Split the input into separate parts 
			String[] parts = input.split("\\s+");
			
			//Check if there's 4 parts and if the input starts with "convert"
			if (parts.length !=4 || !parts[0].equalsIgnoreCase("convert")) {
				System.out.println("Invalid input. use the format: (convert <unit_from> <unit_to> <value>) or type 'exit' to quit: \n");
				continue;
			}
			
			//Declare variables with parts of the input
			String unitFrom = parts[1].toLowerCase();
			String unitTo = parts[2].toLowerCase();
			//Initialize doubles 
			double value, result;
			//Convert string into a double 
			try {
				value = Double.parseDouble(parts[3]);
			} 
			catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid number: " + parts[3]);
				continue;
			}

			//Try each type of conversion 
			try {
				result = tryConvert(unitFrom, unitTo, value);
				System.out.printf("\n%.2f %s = %.2f %s\n", value, unitFrom, result ,unitTo);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}//END of while loop	

		// Close Scanner
		scn.close();
	}// END of main method
	
	//Method to test all conversion methods.
	private static double tryConvert(String unitFrom, String unitTo, double value) {
		//Try convertLength method
		try {
			return convertLength(unitFrom, unitTo, value);
		} 
		catch (IllegalArgumentException e) {}
		
		//Try convertWeight method
		try {
			//check if value is less than 0
			if (value < 0) throw new IllegalArgumentException("Weight can't be negative");
			return convertWeight(unitFrom, unitTo, value);
		} 
		catch (IllegalArgumentException e) {}
		
		//Try convertTemp method
		try {
			return convertTemp(unitFrom, unitTo, value);
		} 
		catch (IllegalArgumentException e) {}
		
		//Try coverCurrency method
		try {
			if (value < 0) throw new IllegalArgumentException("Currency can't be negative ");
			return convertCurrency(unitFrom, unitTo, value);
		} 
		catch (IllegalArgumentException e) {}
		
		//Try convertSpeed method
		try {
			return convertSpeed(unitFrom, unitTo, value);
		} 
		catch (IllegalArgumentException e) {}
		
		//Try convertVolume method
		try {
			return convertVolume(unitFrom, unitTo, value);
		} 
		catch (IllegalArgumentException e) {}
		
		//If all conversions fail, display error
		throw new IllegalArgumentException("Invalid unit conversion");
		
	}//END of tryConvertMethod

	//Method to convert currency units
	private static double convertCurrency(String unitFrom, String unitTo, double value) {
		//Convert the input value to usd
		switch (unitFrom.toLowerCase()) {
			case "usd":
				break;
			case "eur":
				value *= 1.10;
				break;
			case "bitcoin":
				value *= 40000;
			default: 
				throw new IllegalArgumentException("Invalid currency unit: " + unitFrom);
		}
		
		//Convert usd to (eur. bitcoin).
		switch(unitTo.toLowerCase()) {
			case "usd":
				return value;
			case "eur":
				return value * .91;
			case "bitcoin":
				return value * 0.000012;
			default: 
				throw new IllegalArgumentException("Invalid currency unit: " + unitFrom);
		}

	}// END of convertCurrency method
	
	//Method to convert temperature units 
	private static double convertTemp(String unitFrom, String unitTo, double value) {
		//Convert the input value to celsius
		switch (unitFrom.toLowerCase()) {
			case "celsius":
				break;
			case "fahrenheit":
				value = (value -32) * 5 / 9;
				break;
			case "kelvin":
				value -= 273.15;
				break;
			default: 
				throw new IllegalArgumentException("Invalid temp unit: " + unitFrom);
		}
				
		//Convert celsius  to (fahrenheit, kelvin)
		switch (unitTo.toLowerCase()) {
			case "celsius":
				return value;
			case "fahrenheit":
				return (value * 9 / 5) + 32;
			case "kelvin":
				return value + 273.15;
			default: 
				throw new IllegalArgumentException("Invalid temp unit: " + unitTo);	
		}
	}// END of convertTemp method
	
	//Method to convert weight units 
	private static double convertWeight(String unitFrom, String unitTo, double value) {
		//Convert the input value to kilograms
		switch (unitFrom.toLowerCase()) {
			case "kilograms":
				break;
			case "pounds":
				value *= 0.453592;
				break;
			case "grams":
				value *= 0.001;
				break;
			case "ounces":
				value *= 0.0283495;
				break;
			default: 
				throw new IllegalArgumentException("Invalid weight unit: " + unitFrom);
		}
		
		//Convert kilograms to (pounds, grams, ounces)
		switch (unitTo.toLowerCase()) {
			case "kilograms":
				return value;
			case "pounds":
				return value / 0.453592;
			case "grams":
				return value / 0.001;
			case "ounces":
				return value / 0.0283495;
			default: 
				throw new IllegalArgumentException("Invalid weight unit: " + unitTo);	
		}
	}// END of convertWeight method
	
	//Method to convert length units
	private static double convertLength(String unitFrom, String unitTo, double value) {
		//Convert the input value to meters 
		switch (unitFrom.toLowerCase()) {
			case "meters":
				break;
			case "feet":
				value *= 0.3048;
				break;
			case "kilometers":
				value *= 1000;
				break;
			case "miles":
				value *= 1609.34;
				break;
			default: 
				throw new IllegalArgumentException("Invalid length unit: " + unitFrom);
		}
		
		//Convert meters to (feet, kilometers, miles)
		switch (unitTo.toLowerCase()) {
			case "meters":
				return value;
			case "feet":
				return value / 0.3048;
			case "kilometers":
				return value / 1000;
			case "miles":
				return value / 1609.34;
			default: 
				throw new IllegalArgumentException("Invalid length unit: " + unitTo);
		}
	}//END of convertLength method
	
	//Method to convert speed units
	private static double convertSpeed(String unitFrom, String unitTo, double value) {
		//Convert the input value to mph 
		switch (unitFrom.toLowerCase()) {
			case "km/h":
				break;
			case "mph":
				value *= 1.60934;
				break;
			default:
				throw new IllegalArgumentException("Invalid speed unit: " + unitFrom);
		}
		
		//Convert km/h to (mph)
		switch (unitTo.toLowerCase()) {
			case "km/h":
				return value;
			case "mph":
				return value / 1.60934;
			default: 
				throw new IllegalArgumentException("Invalid speed unit: " + unitTo);
		}
	}//END of convertPpeed method
	
	//Method to convert volume units
	private static double convertVolume(String unitFrom, String unitTo, double value) {
		//Convert the input value to liters 
		switch (unitFrom.toLowerCase()) {
			case "liters":
				break;
			case "gallons":
				value *= 3.78541;
				break;
			default:
				throw new IllegalArgumentException("Invalid volume unit: " + unitFrom);
		}
		
		//Convert liters to (gallons)
		switch (unitTo.toLowerCase()) {
			case "liters":
				return value;
			case "gallons":
				return value / 3.78541;
			default: 
				throw new IllegalArgumentException("Invalid volume unit: " + unitTo);
		}
	}//END of convertVolume method

}//END of UnitConverter class
