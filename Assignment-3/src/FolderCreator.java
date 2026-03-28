import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FolderCreator {
    
    public static void createTextFile(File folder, String fileName) throws IOException {
        File file = new File(folder, fileName);
        file.createNewFile();
    }
    
    public static void createFolderStructure() throws IOException {
        File mainFolder = new File("mainFolder");
        mainFolder.mkdir();  // Create main folder

        Random random = new Random();
        
        for (int i = 1; i <= 5; i++) {
            File subFolder = new File(mainFolder, "subfolder" + i);
            subFolder.mkdir();  // Create subfolder
            
            int fileCount = random.nextInt(5);  // Random number of files (0-4)
            for (int j = 1; j <= fileCount; j++) {
                createTextFile(subFolder, "file" + j + ".txt");  // Create .txt files
            }
        }
    }

    public static void main(String[] args) {
        try {
            createFolderStructure();
            System.out.println("Folder structure created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
