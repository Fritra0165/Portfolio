# Overview
This program is a menu-based system that allows users to search, delete, sort, and check in and out media items such as books, magazines, and DVDs.

# Code Overview
## How Does the Project Work?
The program begins by asking the user for a file path in order to upload media files. If the file exists, it loads the items from that file and stores them. Then, the user is presented with a menu with options to either search, delete, sort, check in, and out items. With the delete option, you're able to delete a media item based on its item ID. With the search option, you're able to search by author, title, or publication year. With the sort option, the program will sort the items based on their item ID. With the check-in option, the program allows the user to return an item. Finally, the checkout option allows the user to check out a book.

## How to Compile and Run the Code
* Save all .java files in a folder.
* Open Eclipse and open the folder where you saved the files.
* Once you run the program, input the file path that holds your items.

## Challenges Faced
* Using the custom exists() method from the File class to prevent the program from continuing if the user inputs an invalid file path.
*  Understanding how to implement and properly use the loanable interface. 
*  Understanding selection sort before applying it to my sortByItemID() method.

## Author 
Travis Frias
Friastm@g.cofc.edu


