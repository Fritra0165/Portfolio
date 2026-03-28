# Overview
This program helps manage animal records for a shelter
## Design Choices 
- Number format validation
	- Used regex to ensure proper formatting for phone numbers and dates 
- Exception handling
	- Included handling for "NumberFormatException," "FileNotFoundException," "IOException," and "ArrayIndexOutOfBoundsException," so that the program doesn't crash prematurely 
- Start and end comments
	- Added comments at the start and end of all my methods and classes to create easier to read and understand.

## How to add the test file
Relative Path: place the file "animals.txt" in the same folder as your Java files.
	- When the code executes, you will be prompted to input the file path. Your input will then be used as the argument when the readAnimalsFromFile method is called.

# Code Overview 
This program starts in the *Handler* Class, prompting the user to enter the file path for the "animals.txt" file. Then it calls the *readAnimalsFromFile* method from the *ShelterManager* Class using the file path that the user entered. The *ShelterManager* Class reads the file line by line and parses it into parts, which are then stored in separate variables. From there, the variables are used to validate the format of phone numbers and dates. if those two check out and the Animal is of type "Cat" or "Dog," new objects are created using the *Dog* and *Cat* Class and added to the *animal's* array. Once all the lines are read, the Handler class then calls the *displayAllAnimals* method from the *ShelterManager* Class. This method prints out the details of all the animal records, including ones that didn't pass the validation. If an error does occur, the user is provided with the reason why.  

## Author 
Travis Frias
Friastm@g.cofc.edu


