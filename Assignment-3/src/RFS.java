import java.io.File;

public class RFS {
	// Method to count the number of .txt files in a folder and its subfolders
	public static int countTextFiles(File folder) {
		int count = 0; // DO NOT create extra variables or counters
		File[] files = folder.listFiles();
		if(files == null) {
			return 0;
		}
		
		for(File file: files) {
			if (file.isFile() && file.getName().endsWith(".txt")) {
				System.out.println("Found file: " + file.getName() + " in " + file.getParent() );
				count ++;
			}
			else if(file.isDirectory()) {
				count+=countTextFiles(file);
			}
		}
		
		return count;
	}//END of countTextFiles method

	public static void main(String[] args) {
		File folder = new File("mainFolder"); // Main folder
		int txtFileCount = countTextFiles(folder);
		System.out.println("Total number of .txt files: " + txtFileCount);
	}//END of main method
	
}//END of RFS class