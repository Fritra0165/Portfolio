
import java.util.Scanner;
import java.io.File;

public class Handler {

	public static void main(String[] args) {
		//Create an instance of Scanner
		Scanner scn = new Scanner(System.in);
		//Create an instance of ShelterManger 
		ShelterManager manage = new ShelterManager(); 
		System.out.println("Ex: animals.txt");
		System.out.println("Enter the file path: ");
		//Prompt user for input
		String Input = scn.nextLine();
		//Create new File object with user's input
		File myFile = new File(Input);
		
		//Call the readAnimalsFromFile method 
		manage.readAnimalsFromFile(Input);
		//Call displayAllAnimals method
		manage.displayAllAnimals();
		
	}//END of main method

}//END of Handler class
