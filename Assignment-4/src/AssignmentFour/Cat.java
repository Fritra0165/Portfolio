
public class Cat{
	//Declaring instance variables 
		int registrationNumber;
		String name;
		String dateOfBirth;
		String ownerPhoneNumber;
		String ownerName;
		String lastVaccinations; 
		
		//Dog constructor method
		public Cat(int registrationNumber, String name, String dateOfBirth, 
				String ownerPhoneNumber, String ownerName, String lastVaccinations) {
			this.registrationNumber = registrationNumber;
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.ownerPhoneNumber = ownerPhoneNumber;
			this.ownerName = ownerName;
			this.lastVaccinations = lastVaccinations;
		}//END of Dog constructor
		
		//Method to intialize registration
		public void setRegistrationNumber(int registrationNumber){
			this.registrationNumber = registrationNumber;
		}//END of setRegistrationNumber method
			
		//Method to return registration
		public int getRegistrationNumber() {
			return registrationNumber;
		}//END of getRegistrationNumber method
		
		//Method to intialize name
		public void setName(String name){
			this.name = name;
		}//END of setName method
		
		//Method to return name
		public String getName() {
			return name;
		}//END of getName method
		
		//Method to intialize dateOfBirth
		public void setDateOfBirth(String dateOfBirth){
			this.dateOfBirth = dateOfBirth;
		}//END of setDateOfBirth method
		
		//Method to return dateOfBirth
		public String getDateOfBirth() {
			return dateOfBirth;
		}//END of getDateOfBirth method
		
		//Method to intialize ownerPhoneNumber
		public void setOwnerPhoneNumber(String ownerPhoneNumber){
			this.ownerPhoneNumber = ownerPhoneNumber;
		}//END of setOwnerPhoneNumber method
		
		//Method to return ownerPhoneNumber
		public String getOwnerPhoneNumber() {
			return ownerPhoneNumber;
		}//END of getOwnerPhoneNumber method
		
		//Method to intialize ownerName
		public void setOwnerName(String ownerName){
			this.ownerName = ownerName;
		}//END of setOwnerName method
		
		//Method to return ownerName
		public String getOwnerName() {
			return ownerName;
		}//END of getOwnerName method
		
		//Method to intialize lastVaccinations
		public void setLastVaccinations(String lastVaccinations){
			this.lastVaccinations = lastVaccinations;
		}//END of setlastVaccinations method
		
		//Method to return lastVaccinations
		public String getLastVaccinations() {
			return lastVaccinations;
		}//END of getlastVaccinations method
		
		
		//Method to display animal information
		public String toString() {
			return displayDetails();
			
		}//END of toString method
		
		//Method to display animals information
		public String displayDetails() {
			return registrationNumber + ", " +  name + ", " + dateOfBirth +
					", " + ownerPhoneNumber + ", " + ownerName + ", " + lastVaccinations;
		}//END of displayDetails method

}//END of Cat class
